package com.example.bookCatalogue.book;

import com.example.bookCatalogue.dto.BookDto;
import com.example.bookCatalogue.exception.BookNotFoundException;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    BookDto getBookById( Long bookId) throws BookNotFoundException;
    List<BookDto> getBook();
    void deleteBook(Long bookId) throws  BookNotFoundException;
    BookDto updateBook(Long bookId,BookDto bookDto) throws  BookNotFoundException;



}
