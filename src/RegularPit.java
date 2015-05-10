import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;

/**
 * The purpose of this class is to describe what a RegularPit looks like, and to set up the controller.
 * @author Team Dragon
 *
 */
public class RegularPit extends Pit
{
	/**Constructor for a RegularPit.  Ties it to the Model m, gives it JLabels for parent and counter, and a specific pit
	 * */
	public RegularPit(Model m, JLabel newParent, JLabel marbleCount, int pit)
	{
		model = m;
		parent = newParent;
		pitNumber = pit;
		counter = marbleCount;
		pitWidth = 60;
		pitHeight = 50;
		pitShape = new Ellipse2D.Double(0, 0, pitWidth, pitHeight);
	}	
	@Override
	/**This method returns true to indicate this pit is a RegularPit
	 * @return true
	 * */
	public boolean isRegularPit()
	{	return true;	}
}