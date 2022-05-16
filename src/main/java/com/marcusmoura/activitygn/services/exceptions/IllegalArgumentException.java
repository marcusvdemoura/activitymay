package com.marcusmoura.activitygn.services.exceptions;

import java.io.Serializable;

public class IllegalArgumentException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public IllegalArgumentException (String msg){
        super(msg);
    }

    public IllegalArgumentException(String msg, Throwable cause){
        super(msg, cause);
    }
}
