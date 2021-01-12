package com.spring.books_authors;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;

public class Author {

    @JsonView (Basic.class)
    private int id;
    @JsonView (Basic.class)
    private String name;
    @JsonView (Basic.class)
    private String description;
    @JsonView (Books.class)
    private ArrayList <Book> bookList;

    public Author () {

    }

    public Author ( int id , String name , String description , ArrayList <Book> bookList ) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.bookList = bookList;
    }

    public int getId () {

        return id;
    }

    public void setId ( int id ) {

        this.id = id;
    }

    public String getName () {

        return this.name;
    }

    public void setName ( String name ) {

        this.name = name;
    }

    public String getDescription () {

        return this.description;
    }

    public void setDescription ( String description ) {

        this.description = description;
    }

    public ArrayList <Book> getBookList () {

        return this.bookList;
    }

    public void setBookList ( ArrayList <Book> bookList ) {

        this.bookList = bookList;
    }

    interface Basic {

    }

    interface Books {

    }


}
