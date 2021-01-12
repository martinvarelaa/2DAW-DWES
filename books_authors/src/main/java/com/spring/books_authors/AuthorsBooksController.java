package com.spring.books_authors;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@RestController
@RequestMapping ("/api")
public class AuthorsBooksController {
    
    private final ArrayList <Book>   books   = new ArrayList <> ();
    private final ArrayList <Author> authors = new ArrayList <> ();
    
    @PostConstruct
    public void init () {
        
        Author carlos = new Author ( 0 , "Carlos" , "Gran venezolano" , new ArrayList <Book> () );
        Author martin = new Author ( 1 , "Martín" , "Gran filósofo" , new ArrayList <Book> () );
        Book   book1  = new Book ( 0 , "La vida es bella" , 20 , new ArrayList <Author> () );
        Book   book2  = new Book ( 1 , "La vida es jodida" , 21 , new ArrayList <Author> () );
        
        martin.getBookList ().add ( book1 );
        martin.getBookList ().add ( book2 );
        carlos.getBookList ().add ( book1 );
        
        book1.getAuthorList ().add ( martin );
        book1.getAuthorList ().add ( carlos );
        book2.getAuthorList ().add ( carlos );
        
        this.books.add ( book1 );
        this.books.add ( book2 );
        this.authors.add ( martin );
        this.authors.add ( carlos );
    }
    
    @JsonView (Author_book.class)
    @RequestMapping (value = "/author/{id}", method = RequestMethod.GET)
    public ResponseEntity getBooks_fromAuthor ( @PathVariable int id ) {
        
        Author returnAuth = this.authors.get ( id );
        return new ResponseEntity ( returnAuth , HttpStatus.OK );
    }
    
    @JsonView (Book_author.class)
    @RequestMapping (value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity getAuthors_AndBooks ( @PathVariable int id ) {
        
        Book returnBook = this.books.get ( id );
        return new ResponseEntity ( returnBook , HttpStatus.OK );
    }
    
    @JsonView (Author.Basic.class)
    @RequestMapping (value = "/author", method = RequestMethod.GET)
    public ResponseEntity getAuthors ( ) {
        
        
        return new ResponseEntity ( this.authors , HttpStatus.OK );
    }
    
    @JsonView (Book.Basic.class)
    @RequestMapping (value = "/books", method = RequestMethod.GET)
    public ResponseEntity getBooks ( ) {
        
        
        return new ResponseEntity ( this.books , HttpStatus.OK );
    }
    
    
}
