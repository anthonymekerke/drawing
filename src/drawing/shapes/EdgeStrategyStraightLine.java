package drawing.shapes;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class EdgeStrategyStraightLine implements IEdgeStrategy {

    @Override
    public void buildPath(IShape from, IShape to, Path path) {
        path.getElements().clear();

        MoveTo start = new MoveTo();
        start.xProperty().bind(from.translateXProperty());
        start.yProperty().bind(from.translateYProperty());

        LineTo end = new LineTo();
        end.xProperty().bind(to.translateXProperty());
        end.yProperty().bind(to.translateYProperty());

        path.getElements().addAll(start, end);
    }
}
