import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * This class generates a pocket size design
 *
 * @author Annie Ibarra
 */
public class PocketDesign
{
    private BufferedImage background;
    private int x;
    private int y;

    /**
     * Constructor for objects of class Background
     * @param backgroundOfChoice The background chosen by the user
     */
    public Background(String backgroundOfChoice, int x1, int y1)
    {
        background = ImageLoader.loadImage(backgroundOfChoice);
        x = x1;
        y = y1;
    }

    /**
     * Returns the background you want
     */
    public BufferedImage getBackground()
    {
        return background;
    }

    public void drawBackground(Graphics brush)
    {
        brush.drawImage(background, x, y, null);
    }
}
