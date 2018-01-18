import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

/**
 * A simple GUI to generate and view a random design.
 *
 * @author Annie Ibarra
 *
 */
 public class DesignGeneratorGUI implements ActionListener {

   private Design design;
   private JButton generatePocketDesignButton;
   private JButton generateFullDesignButton;
   private JButton previousDesignButton;

   /**
   * Creates a new DesignGeneratorFrame object
   */
   public DesignGeneratorGUI() {
     JFrame frame = new JFrame("LOGO NAME GOES HERE"); //change logo name when decided
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setResizable(false); //maybe want to be resizable ??

     frame.setLayout(new BorderLayout());

     //the design panel
     design = new Design; //ADD DESIGN.JAVA CLASS!!!!!
     frame.add(design, BorderLayout.CENTER);

     //buttons for the lower panel and allow for each of them to be "heard"
     

   }

 }
