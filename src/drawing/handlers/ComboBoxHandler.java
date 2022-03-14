package drawing.handlers;

import drawing.commands.CommandHistory;
import drawing.commands.EdgeStrategyCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComboBoxHandler implements EventHandler<ActionEvent> {
    private DrawingPane drawingPane;
    private CommandHistory history;

    private ObjectProperty<String> comboBoxValue = new SimpleObjectProperty<>();

    public ComboBoxHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
        this.history = drawingPane.getCommandHistory();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            ICommand command = new EdgeStrategyCommand(drawingPane, comboBoxValue.getValue());
            this.history.exec(command);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ObjectProperty<String> ComboBoxValueProperty(){
        return this.comboBoxValue;
    }
}
