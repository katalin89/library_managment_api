package ro.mycode.managerapi.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.managerapi.dto.AddBookRequest;
import ro.mycode.managerapi.exceptions.BookNotFoundException;
import ro.mycode.managerapi.exceptions.ExceptieBookDbEmpty;
import ro.mycode.managerapi.exceptions.StudentHaveNotThatBookException;
import ro.mycode.managerapi.exceptions.StudentNotFoundException;
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
//
//    public List<Book> getAllBooks()throws ExceptieBookDbEmpty{
//        List<Book> books=bookRepo.getAllBookName();
//        if(books.size()>0){
//            return  books;
//        }
//        throw ExceptieBookDbEmpty;
//    }





    @Transactional
    @Modifying
    public void addBookToStudent(AddBookRequest addBookRequest) {
        Optional<Student> student = studentRepo.findById(addBookRequest.getStudentId());
        if (student.isPresent()) {
                        Book book=Book.builder()
                    .bookName(addBookRequest.getBookName())
                    .createdAt(addBookRequest.getCreatedAt()).build();
            Student student1 = student.get();
            student1.addBook(book);
            studentRepo.saveAndFlush(student1);
        }else{

            throw new StudentNotFoundException();
        }

    }

    @Transactional
    @Modifying

//    public  void deleteBookByName(String bookName){

    public void deleteBookByBookName(Long id,String bookName) throws BookNotFoundException {
      Book byName=bookRepo.findBookByBookName(bookName);

      if(byName!=null){
          Optional<Student> optionalStudent = studentRepo.findById(id);

          if(optionalStudent.isPresent()){


              Student student = optionalStudent.get();


              if(student.exists(byName.getId())){
                  student.deleteBook(byName);


                  studentRepo.saveAndFlush(student);

              }else{

                 throw new StudentHaveNotThatBookException();
              }


          }else{
              throw new StudentNotFoundException();
          }
      }
        else
           throw new   BookNotFoundException();
 }

    public List<String> getAllBooks()throws ExceptieBookDbEmpty{
        List<String>books=bookRepo.getAllBookName();
        if(books.size()>0){
            return  books;
        }
        throw  new ExceptieBookDbEmpty();
    }
    public List<Book> getAllStudentsBook(Long id)throws  ExceptieBookDbEmpty{
        List<Book> books=bookRepo.getAllStudentsBook(id);

        if(books.size()>0){
            return  books;
        }
        throw new ExceptieBookDbEmpty();

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




