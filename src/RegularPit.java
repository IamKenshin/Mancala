import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;

/**
 * The purpose of this class is to describe what a RegularPit looks like, and to set up the controller.
 * @author Team Dragon
 *
 */
public class RegularPit extends Pit
{
	public RegularPit(Model m, JLabel newParent, JLabel marbleCount, int pit)
	{
		model = m;
		parent = newParent;
		marbles = marbleCount;
		pitNumber = pit;
		pitWidth = 60;
		pitHeight = 50;
		pitShape = new Ellipse2D.Double(0, 0, pitWidth, pitHeight);
	}	
	@Override
	public boolean isRegularPit()
	{	return true;	}
}