package ro.mycode.managerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.managerapi.model.Book;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public
interface BookRepo extends JpaRepository<Book,Long> {

    @Query("select distinct b.bookName from Book  b")
    List<String>getAllBooks();

    @Transactional
    @Modifying
    @Query("delete from Book b where b.bookName like ?1")
    void deleteBookByBookName(String bookName);

    @Transactional
    @Modifying
    @Query("delete from Book b where b.id=?1")
    void deleteById(Long id);

    Book findBookByBookName(String bookName);

    Book findBookById(Long id);

    @Transactional
    @Modifying
    @Query("select  b from Book b where b.bookName=?1")
    List<Book>findBookWith(String bookName);



}
