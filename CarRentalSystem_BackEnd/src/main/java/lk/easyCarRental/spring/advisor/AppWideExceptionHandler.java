package lk.easyCarRental.spring.advisor;

import lk.easyCarRental.spring.exception.NotFoundException;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.util.ResponseUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception e){
        return new ResponseEntity(new ResponseUtil(500,e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e){
        return new ResponseEntity(new ResponseUtil(500,e.getMessage(),null),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleValidationException(ValidationException e){
        return new ResponseEntity(new ResponseUtil(500,e.getMessage(),null),HttpStatus.BAD_REQUEST);
    }
}
