package com.asy.test.springjsf;

import com.asy.test.springjsf.model.Book;
import com.asy.test.springjsf.service.BookService;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by asy
 */

@Component
@ManagedBean(name = "bookManager")
@RequestScoped
public class BookManager {

    private static final Logger logger = LoggerFactory.getLogger(BookManager.class);

    private String name;
    private String author;
    private int year;

    private List<Book> books;
    private List<Book> filteredBooks;
    private Book selectedBook;

    @Autowired
    private BookService bookService;

    @PostConstruct
    public void init() {
        books = bookService.listBooks();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getFilteredBooks() {
        return filteredBooks;
    }

    public String doSave() {
        save();
        return "booklist";
    }

    public String saveAndClose() {
        save();
        RequestContext.getCurrentInstance().execute("PF('bookAddDialog').hide()");
        return "booklist";
    }

     private void save() {
         System.out.println("------------ " + name + " ----------------------");
         bookService.addBook(new Book(name, author, year));
         selectedBook = null;
         name = "";
         author = "";
         year = 0;
     }


    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    public void deleteBook() {
        logger.debug("Deleting book : " + selectedBook);
        bookService.deleteBook(selectedBook);
        selectedBook = null;
    }

}
