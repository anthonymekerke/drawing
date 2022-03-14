package drawing.shapes;

import javafx.scene.shape.*;

public class EdgeStrategyOrthogonalVLine implements IEdgeStrategy {

    @Override
    public void buildPath(IShape from, IShape to, Path path) {
        path.getElements().clear();

        MoveTo start = new MoveTo();
        start.xProperty().bind(from.translateXProperty());
        start.yProperty().bind(from.translateYProperty());

        VLineTo line1 = new VLineTo();
        line1.setY((from.translateYProperty().getValue() + to.translateYProperty().getValue())/2);

        HLineTo line2 = new HLineTo();
        line2.setX(to.translateXProperty().getValue());

        LineTo end = new LineTo();
        end.xProperty().bind(to.translateXProperty());
        end.yProperty().bind(to.translateYProperty());

        path.getElements().addAll(start, line1, line2, end);
    }
}
