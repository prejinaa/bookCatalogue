package com.example.bookCatalogue.book;

import com.example.bookCatalogue.dto.BookDto;
import com.example.bookCatalogue.exception.BookNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/book")
@RequiredArgsConstructor

public class BookController {

    private final BookService bookService;


    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto){
        BookDto createBook=bookService.createBook(bookDto);
        return new ResponseEntity<>(createBook, HttpStatus.CREATED);

    }
    @GetMapping(value = "/{bookId}")
        public ResponseEntity<BookDto> getBookById(@PathVariable("bookId")  Long bookId)
            throws BookNotFoundException {
          try{
            BookDto book= bookService.getBookById(bookId);
            return new ResponseEntity<>(book,HttpStatus.OK);
           }
        catch (BookNotFoundException bookNotFoundException){
            throw   bookNotFoundException;
        }

    }
 @GetMapping
   public ResponseEntity<List<BookDto>> getBook(){
          List<BookDto> bookDtos= bookService.getBook();
          return new ResponseEntity<>(bookDtos,HttpStatus.OK);


}
   @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("bookId") Long bookId)
        throws BookNotFoundException{
         bookService.deleteBook(bookId);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);


}
   @PutMapping(value = "/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable ("bookId") Long bookId,@RequestBody BookDto bookDto)
        throws BookNotFoundException {
        BookDto bookDto1 = bookService.updateBook(bookId, bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);

}

}
