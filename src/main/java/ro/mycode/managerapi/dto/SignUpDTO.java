package ro.mycode.managerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SignUpDTO {
   @NonNull
    private String firstName;
   @NonNull
    private String lastName;
   @NonNull
    private String email;
   @NonNull
    private String password;

}


