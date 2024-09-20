package pedro.apifind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.apifind.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
