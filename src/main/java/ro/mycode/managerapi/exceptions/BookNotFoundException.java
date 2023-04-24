package ro.mycode.managerapi.exceptions;


import static ro.mycode.managerapi.constatnts.Constants.BOOK_NOT_FOUND_EXCEPTION;

public class BookNotFoundException extends  RuntimeException{

    public BookNotFoundException(){
        super(BOOK_NOT_FOUND_EXCEPTION);

    }

}
