package ro.mycode.managerapi.exceptions;

import static ro.mycode.managerapi.constatnts.Constants.EMPTY_DATABASE_EXCEPTION;

public class ExceptieBookDbEmpty extends RuntimeException{
    public  ExceptieBookDbEmpty(){
        super(EMPTY_DATABASE_EXCEPTION);
    }
}
