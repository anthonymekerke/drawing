package drawing.shapes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ShapeDecoratorText extends ShapeDecorator {
    private Text text;

    public ShapeDecoratorText(IShape shape, String text){
        super(shape);
        this.text = new Text(text);
        this.text.getStyleClass().add("decorator-text");

        this.text.xProperty().bind(shape.translateXProperty());
        this.text.yProperty().bind(shape.translateYProperty());
    }

    @Override
    public void addShapeToPane(Pane pane) {
        shapeDecorated.addShapeToPane(pane);
        decorate(pane);
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        shapeDecorated.removeShapeFromPane(pane);
        removeDecoration(pane);
    }

    @Override
    public void decorate(Pane pane) {
        pane.getChildren().add(text);
    }

    @Override
    public void removeDecoration(Pane pane){
        pane.getChildren().remove(text);
    }
}
