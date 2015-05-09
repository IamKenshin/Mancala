import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The purpose of this class is to describe what a RegularPit looks like, and to set up the controller.
 * @author Team Dragon
 *
 */
public class RegularPit extends Pit implements ChangeListener
{
	public RegularPit(JLabel newParent)
	{
		pitWidth = 60;
		pitHeight = 50;
		parent = newParent;
		pitShape = new Ellipse2D.Double(0, 0, pitWidth, pitHeight);
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		//change count to new number of marbles.
		parent.repaint();
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Ellipse2D.Double(x, y, pitWidth, pitHeight));
		Marble.draw(g2, 3);//TODO change this to get the number from the model
	}

	@Override
	public int getIconWidth()
	{	return pitWidth + 1;	}

	@Override
	public int getIconHeight()
	{	return pitHeight + 1;	}
}