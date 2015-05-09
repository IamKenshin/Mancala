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
	public Model(int initialMarbleCount)
	{
		initialNumberOfMarbles = initialMarbleCount;
		pits = new Pit[12];
		numberOfMarbles = new int[12];
		//= new ArrayList<Pit>();
	}
	
	/**
	 * 
	 * @return the number of marbles in the corresponding Pit
	 * @param whichPitToAccess
	 */
	public int getNumberOfMarblesInPit(int whichPitToAccess)
	{	return numberOfMarbles[whichPitToAccess];	}
	
	/**
	 * This is used when a pit is clicked on. This can only be a RegularPit. You cannot remove from a MancalaPit.
	 * At the end of this, we need to notify the Pit that the state has changed.
	 * @param whichPitToRemoveFrom
	 */
	public void removeAllMarbles(int whichPitToRemoveFrom)
	{
		numberOfMarbles[whichPitToRemoveFrom] = 0;
		notifyListener(whichPitToRemoveFrom);
	}
	
	/**
	 * adds one marbles to the Pit. As a player is moving around the board, the player adds one marble to each pit except for his opponent's manacala pit.
	 * At the end of this, we need to notify the Pit that the state has changed.
	 * @param whichPitToAddTo
	 */
	public void addOneMarble(int whichPitToAddTo)
	{
		numberOfMarbles[whichPitToAddTo]++;
		notifyListener(whichPitToAddTo);
	}
	
	/**
	 * Okay. I'm not sure if this is such a good way to do this, but I know the model needs an attach somewhere.
	 * @param pitToAttach
	 * @param pitBank Use Model.NORTH_PITS or Model.SOUTH_PITS
	 */
	public void attach(Pit pitToAttach)
	{
		int i = 0;
		while(pits[i] != null)
			i++;
		pits[i] = pitToAttach;
		if(i < 10)
			numberOfMarbles[i] = initialNumberOfMarbles;
	}
	private void notifyListener(int changedPit)
	{
		pits[changedPit].stateChanged(new ChangeEvent(this));
	}
}
