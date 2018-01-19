import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.util.ArrayList;
/**
 * The class represents the canvas with which the generated designs will appear
 *
 */
public class DesignCanvas extends JPanel
{
    public static final int CANVAS_WIDTH = 1000;
    public static final int CANVAS_HEIGHT = 1000;
    private BufferedImage bufferedImage;
    private Graphics2D bufferBrush;
    private Point spot;
    private int mode;
    private int backgroundMode;

    /**
     * Constructor for objects of class Painter
     */
    public DesignCanvas()
    {
        Dimension canvasDimension = new Dimension(CANVAS_WIDTH,CANVAS_HEIGHT); //create the dimensions of the canvas
        this.setPreferredSize(canvasDimension); //create the canvas with dimensions made above

        //makes a BufferedImage of the given width/height and using an int-precision RGB buffer
        bufferedImage = new BufferedImage(CANVAS_WIDTH,CANVAS_HEIGHT, BufferedImage.TYPE_INT_RGB);
        bufferBrush = bufferedImage.createGraphics();

        mode = 0; //0 means the brush is in line mode

        bufferBrush.setColor(Color.WHITE);
        bufferBrush.fillRect(0,0,CANVAS_WIDTH,CANVAS_HEIGHT); //make the canvas white
        //bufferBrush.setColor(Color.BLACK); //set the brush back to black as default

    }

    /**
    * Sets design mode
    * 0 - blank/note mode
    * 1 - pocket size design (4.25x5.5)
    * 2 - half size design (8.5x5.5) ADD LATER
    * 3 - full size design (10x10)
    **/
    public void setMode(int m)
    {
        mode = m;
    }

    /**
     * This method is what makes the design show up
     */
    public void paintComponent(Graphics brush)
    {
        brush.drawImage(bufferedImage, 0, 0, null); //bufferedImage is the name of the BufferedImage
        this.repaint();
        //bufferBrush.drawOval();
    }

    /**
     * This method draws a chosen background to fill
     */
    public void drawBackground()
    {
        if(backgroundMode == 1) //pocket design mode
        {
            // Background mushroomBackground = new Background("146142-butterfly-outline-drawings.png", 80, 0); //make and place new background
            //
            // mushroomBackground.drawBackground(bufferBrush);
            // this.repaint();
        }
        else if(backgroundMode == 2) //half size design mode
        {
            // Background ladybugBackground = new Background("ladybird.png", 50, 50); //make and place new background
            //
            // ladybugBackground.drawBackground(bufferBrush);
            // this.repaint();
        }
        else if(backgroundMode == 3) //full size design mode
        {
            // Background pizzaBackground = new Background("grapes.png", 140, 20); //make and place new background
            //
            // pizzaBackground.drawBackground(bufferBrush);
            // this.repaint();
        }
    }

}
