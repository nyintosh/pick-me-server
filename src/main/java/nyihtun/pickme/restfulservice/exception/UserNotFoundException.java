package nyihtun.pickme.restfulservice.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(long id) {
        super(String.format("User with id: " + id + " Not Found!"));
    }
}