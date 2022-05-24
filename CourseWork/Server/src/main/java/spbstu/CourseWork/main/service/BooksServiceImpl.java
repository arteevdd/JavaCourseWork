package spbstu.CourseWork.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbstu.CourseWork.main.dto.BooksDto;
import spbstu.CourseWork.main.entity.BookTypes;
import spbstu.CourseWork.main.entity.Books;
import spbstu.CourseWork.main.exception.BookNotFoundException;
import spbstu.CourseWork.main.repository.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService{

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private BookTypesService bookTypesService;

    @Override
    public Books add(BooksDto booksDto) {
        String name = booksDto.getName();
        Integer cnt = booksDto.getCnt();
        Integer typeId = booksDto.getTypeId();

        BookTypes bookType = bookTypesService.findById(typeId);
        Books book = new Books(name, cnt, bookType);
        booksRepository.save(book);
        return book;
    }

    @Override
    public Books findById(Integer id) {
        Optional<Books> ap = booksRepository.findById(id);
        if(ap.isPresent()) {
            return ap.get();
        }else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public Books findByName(String name) {
        Optional<Books> ap = booksRepository.findByName(name);
        if(ap.isPresent()) {
            return ap.get();
        }else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public List<Books> findByCount(Integer cnt) {
        return (List<Books>) booksRepository.findByCnt(cnt);
    }

    @Override
    public List<Books> findAll() {
        return (List<Books>) booksRepository.findAll();
    }

    @Override
    public List<Books> findBookByBookTypeName(String name) {
        return (List<Books>) booksRepository.findBookByBookTypeName(name);
    }

    @Override
    public List<Books> findBookByDayCount(Integer dayCnt) {
        return (List<Books>) booksRepository.findBookByDayCount(dayCnt);
    }

    @Override
    public void deleteBookByName(String name) {
        booksRepository.deleteBookByName(name);
    }
}
