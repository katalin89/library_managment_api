package ro.mycode.managerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.managerapi.constatnts.Constants.STUDENT_NOT_FOUND_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentNotFoundException  extends RuntimeException{
    public  StudentNotFoundException(){
        super( STUDENT_NOT_FOUND_EXCEPTION );
    }


}
