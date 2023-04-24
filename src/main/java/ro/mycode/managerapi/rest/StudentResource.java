package ro.mycode.managerapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.managerapi.dto.AddBookRequest;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.repository.BookRepo;
import ro.mycode.managerapi.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students/")
@CrossOrigin
public class StudentResource {


    private StudentService studentService;
    private final BookRepo bookRepo;

    private StudentResource(StudentService studentService,
                            BookRepo bookRepo) {

        this.studentService = studentService;
        this.bookRepo = bookRepo;
    }

    @PostMapping("addBook")
    public ResponseEntity<Void> addBook(@Valid @RequestBody AddBookRequest book) {
        studentService.addBookToStudent(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




    @GetMapping("all")
    public ResponseEntity<List<String>> getAllBooks() {
        List<String> allBooks = studentService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping("studentsBook/{id}")
    public ResponseEntity<List<Book>> getAllStudentsBook(@PathVariable Long id) {
        List<Book> allStudntsBooks = studentService.getAllStudentsBook(id);
        return new ResponseEntity<>(allStudntsBooks, HttpStatus.OK);
    }

    @DeleteMapping("deleteByBookName/{id}/{name}")
    ResponseEntity deleteByBookName(@PathVariable Map<Long, String> pathVarsMap){
       this.studentService.deleteBookByBookName(Long.parseLong(pathVarsMap.get("id")),pathVarsMap.get("name"));

       String id = pathVarsMap.get("id");
       String name = pathVarsMap.get("name");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
