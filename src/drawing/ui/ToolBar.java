package drawing.ui;

import drawing.handlers.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class ToolBar extends HBox implements Observer{
    private Button clearButton, rectangleButton, circleButton, triangleButton, removeButton,
            groupButton, ungroupButton, undoButton, redoButton, cloneButton, textButton,
            lineButton;

    private ComboBox<String> comboBox;

    private DrawingPane drawingPane;

    public ToolBar(DrawingPane drawingPane){
        this.drawingPane = drawingPane;

        ButtonFactory factory = new ButtonFactory(ButtonFactory.Style.ICONS_ONLY);

        clearButton = factory.createButton(ButtonFactory.CLEAR_BUTTON);
        rectangleButton = factory.createButton(ButtonFactory.RECTANGLE_BUTTON);
        circleButton = factory.createButton(ButtonFactory.CIRCLE_BUTTON);
        triangleButton = factory.createButton(ButtonFactory.TRIANGLE_BUTTON);
        removeButton = factory.createButton(ButtonFactory.REMOVE_BUTTON);
        groupButton = factory.createButton(ButtonFactory.GROUP_BUTTON);
        ungroupButton = factory.createButton(ButtonFactory.UNGROUP_BUTTON);
        undoButton = factory.createButton(ButtonFactory.UNDO_BUTTON);
        redoButton = factory.createButton(ButtonFactory.REDO_BUTTON);
        cloneButton = factory.createButton(ButtonFactory.CLONE_BUTTON);
        textButton = factory.createButton(ButtonFactory.TEXT_BUTTON);
        lineButton = factory.createButton(ButtonFactory.LINE_BUTTON);

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(EdgeStrategyFactory.EDGE_STRATEGY_HLINE,
                EdgeStrategyFactory.EDGE_STRATEGY_VLINE, EdgeStrategyFactory.EDGE_STRATEGY_STRAIGHT);

        buildUI();
        addListeners();
    }

    private void buildUI(){
        this.getStyleClass().add("toolbar");
        this.setPadding(new Insets(5));
        this.setSpacing(5.0);

        this.getChildren().addAll(undoButton, redoButton, clearButton, rectangleButton, circleButton, triangleButton,
                removeButton, groupButton, ungroupButton, cloneButton, textButton, lineButton, comboBox);
    }

    private void addListeners(){
        ComboBoxHandler comboBoxHandler = new ComboBoxHandler(drawingPane);

        clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(drawingPane));
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));
        removeButton.addEventFilter(ActionEvent.ACTION, new RemoveButtonHandler(drawingPane));
        groupButton.addEventFilter(ActionEvent.ACTION, new GroupButtonHandler(drawingPane));
        ungroupButton.addEventFilter(ActionEvent.ACTION, new UngroupButtonHandler(drawingPane));
        undoButton.addEventFilter(ActionEvent.ACTION, new UndoButtonHandler(drawingPane));
        redoButton.addEventFilter(ActionEvent.ACTION, new RedoButtonHandler(drawingPane));
        cloneButton.addEventFilter(ActionEvent.ACTION, new CloneButtonHandler(drawingPane));
        textButton.addEventFilter(ActionEvent.ACTION, new TextButtonHandler(drawingPane));
        lineButton.addEventFilter(ActionEvent.ACTION, new LineButtonHandler(drawingPane));
        comboBox.addEventFilter(ActionEvent.ACTION, comboBoxHandler);
        comboBoxHandler.ComboBoxValueProperty().bind(comboBox.valueProperty());
    }

    @Override
    public void update(int created, int selected, boolean undo, boolean redo){

        if(created == 0){clearButton.setDisable(true);}
        else{clearButton.setDisable(false);}

        if(selected < 1){
            groupButton.setDisable(true);
            ungroupButton.setDisable(true);
            removeButton.setDisable(true);
            cloneButton.setDisable(true);
            textButton.setDisable(true);
        }
        else if(selected == 1){
            removeButton.setDisable(false);
            cloneButton.setDisable(false);
            textButton.setDisable(false);
        }
        else{
            groupButton.setDisable(false);
            ungroupButton.setDisable(false);
        }
        if(created >= 2 && selected >= 1){
            ungroupButton.setDisable(false);
        }

        undoButton.setDisable(undo);
        redoButton.setDisable(redo);
    }
}
