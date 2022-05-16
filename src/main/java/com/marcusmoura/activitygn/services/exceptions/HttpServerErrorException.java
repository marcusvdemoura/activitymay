package com.marcusmoura.activitygn.services.exceptions;

import java.io.Serializable;

public class HttpServerErrorException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;


    public HttpServerErrorException(String msg) {
        super(msg);
    }

    public HttpServerErrorException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
