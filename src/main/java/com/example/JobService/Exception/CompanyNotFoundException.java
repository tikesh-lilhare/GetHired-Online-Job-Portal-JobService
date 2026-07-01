package com.example.JobService.Exception;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(String message) {

        super(message);
    }
}
