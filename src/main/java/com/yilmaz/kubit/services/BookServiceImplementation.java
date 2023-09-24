package com.yilmaz.kubit.services;

import com.yilmaz.kubit.entities.Books;
import com.yilmaz.kubit.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Books createBook(Books book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Books> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Books getById(long id) {
        return bookRepository.getReferenceById(id);
    }
}
