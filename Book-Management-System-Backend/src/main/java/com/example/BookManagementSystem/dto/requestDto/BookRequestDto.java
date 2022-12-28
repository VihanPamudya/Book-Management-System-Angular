package com.example.BookManagementSystem.dto.requestDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDto {
    private long id;
    private String bookName;
    private String authorName;
    private int quantity;
    private Double price;
}
