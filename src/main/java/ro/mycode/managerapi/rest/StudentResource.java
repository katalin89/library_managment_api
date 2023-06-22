package ro.mycode.managerapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.managerapi.dto.AddBookRequest;
import ro.mycode.managerapi.dto.DeleteBookRequest;
import ro.mycode.managerapi.dto.LoginDTO;
import ro.mycode.managerapi.dto.SignUpDTO;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.model.Student;
import ro.mycode.managerapi.service.StudentService;

import javax.validation.Valid;
import java.util.List;

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
    //@RequestBody trimite informatia prin Body folosim de AddBookRequest DTO
    public ResponseEntity<Void> addBook(@Valid @RequestBody AddBookRequest book) {
        studentService.addBookToStudent(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("allNames")
    public ResponseEntity<List<String>> getAllStudentsName(@Valid @RequestBody Long id) {
        List<String> allStudentsName= studentService.getAllStudentsName();
        return new ResponseEntity<>(allStudentsName, HttpStatus.OK);
    }

//    @GetMapping("studentsBook/{id}")
//    public ResponseEntity<List<Book>> getAllStudentsBook(@PathVariable Long id) {
//        List<Book> allStudntsBooks = studentService.getAllStudentsBook(id);
//        return new ResponseEntity<>(allStudntsBooks, HttpStatus.OK);
//    }

    @GetMapping("allStudentsBooks/{id}")
    public ResponseEntity<List<Book>> getAllStudentsBooks(@PathVariable Long id) {
        List<Book> allBooks = studentService.getAllStudentsBook(id);
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    //@PathVariable
    @DeleteMapping("deleteByBookName")
    ResponseEntity<String> deleteByBookName(@RequestBody DeleteBookRequest deleteBookRequest){
       //this.studentService.deleteBookByBookId(deleteBookRequest.getStudentId());
        this.studentService.deleteBookByBookId(deleteBookRequest);
        return new ResponseEntity<>("ok",HttpStatus.ACCEPTED);
    }

    @PostMapping("login")
    public  ResponseEntity<Student>getUser(@Valid @RequestBody LoginDTO user){
        return new ResponseEntity<>(studentService.getUser(user),HttpStatus.OK);
    }

    @PostMapping("signUp")
    public  ResponseEntity<Student>getUserUp(@Valid @RequestBody SignUpDTO user){
        return  new ResponseEntity<>(studentService.addUserSignUp(user), HttpStatus.OK);
    }






}

