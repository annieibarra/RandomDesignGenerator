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
public class DesignCanvas extends JPanel implements MouseListener, MouseMotionListener
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

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
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
     * This method will let you change the color of the "brush" the user is currently drawing with
     * @param c A color
     */
    public void setPaintColor(Color c)
    {
        bufferBrush.setColor(c);
    }

    /**
     * Erases everything in the JPanel
     */
    public void eraseAll()
    {
        bufferBrush.setColor(Color.WHITE);
        bufferBrush.fillRect(0,0,CANVAS_WIDTH,CANVAS_HEIGHT); //make the canvas white
        this.repaint();
        spot = null;
        bufferBrush.setColor(Color.BLACK); //set the brush back to black as default
    }

    /**
     * Sets the brush size
     * @param width The new width of the brush
     */
    public void setBrushSize(float width)
    {
        BasicStroke stroke = new BasicStroke(width); //make a new basic stroke with given width

        bufferBrush.setStroke(stroke); //mnake the stroke that width
    }

    /**
     * This method flood fills an area of white space on a given background
     * @param x The X cordinate of the starting point of flood fill
     * @param y The Y cordinate of the starting point of flood fill
     * @param c The color that is being flood filled
     */
    public void floodFill(int x, int y, Color c)
    {
        ArrayList<Point> toFill = new ArrayList<Point>();
        Point startingPoint = new Point(x, y);
        int fillRGB = c.getRGB();
        toFill.add(startingPoint);
        while(toFill.size() != 0)
        {
            Point currentPoint = toFill.get(0); //get the starting point and set as current point
            int initialRGB = bufferedImage.getRGB(currentPoint.x, currentPoint.y); //get the initial rgb for the current point
            toFill.remove(0); //cross off to fill list
            //System.out.println(currentPoint);
            if(currentPoint.x > 0 && currentPoint.x < bufferedImage.getWidth()-1 && currentPoint.y < bufferedImage.getHeight()-1 && currentPoint.y > 0)
            {
                //System.out.println("in bounds");
                if(bufferedImage.getRGB(currentPoint.x, currentPoint.y) != Color.BLACK.getRGB() && fillRGB != initialRGB)
                {
                    bufferedImage.setRGB(currentPoint.x, currentPoint.y, fillRGB);
                    toFill.add(new Point((currentPoint.x+1), currentPoint.y));
                    toFill.add(new Point(currentPoint.x, (currentPoint.y+1)));
                    toFill.add(new Point((currentPoint.x-1), currentPoint.y));
                    toFill.add(new Point(currentPoint.x, (currentPoint.y-1)));
                }
            }
            //System.out.println(toFill.size());
        }
    }

    /**
     * This method draws a chosen background to fill
     */
    public void drawBackground()
    {
        if(backgroundMode == 1) //background 1 mode
        {
            // Background mushroomBackground = new Background("146142-butterfly-outline-drawings.png", 80, 0); //make and place new background
            //
            // mushroomBackground.drawBackground(bufferBrush);
            // this.repaint();
        }
        else if(backgroundMode == 2) //background 2 mode
        {
            // Background ladybugBackground = new Background("ladybird.png", 50, 50); //make and place new background
            //
            // ladybugBackground.drawBackground(bufferBrush);
            // this.repaint();
        }
        else if(backgroundMode == 3) //background 3 mode
        {
            // Background pizzaBackground = new Background("grapes.png", 140, 20); //make and place new background
            //
            // pizzaBackground.drawBackground(bufferBrush);
            // this.repaint();
        }
    }

    /**
     * This method draws a specified sticker at the location specified by a mouse event (e)
     * @param e A mouse event
     */
    public void drawSticker(MouseEvent e)
    {
        if(mode == 1) //ice cream sticker mode
        {
            //System.out.print("DrawingSticker");
            // int x = e.getX(); //get x cordinate of event
            // int y = e.getY(); //get y cordinate of event
            //
            // Sticker iceCreamSticker = new Sticker("melty_icecream_cone_l.png", x, y); //create a sticker with the points of e
            //
            // //allign the sticker with the mouse
            // iceCreamSticker.setXCordinate(x-(iceCreamSticker.stickerHalfHeight())); //move the sticker's location to the left by half its width
            // iceCreamSticker.setYCordinate(y-(iceCreamSticker.stickerHalfWidth())); //move the sticker's location down by half its height
            //
            // iceCreamSticker.drawSticker(bufferBrush);
            // this.repaint();
        }
        else if(mode == 2) //sun sticker mode
        {
            // int x = e.getX(); //get x cordinate of event
            // int y = e.getY(); //get y cordinate of event
            //
            // Sticker sunSticker = new Sticker("sun_strong_bold_T.png", x, y); //create a sticker with the points of e
            //
            // //allign the sticker with the mouse
            // sunSticker.setXCordinate(x-(sunSticker.stickerHalfHeight())); //move the sticker's location to the left by half its width
            // sunSticker.setYCordinate(y-(sunSticker.stickerHalfWidth())); //move the sticker's location down by half its height
            //
            // sunSticker.drawSticker(bufferBrush);
            // this.repaint();
        }
        else if(mode == 3) //strawberry sticker mode
        {
            // int x = e.getX(); //get x cordinate of event
            // int y = e.getY(); //get y cordinate of event
            //
            // Sticker strawberrySticker = new Sticker("strawberry-clip-art-nicubunu_Strawberry_Vector_Clipart.png", x, y); //create a sticker with the points of e
            //
            // //allign the sticker with the mouse
            // strawberrySticker.setXCordinate(x-(strawberrySticker.stickerHalfHeight())); //move the sticker's location to the left by half its width
            // strawberrySticker.setYCordinate(y-(strawberrySticker.stickerHalfWidth())); //move the sticker's location down by half its height
            //
            // strawberrySticker.drawSticker(bufferBrush);
            // this.repaint();
        }
        else if(mode == 4) //sunflower sticker mode
        {
            // int x = e.getX(); //get x cordinate of event
            // int y = e.getY(); //get y cordinate of event
            //
            // Sticker sunflowerSticker = new Sticker("sunflower_clipart_T.png", x, y); //create a sticker with the points of e
            //
            // //allign the sticker with the mouse
            // sunflowerSticker.setXCordinate(x-(sunflowerSticker.stickerHalfHeight())); //move the sticker's location to the left by half its width
            // sunflowerSticker.setYCordinate(y-(sunflowerSticker.stickerHalfWidth())); //move the sticker's location down by half its height
            //
            // sunflowerSticker.drawSticker(bufferBrush);
            // this.repaint();
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e A mouse event
     */
    public void mousePressed(MouseEvent e)
    {
        //System.out.println(stickerMode);
        int x = e.getX(); //get the x coordinate of mouse event
        int y = e.getY(); //get y coordinate of mouse event
        if(mode == 0) //line mode
        {
            spot = new Point(x, y); //sets stored point as where you clicked
            if(spot != null) //exception if the point is not defined
            {
                bufferBrush.fillOval(x, y, 2, 2); //draws line between previous and new points
            }
            this.repaint();
        }

        if(mode > 0 && mode < 5) //if it is in sticker mode, find which sticker
        {
            //this.drawSticker(e); //draw sticker
            this.repaint();
        }

        if(mode == 5)
        {
            //System.out.print(mode);
            Color brushColor = bufferBrush.getColor();
            //int rgb = brushColor.getRGB();

            this.floodFill(x, y, brushColor);//, 2000);
            this.repaint();
        }
    }

    /**
     * Invoked when a mouse button has been released on a component.
     * @param e A mouse event
     */
    public void mouseReleased(MouseEvent e)
    {
        spot = null; //when the mouse is not being touched let it be null
    }

    /**
     * Invoked when a mouse button is pressed on a component and then dragged.
     * @param e A mouse event
     */
    public void mouseDragged(MouseEvent e)
    {
        if(mode == 0) //line mode
        {
            int x = e.getX(); //get the x coordinate of mouse event
            int y = e.getY(); //get y coordinate of mouse event

            if(spot != null) //exception if the point is not defined
            {
                bufferBrush.drawLine(x, y, (int)spot.getX(), (int)spot.getY()); //draws line between previous and new points
            }
            spot = new Point(x, y); //sets stored point as where you clicked
            this.repaint();
        }

        if(mode > 0)
        {
            this.drawSticker(e);
            this.repaint();
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     * @param e A mouse event
     */
    public void mouseClicked(MouseEvent e)
    {

    }

    /**
     * Invoked when the mouse enters a component.
     * @param e A mouse event
     */
    public void mouseEntered(MouseEvent e)
    {

    }

    /**
     * Invoked when the mouse exits a component.
     * @param e A mouse event
     */
    public void mouseExited(MouseEvent e)
    {

    }

    /**
     * Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed.
     * @param e A mouse event
     */
    public void mouseMoved(MouseEvent e)
    {

    }

}
