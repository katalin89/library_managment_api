package ro.mycode.managerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
   @Size(min=2,message = "Name must have min two caracters")
   private String firstName;

   @Column(name="lastName",nullable = false)
   @NotBlank(message="Field must not be the empty string")
   private String lastName;

   @Column(name="email",nullable = false)
  @Email(message = "That a string field must be a valid email address.")
   private String email;

   @Column(name="age",nullable = false)
   @Min(value = 18,message = "A student must be min 18 years ")
   private int age;

   @Override
   public  boolean equals(Object o){
       Student student=(Student) o;
       return  this.age==student.age;
   }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
