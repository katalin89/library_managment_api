package ro.mycode.managerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Student")
@Table(name="students")

public class Student implements Comparable<Student>{
   @Id
   @SequenceGenerator(name="student-sequence",sequenceName = "student-sequence",allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student-sequence")

   private Long id;

   @Column(name = "firstName",nullable = false)
   @Size(min=2)

    public int compareTo(Student o) {
        return 0;
    }
}
