// here is a random comment. 
// Random comment = new Random(); 
//I fell in the pit.
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	protected JLabel marbles;
	protected JLabel winner;
	protected Model model;
	protected int pitNumber;
	
	public int getPitNumber()
	{	return pitNumber;	}
	public abstract boolean isRegularPit();
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Ellipse2D.Double(x, y, pitWidth, pitHeight));
		Marble.draw(g2, model.getNumberOfMarblesInPit(this));
	}

public void stateChanged(ChangeEvent e)
	{
		parent.repaint();
		marbles.setText(""+ model.getNumberOfMarblesInPit(this));
		//winner.setText("" + model.checkForWinner());
		//int a = endOfGmae();
		
		 
		
		
	}


	public int getIconWidth()
	{	return pitWidth + 1;	}

	public int getIconHeight()
	{	return pitHeight + 1;	}
}
