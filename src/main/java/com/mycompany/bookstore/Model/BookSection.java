/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bookstore.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author ahmed
 */
@Document(collection = "booksection")
public class BookSection implements Serializable{
    
    @Id
    private String id;
    @Field(value = "name")
    private String name;
    
    private List<Book> books;

    @PersistenceConstructor
    public BookSection(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public BookSection() {
    }
    
    
    
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookSection [" + "id :" + id + ", name :" + name + ']';
    }
    
    
    
    
    
}
