package com.example.bookCatalogue.mapper;

import com.example.bookCatalogue.book.Book;
import com.example.bookCatalogue.dto.BookDto;

public class BookMapper {
    public static BookDto mapToBookDto(Book book){
        return new BookDto(book.getBookId(), book.getBookName(), book.getBookAuthor(), book.getDescription());
    }
    public static Book mapToBook(BookDto bookDto){
        return  new Book(bookDto.getBookId(), bookDto.getBookName(), bookDto.getBookAuthor(), bookDto.getDescription());
    }
}
