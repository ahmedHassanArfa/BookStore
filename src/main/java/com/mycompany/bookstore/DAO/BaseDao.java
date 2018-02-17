/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 *
 * @author ahmed
 * @param <T>
 */
public class BaseDao<T> { 
    
    private Class<T> clazz;

    public BaseDao(Class<T> t) {
        this.clazz = t;
    }
    
    

    @Autowired
    private MongoTemplate mongoTemplate;

//    private ApplicationContext ctx = new GenericXmlApplicationContext("/WEB-INF/springConfig.xml");
//    private MongoOperations mongoOperation = (MongoOperations) getCtx().getBean("mongoTemplate");

    public T findOne(Query query) {
        return (T) mongoTemplate.findOne(query, clazz);
    }

    public void delete(Query query) {
        mongoTemplate.remove(query, clazz);
    }

    public void save(T t) {
        mongoTemplate.save(t);
    }

    public void saveList(List<T> list) {
        for (T t1 : list) {
            save(t1);
        }
    }

    public void update(Query query, Update update) {
        mongoTemplate.updateFirst(query, update, clazz);
    }

    public List<T> findAll() {
        return (List<T>) mongoTemplate.findAll(clazz);
    }

    private void createCollection() {
        if (!mongoTemplate.collectionExists(clazz)) {
            mongoTemplate.createCollection(clazz);
        }
    }

    /**
     * @return the mongoTemplate
     */
    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    /**
     * @param mongoTemplate the mongoTemplate to set
     */
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * @return the clazz
     */
    public Class<T> getClazz() {
        return clazz;
    }

    /**
     * @param clazz the clazz to set
     */
    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

}
