package com.example.BookManagementSystem.controller;

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

    @GetMapping(value = "/view/{name}")
    public ResponseEntity<UserDto> getUser(@PathVariable("name") String epfNumber) {

        try {
            UserDto userDto = userService.findUserById(epfNumber);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (CustomException ex) {
            return ErrorResponseUtil.errorResponse(ex);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Get user list
    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> getAllUsers() {

        try {
            List<User> userList = userService.getAll();
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (CustomException ex) {
            return ErrorResponseUtil.errorResponse(ex);
        }
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequestDto user) {

        try {
            UserDto savedUser = userService.create(user);

            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } catch (CustomException ex) {
            return ErrorResponseUtil.errorResponse(ex);
        }

    }

    @PutMapping(value = "/modify/{name}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("name") String epfNumber, @RequestBody UserRequestDto user) {

        try {
            UserDto updatedUser = userService.update(epfNumber, user);

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (CustomException ex) {
            return ErrorResponseUtil.errorResponse(ex);
        }

    }

    @DeleteMapping(value = "/delete/{name}")
    public ResponseEntity<Void> deleteUser(@PathVariable("name") List<String> epfNumber) {

        try {
            for (String id : epfNumber) {
                userService.delete(id);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException ex) {
            return ErrorResponseUtil.errorResponse(ex);
        }

    }

}
