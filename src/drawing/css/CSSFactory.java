package drawing.css;

public class CSSFactory {

    private static final String CSS_DIR = "./";

    public static String getStyleSheet(String filename) {
        return CSSFactory.class.getResource(CSS_DIR + filename).toExternalForm();
    }

}

