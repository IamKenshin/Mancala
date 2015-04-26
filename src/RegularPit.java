import java.awt.Graphics2D;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The purpose of this class is to describe what a RegularPit looks like, and to set up the controller.
 * @author Team Dragon
 *
 */
public class RegularPit extends Pit implements ChangeListener
{
	public RegularPit()
	{
		//add a mouse listener
	}
	public void draw(Graphics2D g2)
	{
		
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		//redraw
	}
}