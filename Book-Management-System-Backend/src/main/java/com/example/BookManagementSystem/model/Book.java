package com.example.BookManagementSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "book_name", nullable = false, length = 50)
    private String bookName;
    @Column(name = "author_name", nullable = false, length = 50)
    private String authorName;
    @Column(name = "quantity", nullable = true, length = 10)
    private int quantity;
    @Column(name = "price", nullable = true, length = 10)
    private Double price;
}
