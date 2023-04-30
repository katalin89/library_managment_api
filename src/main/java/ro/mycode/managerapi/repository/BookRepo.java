package ro.mycode.managerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.managerapi.model.Book;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

//chage class to interface
@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
//JpaRepository este o clasa de baza care contine queryuri de baza cu care putem obtine date de la o
// entitate de exemplu : getAll - ne da toate elemente intr-o tabela


    @Query("select distinct b.bookName from  Book b")
    List<String> getAllBookName();
    @Transactional
    @Modifying
    @Query("select b from Book b where b.bookName=?1 and b.createdAt=?2")
    List<Book>findBookWith(String bookName, LocalDate createdAt);

    @Transactional
    @Modifying
    @Query("select b from Book b where b.bookName=?1 ")
    List<Book>findBookWithName(String bookName);



    @Query("select b from Book b where b.bookName=?1")
    String getBook(String bookName);

    @Query("select b from Book b where b.student.id=?1")
    List<Book> getAllStudentsBook(Long id);


//SELECT * FROM employee WHERE name="employee name";
    Book findBookByBookName(String bookName);

}
