import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The only purpose of this class is to describe what a MancalaPit looks like.
 * @author Team Dragon
 *
 */
public class MancalaPit extends Pit implements ChangeListener
{
	public MancalaPit(int x, int y)
	{
		pitWidth = 50;
		pitHeight = 300;
		pitShape = new Ellipse2D.Double(x, y, pitWidth, pitHeight);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});
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
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}