package spbstu.CourseWork.main.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spbstu.CourseWork.main.entity.Client;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ClientsRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findById(Integer integer);

    Iterable<Client> findByFirstName(String str);

    Iterable<Client> findByLastName(String str);

    Iterable<Client> findByFatherName(String str);

    Iterable<Client> findByPassportSeria(String str);

    Iterable<Client> findByPassportNum(String str);

    @Modifying
    @Transactional
    @Query("UPDATE Client c " +
           "SET c.firstName = :newFirstName, " +
           "c.lastName = :newLastName, " +
           "c.fatherName = :newFatherName " +
           "WHERE c.id = :id")
    void updateClient(
            @Param("id") Integer id,
            @Param("newFirstName") String newFirstName,
            @Param("newLastName") String newLastName,
            @Param("newFatherName") String newFatherName);
}
