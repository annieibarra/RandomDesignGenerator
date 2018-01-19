import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * A class for loading external images.
 */
public class ImageLoader
{
    /**
     * This method opens an image file at a given location and returns a BufferedImage representing that picture
     * @param filename The filename & path to the image. E.g., "picture.jpg"
     * @return A BufferedImage representing the image
     */
    public static BufferedImage loadImage(String filename)
    {
        try
        {
            //gets the filename (relative to this .class file)
            return ImageIO.read(new Object() { }.getClass().getEnclosingClass().getResource(filename));
        }
        catch (IOException ioe) //in case something goes wrong
        {
            System.out.println("Failed to load image \'"+filename+"': "+ioe);
            return null;
        }
    }


}
