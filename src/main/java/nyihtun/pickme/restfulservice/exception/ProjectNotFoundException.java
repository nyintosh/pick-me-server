package nyihtun.pickme.restfulservice.exception;

public class ProjectNotFoundException extends Exception {
    public ProjectNotFoundException(long id) {
        super(String.format("Project with id: " + id + " Not Found!"));
    }
}