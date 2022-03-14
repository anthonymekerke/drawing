package drawing.shapes;

import javafx.beans.binding.DoubleBinding;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;

public class Edge implements IShape {
    private IShape from;
    private IShape to;
    private IEdgeStrategy strategy;
    private Path shape;
    boolean selected;

    public Edge(IShape from, IShape to, IEdgeStrategy strategy){
        this.from = from;
        this.to = to;
        this.strategy = strategy;
        this.shape = new Path();
        this.selected = false;

        this.shape.getStyleClass().add("edge");
        this.strategy.buildPath(from, to, shape);
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
        this.from.setSelected(selected);
        this.to.setSelected(selected);
    }

    @Override
    public boolean isOn(double x, double y) {
        return (from.isOn(x,y) | to.isOn(x,y));
    }

    @Override
    public void offset(double x, double y) {}

    @Override
    public void addShapeToPane(Pane pane) {
        pane.getChildren().add(shape);

        from.addShapeToPane(pane);
        to.addShapeToPane(pane);
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        pane.getChildren().remove(shape);

        from.removeShapeFromPane(pane);
        to.removeShapeFromPane(pane);
    }

    @Override
    public IShape clone() {
        return null;
    }

    @Override
    public void addStyle(String style) {
        from.addStyle(style);
        to.addStyle(style);
    }

    @Override
    public void removeStyle(String style) {
        from.removeStyle(style);
        to.removeStyle(style);
    }

    @Override
    public DoubleBinding translateXProperty() {
        double  centerX = (from.translateXProperty().getValue() + to.translateXProperty().getValue()) / 2;

        return shape.translateXProperty().add(centerX);
    }

    @Override
    public DoubleBinding translateYProperty() {
        double centerY = (from.translateYProperty().getValue() + to.translateYProperty().getValue()) / 2;

        return shape.translateYProperty().add(centerY);
    }

    @Override
    public void updateTranslation(){}

    public void setEdgeStrategy(IEdgeStrategy strategy) {
        this.strategy = strategy;
        this.strategy.buildPath(from, to, shape);
    }

    public IEdgeStrategy getEdgeStrategy(){
        return this.strategy;
    }
}
