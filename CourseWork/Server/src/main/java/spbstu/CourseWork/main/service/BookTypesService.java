package spbstu.CourseWork.main.service;

import spbstu.CourseWork.main.dto.BookTypesDto;
import spbstu.CourseWork.main.entity.BookTypes;

import java.util.List;

public interface BookTypesService {
    BookTypes findById(Integer id);
    BookTypes findByName(String name);
    List<BookTypes> findByCnt(Integer cnt);
    List<BookTypes> findAll();
    List<BookTypes> findByDayCnt(Integer dayCnt);
    BookTypes add(BookTypesDto bookTypesDto);
    void deleteBookTypeByName(String name);
}
