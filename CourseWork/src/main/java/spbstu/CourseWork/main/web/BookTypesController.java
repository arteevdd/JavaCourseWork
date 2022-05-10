package spbstu.CourseWork.main.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import spbstu.CourseWork.main.entity.BookTypes;
import spbstu.CourseWork.main.exception.BookTypeNotFoundException;
import spbstu.CourseWork.main.service.BookTypesService;

import java.util.List;

@RestController
@RequestMapping("/book-types")
public class BookTypesController {
    private BookTypesService bookTypesService;

    @Autowired
    public void setBookTypesRepository(BookTypesService bookTypesService) {
        this.bookTypesService = bookTypesService;
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<BookTypes> findById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(bookTypesService.findById(id), HttpStatus.OK);
        }catch (BookTypeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<BookTypes> findByName(@PathVariable("name") String name){
        try {
            return new ResponseEntity<>(bookTypesService.findByName(name), HttpStatus.OK);
        }catch(BookTypeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-cnt/{cnt}")
    public ResponseEntity<List<BookTypes>> findByCnt(@PathVariable("cnt") Integer cnt){
        try{
            List<BookTypes> bookTypesList = bookTypesService.findByCnt(cnt);
            return new ResponseEntity<>(bookTypesList, HttpStatus.OK);
        }catch (BookTypeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-day-cnt/{dayCnt}")
    public ResponseEntity<List<BookTypes>> findByDayCnt(@PathVariable("dayCnt") Integer dayCnt){
        try{
            List<BookTypes> bookTypesList = bookTypesService.findByDayCnt(dayCnt);
            return new ResponseEntity<>(bookTypesList, HttpStatus.OK);
        }catch (BookTypeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<BookTypes> deleteBookTypesByName(@PathVariable("name") String name){
        try {
            bookTypesService.deleteBookTypeByName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (BookTypeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


}
