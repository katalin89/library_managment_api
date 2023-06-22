package ro.mycode.managerapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
//cu ajutorul builder putem adauga carti in managerApiApplication
@SuperBuilder
public class  Book implements  Comparable<Book>{

    @Id
    @SequenceGenerator(name="book_sequence",sequenceName = "book_sequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "book_sequence")
    private Long id;

    @Column(name="book_name",nullable = false)
    @NotBlank(message = "string field cannot be an empty string")
    private String bookName;


    @Column(name="created_at",nullable = false)
    private LocalDate createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_id_fk")

    )
    @JsonBackReference
    @ToString.Exclude
    private Student student;

    @Override
    public int compareTo(Book o) {
        if(this.bookName.compareTo(o.bookName)>0){
            return 1;
        }
        if(this.bookName.compareTo(o.bookName)<0){
            return -1;
        }else
        return 0;
    }



    @Override
    public boolean equals(Object o){
        Book book=(Book)o;
        return this.bookName.equals(book.bookName);
    }


}
