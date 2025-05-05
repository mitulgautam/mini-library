package dev.mitulgautam.minilibrary.controllers;

import ch.qos.logback.core.util.StringUtil;
import dev.mitulgautam.minilibrary.responseDto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> StringUtil.capitalizeFirstLetter(error.getField()) + " " + error.getDefaultMessage())
                .toList();
        ResponseDto<?> responseDto = new ResponseDto<>();
        responseDto.setError(String.join(". ", errors) + ".");
        return ResponseEntity.badRequest().body(responseDto);
    }
}
