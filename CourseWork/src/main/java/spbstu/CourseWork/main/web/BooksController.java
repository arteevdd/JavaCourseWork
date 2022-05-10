package spbstu.CourseWork.main.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import spbstu.CourseWork.main.entity.Books;
import spbstu.CourseWork.main.exception.BookNotFoundException;
import spbstu.CourseWork.main.service.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Books> findById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(booksService.findById(id), HttpStatus.OK);
        }catch (BookNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<Books> findByName(@PathVariable("name") String name){
        try {
            return new ResponseEntity<>(booksService.findByName(name), HttpStatus.OK);
        }catch (BookNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-count/{count}")
    public ResponseEntity<List<Books>> findByCnt(@PathVariable("count") Integer count){
        try {
            List<Books> books = booksService.findByCount(count);
            return new ResponseEntity<>(books, HttpStatus.OK);
        }catch (BookNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-book-by-type-name/{typeName}")
    public ResponseEntity<List<Books>> findBookByBookTypeName(@PathVariable("typeName") String typeName){
        try {
            List<Books> books = booksService.findBookByBookTypeName(typeName);
            return new ResponseEntity<>(books, HttpStatus.OK);
        }catch (BookNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-book-by-day-count/{dayCount}")
    public ResponseEntity<List<Books>> findBookByDayCount(@PathVariable("dayCount") Integer dayCount){
        try {
            List<Books> books = booksService.findBookByDayCount(dayCount);
            return new ResponseEntity<>(books, HttpStatus.OK);
        }catch (BookNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Books> deleteBookByName(@PathVariable("name") String name){
       try {
           booksService.deleteBookByName(name);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch (BookNotFoundException e){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
       }
    }
}
