package drawing.shapes;

import javafx.beans.binding.DoubleBinding;
import javafx.scene.layout.Pane;

public abstract class ShapeDecorator implements IShape {
    protected IShape shapeDecorated;

    public ShapeDecorator(IShape shape){
        this.shapeDecorated = shape;
    }

    @Override
    public boolean isSelected() {
        return shapeDecorated.isSelected();
    }

    @Override
    public void setSelected(boolean selected) {
        shapeDecorated.setSelected(selected);
    }

    @Override
    public boolean isOn(double x, double y) {
        return shapeDecorated.isOn(x, y);
    }

    @Override
    public void offset(double x, double y) {
        shapeDecorated.offset(x, y);
    }

    @Override
    public void addShapeToPane(Pane pane) {
        shapeDecorated.addShapeToPane(pane);
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        shapeDecorated.removeShapeFromPane(pane);
    }

    @Override
    public IShape clone() {
        return shapeDecorated.clone();
    }

    @Override
    public DoubleBinding translateXProperty(){
        return shapeDecorated.translateXProperty();
    }

    @Override
    public DoubleBinding translateYProperty(){
        return shapeDecorated.translateYProperty();
    }

    @Override
    public void addStyle(String style){
        shapeDecorated.addStyle(style);
    }

    @Override
    public void removeStyle(String style){
        shapeDecorated.removeStyle(style);
    }

    @Override
    public void updateTranslation(){
        shapeDecorated.updateTranslation();
    }

    public abstract void decorate(Pane pane);

    public abstract void removeDecoration(Pane pane);
}
