package com.example.BookManagementSystem.service.implementation;

import com.example.BookManagementSystem.dto.requestDto.BookRequestDto;
import com.example.BookManagementSystem.dto.responseDto.BookDto;
import com.example.BookManagementSystem.model.Book;
import com.example.BookManagementSystem.repository.IBookRepository;
import com.example.BookManagementSystem.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;

    @Autowired
    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto create(BookRequestDto book) throws Exception {
        try {

            Book bookRequest = new Book();

            if (book == null) {
                throw new Exception("Request fail");
            }

            String bookName = book.getBookName();
            bookRequest.setBookName(bookName);

            String authorName = book.getAuthorName();
            bookRequest.setAuthorName(authorName);

            int quantity = book.getQuantity();
            bookRequest.setQuantity(quantity);

            Double price = book.getPrice();
            bookRequest.setPrice(price);

            Book savedBook = bookRepository.save(bookRequest);


            BookDto bookDto = convertBookToBookResponseDto(savedBook);
            return bookDto;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Book> getAll() throws Exception {
        try {
            return bookRepository.findAll();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {

            Optional<Book> foundBook = bookRepository.findById(id);

            if (foundBook.isPresent()) {
                bookRepository.delete(foundBook.get());
            } else {
                throw new Exception("Book not deleted!");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public BookDto getBook(Long id) throws Exception {
        try {

            Optional<Book> foundBooks = bookRepository.findById(id);

            if (foundBooks.isPresent()) {

                Book foundBook = foundBooks.get();
                BookDto bookDto = convertBookToBookResponseDto(foundBook);
                return bookDto;
            } else {
                throw new Exception("Cannot find the user by given Employee number: " + id);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public BookDto update(Long id, BookRequestDto book) throws Exception {
        try {

            if (book == null) {
                throw new Exception("Request fail!");
            }

            Optional<Book> foundBook = bookRepository.findById(id);

            if (!foundBook.isPresent()) {
                throw new Exception("Book not here!");
            }

            Book currentBook = foundBook.get();

            Book updatingBook = new Book();

            String bookName = book.getBookName();
            updatingBook.setBookName(bookName);

            String authorName = book.getAuthorName();
            updatingBook.setAuthorName(authorName);

            int quantity = book.getQuantity();
            updatingBook.setQuantity(quantity);

            Double price = book.getPrice();
            updatingBook.setPrice(price);

            Book updatedBook = bookRepository.save(updatingBook);

            BookDto bookDto = convertBookToBookResponseDto(updatedBook);
            return bookDto;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public BookDto convertBookToBookResponseDto(Book book) throws Exception {
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);
        return bookDto;
    }
}
