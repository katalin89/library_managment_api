package ro.mycode.managerapi.exceptions;

import static ro.mycode.managerapi.constatnts.Constants.STUDENT_ALREADY_HAS_THE_BOOK;

public class ExceptionStudentAlreadyHasTheBook extends RuntimeException{
    public ExceptionStudentAlreadyHasTheBook(){
        super(STUDENT_ALREADY_HAS_THE_BOOK);
    }
}
