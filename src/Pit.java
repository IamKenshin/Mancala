import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public abstract class Pit extends JComponent
{
	private Ellipse2D pitShape;
	/**
	 * I'm not sure if the pits should store count, or if the model should...
	 * @return
	 */
	private ArrayList<Marble> marbles; 
	public int getCount()
	{	return marbles.size();	}
}