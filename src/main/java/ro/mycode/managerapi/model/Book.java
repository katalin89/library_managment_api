package ro.mycode.managerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Book")
@Table(name="books")

public class Book implements  Comparable<Book>{

    @Id
    @SequenceGenerator(name="book-sequence",sequenceName = "book-sequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "book-sequence")
    private Long id;

    @Column(name="student_id",nullable = false)
    @Size(min=1,message = "Id must be min 1")
    private Long studentId;

    @Column(name="book_name",nullable = false)
    @NotBlank(message = "string field must not be the empty string")
    private String bookName;


    @Column(name="created_at",nullable = false)
    @Min(value=1890,message = "The book have to be created after 1890")
    private String createdAt;


    @Override
    public int compareTo(Book o) {
        return 0;
    }
}
