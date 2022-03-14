package drawing.images;

public class ImageFactory {

    private static final String IMG_DIR = "./";

    public static String getImage(String filename) {
        return ImageFactory.class.getResource(IMG_DIR + filename).toExternalForm();
    }
}
