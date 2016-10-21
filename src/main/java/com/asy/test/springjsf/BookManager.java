package com.asy.test.springjsf;

import com.asy.test.springjsf.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asy
 */

@ManagedBean(name = "bookManager")
@RequestScoped
public class BookManager {

    private static final Logger logger = LoggerFactory.getLogger(BookManager.class);

    private String name;
    private List<Book> books;
    private List<Book> filteredBooks;
    private Book selectedBook;

    @PostConstruct
    public void init() {
        books = new ArrayList<Book>();
        books.add(new Book("A", "b", 1441));
        books.add(new Book("A2", "b2", 1442));
        books.add(new Book("A3", "b3", 1443));
        books.add(new Book("A4", "b4", 1444));
        books.add(new Book("A5", "b5", 1445));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getFilteredBooks() {
        return filteredBooks;
    }

    public String doSave() {
        System.out.println("------------ " + name + " ----------------------");
        return "menu";
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    public void deleteBook() {
        logger.debug("Deleting book : " + selectedBook);
        books.remove(selectedBook);
        selectedBook = null;
    }

}
