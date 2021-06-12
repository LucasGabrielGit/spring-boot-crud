package br.com.app.ProjectCRUD.rest.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class APIExceptions {
    @Getter
    private List<String> errors;

    public APIExceptions(List<String> errors) {
        this.errors = errors;
    }

    public APIExceptions(String message) {
        this.errors = Arrays.<String>asList(message);
    }
}
