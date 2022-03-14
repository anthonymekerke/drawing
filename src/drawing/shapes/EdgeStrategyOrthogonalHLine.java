package drawing.shapes;

import javafx.scene.shape.*;

public class EdgeStrategyOrthogonalHLine implements IEdgeStrategy {

    @Override
    public void buildPath(IShape from, IShape to, Path path) {
        path.getElements().clear();

        MoveTo start = new MoveTo();
        start.xProperty().bind(from.translateXProperty());
        start.yProperty().bind(from.translateYProperty());

        HLineTo line1 = new HLineTo();
        line1.setX((from.translateXProperty().getValue() + to.translateXProperty().getValue())/2);

        VLineTo line2 = new VLineTo();
        line2.setY(to.translateYProperty().getValue());

        LineTo end = new LineTo();
        end.xProperty().bind(to.translateXProperty());
        end.yProperty().bind(to.translateYProperty());

        path.getElements().addAll(start, line1, line2, end);
    }
}
