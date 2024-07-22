package com.example.bookCatalogue.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "book name can't be left empty")
    private String bookName;

    @NotBlank(message = "author name can't be left empty")
    private String bookAuthor;

    @NotBlank(message = "book description name can't be left empty")
    private String description;

}
