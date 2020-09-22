package nyihtun.pickme.restfulservice.controller;

import nyihtun.pickme.restfulservice.entity.User;
import nyihtun.pickme.restfulservice.entity.UserProfile;
import nyihtun.pickme.restfulservice.exception.UserNotFoundException;
import nyihtun.pickme.restfulservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/POST")
    public User saveUser(@Valid @RequestBody User reqUser) {
        UserProfile profile = new UserProfile();
        reqUser.setProfile(profile);
        return repository.save(reqUser);
    }

    @GetMapping("GET/all")
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @GetMapping("GET/id/{id}")
    public User getUserById(@PathVariable("id") long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/GET/username/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @GetMapping("/GET/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return repository.findByEmail(email);
    }

    @PutMapping("/PUT/email/{email}")
    public User updateUserByEmail(@Valid @RequestBody User reqUser, @PathVariable("email") String email) {
        User user = repository.findByEmail(email);
        return repository.save(reqUser);
    }

    @DeleteMapping("/DELETE/email/{email}")
    public ResponseEntity<?> deleteUserByEmail(@PathVariable("email") String email) {
        User user = repository.findByEmail(email);
        repository.delete(user);
        return ResponseEntity.ok().build();
    }
}