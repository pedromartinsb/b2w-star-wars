package br.com.pedrom.starwars.controller.exception.handler;

import br.com.pedrom.starwars.controller.exception.StandardError;
import br.com.pedrom.starwars.services.exception.ObjectAlreadyExistException;
import br.com.pedrom.starwars.services.exception.ObjectNotEnabledException;
import br.com.pedrom.starwars.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
    //error 404
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    //error 409
    @ExceptionHandler({ ObjectAlreadyExistException.class })
    public ResponseEntity<Object> handleObjectAlreadyExist(final
                                                           RuntimeException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(System.currentTimeMillis(),
                status.value(), "PlanetAlreadyExist", e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    //error 401
    @ExceptionHandler(value = {ObjectNotEnabledException.class})
    public ResponseEntity<Object> handleObjectNotEnabled(final
                                                         RuntimeException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardError err = new StandardError(System.currentTimeMillis(),
                status.value(), "PlanetNotEnable", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}