package com.example.JobService.Exception;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException(
            String message) {

        super(message);
    }
}
