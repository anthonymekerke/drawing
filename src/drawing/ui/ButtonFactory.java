package drawing.ui;

import drawing.images.ImageFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class ButtonFactory {
    enum Style{
        TEXT_ONLY,
        ICONS_ONLY
    }

    public static final String CLEAR_BUTTON = "Clear";
    public static final String REMOVE_BUTTON = "Remove";
    public static final String TRIANGLE_BUTTON = "Triangle";
    public static final String RECTANGLE_BUTTON = "Rectangle";
    public static final String CIRCLE_BUTTON = "Circle";
    public static final String GROUP_BUTTON = "Group";
    public static final String UNGROUP_BUTTON = "Ungroup";
    public static final String UNDO_BUTTON = "Undo";
    public static final String REDO_BUTTON = "Redo";
    public static final String CLONE_BUTTON = "Clone";
    public static final String TEXT_BUTTON = "Text";
    public static final String LINE_BUTTON = "Line";

    private Style style;

    public ButtonFactory(Style style){
        this.style = style;
    }

    public Button createButton(String buttonName){
        Tooltip tooltip = new Tooltip();
        ImageView icon = null;
        String text = "";
        Button button;

        switch(buttonName){
            case CLEAR_BUTTON:
                tooltip.setText("Delete all shapes");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("clear.png")) : null;
                text = style == Style.TEXT_ONLY ? CLEAR_BUTTON : "";
                break;

            case REMOVE_BUTTON:
                tooltip.setText("Delete the selected shapes");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("remove.png")) : null;
                text = style == Style.TEXT_ONLY ? REMOVE_BUTTON : "";
                break;

            case RECTANGLE_BUTTON:
                tooltip.setText("Draw a rectangle");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("rectangle.png")) : null;
                text = style == Style.TEXT_ONLY ? RECTANGLE_BUTTON : "";
                break;

            case TRIANGLE_BUTTON:
                tooltip.setText("Draw a triangle");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("triangle.png")) : null;
                text = style == Style.TEXT_ONLY ? TRIANGLE_BUTTON : "";
                break;

            case CIRCLE_BUTTON:
                tooltip.setText("Draw a circle");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("circle.png")) : null;
                text = style == Style.TEXT_ONLY ? CIRCLE_BUTTON : "";
                break;

            case GROUP_BUTTON:
                tooltip.setText("Group selected shapes");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("group.png")) : null;
                text = style == Style.TEXT_ONLY ? GROUP_BUTTON : "";
                break;

            case UNGROUP_BUTTON:
                tooltip.setText("Ungroup selected shapes");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("ungroup.png")) : null;
                text = style == Style.TEXT_ONLY ? UNGROUP_BUTTON : "";
                break;

            case UNDO_BUTTON:
                tooltip.setText("Undo the last command");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("undo.png")) : null;
                text = style == Style.TEXT_ONLY ? UNDO_BUTTON : "";
                break;

            case REDO_BUTTON:
                tooltip.setText("Redo the last command");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("redo.png")) : null;
                text = style == Style.TEXT_ONLY ? REDO_BUTTON : "";
                break;

            case CLONE_BUTTON:
                tooltip.setText("Clone the selected shapes");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("cloner.png")) : null;
                text = style == Style.TEXT_ONLY ? CLONE_BUTTON : "";
                break;

            case TEXT_BUTTON:
                tooltip.setText("Add text to selected shapes");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("text.png")) : null;
                text = style == Style.TEXT_ONLY ? TEXT_BUTTON : "";
                break;

            case LINE_BUTTON:
                tooltip.setText("link selected shapes");
                icon = style == Style.ICONS_ONLY ? new ImageView(ImageFactory.getImage("line.png")) : null;
                text = style == Style.TEXT_ONLY ? LINE_BUTTON : "";
                break;
        }

        if(text.equals("") && icon == null) {return null;}

        button = new Button(text, icon);
        button.setTooltip(tooltip);
        return button;
    }
}
