package ro.mycode.managerapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.managerapi.constants.Constatnts.BOOK_DUPLICATION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionExistingBook extends RuntimeException {
    public ExceptionExistingBook(){
        super(BOOK_DUPLICATION);
    }
}
