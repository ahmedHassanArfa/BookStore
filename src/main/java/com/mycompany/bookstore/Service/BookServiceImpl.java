/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.Service;

import com.mycompany.bookstore.DAO.BookDAO;
import com.mycompany.bookstore.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahmed
 */
@Service
public class BookServiceImpl implements BookServiceI {

    @Autowired
    BookDAO bookDAO;

    @Override
    public void save(Book book) throws Exception {
        bookDAO.save(book);
    }

    @Override
    public void delete(Book book) throws Exception {
        bookDAO.delete("id", book.getId().toString());
    }

}
