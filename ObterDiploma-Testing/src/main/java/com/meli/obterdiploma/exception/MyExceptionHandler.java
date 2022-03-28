package com.meli.obterdiploma.exception;

import com.meli.obterdiploma.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<List<ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<ObjectError> erros = e.getBindingResult().getAllErrors();
        List<ErrorDTO> results = new ArrayList<ErrorDTO>();
        erros.forEach(x -> {
            ErrorDTO error = new ErrorDTO("campo inválido", x.getDefaultMessage());
            results.add(error);
        });
        return new ResponseEntity<>(results, HttpStatus.BAD_REQUEST);
    }
}

