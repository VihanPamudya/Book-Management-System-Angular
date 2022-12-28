package com.example.BookManagementSystem.service;

import com.example.BookManagementSystem.dto.requestDto.BookRequestDto;
import com.example.BookManagementSystem.dto.responseDto.BookDto;
import com.example.BookManagementSystem.model.Book;

import java.util.List;

public interface IBookService {
    public BookDto create(BookRequestDto book) throws Exception;

    public List<Book> getAll() throws Exception;

    public BookDto getBook(Long id) throws Exception;

    public void delete(Long id) throws Exception;

    public BookDto update(Long id, BookRequestDto book) throws Exception;
}
