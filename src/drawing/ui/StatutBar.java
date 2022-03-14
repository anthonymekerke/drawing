package drawing.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StatutBar extends HBox implements Observer {
    private Label shapeCreated;
    private Label shapeSelected;

    public StatutBar(){
        this.shapeCreated = new Label("0 shape(s)");
        this.shapeSelected = new Label();

        buildUI();
    }

    private void buildUI(){
        this.setAlignment(Pos.CENTER_LEFT);
        this.getStyleClass().add("statutbar");

        this.getChildren().addAll(shapeCreated, shapeSelected);
    }

    public String getShapeCreatedText(){
        return shapeCreated.getText();
    }

    public String getShapeSelectedText() {return shapeSelected.getText();}

    public void update(int created, int selected, boolean undo, boolean redo){
        this.shapeCreated.setText(created + " shape(s)");

        if(selected != 0) {this.shapeSelected.setText(":" + selected + " selected");}
        else{this.shapeSelected.setText("");}
    }
}
