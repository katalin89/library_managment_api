package ro.mycode.managerapi.exceptions;

import static ro.mycode.managerapi.constatnts.Constants.STUDENT_EMPTY_DATABASE_EXCEPTION;

public class ExceptionStudentDbEmpty extends  RuntimeException {
    public ExceptionStudentDbEmpty(){
        super(STUDENT_EMPTY_DATABASE_EXCEPTION);
    }

}