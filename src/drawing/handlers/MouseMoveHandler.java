package drawing.handlers;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class MouseMoveHandler implements EventHandler<MouseEvent> {
    private DrawingPane drawingPane;
    private List<IShape> selectedShape;

    private double orgSceneX;
    private double orgSceneY;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(MouseEvent event){
        if(event.getEventType().equals(MouseEvent.MOUSE_PRESSED)){
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();

            selectedShape = drawingPane.getSelection();
            for(IShape shape : selectedShape){
                shape.updateTranslation();
            }
        }

        if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
            if(selectedShape.isEmpty()) {return;}

            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;

            for(IShape shape: selectedShape){
                shape.offset(offsetX, offsetY);
            }
        }
    }
}
