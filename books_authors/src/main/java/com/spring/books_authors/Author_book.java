package com.spring.books_authors;

interface Author_book extends Author.Basic, Author.Books, Book.Basic {
}


interface Book_author extends Author.Basic, Book.Authors, Book.Basic{

}
