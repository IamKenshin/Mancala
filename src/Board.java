import java.awt.*;
import java.awt.Graphics;
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
		final JPanel board = new JPanel();
		final JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		board.setLayout(new BorderLayout());
		northPanel.add(new RegularPit(50, 10));
		board.add(northPanel, BorderLayout.NORTH);
		northPanel.setBounds(0, 0, 600, 200);
		//add north panel with 6 RegularPits
		//add south panel with 6 RegularPits
		//add east panel with 1 MancalaPit
		//add west panel with 1 MancalaPit
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
	}
}
