package drawing.commands;

import drawing.exceptions.EmptySelectionException;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommand implements ICommand {
    private DrawingPane drawingPane;
    private List<IShape> selection;

    public RemoveCommand(DrawingPane drawingPane)
            throws EmptySelectionException
    {
        this.drawingPane = drawingPane;
        this.selection = new ArrayList<>();

        selection.addAll(drawingPane.getSelection());

        if(selection.isEmpty()){
            throw new EmptySelectionException();
        }
    }

    @Override
    public void execute() {
        for(IShape shape : selection){
            drawingPane.removeShape(shape);
        }
    }

    @Override
    public void undo() {
        for(IShape shape : selection){
            drawingPane.addShape(shape);
        }
    }
}
