/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bookstore.Service;

import com.mycompany.bookstore.Model.Book;

/**
 *
 * @author ahmed
 */
public interface BookServiceI {
    
    public void save(Book book) throws Exception;
    
    public void delete(Book book) throws Exception;
    
}
