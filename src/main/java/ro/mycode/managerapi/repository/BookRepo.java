package ro.mycode.managerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.managerapi.model.Book;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

}
