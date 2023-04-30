package ro.mycode.managerapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.managerapi.dto.UpdateDTO;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book/")
@CrossOrigin
public class BookResource {
    private BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("updateBook")
    public ResponseEntity update(@Valid @RequestBody UpdateDTO book) {
        this.bookService.update(book);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> allBooks= bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }


}