package drawing.handlers;

import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import drawing.commands.TextCommand;
import drawing.exceptions.IsAGroupException;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class TextButtonHandler implements EventHandler<Event> {
    private DrawingPane drawingPane;
    private CommandHistory history;

    public TextButtonHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
        history = drawingPane.getCommandHistory();
    }


    @Override
    public void handle(Event event) {
        try{
            ICommand command = new TextCommand(drawingPane);
            history.exec(command);
        }catch(IsAGroupException e){
            e.printStackTrace();
        }
    }
}
