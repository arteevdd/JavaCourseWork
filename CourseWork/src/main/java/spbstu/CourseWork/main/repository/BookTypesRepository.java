package spbstu.CourseWork.main.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spbstu.CourseWork.main.entity.BookTypes;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.Optional;

@Repository
public interface BookTypesRepository extends CrudRepository<BookTypes, Integer> {

    Optional<BookTypes> findById(Integer integer);

    Optional<BookTypes> findByName(String str);

    Iterable<BookTypes> findByCnt(Integer integer);

    Iterable<BookTypes> findByDayCount(Integer integer);

    @Transactional
    void deleteBookTypeByName(String name);
}
