package ro.mycode.managerapi.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.managerapi.dto.AddBookRequest;
import ro.mycode.managerapi.exceptions.*;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.model.Student;
import ro.mycode.managerapi.repository.BookRepo;
import ro.mycode.managerapi.repository.StudentRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private BookRepo bookRepo;

    private StudentRepo studentRepo;

    public StudentService(BookRepo bookRepo, StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
        this.bookRepo = bookRepo;
    }

    @Transactional
    @Modifying
    public void addBookToStudent(AddBookRequest addBookRequest) {
        //nu verificam daca are studentul deja cartea respectiva?
        if (studentRepo.studentHaveBook(addBookRequest.getStudentId(), addBookRequest.getBookName()).size()>0) {
            throw new ExceptionStudentAlreadyHasTheBook();
        }
            Optional<Student> student = studentRepo.findById(addBookRequest.getStudentId());
            if (student.isPresent()) {
                Book book = Book.builder()
                        .bookName(addBookRequest.getBookName())
                        .createdAt(addBookRequest.getCreatedAt()).build();
                Student student1 = student.get();
                student1.addBook(book);
                studentRepo.saveAndFlush(student1);
            } else {

                throw new StudentNotFoundException();
            }
        }


    @Transactional
    @Modifying
    public void deleteBookByBookName(Long studentId, String bookName) throws BookNotFoundException {
        Book byName = bookRepo.findBookByBookName(bookName);

        if (byName.getStudent().getId() == studentId) {
            if (byName != null) {
                Optional<Student> optionalStudent = studentRepo.findById(studentId);

                if (optionalStudent.isPresent()) {
                    Student student = optionalStudent.get();
                    if (student.exists(byName.getId())) {
                        student.deleteBook(byName);
                        studentRepo.saveAndFlush(student);
                    } else {
                        throw new StudentHaveNotThatBookException();
                    }

                } else {
                    throw new StudentNotFoundException();
                }
            } else
                throw new BookNotFoundException();
        }
        else {
            throw new StudentHaveNotThatBookException();
        }
    }

    public List<String> getAllStudentsName() throws ExceptionStudentDbEmpty {

        List<String> students = studentRepo.getAllStudentsName();

        if (students.size() > 0) {
            return students;
        }
        throw new ExceptionStudentDbEmpty();
    }

    public String getBook(String bookName) throws ExceptionBookDbEmpty {
        String book = bookRepo.getBook(bookName);
        if (book != "") {
            return book;
        }
        throw new ExceptionBookDbEmpty();
    }

    public List<Book> getAllStudentsBook(Long id) throws ExceptionBookDbEmpty {
        List<Book> books = bookRepo.getAllStudentsBook(id);

        if (books.size() > 0) {
            return books;
        }
        throw new ExceptionBookDbEmpty();

    }
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        studentRepo.saveAndFlush(student);
    }

//    public void deleteBookByBookName(Long id,String bookName) throws BookNotFoundException {
//        Book byName=bookRepo.findBookByBookName(bookName);
//
//        if(byName!=null){
//            bookRepo.deleteBookFromStudentList(id,bookName);
//        }
//        else
//            throw new   BookNotFoundException();
//
//
//
//    }

}




