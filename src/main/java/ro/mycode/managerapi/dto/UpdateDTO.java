package ro.mycode.managerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@SuperBuilder
public class UpdateDTO {
    @NonNull
    private Long id;
    private String bookName;
    private LocalDate createdAt;
    @NonNull
    private Long studentId;

}

/*@Data
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



}*/