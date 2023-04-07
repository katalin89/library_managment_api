package ro.mycode.managerapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Book")
@Table(name="books")
//cu ajutorul builder putem adauga cari in managerApiApplication
@SuperBuilder
public class Book implements  Comparable<Book>{

    @Id
    @SequenceGenerator(name="book_sequence",sequenceName = "book_sequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "book_sequence")
    private Long id;


    @Column(name="book_name",nullable = false)
    @NotBlank(message = "string field must not be the empty string")
    private String bookName;


    @Column(name="created_at",nullable = false)
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_id_fk")

    )
    @JsonBackReference
    private Student student;


    @Override
    public int compareTo(Book o) {
        return 0;
    }
}
