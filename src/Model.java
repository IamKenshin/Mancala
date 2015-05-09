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
	private int initialNumberOfMarbles;
	private boolean player; // true for player A, false for player B
	public static boolean PLAYER_A = false;
	public static boolean PLAYER_B = true;
	
	public Model ()
	{
		pits = new Pit[14];
		numberOfMarbles = new int[14];
	}
	
	public boolean getPlayer()
	{
		return player;
	}
	public void setPlayer()
	{
		player = !player;
	}
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
	public MancalaPit getOpponentsMancalaPit(boolean currentPlayer)
	{
		if(currentPlayer == PLAYER_A)
			return (MancalaPit) pits[13];
		else
			return (MancalaPit) pits[12];
	}
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
	}
	private void notifyListener(int listener)
	{
		pits[listener].stateChanged(new ChangeEvent(this));
	}
}
