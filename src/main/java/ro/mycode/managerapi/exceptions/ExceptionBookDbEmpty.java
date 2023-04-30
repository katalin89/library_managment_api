package ro.mycode.managerapi.exceptions;

import static ro.mycode.managerapi.constatnts.Constants.EMPTY_DATABASE_EXCEPTION;

public class ExceptionBookDbEmpty extends RuntimeException{
    public ExceptionBookDbEmpty(){
        super(EMPTY_DATABASE_EXCEPTION);
    }
}
