package drawing.commands;

import drawing.exceptions.EmptySelectionException;
import drawing.exceptions.NotEnoughShapesException;
import drawing.shapes.IShape;
import drawing.shapes.ShapeComposite;
import drawing.ui.DrawingPane;

import java.util.ArrayList;
import java.util.List;

public class GroupCommand implements ICommand {
    private DrawingPane drawingPane;
    private List<IShape> selection;
    private ShapeComposite group;

    public GroupCommand(DrawingPane drawingPane)
            throws EmptySelectionException, NotEnoughShapesException
    {
        if(drawingPane.getSelection().isEmpty()){
            throw new EmptySelectionException();
        }
        if(drawingPane.getSelection().size() == 1){
            throw new NotEnoughShapesException();
        }

        this.drawingPane = drawingPane;
        this.group = new ShapeComposite();
        this.selection = new ArrayList<>();

        selection.addAll(drawingPane.getSelection());
    }

    @Override
    public void execute() {
        for(IShape shape : selection){
            drawingPane.removeShape(shape);
            shape.setSelected(false);
            group.addShape(shape);
            shape.addStyle("group");
        }

        group.setSelected(true);
        drawingPane.addShape(group);
        drawingPane.updateObservers();
    }

    @Override
    public void undo() {
        drawingPane.removeShape(group);
        group.setSelected(false);

        for(IShape shape : selection){
            drawingPane.addShape(shape);
            shape.removeStyle("group");
        }
        group.getChildren().clear();
        drawingPane.updateObservers();
    }
}
