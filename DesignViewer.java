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

   /*
   * Constructor for objects of Design Class
   */
   public DesignViewer() {
     Dimension canvasDimension = new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT); //creare the dimensions of the canvas that the designs will appear
     this.setPreferredSize(canvasDimension); //create canvas with dimensions made above
   }

 }
