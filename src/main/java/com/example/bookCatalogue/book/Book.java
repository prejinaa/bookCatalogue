package com.example.bookCatalogue.book;


import jakarta.persistence.*;


import lombok.*;

//this is a book model
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column( name="Book_name")
    private String bookName;

    @Column(name = "Book_author")
    private String bookAuthor;

    @Column(name = "Book-Description")
    private String description;



}
