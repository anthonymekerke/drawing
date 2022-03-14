package drawing.handlers;

import drawing.shapes.IShape;
import drawing.shapes.ShapeAdapter;
import drawing.ui.DrawingPane;
import javafx.scene.shape.Polygon;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class TriangleButtonHandler extends ShapeButtonHandler {

    public TriangleButtonHandler(DrawingPane drawingPane) {
        super(drawingPane);
    }

    @Override
    protected IShape createShape() {
        double x1 = originX;
        double y1 = originY;

        double x2 = destinationX;
        double y2 = destinationY;

        double length = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));

        double x3 = x1 + Math.sqrt((length * length) / 2);
        double y3 = y1 + Math.sqrt((length * length) / 2);

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(x1, y1, x2, y2, x3, y3);
        triangle.getStyleClass().add("triangle");

        return new ShapeAdapter(triangle);
    }
}
