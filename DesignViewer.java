import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.util.ArrayList;

/**
* Creates the canvas for the design to appear
*
* @author Annie Ibarra
*
*/
public class DesignViewer extends JPanel { //implements MouseListener, MouseMotionListener {

  public static final int CANVAS_WIDTH = 1000;
  public static final int CANVAS_HEIGHT = 1000;
  private BufferedImage bufferedImage; //the canvas with the design image output
  private Graphics2D bufferBrush; //this will be used to "draw" the design on the canvas
  private int mode;

  /*
  * Constructor for objects of Design Class
  */
  public DesignViewer() {
    Dimension canvasDimension = new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT); //creare the dimensions of the canvas that the designs will appear
    this.setPreferredSize(canvasDimension); //create canvas with dimensions made above

    //makes a BufferedImage of the given width/height and using an int-precision RGB buffer
    bufferedImage = new BufferedImage(CANVAS_WIDTH,CANVAS_HEIGHT, BufferedImage.TYPE_INT_RGB);
    bufferBrush = bufferedImage.createGraphics();

    mode = 0; //blank canvas

    bufferBrush.setColor(Color.BLACK);
    bufferBrush.fillRect(0,0,CANVAS_WIDTH,CANVAS_HEIGHT); //make the canvas white
    //bufferBrush.draw3DRect(0,0,CANVAS_WIDTH,CANVAS_HEIGHT, false);
  }

  /**
  * Sets design mode
  * 0 - blank
  * 1 - pocket size design (4.25x5.5)
  * 2 - half size design (8.5x5.5)
  * 3 - full size design (10x10)
  **/
  public void setMode(int m) {
    mode = m;
  }

  /**
  * This method is what makes the image show up
  */
  public void paintComponent(Graphics brush)
  {
    brush.drawImage(bufferedImage, 0, 0, null); //bufferedImage is the name of the BufferedImage
    this.repaint();
    //bufferBrush.drawOval();
  }

  /**
  * This method draws a generated design
  */
  public void drawDesign()
  {
    if(mode == 1) //pocket size design (4.25x5.5) mode
    {
      //Background mushroomBackground = new Background("146142-butterfly-outline-drawings.png", 80, 0); //make and place new background

      //mushroomBackground.drawBackground(bufferBrush);
      //this.repaint();
    }
    else if(mode == 2) //half size design (8.5x5.5) mode
    {
      //Background ladybugBackground = new Background("ladybird.png", 50, 50); //make and place new background

      //ladybugBackground.drawBackground(bufferBrush);
      //this.repaint();
    }
    else if(mode == 3) //full size design (10x10) mode
    {
      //Background pizzaBackground = new Background("grapes.png", 140, 20); //make and place new background

      //pizzaBackground.drawBackground(bufferBrush);
      //this.repaint();
    }
  }

}
