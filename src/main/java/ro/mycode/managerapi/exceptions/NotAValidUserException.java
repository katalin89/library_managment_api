package ro.mycode.managerapi.exceptions;

import static ro.mycode.managerapi.constatnts.Constants.NOT_A_VALID_USER;

public class NotAValidUserException extends  RuntimeException {
    public  NotAValidUserException(){
        super(NOT_A_VALID_USER);
    }
}
