package drawing.handlers;

import drawing.commands.CommandHistory;
import drawing.commands.GroupCommand;
import drawing.commands.ICommand;
import drawing.exceptions.EmptySelectionException;
import drawing.exceptions.NotEnoughShapesException;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GroupButtonHandler implements EventHandler<ActionEvent> {
    private DrawingPane drawingPane;
    private CommandHistory history;

    public GroupButtonHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            ICommand command = new GroupCommand(drawingPane);
            history.exec(command);
        }catch(EmptySelectionException | NotEnoughShapesException e){
            e.printStackTrace();
        }
    }
}
