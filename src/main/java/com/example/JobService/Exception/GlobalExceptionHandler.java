package com.example.JobService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(
            JobNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleJobNotFound(
            JobNotFoundException ex) {

        ErrorResponse response =
                new ErrorResponse(

                        LocalDateTime.now(),

                        HttpStatus.NOT_FOUND.value(),

                        ex.getMessage()
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(
            CompanyNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleCompanyNotFound(
            CompanyNotFoundException ex) {

        ErrorResponse response =
                new ErrorResponse(

                        LocalDateTime.now(),

                        HttpStatus.NOT_FOUND.value(),

                        ex.getMessage()
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(
            Exception.class)
    public ResponseEntity<ErrorResponse>
    handleGenericException(
            Exception ex) {

        ErrorResponse response =
                new ErrorResponse(

                        LocalDateTime.now(),

                        HttpStatus.INTERNAL_SERVER_ERROR.value(),

                        ex.getMessage()
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @ExceptionHandler(
            MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>
    handleValidationException(
            MethodArgumentNotValidException ex) {

        String message =
                ex.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage();

        ErrorResponse response =
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        message
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }
}
