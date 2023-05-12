package ro.mycode.managerapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.managerapi.dto.AddBookRequest;
import ro.mycode.managerapi.dto.LoginDTO;
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

   // @PathVariable trimite prin url
    @DeleteMapping("deleteByBookName/{id}")

    ResponseEntity<String> deleteByBookName(@PathVariable Map<Long, String> pathVarsMap){
       this.studentService.deleteBookByBookId(Long.parseLong(pathVarsMap.get("id")));
        return new ResponseEntity<>(pathVarsMap.get("id"),HttpStatus.ACCEPTED);
    }

    @PostMapping("login")
    public  ResponseEntity<Student>getUser(@Valid @RequestBody LoginDTO user){
        return new ResponseEntity<>(studentService.getUser(user),HttpStatus.OK);
    }

}

