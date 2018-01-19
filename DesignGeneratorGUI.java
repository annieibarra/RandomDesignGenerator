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

  //private DesignViewer designViewer;
  private DesignCanvas canvas;
  private JButton generatePocketDesignButton;
  private JButton generateFullDesignButton;
  private JButton previousDesignButton;
  private JButton saveDesignButton;
  private JPanel buttonPanel;

  /**
  * Creates a new DesignGeneratorFrame object
  */
  public DesignGeneratorGUI() {
    JFrame frame = new JFrame("LOGO NAME GOES HERE"); //change logo name when decided
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false); //maybe want to be resizable ??

    frame.setLayout(new BorderLayout());

    //the design viewer panel
    //designViewer = new DesignViewer();
    //frame.add(designViewer, BorderLayout.CENTER);

    canvas = new DesignCanvas();
    frame.add(canvas, BorderLayout.CENTER);

    //JButton button = new JButton("TEST BUTTON");
    //frame.add(button, BorderLayout.CENTER);

    //buttons for the lower panel and allow for each of them to be "heard"
    previousDesignButton = new JButton("Previous Design");
    previousDesignButton.addActionListener(this);

    generatePocketDesignButton = new JButton("Generate Pocket Design");
    generatePocketDesignButton.addActionListener(this);

    generateFullDesignButton = new JButton("Generate Full Size Design");
    generateFullDesignButton.addActionListener(this);

    //saveDesignButton = new JButton("Save Design");
    //saveDesignButton.addActionListener(this);

    buttonPanel = new JPanel(new GridLayout(1,5)); //make grid for buttons to be placed in

    //add each button to the grid
    buttonPanel.add(previousDesignButton);
    buttonPanel.add(generatePocketDesignButton);
    buttonPanel.add(generateFullDesignButton);
    //buttonPanel.add(saveDesignButton);

    frame.add(buttonPanel, BorderLayout.SOUTH); //place grid on bottom of the frame

    frame.pack();
    frame.setVisible(true);

  }

  /**
  * This method responds to actionEvents (buttons) being pressed
  * @param evt An action event
  */
  public void actionPerformed(ActionEvent evt)
  {
    if(evt.getSource() == generatePocketDesignButton) {
      //designViewer.setMode(1);
    }
    else if(evt.getSource() == generateFullDesignButton) {
      //designViewer.setMode(3);
    }
    else if(evt.getSource() == previousDesignButton) {
      //retrieve preiously generated design from database
      //make a "get next design" button available
        //check if it is the most recent design
        //if it is, make the "get next design" button go away or unavailable
    }
    // else if(evt.getSource() == saveDesignButton) {
    //   //save the design to the database
    // }
  }
}
