package spbstu.CourseWork.main.exception;

public class InvalidJwtAuthentificationExceprion extends RuntimeException{
    public InvalidJwtAuthentificationExceprion(String message) {
        super(message);
    }
}
