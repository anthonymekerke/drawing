package drawing.shapes;

import javafx.beans.binding.DoubleBinding;
import javafx.scene.layout.Pane;

public interface IShape{
    boolean isSelected();
    void setSelected(boolean selected);
    boolean isOn(double x, double y);
    void offset(double x, double y);
    void addShapeToPane(Pane pane);
    void removeShapeFromPane(Pane pane);

    IShape clone();

    void addStyle(String style);
    void removeStyle(String style);

    DoubleBinding translateXProperty();
    DoubleBinding translateYProperty();

    //should change later
    void updateTranslation();
}