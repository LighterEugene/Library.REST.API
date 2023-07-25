package com.example.library.Controllers;

import com.example.library.Models.Book;
import com.example.library.Models.Library;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.library.Repositories.LibraryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    private LibraryRepository libraryRepository;


    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest) {
        if (bookRequest.getLibraryId() != null) {
            Long libraryId = bookRequest.getLibraryId();
            Library library = libraryRepository.findById(libraryId).orElse(null);
            if (library != null) {
                Book book = new Book();
                book.setLibrary(library);
                book.setTitle(bookRequest.getTitle());
                book.setAuthor(bookRequest.getAuthor());
                book.setPublicationYear(bookRequest.getPublicationYear());
                book.setGenre(bookRequest.getGenre());
                book.setIsbn(bookRequest.getIsbn());

                Book savedBook = bookService.addBook(book);
                return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        Book existingBook = bookService.getBookById(id);
        if (existingBook != null) {
            Long libraryId = bookRequest.getLibraryId();
            Library library = libraryRepository.findById(libraryId).orElse(null);
            if (library != null) {
                existingBook.setLibrary(library);
                existingBook.setTitle(bookRequest.getTitle());
                existingBook.setAuthor(bookRequest.getAuthor());
                existingBook.setPublicationYear(bookRequest.getPublicationYear());
                existingBook.setGenre(bookRequest.getGenre());
                existingBook.setIsbn(bookRequest.getIsbn());

                Book updatedBook = bookService.updateBook(id, existingBook);
                return new ResponseEntity<>(updatedBook, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
