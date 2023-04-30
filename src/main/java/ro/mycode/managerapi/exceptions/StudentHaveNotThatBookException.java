package ro.mycode.managerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.managerapi.constatnts.Constants.STUDENT_NOT_HAS_THE_BOOK;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentHaveNotThatBookException extends  RuntimeException {

    public  StudentHaveNotThatBookException(){
        super(STUDENT_NOT_HAS_THE_BOOK);
    }
}

