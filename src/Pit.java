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
		//int a = endOfGmae();
		
		 if ( endOfGmae1() == 0 ||  endOfGmae2() == 0){
			 System.out.println(" the end of game");
		 }
		
		
	}
	
	public int endOfGmae1(){
		int i = 0;
		int count = 0;
		while ( i < 6){
			count += Model.numberOfMarbles[i];
			i++;
		}
		return count;
	}

	public int endOfGmae2(){
		int i = 6;
		int count = 0;
		while ( i < 12){
			count += Model.numberOfMarbles[i];
			i++;
		}
		return count;
	}

	public int getIconWidth()
	{	return pitWidth + 1;	}

	public int getIconHeight()
	{	return pitHeight + 1;	}
}
