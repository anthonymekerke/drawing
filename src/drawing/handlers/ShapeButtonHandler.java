package drawing.handlers;

import drawing.shapes.IShape;
import drawing.commands.CommandHistory;
import drawing.commands.ShapeCommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class ShapeButtonHandler implements EventHandler<Event> {

    private DrawingPane drawingPane;
    protected double originX;
    protected double originY;
    protected double destinationX;
    protected double destinationY;

    private CommandHistory history;

    public ShapeButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(Event event) {

        if (event instanceof ActionEvent) {
            drawingPane.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
        }

        if (event instanceof MouseEvent) {
            if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                drawingPane.addEventHandler(MouseEvent.MOUSE_RELEASED, this);
                originX = ((MouseEvent) event).getX();
                originY = ((MouseEvent) event).getY();
            }

            if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                destinationX = ((MouseEvent) event).getX();
                destinationY = ((MouseEvent) event).getY();

                history.exec(new ShapeCommand(drawingPane, createShape()));

                drawingPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, this);
                drawingPane.removeEventHandler(MouseEvent.MOUSE_RELEASED, this);
            }
        }
    }

    protected abstract IShape createShape();

}
