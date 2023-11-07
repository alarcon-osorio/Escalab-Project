package com.tlaxcala.exception;

//import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
//import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
//mport org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ResponseExceptionHandler {

    // Desarrollando excepciones custom
    // Alternativa 1: desde Spring Boot 1.5 hasta el día de hoy
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        CustomErrorResponse err = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // Alternativa 2: desde Spring Boot 3
    /*@ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        // personalización
        problemDetail.setTitle("Model Not Found Exception");
        problemDetail.setType(URI.create("/not-found")); // bloque de info.
        problemDetail.setProperty("extra1", "extra-value");
        problemDetail.setProperty("extra-2", 32);
        return problemDetail;
    }*/

    // Alternativa 3: desde Spring Boot 3
    /*@ExceptionHandler(ModelNotFoundException.class)
    public ErrorResponse handleModelNotFoundExcepcion(ModelNotFoundException ex, WebRequest request) {
        return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage())
            .title("Model Not Found")
            .type(URI.create(request.getContextPath()))
            .property("extra1", "extra-value")
            .property("extra", 2)
            .build();
    }*/
    
}
