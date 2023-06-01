package ro.mycode.managerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.managerapi.constatnts.Constants.EXISTING_USER;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistingUser  extends  RuntimeException{

    public ExistingUser(){
        super(EXISTING_USER);
    }

}
