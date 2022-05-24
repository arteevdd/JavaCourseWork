package spbstu.CourseWork.main.exception;

public class BookTypeNotFoundException extends RuntimeException{
    public BookTypeNotFoundException(String message){
        super(message);
    }
}
