package ro.mycode.managerapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.managerapi.constants.Constatnts.EMPTY_DATABASE_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST )
public class ExceptionBookDBEmpty extends RuntimeException {

    public ExceptionBookDBEmpty(){
        super(EMPTY_DATABASE_EXCEPTION);
    }
}
