package be.user.service.exceptions;

public class InvalidUsernameOrPasswordException extends Exception {
    public InvalidUsernameOrPasswordException(String message) {
        super(message);
    }
}
