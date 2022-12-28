package com.example.BookManagementSystem.controller;

import com.example.BookManagementSystem.dto.requestDto.BookRequestDto;
import com.example.BookManagementSystem.dto.responseDto.BookDto;
import com.example.BookManagementSystem.model.Book;
import com.example.BookManagementSystem.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/book-management/book")
public class BookController {
    private final IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/view/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") Long id) {

        try {
            BookDto bookDto = bookService.getBook(id);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Book>> getAllBooks() {

        try {
            List<Book> bookList = bookService.getAll();
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<BookDto> createBook(@RequestBody BookRequestDto book) {

        try {
            BookDto saveBook = bookService.create(book);

            return new ResponseEntity<>(saveBook, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long id, @RequestBody BookRequestDto book) {

        try {
            BookDto updateBook = bookService.update(id, book);

            return new ResponseEntity<>(updateBook, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") List<Long> id) {

        try {
            for (Long bookId : id) {
                bookService.delete(bookId);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
