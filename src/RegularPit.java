import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The purpose of this class is to describe what a RegularPit looks like, and to set up the controller.
 * @author Team Dragon
 *
 */
public class RegularPit extends Pit implements ChangeListener
{
	public RegularPit(int x, int y)
	{
		pitWidth = 60;
		pitHeight = 50;
		pitShape = new Ellipse2D.Double(x, y, pitWidth, pitHeight);
		//add a mouse listener
	}
	public void draw(Graphics2D g2)
	{
		g2.draw(pitShape);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		this.draw(g2);
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		//redraw
	}
}