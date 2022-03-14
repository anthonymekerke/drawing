package drawing.commands;

import drawing.exceptions.EmptyPaneException;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

import java.util.ArrayList;
import java.util.List;

public class ClearCommand implements ICommand {
    private DrawingPane drawingPane;
    private List<IShape> shapesToClear;

    public ClearCommand(DrawingPane drawingPane)
            throws EmptyPaneException {

        this.drawingPane = drawingPane;
        shapesToClear = new ArrayList<>();

        for(IShape shape : drawingPane){shapesToClear.add(shape);}

        if(shapesToClear.isEmpty()){
            throw new EmptyPaneException();
        }
    }

    @Override
    public void execute() {
        for(IShape shape : shapesToClear){drawingPane.removeShape(shape);}
    }

    @Override
    public void undo() {
        for(IShape shape : shapesToClear){drawingPane.addShape(shape);}
    }
}
