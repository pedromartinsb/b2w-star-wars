package br.com.pedrom.starwars.services.exceptions;

import java.io.Serializable;

public class ObjectAlreadyExistException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public ObjectAlreadyExistException(String message) {
        super(message);
    }
}
