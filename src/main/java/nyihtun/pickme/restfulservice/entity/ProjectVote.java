package nyihtun.pickme.restfulservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_vote")
public class ProjectVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private long id;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false)
    private long projectId;

    public ProjectVote() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
