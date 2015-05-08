import java.awt.*;

import javax.swing.*;

/**
 * This is to describe the general look of the app. All the views are added to this View, then this view is added to a JFrame in the main method.
 * @author Team Dragon
 */
public class Board extends JPanel
{
	/**
	 * Constructor. Add all the pits to the panel.
	 */
	public Board()
	{
		//We might want to think about using a null layout and manually setting the location for each pit.
		//However, idk how the marbles would work.  Maybe create a JPanel for each pit and add a marble to it.
		final JFrame board = new JFrame();
		final JPanel northPanel = new JPanel();
		final RegularPit nPit1 = new RegularPit(50, 10);
		northPanel.setLayout(new FlowLayout());
		board.setSize(800, 400);
		board.setLayout(new BorderLayout());
		northPanel.add(nPit1);
		board.add(northPanel, BorderLayout.NORTH);
		//add north panel with 6 RegularPits
		//add south panel with 6 RegularPits
		//add east panel with 1 MancalaPit
		//add west panel with 1 MancalaPit
		
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
	}
}
