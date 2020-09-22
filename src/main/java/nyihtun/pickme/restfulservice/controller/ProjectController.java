package nyihtun.pickme.restfulservice.controller;

import nyihtun.pickme.restfulservice.entity.Project;
import nyihtun.pickme.restfulservice.entity.ProjectVote;
import nyihtun.pickme.restfulservice.exception.ProjectNotFoundException;
import nyihtun.pickme.restfulservice.repository.ProjectRepository;
import nyihtun.pickme.restfulservice.repository.ProjectVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectVoteRepository voteRepository;

    // BEGIN: PURE PROJECT CTR
    @PostMapping("/POST")
    public Project save(@Valid @RequestBody Project reqProject) {
        return projectRepository.save(reqProject);
    }

    @GetMapping("/GET/type/{type}/limit/{limit}/random/exceptId/{id}")
    public List<Project> getAllByLimitOrderByRandom(@PathVariable("type") String type, @PathVariable("id") long id, @PathVariable("limit") long limit) {
        return projectRepository.selectAllByLimitOrderByRandom(type, id, limit);
    }

    @GetMapping("/GET/type/{type}/limit/{limit}/desc")
    public List<Project> getAllByLimitDescOrder(@PathVariable("type") String type, @PathVariable("limit") long limit) {
        return projectRepository.selectAllByLimitDescOrder(type, limit);
    }

    @GetMapping("/GET/type/{type}/desc")
    public List<Project> getAllByTypeDescOrder(@PathVariable("type") String type) {
        return projectRepository.selectAllByTypeDescOrder(type);
    }

    @GetMapping("/GET/id/{id}")
    public Project getById(@PathVariable("id") long id) throws ProjectNotFoundException {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @GetMapping("/GET/userId/{userId}/type/{type}/desc")
    public List<Project> getAllByUserIdAndType(@PathVariable("userId") long userId, @PathVariable("type") String type) {
        return projectRepository.selectAllByUserIdAndType(userId, type);
    }

    @GetMapping("/GET/all")
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @PutMapping("/PUT/id/{id}")
    public Project updateById(@Valid @RequestBody Project reqProject, @PathVariable("id") long id) throws ProjectNotFoundException {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
        return projectRepository.save(reqProject);
    }

    @DeleteMapping("/DELETE/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id) throws ProjectNotFoundException {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
        projectRepository.delete(project);
        return ResponseEntity.ok().build();
    }
    // END: PURE PROJECT CTR

    // BEGIN: VOTING
    @PostMapping("/POST/vote")
    public ResponseEntity<?> saveVote(@Valid @RequestBody ProjectVote reqVote) {
        voteRepository.save(reqVote);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/GET/vote/pid/{pid}")
    public Long getVoteCountByPid(@PathVariable("pid") long pid) {
        return voteRepository.selectVoteCountByPid(pid);
    }

    @GetMapping("/GET/userVoteId/pid/{pid}")
    public List<Long> getUserVoteIdByPid(@PathVariable("pid") long pid) {
        return voteRepository.selectUserVoteIdByPid(pid);
    }

    @DeleteMapping("/DELETE/vote/userId/{uid}/projectId/{pid}")
    public ResponseEntity<?> deleteVoteByUidAndPid(@PathVariable("uid") long uid, @PathVariable("pid") long pid) {
        ProjectVote vote = voteRepository.selectVoteByUidAndPid(uid, pid);
        voteRepository.delete(vote);
        return ResponseEntity.ok().build();
    }
    // END: VOTING
}