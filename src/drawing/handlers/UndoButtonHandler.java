package drawing.handlers;

import drawing.commands.CommandHistory;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class UndoButtonHandler implements EventHandler<Event> {
    private DrawingPane drawingPane;
    private CommandHistory history;

    public UndoButtonHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(Event event) {
        history.undo();
    }
}
