package drawing.commands;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class ShapeCommand implements ICommand {
    private DrawingPane drawingPane;
    private IShape shape;

    public ShapeCommand(DrawingPane drawingPane, IShape shape){
        this.drawingPane = drawingPane;
        this.shape = shape;
    }


    @Override
    public void execute() {
        drawingPane.addShape(shape);
    }

    @Override
    public void undo() {
        drawingPane.removeShape(shape);
    }
}
