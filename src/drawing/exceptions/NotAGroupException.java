package drawing.exceptions;

public class NotAGroupException extends Exception {
    public NotAGroupException(){
        super("Shape selected is not a group");
    }
}
