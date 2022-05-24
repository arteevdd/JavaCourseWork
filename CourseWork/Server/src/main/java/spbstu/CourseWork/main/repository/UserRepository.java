package spbstu.CourseWork.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spbstu.CourseWork.main.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
     Optional<User> findUserByName(String userName);
}
