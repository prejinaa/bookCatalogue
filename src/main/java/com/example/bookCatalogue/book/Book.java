package com.example.bookCatalogue.book;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this is a book model
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column( name="Book_name")
    @NotBlank(message = "book name can't be left empty")
    private String bookName;
    @Column(name = "Book_author")
    @NotBlank(message = "author name can't be left empty")
    private String bookAuthor;
    @Column(name = "Book-Description")
    @NotBlank(message = "book description name can't be left empty")
    private String description;



}
