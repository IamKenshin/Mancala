// here is a random comment. 
// Random comment = new Random(); 
//I fell in the pit.
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Pit implements Icon
{
	//instead of doing protected variables, these should all be private with getters and setters. definitely low priority.
	protected Ellipse2D pitShape;
	protected int pitWidth, pitHeight;
	protected JLabel parent;
	protected Model model;
	protected int pitNumber;
}
