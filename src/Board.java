import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
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
	JLabel winnerLabel;
	JPanel centerPanel;
	private static int numberOfPits = 6;
	/**Constructor for the Board.  This is a JFrame and acts as the container for all the views and controllers.
	 * @param newmodel the Model object that Board communicates with.
	 * */
	public Board(Model newModel)
	{
		model = newModel;
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		add(centerPanel);
		initializeCenter();
		
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**This method initializes the start menu.  It allows you to choose the game mode of either 3 or 4 marbles.
	 * */
	private void initializeCenter()
	{
		JButton b1 = new JButton(" 3 ");
		JButton b2 = new JButton(" 4 ");
		JLabel label = new JLabel("Select the number of marbles :" );
		JPanel jp = new JPanel();
		jp.add(label);
		jp.add(b1);
		jp.add(b2);
		
		b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				model.setInitialNumberOfMarbles(3);
				showSelectColor();
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				model.setInitialNumberOfMarbles(4);
				getContentPane().removeAll();
				showSelectColor();
			}
		});
		centerPanel.add(jp);
	}
	/**This method creates the game board by calling all the methods that are responsible
	 * for setting up the North, South, East, and West sides of the board.
	 * */
	private void createBoard()
	{
		initializeNorth();
		initializeSouth();
		initializeEast();
		initializeWest();
		JButton undoButton = new JButton("Undo");
		winnerLabel = new JLabel();
		undoButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	model.loadState();	}
		});
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.add(undoButton);
		centerPanel.add(winnerLabel);
		add(centerPanel);
	}
	/**Responsible for setting up the North side of the board.  This will be Player B's pits.*/
	private void initializeNorth()
	{
		JPanel northPanel = new JPanel();
		for(int i = 0; i < numberOfPits; i++)
		{
			JLabel label = new JLabel("B" + (numberOfPits-i));
			JLabel marbleCount = new JLabel();
			final RegularPit pit = new RegularPit(model, label, marbleCount, i);
			label.setIcon(pit);
			model.attach(pit);
			marbleCount.setText("" + model.getNumberOfMarblesInPit(pit));
			label.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					boolean player = model.getPlayer();
					if(player == Model.PLAYER_B)
					{
						Pit cursor = pit;
						model.saveState();
						MancalaPit opponentsMancalaPit = model.getOpponentsMancalaPit(player);
						MancalaPit playersMancalaPit = model.getPlayersMancalaPit(player);
						
						//pick up the marbles in the current pit.
						int marblesInHand = model.getNumberOfMarblesInPit(pit);
						if(marblesInHand == 0)
							return;
						model.saveState();
						model.removeAllMarbles(pit);
						
						//put one in each pit until there are none left in your hand.
						while(marblesInHand > 0)
						{
							cursor = model.nextPit(cursor);
							if(!cursor.equals(opponentsMancalaPit))
							{
								model.addOneMarble(cursor);
								marblesInHand--;
							}
						}
						if(!cursor.equals(playersMancalaPit))
						{
							if(model.getNumberOfMarblesInPit(cursor) == 1 && cursor.getPitNumber() < 6 && cursor.getPitNumber() >= 0)
								model.takeFromAcross(cursor);
							model.setPlayer();
						}
						winnerLabel.setText(model.checkForWinner());
						if(!winnerLabel.getText().equals(""))
							initializeCenter();
					}
				}
			});
			northPanel.add(label);
			northPanel.add(marbleCount, BorderLayout.SOUTH);
		}
		add(northPanel, BorderLayout.NORTH);
	}
	/**Responsible for setting up the South side of the board.  This will be Player A's pits.*/
	private void initializeSouth()
	{
		JPanel southPanel = new JPanel();
		for(int i = 0; i < numberOfPits; i++)
		{
			JLabel label = new JLabel("A" +(i+1));
			JLabel marbleCount = new JLabel();
			final RegularPit pit = new RegularPit(model, label, marbleCount, i + 6);
			
			label.setIcon(pit);
			model.attach(pit);
			marbleCount.setText("" + model.getNumberOfMarblesInPit(pit));
			label.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					boolean player = model.getPlayer();
					if(player == Model.PLAYER_A)
					{
						Pit cursor = pit;
						MancalaPit opponentsMancalaPit = model.getOpponentsMancalaPit(player);
						MancalaPit playersMancalaPit = model.getPlayersMancalaPit(player);
						
						//pick up the marbles in the current pit.
						int marblesInHand = model.getNumberOfMarblesInPit(pit);
						if(marblesInHand == 0)
							return;
						model.saveState();
						model.removeAllMarbles(pit);
						
						//put one in each pit until there are none left in your hand.
						while(marblesInHand > 0)
						{
							cursor = model.nextPit(cursor);
							if(!cursor.equals(opponentsMancalaPit))
							{
								model.addOneMarble(cursor);
								marblesInHand--;
							}
						}
						if(!cursor.equals(playersMancalaPit))
						{
							if(model.getNumberOfMarblesInPit(cursor) == 1 && cursor.getPitNumber() < 12 && cursor.getPitNumber() >= 6)
								model.takeFromAcross(cursor);
							model.setPlayer();
						}
						winnerLabel.setText(model.checkForWinner());
						if(!winnerLabel.getText().equals(""))
							initializeCenter();
					}
				}
			});
			southPanel.add(label);
			southPanel.add(marbleCount, BorderLayout.NORTH);
		}
		add(southPanel, BorderLayout.SOUTH);
	}
	/**Responsible for setting up the East side of the board.  This will contain Player A's Mancala Pit.*/
	private void initializeEast()
	{
		JPanel eastPanel = new JPanel();
		JLabel eastLabel = new JLabel("A");
		JLabel marbleCount = new JLabel();
		MancalaPit eastMancalaPit = new MancalaPit(model, eastLabel, marbleCount, 12);
		eastLabel.setIcon(eastMancalaPit);
		model.attach(eastMancalaPit);
		marbleCount.setText("" + model.getNumberOfMarblesInPit(eastMancalaPit));
		eastPanel.add(marbleCount, BorderLayout.WEST);
		eastPanel.add(eastLabel);
		add(eastPanel, BorderLayout.EAST);
	}
	/**Responsible for setting up the West side of the board.  This will contain Player B's Mancala Pit.*/
	private void initializeWest()
	{
		JPanel westPanel = new JPanel();
		JLabel westLabel = new JLabel("B");
		JLabel marbleCount = new JLabel();
		MancalaPit westMancalaPit = new MancalaPit(model, westLabel, marbleCount, 13);
		westLabel.setIcon(westMancalaPit);
		model.attach(westMancalaPit);
		marbleCount.setText("" + model.getNumberOfMarblesInPit(westMancalaPit));
		westPanel.add(marbleCount, BorderLayout.EAST);
		westPanel.add(westLabel);
		add(westPanel, BorderLayout.WEST);
	}
	/**This method allows the user to choose which board version they want to play on.  They have the option 
	 * of playing with either red or green marbles.
	 * */
	private void showSelectColor()
	{
		JButton b1 = new JButton(" Red ");
		JButton b2 = new JButton(" Green ");
		JLabel label = new JLabel("Select the color of the marbles :" );
		JPanel jp = new JPanel();
		jp.add(label);
		jp.add(b1);
		jp.add(b2);
		
		b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				model.setColor(Color.RED);
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
				model.setColor(Color.GREEN);
				getContentPane().removeAll();
				createBoard();
				validate();
				repaint();
			}
		});
		getContentPane().removeAll();
		add(jp);
		validate();
		repaint();
	}
}