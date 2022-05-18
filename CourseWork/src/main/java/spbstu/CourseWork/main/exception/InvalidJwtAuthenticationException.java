package spbstu.CourseWork.main.exception;

public class InvalidJwtAuthenticationException extends RuntimeException{
    public InvalidJwtAuthenticationException(String message) {
        super(message);
    }
}
