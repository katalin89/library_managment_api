package ro.mycode.managerapi.exceptions;

import static ro.mycode.managerapi.constatnts.Constants.NOT_YOUR_BOOK_EXCEPTION;

public class NotYourBookException  extends  RuntimeException{
    public  NotYourBookException(){
        super( NOT_YOUR_BOOK_EXCEPTION);
    }
}


