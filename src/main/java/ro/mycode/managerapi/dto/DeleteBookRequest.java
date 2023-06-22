package ro.mycode.managerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DeleteBookRequest {
    @NonNull
    private Long id;
    @NotEmpty
    private String bookName;
    @NonNull
    private LocalDate createdAt;
    @NonNull
    private Long studentId;


}
