package com.spring.books_authors;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;

public class Book {

    @JsonView (Basic.class)
    private int id;
    @JsonView (Basic.class)
    private String title;
    @JsonView (Basic.class)
    private int price;
    @JsonView (Authors.class)
    private ArrayList <Author> authorList;

    public Book () {

    }

    public Book ( int id , String title , int price , ArrayList <Author> authorList ) {

        this.id = id;
        this.title = title;
        this.price = price;
        this.authorList = authorList;
    }

    public int getId () {

        return this.id;
    }

    public void setId ( int id ) {

        this.id = id;
    }

    public String getTitle () {

        return this.title;
    }

    public void setTitle ( String title ) {

        this.title = title;
    }

    public int getPrice () {

        return price;
    }

    public void setPrice ( int price ) {

        this.price = price;
    }

    public ArrayList <Author> getAuthorList () {

        return authorList;
    }

    public void setAuthorList ( ArrayList <Author> authorList ) {

        this.authorList = authorList;
    }

    interface Basic {

    }

    interface Authors {

    }


}
