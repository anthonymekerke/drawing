package drawing.commands;

import drawing.exceptions.NotAGroupException;
import drawing.exceptions.TooMuchShapesException;
import drawing.shapes.IShape;
import drawing.shapes.ShapeComposite;
import drawing.ui.DrawingPane;

import java.util.ArrayList;
import java.util.List;

public class UngroupCommand implements ICommand {
    private DrawingPane drawingPane;
    private List<IShape> selection;
    private ShapeComposite group;

    public UngroupCommand(DrawingPane drawingPane)
            throws TooMuchShapesException, NotAGroupException
    {
        List<IShape> selected = drawingPane.getSelection();

        if(selected.size() != 1){
            throw new TooMuchShapesException();
        }
        if(!(selected.get(0) instanceof ShapeComposite)){
            throw new NotAGroupException();
        }

        this.drawingPane = drawingPane;
        this.selection = new ArrayList<>();
        this.group = (ShapeComposite)selected.get(0);

        this.selection.addAll(((ShapeComposite) selected.get(0)).getChildren());
    }

    @Override
    public void execute(){
        drawingPane.removeShape(group);
        group.setSelected(false);
        group.removeStyle("group");

        for(IShape shape : selection){
            drawingPane.addShape(shape);
        }

        drawingPane.updateObservers();
    }

    @Override
    public void undo() {
        for(IShape shape : group.getChildren()){
            drawingPane.removeShape(shape);
        }

        drawingPane.addShape(group);
        group.setSelected(true);
        group.addStyle("group");

        drawingPane.updateObservers();
    }
}
