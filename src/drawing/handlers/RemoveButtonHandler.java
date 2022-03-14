package drawing.handlers;

import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import drawing.commands.RemoveCommand;
import drawing.exceptions.EmptySelectionException;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RemoveButtonHandler implements EventHandler<ActionEvent> {
    private DrawingPane drawingPane;
    private CommandHistory history;

    public RemoveButtonHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(ActionEvent event){
        try{
            ICommand command = new RemoveCommand(drawingPane);
            history.exec(command);
        }catch(EmptySelectionException e){
            e.printStackTrace();
        }
    }
}
