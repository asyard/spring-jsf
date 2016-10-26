package com.asy.test.springjsf.service;

import com.asy.test.springjsf.model.Book;

import java.util.List;

/**
 * Created by asy
 */
public interface BookService {

    List<Book> listBooks();

    void addBook(Book book);

    void deleteBook(Book book);

}
