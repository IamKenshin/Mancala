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
	public RegularPit(Model m, JLabel newParent, int pit)
	{
		model = m;
		parent = newParent;
		pitNumber = pit;
		pitWidth = 60;
		pitHeight = 50;
		pitShape = new Ellipse2D.Double(0, 0, pitWidth, pitHeight);
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		parent.repaint();
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Ellipse2D.Double(x, y, pitWidth, pitHeight));
		Marble.draw(g2, model.getNumberOfMarblesInPit(pitNumber));
	}

	@Override
	public int getIconWidth()
	{	return pitWidth + 1;	}

	@Override
	public int getIconHeight()
	{	return pitHeight + 1;	}
}