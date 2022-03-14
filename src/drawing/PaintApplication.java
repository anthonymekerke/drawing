package drawing;

import drawing.css.CSSFactory;
import drawing.handlers.MouseMoveHandler;
import drawing.handlers.SelectionHandler;
import drawing.ui.DrawingPane;
import drawing.ui.StatutBar;
import drawing.ui.ToolBar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PaintApplication extends Application {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Scene scene;
    private BorderPane root;

    private ToolBar toolBar;
    private StatutBar statutBar;
    private DrawingPane drawingPane;

    @Override
    public void start(Stage primaryStage){
        root = new BorderPane();
        scene = new Scene(root, WIDTH, HEIGHT);

        root.getStylesheets().add(
                CSSFactory.getStyleSheet("Paint.css")
        );

        buildUI();
        addListeners();

        primaryStage.setTitle("Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buildUI(){
        drawingPane = new DrawingPane();
        drawingPane.getStyleClass().add("drawingPane");
        root.setCenter(drawingPane);


        toolBar = new ToolBar(drawingPane);
        drawingPane.addObserver(toolBar);
        root.setTop(toolBar);

        statutBar = new StatutBar();
        drawingPane.addObserver(statutBar);
        root.setBottom(statutBar);
    }

    private void addListeners(){
        SelectionHandler selectionHandler = new SelectionHandler(drawingPane);
        MouseMoveHandler mouseMoveHandler = new MouseMoveHandler(drawingPane);

        root.setOnKeyTyped(keyEvent -> {
            drawingPane.setOnMousePressed(selectionHandler);
            drawingPane.setOnMouseReleased(null);
            drawingPane.setOnMouseDragged(null);
        });

        root.setOnKeyReleased(keyEvent -> {
            drawingPane.setOnMousePressed(mouseMoveHandler);
            drawingPane.setOnMouseReleased(mouseMoveHandler);
            drawingPane.setOnMouseDragged(mouseMoveHandler);
        });
    }

    public DrawingPane getDrawingPane() {
        return drawingPane;
    }

    public StatutBar getStatutBar() {return statutBar;}

    public static void main(String[] args) {
        launch(args);
    }
}
