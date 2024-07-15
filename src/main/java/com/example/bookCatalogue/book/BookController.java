package com.example.bookCatalogue.book;

import com.example.bookCatalogue.dto.BookDto;
import com.example.bookCatalogue.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping(value = "/book")
   public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        BookDto createBook=bookService.createBook(bookDto);
        return new ResponseEntity<>(createBook, HttpStatus.CREATED);

    }
    @GetMapping(value = "/book/{bookId}")
   public ResponseEntity<BookDto> getBookById(@PathVariable("bookId")  Long bookId) throws BookNotFoundException {
        try{
            BookDto book= bookService.getBookById(bookId);
            return new ResponseEntity<>(book,HttpStatus.OK);
        }
        catch (BookNotFoundException bookNotFoundException){
            throw   bookNotFoundException;
        }

    }
@GetMapping(value = "/book")
   public ResponseEntity<List<BookDto>> getBook(){
          List<BookDto> bookDtos= bookService.getBook();
          return new ResponseEntity<>(bookDtos,HttpStatus.OK);


}
@DeleteMapping(value = "/book/{bookId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("bookId") Long bookId)
        throws BookNotFoundException{
         bookService.deleteBook(bookId);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);


}
@PutMapping(value = "/book/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable ("bookId") Long bookId,@RequestBody BookDto bookDto)
        throws BookNotFoundException {
        BookDto bookDto1 = bookService.updateBook(bookId, bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);

}

}
