package ro.mycode.managerapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.managerapi.constants.Constatnts.BOOK_NOT_FOUND_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookNotFoundException  extends RuntimeException{

    public  BookNotFoundException(){
        super(BOOK_NOT_FOUND_EXCEPTION);
    }
}