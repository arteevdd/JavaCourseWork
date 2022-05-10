package spbstu.CourseWork.main.repository;


import org.springframework.data.repository.CrudRepository;
import spbstu.CourseWork.main.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserByUserName(String userName);
}
