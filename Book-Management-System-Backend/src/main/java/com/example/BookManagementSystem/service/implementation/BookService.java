package com.example.BookManagementSystem.service.implementation;

import com.example.BookManagementSystem.dto.requestDto.BookRequestDto;
import com.example.BookManagementSystem.dto.responseDto.BookDto;
import com.example.BookManagementSystem.model.Book;
import com.example.BookManagementSystem.repository.IBookRepository;
import com.example.BookManagementSystem.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;

    @Autowired
    public BookService(IBookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public BookDto create(BookRequestDto book) throws Exception {
        return null;
    }

    @Override
    public List<Book> getAll() throws Exception {
        return null;
    }
    @Override
    public void delete(Long id) throws Exception {

    }

    @Override
    public BookDto getBook(Long id) throws Exception {
        return null;
    }

    @Override
    public BookDto update(Long id, BookRequestDto book) throws Exception {
        return null;
    }
}
