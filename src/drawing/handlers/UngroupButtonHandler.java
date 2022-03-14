package drawing.handlers;

import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import drawing.commands.UngroupCommand;
import drawing.exceptions.NotAGroupException;
import drawing.exceptions.TooMuchShapesException;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UngroupButtonHandler implements EventHandler<ActionEvent> {
    private DrawingPane drawingPane;
    private CommandHistory history;

    public UngroupButtonHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            ICommand command = new UngroupCommand(drawingPane);
            history.exec(command);
        }catch(TooMuchShapesException | NotAGroupException e){
            e.printStackTrace();
        }
    }
}
