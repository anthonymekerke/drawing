package drawing.commands;

import drawing.exceptions.IsAGroupException;
import drawing.exceptions.NotValidSelectionException;
import drawing.shapes.*;
import drawing.ui.DrawingPane;

import java.util.ArrayList;
import java.util.List;

public class LineCommand implements ICommand {
    private DrawingPane drawingPane;
    private List<IShape> selection;
    private Edge edge;

    public LineCommand(DrawingPane drawingPane)
            throws NotValidSelectionException, IsAGroupException
    {
        List<IShape> selected = drawingPane.getSelection();
        if(selected.size() != 2){
            throw new NotValidSelectionException();
        }
        if(selected.get(0) instanceof ShapeComposite | selected.get(1) instanceof ShapeComposite){
            throw new IsAGroupException();
        }

        IEdgeStrategy edgeStrategy = new EdgeStrategyOrthogonalVLine();
        this.drawingPane = drawingPane;
        this.selection = new ArrayList<>();
        this.selection.addAll(selected);

        this.edge = new Edge(this.selection.get(0), this.selection.get(1), edgeStrategy);
    }

    @Override
    public void execute() {
        for(IShape shape : selection){
            drawingPane.removeShape(shape);
            shape.setSelected(false);
        }

        drawingPane.addShape(edge);
    }

    @Override
    public void undo() {
        drawingPane.removeShape(edge);

        for(IShape shape : selection){
            shape.setSelected(true);
            drawingPane.addShape(shape);
        }
    }
}
