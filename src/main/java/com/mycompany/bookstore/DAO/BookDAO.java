/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bookstore.DAO;

import com.mycompany.bookstore.Model.Book;
import com.mycompany.bookstore.Model.BookSection;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ahmed
 */
@Repository
public class BookDAO extends BaseDao<Book>{

    public BookDAO() {
        super(Book.class);
    }
    
    
    
      public Book findBookSection(String key, String value) {
        Query query = new Query(Criteria.where(key).is(value));
        return findOne(query);
    }

    public void updateBookSection(String key, String value, String keyUpdate, String valueUpdate) {
        Query query = new Query(Criteria.where(key).is(value));
        Update update = Update.update(keyUpdate, valueUpdate);
        update(query, update);
    }

    public void delete(String key, String value) {
        Query query = new Query(Criteria.where(key).is(value));
        delete(query);
    }
    
    
}
