package com.yilmaz.kubit.services;

import com.yilmaz.kubit.entities.Books;

import java.util.List;

public interface BookService {
    Books createBook(Books book);
    List<Books> getAll();
    Books getById(long id);
}
