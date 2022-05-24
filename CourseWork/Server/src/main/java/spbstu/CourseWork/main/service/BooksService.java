package spbstu.CourseWork.main.service;

import spbstu.CourseWork.main.dto.BooksDto;
import spbstu.CourseWork.main.entity.Books;

import java.util.List;

public interface BooksService {
    Books add(BooksDto booksDto);
    Books findById(Integer id);
    Books findByName(String name);
    List<Books> findByCount(Integer cnt);
    List<Books> findAll();
    List<Books> findBookByBookTypeName(String name);
    List<Books> findBookByDayCount(Integer dayCnt);
    void deleteBookByName(String name);
}
