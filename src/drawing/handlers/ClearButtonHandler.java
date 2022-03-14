package drawing.handlers;

import drawing.commands.ClearCommand;
import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import drawing.exceptions.EmptyPaneException;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<ActionEvent> {
    private DrawingPane drawingPane;
    private CommandHistory history;

    public ClearButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(ActionEvent event) {
        try{
            ICommand command = new ClearCommand(drawingPane);
            history.exec(command);
        }catch(EmptyPaneException e){
            e.printStackTrace();
        }
    }
}
