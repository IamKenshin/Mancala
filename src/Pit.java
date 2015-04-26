import java.util.ArrayList;

public abstract class Pit
{
	/**
	 * I'm not sure if the pits should store count, or if the model should...
	 * @return
	 */
	private ArrayList<Marble> marbles; 
	public int getCount()
	{	return marbles.size();	}
}