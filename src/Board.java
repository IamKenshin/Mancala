import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
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
		initializeCenter();
		
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void initializeCenter()
	{
		JButton b1 = new JButton(" 3 ");
		JButton b2 = new JButton(" 4 ");
		JLabel label = new JLabel("Select the number of marbles :" );
		JPanel jp = new JPanel(new FlowLayout());
		jp.add(label);
		jp.add(b1);
		jp.add(b2);
		
		b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				model.setInitialNumberOfMarbles(3);
				getContentPane().removeAll();
				createBoard();
				validate();
				repaint();
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				model.setInitialNumberOfMarbles(4);
				getContentPane().removeAll();
				createBoard();
				validate();
				repaint();
			}
		});
		add(jp, BorderLayout.CENTER);
	}
	
	private void createBoard()
	{
		initializeNorth();
		initializeSouth();
		initializeEast();
		initializeWest();
	}
	private void initializeNorth()
	{
		JPanel northPanel = new JPanel();
		for(int i = 0; i < numberOfPits; i++)
		{
			JLabel label = new JLabel("B" + (numberOfPits-i));
			label.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					if(!model.getPlayer())
					{
						
					}
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
			JLabel label = new JLabel("A" +(i+1));
			label.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					if(!model.getPlayer())
					{
						
					}
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
		JLabel eastLabel = new JLabel("A");
		MancalaPit eastMancalaPit = new MancalaPit(model, eastLabel, 12);
		eastLabel.setIcon(eastMancalaPit);
		model.attach(eastMancalaPit);
		add(eastLabel, BorderLayout.EAST);
	}
	private void initializeWest()
	{
		JLabel westLabel = new JLabel("B");
		MancalaPit westMancalaPit = new MancalaPit(model, westLabel, 13);
		westLabel.setIcon(westMancalaPit);
		model.attach(westMancalaPit);
		add(westLabel, BorderLayout.WEST);
	}
}
