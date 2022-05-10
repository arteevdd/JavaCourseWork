package spbstu.CourseWork.main.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spbstu.CourseWork.main.entity.Journal;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface JournalRepository extends CrudRepository<Journal, Integer> {

    Optional<Journal> findById(Integer integer);

    Iterable<Journal> findByDataBeg(Timestamp timestamp);

    Iterable<Journal> findByDataEnd(Timestamp timestamp);

    Iterable<Journal> findByDataRet(Timestamp timestamp);

    @Query("SELECT j FROM Journal j " +
           "JOIN Books b " +
           "ON j.bookId = b " +
           "WHERE b.name = :name")
    Iterable<Journal> findJournalByBookName(@Param("name") String name);

    @Query("SELECT j FROM Journal j "+
           "JOIN Client c " +
           "ON j.clientId = c " +
           "WHERE c.firstName = :firstName " +
           "AND c.lastName = :lastName " +
           "AND c.fatherName = :fatherName")
    Iterable<Journal> findJournalByClientInitials(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("fatherName") String fatherName
    );

    @Query("SELECT j FROM Journal j " +
           "JOIN Client c " +
           "ON j.clientId = c " +
           "WHERE c.passportSeria = :passportSeria " +
           "AND c.passportNum = :passportNum")
      Iterable<Journal> findJournalByPassportSeriaAndPassportNum(
              @Param("passportSeria") String passportSeria,
              @Param("passportNum") String passportNum
    );

}
