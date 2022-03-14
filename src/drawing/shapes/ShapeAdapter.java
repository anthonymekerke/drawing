package drawing.shapes;

import javafx.beans.binding.DoubleBinding;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape, Cloneable {
    protected Shape shape;
    private boolean selected;

    private double orgTranslateX;
    private double orgTranslateY;

    public ShapeAdapter(Shape shape){
        this.shape = shape;
        this.selected = false;
    }

    @Override
    public boolean isSelected() {return this.selected;}

    @Override
    public void setSelected(boolean selected){
        this.selected = selected;

        if(this.selected) {
            addStyle("selected");
        }
        else{
            removeStyle("selected");
        }
    }

    @Override
    public boolean isOn(double x, double y){
        return shape.getBoundsInParent().contains(x, y);
    }

    @Override
    public void offset(double x, double y){
        shape.setTranslateX(x + orgTranslateX);
        shape.setTranslateY(y + orgTranslateY);
    }

    @Override
    public void addShapeToPane(Pane pane){
        pane.getChildren().add(shape);
    }

    @Override
    public void removeShapeFromPane(Pane pane){
        pane.getChildren().removeAll(shape);
    }

    @Override
    public IShape clone(){
        ShapeAdapter clone;
        Shape clonedShape;

        if(shape instanceof Rectangle){
            clonedShape = new Rectangle(((Rectangle) shape).getX(), ((Rectangle) shape).getY(),
                    ((Rectangle) shape).getWidth(), ((Rectangle) shape).getHeight());
        }
        else if(shape instanceof Ellipse){
            clonedShape = new Ellipse(((Ellipse) shape).getCenterX(), ((Ellipse) shape).getCenterY(),
                    ((Ellipse) shape).getRadiusX(), ((Ellipse) shape).getRadiusY());
        }
        else{
            clonedShape = new Polygon();
            ((Polygon)clonedShape).getPoints().addAll(((Polygon)shape).getPoints());
        }

        clonedShape.getStyleClass().add("clone");
        clone = new ShapeAdapter(clonedShape);

        return clone;
    }

    @Override
    public DoubleBinding translateXProperty(){
        double centerX = getCenterX();
        return shape.translateXProperty().add(centerX);
    }

    @Override
    public DoubleBinding translateYProperty(){
        double centerY = getCenterY();
        return shape.translateYProperty().add(centerY);
    }

    @Override
    public void addStyle(String style){
        this.shape.getStyleClass().add(style);
    }

    @Override
    public void removeStyle(String style){
        this.shape.getStyleClass().remove(style);
    }

    @Override
    public void updateTranslation(){
        orgTranslateX = shape.getTranslateX();
        orgTranslateY = shape.getTranslateY();
    }

    private double getCenterX(){
        if(shape instanceof Ellipse){
            return ((Ellipse) shape).getCenterX();
        }
        if(shape instanceof Rectangle){
            return ((Rectangle) shape).getX() + (((Rectangle) shape).getWidth()/2);
        }
        else{
            double x1 = ((Polygon) shape).getPoints().get(0);
            double x2 = ((Polygon) shape).getPoints().get(2);
            double x3 = ((Polygon) shape).getPoints().get(4);

            double x1_2 = (x1 + x2)/2;
            return (x1_2 + x3)/2;
        }
    }

    private double getCenterY(){
        if(shape instanceof Ellipse){
            return ((Ellipse) shape).getCenterY();
        }
        if(shape instanceof Rectangle){
            return ((Rectangle) shape).getY() + (((Rectangle) shape).getHeight()/2);
        }
        if(shape instanceof Polygon){
            double y1 = ((Polygon) shape).getPoints().get(1);
            double y2 = ((Polygon) shape).getPoints().get(3);
            double y3 = ((Polygon) shape).getPoints().get(5);

            double y1_2 = (y1 + y2)/2;
            return (y1_2 + y3)/2;
        }
        else{
            return 0.0;
        }
    }
}
