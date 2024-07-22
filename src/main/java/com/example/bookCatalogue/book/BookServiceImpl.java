package com.example.bookCatalogue.book;

import com.example.bookCatalogue.dto.BookDto;
import com.example.bookCatalogue.exception.BookNotFoundException;
import com.example.bookCatalogue.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements  BookService{

    private final BookRepo bookRepo;


    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book= BookMapper.mapToBook(bookDto);
         Book creatBook=           bookRepo.save(book);
         return BookMapper.mapToBookDto(creatBook);
    }

    @Override
    public BookDto getBookById(Long bookId) throws BookNotFoundException {
        Optional<Book> book= bookRepo.findById(bookId);
        if(book.isEmpty()){
            throw new BookNotFoundException("Book with this id "+ bookId +" not found");

        }
else {
       return BookMapper.mapToBookDto(book.get());
        }
    }

    @Override
    public List<BookDto> getBook() {
        List<Book> books=bookRepo.findAll();
        return books.stream().map((bok) -> BookMapper.mapToBookDto(bok)).collect(Collectors.toList());

    }

    @Override
    public void deleteBook(Long bookId) throws BookNotFoundException {
        Optional<Book>book=bookRepo.findById(bookId);
        if(book.isEmpty()){
            throw new BookNotFoundException("book with this id" + bookId + " not found");
        }
        else {
             bookRepo.deleteById( bookId);
        }

    }

    @Override
    public BookDto updateBook(Long bookId, BookDto bookDto) throws BookNotFoundException {
      Optional<Book>retriveBook=  bookRepo.findById(bookId);
      if(retriveBook.isEmpty()){
          throw  new BookNotFoundException("Book with this id" + bookId + "not found");
      }
      else{
         Book books= retriveBook.get();
         books.setBookName(bookDto.getBookName());
         books.setBookAuthor(bookDto.getBookAuthor());
         books.setDescription(bookDto.getDescription());
                 Book createBook=bookRepo.save(books);
          return BookMapper.mapToBookDto(createBook);

      }
    }
}
