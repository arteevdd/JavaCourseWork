package spbstu.CourseWork.main.service;

import spbstu.CourseWork.main.entity.BookTypes;

import java.util.List;

public interface BookTypesService {
    BookTypes findById(Integer id);
    BookTypes findByName(String name);
    List<BookTypes> findByCnt(Integer cnt);
    List<BookTypes> findByDayCnt(Integer dayCnt);
    void deleteBookTypeByName(String name);
}
