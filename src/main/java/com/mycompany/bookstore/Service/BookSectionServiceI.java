/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.Service;

import com.mycompany.bookstore.Model.BookSection;
import java.util.List;

/**
 *
 * @author ahmed
 */
public interface BookSectionServiceI {

    public void save(BookSection bookSection) throws Exception;
    
    public List<BookSection> findAllBookSections() throws Exception;
    
     public void delete(BookSection bookSection) throws Exception;

}
