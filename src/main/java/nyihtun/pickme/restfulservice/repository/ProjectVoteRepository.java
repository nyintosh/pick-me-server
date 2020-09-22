package nyihtun.pickme.restfulservice.repository;

import nyihtun.pickme.restfulservice.entity.ProjectVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectVoteRepository extends JpaRepository<ProjectVote, Long> {
    @Query(value = "select count(*) from project_vote where project_id=?", nativeQuery = true)
    public Long selectVoteCountByPid(long pid);

    @Query(value = "select user_id from project_vote where project_id=?", nativeQuery = true)
    public List<Long> selectUserVoteIdByPid(long pid);

    @Query(value = "select * from project_vote where user_id=? and project_id=?", nativeQuery = true)
    public ProjectVote selectVoteByUidAndPid(long uid, long pid);
}