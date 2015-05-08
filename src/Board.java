import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is to describe the general look of the app. All the views are added to this View, then this view is added to a JFrame in the main method.
 * @author Team Dragon
 */
public class Board extends JFrame
{
	/**
	 * Constructor. Add all the pits to the panel.
	 */
	public Board()
	{
		int numberOfPits = 6;
		//We might want to think about using a null layout and manually setting the location for each pit.
		//However, idk how the marbles would work.  Maybe create a JPanel for each pit and add a marble to it.
		
		JPanel northPanel = new JPanel();
		//RegularPit nPit1 = new RegularPit(0, 0);
		for(int i = 0; i < numberOfPits; i++)
		{
			JLabel label = new JLabel();
			label.setIcon(new RegularPit(label));
			northPanel.add(label);
		}
		add(northPanel, BorderLayout.NORTH);

		//add north panel with 6 RegularPits
		//add south panel with 6 RegularPits
		//add east panel with 1 MancalaPit
		//add west panel with 1 MancalaPit
		
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
