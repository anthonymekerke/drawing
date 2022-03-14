package drawing.handlers;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectionHandler implements EventHandler<MouseEvent> {
    private DrawingPane drawingPane;

    public SelectionHandler(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(MouseEvent event){
        boolean isOnShape = false;

        for(IShape shape : drawingPane){
            if(shape.isOn(event.getX(), event.getY())){
                if(shape.isSelected()) {
                    shape.setSelected(false);
                }
                else{
                    shape.setSelected(true);
                }
                isOnShape = true;
            }
        }
        if(!isOnShape){
            for(IShape shape : drawingPane) {shape.setSelected(false);}
        }

        drawingPane.updateObservers();
        drawingPane.updateSelection();
    }
}
