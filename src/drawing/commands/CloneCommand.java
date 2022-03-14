package drawing.commands;

import drawing.exceptions.EmptySelectionException;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

import java.util.ArrayList;
import java.util.List;

public class CloneCommand implements ICommand {
    private DrawingPane drawingPane;
    private List<IShape> clones;

    public CloneCommand(DrawingPane drawingPane)
            throws EmptySelectionException
    {
        IShape clone;
        this.drawingPane = drawingPane;
        this.clones = new ArrayList<>();

        for(IShape shape : drawingPane.getSelection()){
            clone = shape.clone();
            clones.add(clone);
        }

        if(clones.isEmpty()){
            throw new EmptySelectionException();
        }
    }

    @Override
    public void execute() {
        for(IShape clone : clones){
            clone.offset(20, 20);
            drawingPane.addShape(clone);
        }
    }

    @Override
    public void undo() {
        for(IShape clone : clones){
            clone.offset(-20, -20);
            drawingPane.removeShape(clone);
        }
    }
}
