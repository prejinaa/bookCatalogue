package com.example.bookCatalogue.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public class BookDto {
    private Long bookId;


    private String bookName;


    private String bookAuthor;


    private String description;

}
