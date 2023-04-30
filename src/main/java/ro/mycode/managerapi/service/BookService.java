package ro.mycode.managerapi.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ro.mycode.managerapi.dto.AddBookRequest;
import ro.mycode.managerapi.dto.UpdateDTO;
import ro.mycode.managerapi.exceptions.BookNotFoundException;
import ro.mycode.managerapi.exceptions.NotYourBookException;
import ro.mycode.managerapi.exceptions.StudentNotFoundException;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.repository.BookRepo;

import javax.transaction.Transactional;
import java.security.URIParameter;
import java.util.List;

@Service
public class BookService {

    private BookRepo bookRepo;

    public  BookService(BookRepo bookRepo){
        this.bookRepo=bookRepo;
    }
    @Transactional
    @Modifying
    public  void update( UpdateDTO book) throws BookNotFoundException {
        Book b=bookRepo.findBookByBookName(book.getBookName());

        if( b.getId()!=0 && b.getStudent().getId()!= book.getStudentId()&& b.getId()!= book.getId()){
            throw new NotYourBookException();
        }


        if(b.getStudent().getId()!= book.getStudentId()){
            throw  new StudentNotFoundException();
        }

        if(b.getId()!= book.getId()){
            throw  new BookNotFoundException();
        }

        if(b==null){
            throw new BookNotFoundException();
        }
        if(b.getId()!= book.getId()&&b.getStudent().getId()!= book.getStudentId()){
            throw  new BookNotFoundException();
        }

        if(book.getBookName().equals("")==false){
            b.setBookName(book.getBookName());
        }
        if(book.getCreatedAt()!=null){
            b.setCreatedAt(book.getCreatedAt());
        }
    }

    public List<Book> getAllBooks() {
         return bookRepo.findAll();
    }
}

