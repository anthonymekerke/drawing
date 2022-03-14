package drawing.ui;

public interface Observer {
    void update(int created, int selected, boolean undo, boolean redo);
}
