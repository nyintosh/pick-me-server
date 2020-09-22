package nyihtun.pickme.restfulservice.repository;

import nyihtun.pickme.restfulservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "select * from project where type=? order by project_id desc limit ?", nativeQuery = true)
    public List<Project> selectAllByLimitDescOrder(String type, Long limit);

    @Query(value = "select * from project where type=? and project_id <> ? order by rand() limit ?", nativeQuery = true)
    public List<Project> selectAllByLimitOrderByRandom(String type, Long id, Long limit);

    @Query(value = "select * from project where type=? order by project_id desc", nativeQuery = true)
    public List<Project> selectAllByTypeDescOrder(String type);

    @Query(value = "select * from project where user_id=? and type=? order by project_id desc", nativeQuery = true)
    public List<Project> selectAllByUserIdAndType(Long userId, String type);
}