package drawing.handlers;

import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import drawing.commands.LineCommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LineButtonHandler implements EventHandler<ActionEvent>{
    private DrawingPane drawingPane;
    private CommandHistory history;

    public LineButtonHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            ICommand command = new LineCommand(drawingPane);
            history.exec(command);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
