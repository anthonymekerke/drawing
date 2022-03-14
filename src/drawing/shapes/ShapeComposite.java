package drawing.shapes;

import javafx.beans.binding.DoubleBinding;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class ShapeComposite implements IShape, Cloneable {
    private List<IShape> shapes;
    private boolean selected;

    public ShapeComposite(){
        this.shapes = new ArrayList<>();
        this.selected = false;
    }

    public void addShape(IShape shape){
        this.shapes.add(shape);
    }

    public List<IShape> getChildren(){
        return this.shapes;
    }


    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;

        for(IShape shape : shapes){
            shape.setSelected(selected);
        }
    }

    @Override
    public boolean isOn(double x, double y) {

        for(IShape shape : shapes) {
            if(shape.isOn(x,y)) {return true;}
        }

        return false;
    }

    @Override
    public void offset(double x, double y) {
        for(IShape shape : shapes) {shape.offset(x,y);}
    }

    @Override
    public void addShapeToPane(Pane pane) {
        for(IShape shape : shapes){shape.addShapeToPane(pane);}
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        for(IShape shape : shapes){shape.removeShapeFromPane(pane);}
    }

    @Override
    public IShape clone(){
        ShapeComposite groupShape;

        try{
            groupShape = (ShapeComposite) super.clone();
        }
        catch(Exception e){
            groupShape = null;
        }

        return groupShape;
    }

    @Override
    public DoubleBinding translateXProperty(){
        return null;
    }

    public DoubleBinding translateYProperty(){
        return null;
    }

    @Override
    public void addStyle(String style){
        for(IShape shape : shapes){
            shape.addStyle(style);
        }
    }

    @Override
    public void removeStyle(String style) {
        for (IShape shape : shapes) {
            shape.removeStyle(style);
        }
    }

    @Override
    public void updateTranslation(){
        for(IShape shape : shapes){
            shape.updateTranslation();
        }
    }
}
