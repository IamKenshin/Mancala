import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The only purpose of this class is to describe what a MancalaPit looks like.
 * @author Team Dragon
 *
 */
public class MancalaPit extends Pit implements ChangeListener
{
	public MancalaPit(JLabel newParent)
	{
		pitWidth = 50;
		pitHeight = 300;
		parent = newParent;
		pitShape = new Ellipse2D.Double(0, 0, pitWidth, pitHeight);
		/*addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});*/
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
		g2.draw(new Ellipse2D.Double(x, y, pitWidth - 1, pitHeight - 1));
		//iterate through count and draw marbles.
	}
	@Override
	public int getIconWidth()
	{	return pitWidth + 1;	}
	@Override
	public int getIconHeight()
	{	return pitHeight + 1;	}
}