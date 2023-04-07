package ro.mycode.managerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.managerapi.model.Student;

public interface  StudentRepo extends JpaRepository<Student,Long> {
}
