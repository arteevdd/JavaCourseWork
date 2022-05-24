package spbstu.CourseWork.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.CourseWork.main.entity.BookTypes;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BookTypesRepository extends CrudRepository<BookTypes, Integer> {

    Optional<BookTypes> findById(Integer integer);

    Optional<BookTypes> findByName(String str);

    Iterable<BookTypes> findByCnt(Integer integer);

    Iterable<BookTypes> findAll();
    Iterable<BookTypes> findByDayCount(Integer integer);

    @Transactional
    void deleteBookTypeByName(String name);
}
