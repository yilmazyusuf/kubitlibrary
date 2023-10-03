package com.yilmaz.kubit;

import com.yilmaz.kubit.dtos.BookCoverDto;
import com.yilmaz.kubit.entities.Books;
import com.yilmaz.kubit.services.BookServiceImplementation;
import com.yilmaz.kubit.services.FileUploadService;
import com.yilmaz.kubit.services.ResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private BookServiceImplementation bookService;
    @Autowired
    private ResponseService responseService;

    @PostMapping("/books")
    public ResponseEntity<ResponseService> create(@Valid @RequestBody Books book) {

        Books savedBook = bookService.createBook(book);

        responseService.redirectTo("/books");

        return new ResponseEntity<>(responseService,HttpStatus.CREATED);
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
    public ResponseEntity<ResponseService> updateBook(
            @PathVariable("id") long id,
            @Valid @RequestBody Books book) {

        Books existingBook = bookService.getById(id);
        existingBook.setName(book.getName());
        existingBook.setDescription(book.getDescription());
        Books updatedBook = bookService.createBook(existingBook);

        responseService.redirectTo("/books");

        return new ResponseEntity<>(responseService,HttpStatus.OK);
    }
    @PostMapping("/books/cover/upload")
    public ResponseEntity<BookCoverDto> uploadBookCover(@RequestParam("image") MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String uploadDir = "src/frontend/public/images/books";
        FileUploadService.saveFile(uploadDir, fileName, image);
        BookCoverDto coverDto = new BookCoverDto();
        coverDto.setName(fileName);
        return new ResponseEntity<>(coverDto,HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
//https://developers.google.com/books/
//https://isbnsearch.org/isbn/9781803233307