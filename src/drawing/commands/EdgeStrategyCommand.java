package drawing.commands;

import drawing.exceptions.BadEdgeStrategyException;
import drawing.exceptions.NotAnEdgeException;
import drawing.shapes.Edge;
import drawing.shapes.IEdgeStrategy;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import drawing.ui.EdgeStrategyFactory;
import drawing.ui.ToolBar;

public class EdgeStrategyCommand implements ICommand {
    private DrawingPane drawingPane;
    private Edge edge;
    private IEdgeStrategy formerEdgeStrategy;
    private IEdgeStrategy newEdgeStrategy;

    public EdgeStrategyCommand(DrawingPane drawingPane, String edgeStrategy)
            throws NotAnEdgeException, BadEdgeStrategyException
    {
        for(IShape shape : drawingPane.getSelection()){
            if(shape instanceof Edge) {this.edge = (Edge)shape;}
        }
        if(this.edge == null){throw new NotAnEdgeException();}

        this.newEdgeStrategy = EdgeStrategyFactory.createEdgeStrategy(edgeStrategy);
        if(newEdgeStrategy == null){throw new BadEdgeStrategyException();}

        this.drawingPane = drawingPane;
        this.formerEdgeStrategy = edge.getEdgeStrategy();
    }


    @Override
    public void execute() {
        this.edge.setEdgeStrategy(newEdgeStrategy);
    }

    @Override
    public void undo() {
        this.edge.setEdgeStrategy(formerEdgeStrategy);
    }
}
