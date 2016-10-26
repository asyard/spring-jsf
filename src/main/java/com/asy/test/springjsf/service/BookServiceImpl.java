package com.asy.test.springjsf.service;

import com.asy.test.springjsf.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asy
 */

@Service
public class BookServiceImpl implements BookService {

    private static List<Book> bookList = null;

    public List<Book> listBooks() {
        if (bookList == null) {
            bookList = new ArrayList<Book>();
            bookList.add(new Book("A", "b", 1441));
            bookList.add(new Book("A2", "b2", 1442));
            bookList.add(new Book("A3", "b3", 1443));
            bookList.add(new Book("A4", "b4", 1444));
            bookList.add(new Book("A5", "b5", 1445));
        }

        return bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void deleteBook(Book book) {
        bookList.remove(book);
    }
}
