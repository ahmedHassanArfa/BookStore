/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.Service;

import com.mycompany.bookstore.DAO.BookSectionDAO;
import com.mycompany.bookstore.Model.BookSection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahmed
 */
@Service
public class BookSectionServiceImpl implements BookSectionServiceI {

    @Autowired
    BookSectionDAO bookSectionDAO;

    @Override
    public List<BookSection> findAllBookSections() throws Exception {
        return bookSectionDAO.findAll();
    }

    @Override
    public void save(BookSection bookSection) throws Exception {
        bookSectionDAO.save(bookSection);
    }

    @Override
    public void delete(BookSection bookSection) throws Exception {
        bookSectionDAO.delete("id", bookSection.getId().toString());
    }

}
