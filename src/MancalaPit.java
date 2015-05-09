import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;

/**
 * The only purpose of this class is to describe what a MancalaPit looks like.
 * @author Team Dragon
 *
 */
public class MancalaPit extends Pit
{
	public MancalaPit(Model m, JLabel newParent, int pit)
	{
		model = m;
		parent = newParent;
		pitNumber = pit;
		pitWidth = 50;
		pitHeight = 250;
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
	@Override
	public boolean isRegularPit()
	{	return false;	}
}