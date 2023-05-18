package ro.mycode.managerapi.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ro.mycode.managerapi.dto.AddBookRequest;
import ro.mycode.managerapi.dto.UpdateDTO;
import ro.mycode.managerapi.exceptions.*;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.repository.BookRepo;

import javax.transaction.Transactional;
import java.security.URIParameter;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Transactional
    public void update(UpdateDTO book) throws BookNotFoundException {
//optional luam datele din el
        Optional<Book> bookByBookId = bookRepo.findById(book.getId());

        //b.getStudent este null
        if (bookByBookId.isEmpty()) {

            throw new BookNotFoundException();
        } else if (book.getStudentId() != bookByBookId.get().getStudent().getId()) {
            throw new NotYourBookException();
        }

//       else if(book.getStudentId()==bookByBookId.get().getStudent().getId()){
//           throw new ExceptionStudentAlreadyHasTheBook();
//       }
        //todo:updates


        if (!book.getBookName().equals("")) {

            bookByBookId.get().setBookName(book.getBookName());

        }

        if (!book.getCreatedAt().equals("")) {
            bookByBookId.get().setCreatedAt(book.getCreatedAt());
        }


        bookRepo.saveAndFlush(bookByBookId.get());
    }

    public List<Book> getAllBooks() throws ExceptionBookDbEmpty {
        List<Book> books = bookRepo.findAll();
        if (books.size() > 0) {
            return books;
        }
        throw new ExceptionBookDbEmpty();

    }


}

