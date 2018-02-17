/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.MB;

import com.mycompany.bookstore.Model.Book;
import com.mycompany.bookstore.Model.BookSection;
import com.mycompany.bookstore.Service.BookSectionServiceI;
import com.mycompany.bookstore.Service.BookServiceI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ahmed
 */
@Component
@ViewScoped
public class BookStoreMB implements Serializable {

    @Autowired
    BookSectionServiceI bookSectionServiceI;
    @Autowired
    BookServiceI bookServiceI;

    private List<BookSection> bookSectionsList = new ArrayList<>();
    private BookSection selectedBookSection;
    private Book selectedBook;

    @PostConstruct
    public void init() {
        try {
            bookSectionsList = bookSectionServiceI.findAllBookSections();
        } catch (Exception ex) {
            Logger.getLogger(BookStoreMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        resetInstances();
    }

    public void resetInstances() {
        selectedBookSection = new BookSection();
        selectedBook = new Book();
    }

    public void saveOrUpdateBookSection() {
        try {
            bookSectionServiceI.save(selectedBookSection);
        } catch (Exception ex) {
            Logger.getLogger(BookStoreMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        bookSectionsList.add(selectedBookSection);
        resetInstances();
    }

    public void saveOrUpdateBook() {
        try {
            selectedBook.setBookSection(selectedBookSection);
            bookServiceI.save(selectedBook);

            if (selectedBookSection.getBooks() == null) {
                selectedBookSection.setBooks(new ArrayList<Book>());
            }
            selectedBookSection.getBooks().add(selectedBook);
            saveOrUpdateBookSection();
            resetInstances();
        } catch (Exception ex) {
            Logger.getLogger(BookStoreMB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteBookSection() {
        try {
            bookSectionServiceI.delete(selectedBookSection);
        } catch (Exception ex) {
            Logger.getLogger(BookStoreMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        bookSectionsList.remove(selectedBookSection);
        resetInstances();
    }

    public void deleteBook() {
        try {
            bookServiceI.delete(selectedBook);
        } catch (Exception ex) {
            Logger.getLogger(BookStoreMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        selectedBookSection.getBooks().remove(selectedBook);
        saveOrUpdateBookSection();
        resetInstances();
    }

    /**
     * @return the bookSectionsList
     */
    public List<BookSection> getBookSectionsList() {
        return bookSectionsList;
    }

    /**
     * @param bookSectionsList the bookSectionsList to set
     */
    public void setBookSectionsList(List<BookSection> bookSectionsList) {
        this.bookSectionsList = bookSectionsList;
    }

    /**
     * @return the selectedBookSection
     */
    public BookSection getSelectedBookSection() {
        return selectedBookSection;
    }

    /**
     * @param selectedBookSection the selectedBookSection to set
     */
    public void setSelectedBookSection(BookSection selectedBookSection) {
        this.selectedBookSection = selectedBookSection;
    }

    /**
     * @return the selectedBook
     */
    public Book getSelectedBook() {
        return selectedBook;
    }

    /**
     * @param selectedBook the selectedBook to set
     */
    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

}
