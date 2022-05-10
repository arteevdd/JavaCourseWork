package spbstu.CourseWork.main.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spbstu.CourseWork.main.entity.Books;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer> {

    Optional<Books> findById(Integer integer);

    Optional<Books> findByName(String str);

    Iterable<Books> findByCnt(Integer integer);

    @Query("SELECT b FROM Books b " +
           "JOIN BookTypes bt " +
           "ON b.typeId = bt " +
           "WHERE bt.name = :name")
    Iterable<Books> findBookByBookTypeName(@Param("name") String name);

    @Query("SELECT b FROM Books b " +
           "JOIN BookTypes bt " +
           "ON b.typeId = bt " +
           "WHERE bt.dayCount = :dayCount")
    Iterable<Books> findBookByDayCount(@Param("dayCount") Integer dayCount);

    @Transactional
    void deleteBookByName(String name);
}

