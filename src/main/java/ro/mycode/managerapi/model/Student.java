package ro.mycode.managerapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.mycode.managerapi.exceptions.BookNotFoundException;
import ro.mycode.managerapi.exceptions.StudentHaveNotThatBookException;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Student")
@Table(name = "students")
@SuperBuilder
public class Student implements Comparable<Student> {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

    private Long id;

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, message = "Name must have min two caracters")
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @NotBlank(message = "Field must not be the empty string")
    private String lastName;

    @Column(name = "email", nullable = false)
    @Email(message = "That  string field must be a valid email address.")
    private String email;

    @Column(name = "age", nullable = false)
    @Min(value = 18, message = "A student must be min 18 years ")
    private int age;


    @Column(name = "password", nullable = false)
    @Size(min = 4, message = "Password must have four characters")
    private String password;

    @Override
    public boolean equals(Object o) {
        Student student = (Student) o;
        return this.age == student.age;
    }

    @Override
    public int compareTo(Student o) {
        if (this.age > o.age) {
            return 1;
        }
        if (this.age < o.age) {
            return -1;
        } else
            return 0;
    }


    @OneToMany(//un student este mapat la mai multe carti
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JsonManagedReference
    @Builder.Default
    List<Book> books = new ArrayList<>();

    //addBook


    public void addBook(Book book) {
        this.books.add(book);
        book.setStudent(this);//studentul va avea bookul respectiv
    }

    //eraseBook

    //sa sterga dupa id
    public void deleteBook(Book book) throws BookNotFoundException {
        if (exists(book.getId())) {

            this.books.remove(book);
            book.setStudent(null);
        } else
            throw new BookNotFoundException();
        // trow exception if book not exists


    }


    //findBook
    public boolean exists(Long id) {
        for (Book o : books) {
            if (o.getId() == id) {
                return true;
            }
        }
        return false;
    }
    //exceptie , functie care verifica daca studentul are cartea

    public boolean studentHasTheBook(Book book){
        for(Book b:books){
            if(b.getStudent()== book.getStudent()){
                return true;
            }
        }
        return false;

    }
}
