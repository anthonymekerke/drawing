package drawing.exceptions;

public class NotEnoughShapesException extends Exception {
    public NotEnoughShapesException(){
        super("Not enough shapes selected");
    }
}
