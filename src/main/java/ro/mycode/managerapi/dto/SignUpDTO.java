package ro.mycode.managerapi.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
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