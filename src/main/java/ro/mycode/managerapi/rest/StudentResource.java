package ro.mycode.managerapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.managerapi.dto.AddBookRequest;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.model.Student;
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
    private StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudents= studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity addStudent( @RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("addBook")
    public ResponseEntity<Void> addBook(@Valid @RequestBody AddBookRequest book) {
        studentService.addBookToStudent(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("allNames")
    public ResponseEntity<List<String>> getAllStudentsName() {
        List<String> allStudentsName= studentService.getAllStudentsName();
        return new ResponseEntity<>(allStudentsName, HttpStatus.OK);
    }

    @GetMapping("studentsBook/{id}")
    public ResponseEntity<List<Book>> getAllStudentsBook(@PathVariable Long id) {
        List<Book> allStudntsBooks = studentService.getAllStudentsBook(id);
        return new ResponseEntity<>(allStudntsBooks, HttpStatus.OK);
    }

    @DeleteMapping("deleteByBookName/{id}/{name}")
    ResponseEntity<String> deleteByBookName(@PathVariable Map<Long, String> pathVarsMap){
       this.studentService.deleteBookByBookName(Long.parseLong(pathVarsMap.get("id")),pathVarsMap.get("name"));
        return new ResponseEntity<>(pathVarsMap.get("id"),HttpStatus.ACCEPTED);
    }

}
