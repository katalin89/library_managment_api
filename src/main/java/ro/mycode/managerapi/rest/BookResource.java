package ro.mycode.managerapi.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.managerapi.dtos.BookDTO;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/book/")
@CrossOrigin
public class BookResource {

    private BookService bookService;

    public BookResource(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book>allBooks=bookService.getAllBooks();
        return  new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @DeleteMapping("deleteByBookName/{bookName}")
    ResponseEntity deleteByBookName(@PathVariable String bookName){
        this.bookService.deleteByBookName(bookName);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity deleteById(@PathVariable Long id){
        this.bookService.deleteById(id);

        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("add")
    public  ResponseEntity addBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("update")

    public  ResponseEntity update(@Valid @RequestBody BookDTO book,String bookName){
        this.bookService.update(book,bookName);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
