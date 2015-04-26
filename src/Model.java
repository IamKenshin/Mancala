import java.util.ArrayList;

/**
 * This is the model that holds all the data. It does all the heavy lifting of the app, and all the views just reflect what happens here.
 * There are alot of issues with this Class right now. I'm not sure how to access the pits exactly with parameters, so those int parameters are just dummies for now.
 * @author Team Dragon
 */
public class Model
{
	private ArrayList<Pit> southPits; // belong to player 1
	private ArrayList<Pit> northPits; // belong to player 2
	public final static boolean NORTH_PITS = true;
	public final static boolean SOUTH_PITS = false;
	public Model()
	{
		southPits = new ArrayList<Pit>();
		northPits = new ArrayList<Pit>();
	}
	
	/**
	 * 
	 * @return the number of marbles in the corresponding Pit
	 * @param whichPitToAccess
	 */
	public int numberOfMarblesInPit(int whichPitToAccess)
	{
		int output = 0; // This should access the corresponding pit and call getCount();
		return output;
	}
	
	/**
	 * This is used when a pit is clicked on. This can only be a RegularPit. You cannot remove from a MancalaPit.
	 * At the end of this, we need to notify the Pit that the state has changed.
	 * @param whichPitToRemoveFrom
	 */
	public void removeAllMarbles(int whichPitToRemoveFrom)
	{
		
	}
	
	/**
	 * adds one marbles to the Pit. As a player is moving around the board, the player adds one marble to each pit except for his opponent's manacala pit.
	 * At the end of this, we need to notify the Pit that the state has changed.
	 * @param whichPitToAddTo
	 */
	public void addOneMarble(int whichPitToAddTo)
	{
		
	}
	
	/**
	 * Okay. I'm not sure if this is such a good way to do this, but I know the model needs an attach somewhere.
	 * @param pitToAttach
	 * @param pitBank Use Model.NORTH_PITS or Model.SOUTH_PITS
	 */
	public void attach(Pit pitToAttach, boolean pitBank)
	{
		
		if(pitBank == NORTH_PITS)
			northPits.add(pitToAttach);
		else
			southPits.add(pitToAttach);
			
	}
}
