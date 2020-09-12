package com.dsmanioto.productsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UserAutenticationUserDontExistExecption extends RuntimeException {

    public UserAutenticationUserDontExistExecption(String message) {
        super(message);
    }

}
