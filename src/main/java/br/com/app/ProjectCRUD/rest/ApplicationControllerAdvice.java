package br.com.app.ProjectCRUD.rest;

import br.com.app.ProjectCRUD.rest.exception.APIExceptions;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIExceptions handleValidationErrors(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> messages = result.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return new APIExceptions(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<APIExceptions> handleResponseEntityException(ResponseStatusException ex) {
        String msgError = ex.getMessage();
        HttpStatus status = ex.getStatus();
        APIExceptions exceptions = new APIExceptions(msgError);

        return new ResponseEntity<>(exceptions, status);
    }
}
