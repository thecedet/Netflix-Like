package fr.polytech.netflixbackend.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import fr.polytech.netflixbackend.dto.response.ErrorMessageDto;
import fr.polytech.netflixbackend.exception.ResourceAlreadyExistException;
import fr.polytech.netflixbackend.exception.ResourceBadRequestException;
import fr.polytech.netflixbackend.exception.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorMessageDto internalServerError(Exception ex) {
        ex.printStackTrace();
        return ErrorMessageDto.builder().code("INTERNAL_ERROR").message("An internal error occurred").build();
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorMessageDto resourceNotFound(ResourceNotFoundException ex) {
        return ErrorMessageDto.builder().code("NOT_FOUND").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorMessageDto noresourceNotFound(NoResourceFoundException ex) {
        return ErrorMessageDto.builder().code("NOT_FOUND").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessageDto resourceNotFound(ResourceAlreadyExistException ex) {
        return ErrorMessageDto.builder().code("RESOURCE_ALREADY_EXIST").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = ResourceBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessageDto badrequest(ResourceBadRequestException ex) {
        return ErrorMessageDto.builder().code("BAD_REQUEST").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessageDto badrequest(MethodArgumentNotValidException ex) {
        return ErrorMessageDto.builder().code("BAD_REQUEST").message(ex.getFieldError().getDefaultMessage()).build();
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessageDto badrequest(HttpMessageNotReadableException ex) {
        return ErrorMessageDto.builder().code("BAD_REQUEST").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorMessageDto badrequest(HttpRequestMethodNotSupportedException ex) {
        return ErrorMessageDto.builder().code("NOT_FOUND").message(ex.getMessage()).build();
    }

}
