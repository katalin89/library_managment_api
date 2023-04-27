package ro.mycode.managerapi.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ro.mycode.managerapi.dtos.BookDTO;
import ro.mycode.managerapi.exceptii.BookNotFoundException;
import ro.mycode.managerapi.exceptii.ExceptionBookDBEmpty;
import ro.mycode.managerapi.exceptii.ExceptionExistingBook;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.repository.BookRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() throws ExceptionBookDBEmpty {
        List<Book> books = bookRepo.findAll();
        if (books.size() > 0) {
            return books;
        } else {
            throw new ExceptionBookDBEmpty();
        }
    }

    public void deleteById(Long id) throws BookNotFoundException {

        Book byId = bookRepo.findBookById(id);

        if (byId != null) {
            bookRepo.deleteById(id);
        } else {
            throw new BookNotFoundException();
        }

    }

    public void deleteByBookName(String bookName) throws BookNotFoundException {

        Book byModel = bookRepo.findBookByBookName(bookName);

        if (byModel != null) {
            bookRepo.deleteBookByBookName(bookName);
        } else {
            throw new BookNotFoundException();
        }

    }

    @Transactional
    @Modifying
    public void addBook(Book book) throws BookNotFoundException {

        List<Book> bookWith = bookRepo.findBookWith(book.getBookName());

        if (bookWith.size() > 0) {
            throw new ExceptionExistingBook();
        }

        this.bookRepo.saveAndFlush(book);
    }

    @Transactional
    @Modifying

    public void update(@RequestBody BookDTO book, String bookName) throws BookNotFoundException {
        Book b = bookRepo.findBookByBookName(book.getBookName());

        if (b == null) {
            throw new BookNotFoundException();
        }
        if (book.getBookName().equals("") == false) {
            b.setBookName(book.getBookName());
        }
        if (book.getCreatedAt().equals(null)) {
            b.setCreatedAt(book.getCreatedAt());
        }
    }
}

