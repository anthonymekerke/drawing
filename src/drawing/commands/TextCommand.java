package drawing.commands;

import drawing.exceptions.IsAGroupException;
import drawing.shapes.IShape;
import drawing.shapes.ShapeComposite;
import drawing.shapes.ShapeDecorator;
import drawing.shapes.ShapeDecoratorText;
import drawing.ui.DrawingPane;

import java.util.ArrayList;
import java.util.List;

public class TextCommand implements ICommand {
    private DrawingPane drawingPane;
    private List<IShape> selection;
    private List<ShapeDecorator> decoratedShape;

    public TextCommand(DrawingPane drawingPane)
            throws IsAGroupException
    {
        this.drawingPane = drawingPane;
        this.selection = new ArrayList<>();
        this.decoratedShape = new ArrayList<>();

        this.selection.addAll(drawingPane.getSelection());

        for(IShape shape : selection){
            if(shape instanceof ShapeComposite){
                throw new IsAGroupException();
            }
            decoratedShape.add(new ShapeDecoratorText(shape, "text"));
        }
    }


    @Override
    public void execute() {
        for(IShape shape : selection){
            drawingPane.removeShape(shape);
            shape.setSelected(false);
        }

        for(ShapeDecorator shape : decoratedShape){
            drawingPane.addShape(shape);
        }
    }

    @Override
    public void undo() {
        for(ShapeDecorator shape : decoratedShape){
            drawingPane.removeShape(shape);
            shape.setSelected(false);
        }

        for(IShape shape : selection){
            drawingPane.addShape(shape);
        }
    }
}
