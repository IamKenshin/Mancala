import java.awt.Color;
import javax.swing.event.ChangeEvent;

/**
 * This is the model that holds all the data. It does all the heavy lifting of the app, and all the views just reflect what happens here.
 * There are alot of issues with this Class right now. I'm not sure how to access the pits exactly with parameters, so those int parameters are just dummies for now.
 * @author Team Dragon
 */
public class Model
{
	private Pit[] pits;
	private int[] numberOfMarbles;
	private int[] lastState;
	private int initialNumberOfMarbles;
	private boolean player; 
	private boolean lastPlayer;
	private Color color;
	public static boolean PLAYER_A = false;
	public static boolean PLAYER_B = true;
	private int undoCount;
	
	/**Constructor for Model class.  Initializes pits and numberOfMarbles arrays.  Also initializes the lastState array.
	 * lastState array will be used to undo changes.
	 * */
	public Model()
	{
		undoCount = 0;
		pits = new Pit[14];
		numberOfMarbles = new int[14];
		lastState = new int[14];
	}
	
	
	/**getPlayer() returns the current player.
	 * @return player boolean that is true if player A, false if player B
	 * */
	public boolean getPlayer()
	{
		return player;
	}
	
	/**setPlayer() Mutator that changes which player has an active turn.
	 * */
	public void setPlayer()
	{
		player = !player;
	}
	/**setInitialNumberOfMarbles(int initialNumber) sets how many marbles are in each RegularPit at the start of the game
	 * */
	public void setInitialNumberOfMarbles(int initialNumber)
	{	initialNumberOfMarbles = initialNumber;	}
	
	/**
	 * 
	 * @return the number of marbles in the corresponding Pit
	 * @param whichPitToAccess
	 */
	public int getNumberOfMarblesInPit(Pit whichPitToAccess)
	{
		int pitNumber = whichPitToAccess.getPitNumber();
		return numberOfMarbles[pitNumber];
	}
	
	/**
	 * This is used when a pit is clicked on. This can only be a RegularPit. You cannot remove from a MancalaPit.
	 * At the end of this, we need to notify the Pit that the state has changed.
	 * @param whichPitToRemoveFrom
	 */
	public void removeAllMarbles(Pit whichPitToRemoveFrom)
	{
		int pitNumber = whichPitToRemoveFrom.getPitNumber();
		numberOfMarbles[pitNumber] = 0;
		notifyListener(pitNumber);
	}
	
	/**
	 * adds one marbles to the Pit. As a player is moving around the board, the player adds one marble to each pit except for his opponent's manacala pit.
	 * At the end of this, we need to notify the Pit that the state has changed.
	 * @param whichPitToAddTo
	 */
	public void addOneMarble(Pit whichPitToAddTo)
	{
		int pitNumber = whichPitToAddTo.getPitNumber();
		numberOfMarbles[pitNumber]++;
		notifyListener(pitNumber);
	}
	/**Changes the current pit to the next pit in the array.  When a player adds a marble to the pit, if he still has marbles left he will advance to the next
	 * pit and deposit another marble.
	 * */
	public Pit nextPit(Pit currentPit)
	{
		int currentPitNumber = currentPit.getPitNumber();
		Pit nextPit = null;
		if(currentPitNumber >= 6 && currentPitNumber <= 11)
			nextPit = pits[++currentPitNumber];
		else if(currentPitNumber >= 1 && currentPitNumber <= 5)
			nextPit = pits[--currentPitNumber];
		else if(currentPitNumber == 0)
			nextPit = pits[13];
		else if(currentPitNumber == 12)
			nextPit = pits[5];
		else if(currentPitNumber == 13)
			nextPit = pits[6];
		return nextPit;
	}
	/**Method will get the opposing player's MancalaPit
	 * @param currentPlayer Either Player A or B
	 * @return MancalaPit either the East or West mancala pit
	 * */
	public MancalaPit getOpponentsMancalaPit(boolean currentPlayer)
	{
		if(currentPlayer == PLAYER_A)
			return (MancalaPit) pits[13];
		else
			return (MancalaPit) pits[12];
	}
	/**Method will get the player's MancalaPit
	 * @param currentPlayer Either Player A or B
	 * @return MancalaPit either the East or West mancala pit
	 * */
	public MancalaPit getPlayersMancalaPit(boolean currentPlayer)
	{
		if(currentPlayer == PLAYER_A)
			return (MancalaPit) pits[12];
		else
			return (MancalaPit) pits[13];
	}
	/**
	 * Okay. I'm not sure if this is such a good way to do this, but I know the model needs an attach somewhere.
	 * @param pitToAttach
	 * @param pitBank Use Model.NORTH_PITS or Model.SOUTH_PITS
	 */
	public void attach(Pit pitToAttach)
	{
		int pitNumber = pitToAttach.getPitNumber();
		pits[pitNumber] = pitToAttach;
		if(pitToAttach.isRegularPit())
			numberOfMarbles[pitNumber] = initialNumberOfMarbles;
		else
			numberOfMarbles[pitNumber] = 0;
		saveState();
	}
	
	/**This will check to see if a winner has been decided.
	 * @return String outcome of the game
	 * */
	public String checkForWinner()
	{
		if(endOfGame())
		{
			for(int i = 0; i < 6; i++)
			{
				numberOfMarbles[13] += numberOfMarbles[i];
				removeAllMarbles(pits[i]);
			}
			for(int i = 6; i < 12; i++)
			{
				numberOfMarbles[12] += numberOfMarbles[i];
				removeAllMarbles(pits[i]);
			}
			notifyAllListeners();
			if(numberOfMarbles[12] > numberOfMarbles[13])
				return "Winner: Player A";
			else if(numberOfMarbles[12] < numberOfMarbles[13])
				return "Winner: Player B";
			else
				return "Draw!";
		}
		return "";
	}
	
	/**this method is a helper method for checkForWinner().  It returns a boolean to be used
	 * in checkForWinner().
	 * @return boolean true if game is over, false otherwise
	 * */
	private boolean endOfGame()
	{
		int count = 0;
		for(int i = 0; i < 6; i++)
			count += numberOfMarbles[i];
		if(count == 0)
			return true;
		count = 0;
		for(int i = 6; i < 12; i++)
			count += numberOfMarbles[i];
		if(count == 0)
			return true;
		return false;
	}

	/**Fires the ChangeEvent to let a pit know that the state has changed.
	 * @param listener the pit index to be notifed.
	 * */
	private void notifyListener(int listener)
	{	pits[listener].stateChanged(new ChangeEvent(this));	}
	
	/**Fires the ChangeEvent to let all the pits know that the state has changed.
	 * */
	private void notifyAllListeners()
	{
		for(Pit pit : pits)
			pit.stateChanged(new ChangeEvent(this));
	}
	/**saves the state of the game in case an undo is needed.
	 * */
	public void saveState()
	{	
		lastState = numberOfMarbles.clone();
		lastPlayer = player;
	}
	
	/**loads the lastState. To be used when undoing a move.
	 * */
	public void loadState()
	{	
		if(undoCount < 2)
		{
		numberOfMarbles = lastState;
		player = lastPlayer;
		notifyAllListeners();
		undoCount++;
		}
		else if(undoCount == 2)
			undoCount = 0;
	}

	/**This method allows us to follow the rule where if you end on one of your empty pits, you can take all the 
	 * marbles in the pit opposite of that ending pit.
	 * */
	public void takeFromAcross(Pit emptyPit)
	{
		int pitNumber = emptyPit.getPitNumber();
		if(pitNumber >= 0 && pitNumber < 6)
		{
			numberOfMarbles[13] += numberOfMarbles[pitNumber + 6] + 1;
			removeAllMarbles(pits[pitNumber + 6]);
			removeAllMarbles(emptyPit);
		}
		else if(pitNumber >= 6 && pitNumber < 12)
		{
			numberOfMarbles[12] += numberOfMarbles[pitNumber - 6] + 1;
			removeAllMarbles(pits[pitNumber - 6]);
			removeAllMarbles(emptyPit);
		}
		notifyAllListeners();
	}
	/**
	 * Sets the color for the Marbles
	 * @param c the Color to draw the Marbles
	 */
	public void setColor(Color c)
	{	color = c;	}
	
	/**
	 * Returns the Color of the Marbles
	 * @return the Color the Marbles are drawn.
	 */
	public Color getColor()
	{	return color;	}
}