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

  private DesignViewer designViewer;
  private JButton generatePocketDesignButton;
  private JButton generateFullDesignButton;
  private JButton previousDesignButton;

  /**
  * Creates a new DesignGeneratorFrame object
  */
  public DesignGeneratorGUI() {
    JFrame frame = new JFrame("LOGO NAME GOES HERE"); //change logo name when decided
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true); //maybe want to be resizable ??

    frame.setLayout(new BorderLayout());

    //the design viewer panel
    designViewer = new DesignViewer();
    frame.add(designViewer, BorderLayout.CENTER);

    //buttons for the lower panel and allow for each of them to be "heard"
    previousDesignButton = new JButton("Previous Design");
    previousDesignButton.addActionListener(this);

    generatePocketDesignButton = new JButton("Generate Pocket Design");
    generatePocketDesignButton.addActionListener(this);

    generateFullDesignButton = new JButton("Generate Full Size Design");
    generateFullDesignButton.addActionListener(this);

    JPanel buttonPanel = new JPanel(new GridLayout(1,3)); //make grid for buttons to be placed in

    //add each button to the grid
    buttonPanel.add(previousDesignButton);
    buttonPanel.add(generatePocketDesignButton);
    buttonPanel.add(generateFullDesignButton);

    frame.add(buttonPanel, BorderLayout.PAGE_END); //place grid on bottom of the frame

    frame.pack();
    frame.setVisible(true);

  }

  /**
  * This method responds to actionEvents (buttons) being pressed
  * @param evt An action event
  */
  public void actionPerformed(ActionEvent evt)
  {

  }
}
