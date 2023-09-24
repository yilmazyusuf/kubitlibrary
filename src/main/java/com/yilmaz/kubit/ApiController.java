package com.yilmaz.kubit;

import com.yilmaz.kubit.entities.Books;
import com.yilmaz.kubit.services.BookServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private BookServiceImplementation bookService;

    @GetMapping("/hello")
    public String hello() {
        return "Full Stack Java with Spring Boot & VueJS!";
    }

    @PostMapping("/books")
    public ResponseEntity<Books> create(@RequestBody Books book) {

        Books savedBook = bookService.createBook(book);

        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getAll() {

        List<Books> books = bookService.getAll();

        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/books/edit/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable("id") long id) {

        Books book = bookService.getById(id);

        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PutMapping("/books/edit/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable("id") long id,@RequestBody Books book) {

        Books existingBook = bookService.getById(id);
        existingBook.setName(book.getName());
        Books updatedBook = bookService.createBook(existingBook);

        return new ResponseEntity<>(updatedBook,HttpStatus.OK);
    }

}
