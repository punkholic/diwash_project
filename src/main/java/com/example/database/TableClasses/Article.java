package com.example.database.TableClasses;

public class Article {

    private int id;
    private String name;

    public Article(){
        this("");
    }

    public Article(String name){
        this.id = -1;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
