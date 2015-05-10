import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**This abstract class is used to factor all common fields and methods from the MancalaPit and RegularPit.
 * @author Team Dragon
 * */
public abstract class Pit implements Icon, ChangeListener
{
	protected Ellipse2D pitShape;
	protected int pitWidth;
	protected int pitHeight;
	protected JLabel parent;
	protected JLabel counter;
	protected Model model;
	protected int pitNumber;
	
	/**getPitNumber() Retrieves the currentpitNumber.
	 * @return pitNumber The pitNumber.
	 * */
	public int getPitNumber()
	{	return pitNumber;	}
	
	/**isRegularPit() Abstract method that will determine if a pit is
	 * a regular or mancala pit.
	 * @return boolean
	 * */
	public abstract boolean isRegularPit();
	
	/**paintIcon is a method that will draw the pit.  Will also draw Marble objects
	 * in the pits.
	 * @param c Component to be drawn
	 * @param g Graphics object
	 * @param x x-coordinate of icon
	 * @param y y-coordinate of icon
	 * */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Ellipse2D.Double(x, y, pitWidth, pitHeight));
		Marble.draw(g2, model.getNumberOfMarblesInPit(this), model.getColor());
	}

	/**Notifies the view that the state has changed so it can repaint itself 
	 * in order to convey the correct model.
	 * */
	public void stateChanged(ChangeEvent e)
	{
		parent.repaint();
		counter.setText(""+ model.getNumberOfMarblesInPit(this));
	}

	/**returns the width of the icon + 1
	 * @return pitWidth + 1
	 * */
	public int getIconWidth()
	{	return pitWidth + 1;	}

	/**returns the height of the icon + 1
	 * @return pitHeight + 1
	 * */
	public int getIconHeight()
	{	return pitHeight + 1;	}
}