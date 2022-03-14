package drawing.handlers;

import drawing.commands.CloneCommand;
import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import drawing.exceptions.EmptySelectionException;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CloneButtonHandler implements EventHandler<ActionEvent> {
    private DrawingPane drawingPane;
    private CommandHistory history;

    public CloneButtonHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(ActionEvent actionEvent){
        try{
            ICommand command = new CloneCommand(drawingPane);
            history.exec(command);
        }
        catch(EmptySelectionException e){
            e.printStackTrace();
        }
    }
}
