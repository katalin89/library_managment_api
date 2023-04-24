package ro.mycode.managerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AddBookRequest {
//ce vine don Postman
    //antotarile ne precizeaza ca imputurile nu pot fi null sau gol
     @NotEmpty
     private String bookName;
     @NonNull
     private LocalDate createdAt;
     @NonNull
     private Long studentId;



}
