package fr.polytech.netflixbackend.exception;

public class ResourceBadRequestException extends RuntimeException{
    public ResourceBadRequestException(String message) {
        super(message);
    }
}
