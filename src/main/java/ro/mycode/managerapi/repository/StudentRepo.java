package ro.mycode.managerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.managerapi.model.Book;
import ro.mycode.managerapi.model.Student;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("select distinct s.firstName,s.lastName from Student  s")
    List<String> getAllStudentsName();

  //Book b :este declarare ca si Student s daca nu declaram va afisa cannot resolv symbol
    @Query("select b   from Book b where b.student.id=?1 and b.bookName=?2")
    List<Book>studentHaveBook(Long id,String bookName);

    @Transactional
    @Modifying
    @Query("delete from Student s where s.firstName=?1 and s.lastName=?2")
    void deleteByName(String firstName,String lastName);

    @Transactional
    @Modifying
    @Query("delete from Student s where s.id=?1")
    void deleteById(Long id);


    @Query("select s from Student s where s.email=?1 and s.password=?2" )
    Optional<Student> login(String email, String password);

    @Query("select s from Student s where s.firstName=?1 and s.lastName=?2 and s.email=?3 and s.password=?4")
    Optional<Student>signUp(String firstName,String lastName,String email,String password);

  @Query("select b from Book b where b.student.id=?1")
  List<Book> getAllStudentsBook(Long id);

  //




}
