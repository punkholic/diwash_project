package com.example.gui;

import com.example.database.TableClasses.StockBook;

public class ObjectCreator<T> {
    public ObjectCreator(Object object){
        System.out.println(object.getClass().isInstance(StockBook.class));
    }
}
