// here is a random comment. 
// Random comment = new Random(); 
//I fell in the pit.
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Pit implements Icon
{
	protected Ellipse2D pitShape;
	protected int pitWidth, pitHeight;
	protected JLabel parent;
	/**
	 * I'm not sure if the pits should store count, or if the model should...
	 * @return
	 */
	private ArrayList<Marble> marbles; 
	public int getCount()
	{	return marbles.size();	}
}
