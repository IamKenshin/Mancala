// here is a random comment. 
// Random comment = new Random(); 
//I fell in the pit.
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public abstract class Pit implements Icon, ChangeListener
{
	//instead of doing protected variables, these should all be private with getters and setters. definitely low priority.
	protected Ellipse2D pitShape;
	protected int pitWidth, pitHeight;
	protected JLabel parent;
	protected Model model;
	protected int pitNumber;
	public abstract void stateChanged(ChangeEvent e);
	public int getPitNumber()
	{	return pitNumber;	}
	public abstract boolean isRegularPit();
}
