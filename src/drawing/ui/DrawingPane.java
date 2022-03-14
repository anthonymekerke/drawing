package drawing.ui;

import drawing.shapes.IShape;
import drawing.commands.CommandHistory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawingPane extends Pane implements Iterable<IShape>{

    public ArrayList<IShape> shapes;
    public ArrayList<IShape> selection;
    public ArrayList<Observer> observers;
    private CommandHistory commandHistory;

    public DrawingPane() {
        clipChildren();
        shapes = new ArrayList<>();
        selection = new ArrayList<>();
        observers = new ArrayList<>();
        commandHistory = new CommandHistory();
    }


    /**
     * Clips the children of this {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     */
    void clipChildren() {
        final Rectangle outputClip = new Rectangle();
        this.setClip(outputClip);

        this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
        shape.addShapeToPane(this);

        updateObservers();
    }

    public void removeShape(IShape shape){
        shapes.remove(shape);
        shape.removeShapeFromPane(this);

        updateObservers();
    }

    public void addObserver(Observer obs){
        observers.add(obs);
        updateObservers();
    }

    public void updateObservers(){
        int selected = 0;
        for(IShape shape : this.shapes){
            if(shape.isSelected()){selected++;}
        }

        for(Observer obs : observers){
            obs.update(getChildren().size(), selected, commandHistory.canUndo(), commandHistory.canRedo());
        }
    }

    public void updateSelection(){
        this.selection.clear();

        for(IShape shape : shapes){
            if(shape.isSelected()){
                selection.add(shape);
            }
        }
    }

    public CommandHistory getCommandHistory(){
        return this.commandHistory;
    }

    public List<IShape> getSelection(){
        return this.selection;
    }

    @Override
    public Iterator<IShape> iterator(){
        return this.shapes.iterator();
    }
}
