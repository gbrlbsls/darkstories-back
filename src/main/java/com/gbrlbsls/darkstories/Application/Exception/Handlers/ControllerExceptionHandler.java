package com.gbrlbsls.darkstories.Application.Exception.Handlers;

import com.gbrlbsls.darkstories.Application.Exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity handleCustomException(CustomException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body("Internal error");
    }

}
