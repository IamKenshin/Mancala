import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	Model model;
	private static int numberOfPits = 6;
	public Board(Model newModel)
	{
		model = newModel;
		
		initializeNorth();
		initializeSouth();
		initializeEast();
		initializeWest();
		
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void initializeNorth()
	{
		JPanel northPanel = new JPanel();
		for(int i = 0; i < numberOfPits; i++)
		{
			JLabel label = new JLabel();
			label.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					//what to do on mouse click. check to see if the player going belongs to these pits.
					//remember, the MancalaPits are not clickable.
				}
			});
			RegularPit pit = new RegularPit(model, label, i);
			label.setIcon(pit);
			model.attach(pit);
			northPanel.add(label);
		}
		add(northPanel, BorderLayout.NORTH);
	}
	
	private void initializeSouth()
	{
		JPanel southPanel = new JPanel();
		for(int i = 0; i < numberOfPits; i++)
		{
			JLabel label = new JLabel();
			label.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					//what to do on mouse click. check to see if the player going belongs to these pits.
					//remember, the MancalaPits are not clickable.
				}
			});
			RegularPit pit = new RegularPit(model, label, i + 6);
			label.setIcon(pit);
			model.attach(pit);
			southPanel.add(label);
		}
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private void initializeEast()
	{
		JLabel eastLabel = new JLabel();
		MancalaPit eastMancalaPit = new MancalaPit(model, eastLabel, 10);
		eastLabel.setIcon(eastMancalaPit);
		add(eastLabel, BorderLayout.EAST);
	}
	private void initializeWest()
	{
		JLabel westLabel = new JLabel();
		MancalaPit westMancalaPit = new MancalaPit(model, westLabel, 11);
		westLabel.setIcon(westMancalaPit);
		add(westLabel, BorderLayout.WEST);
	}
}
