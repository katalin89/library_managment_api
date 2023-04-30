package ro.mycode.managerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.model.Student;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("select distinct s.firstName,s.lastName from Student  s")
    List<String> getAllStudentsName();

  //Book b :este declarare ca si Student s daca nu declaram va afisa cannot resolv symbol
    @Query("select b   from Book b where b.student.id=?1 and b.bookName=?2")
    List<Book>studentHaveBook(Long id,String bookName);

//    @Query("select b from Book b where b.student.id=?1")
//    List<Book> getAllStudentsBook(Long id);

}
