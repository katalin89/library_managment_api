package ro.mycode.managerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ro.mycode.managerapi.model.Student;

import javax.transaction.Transactional;
import java.util.List;

public interface  StudentRepo extends JpaRepository<Student,Long> {



}