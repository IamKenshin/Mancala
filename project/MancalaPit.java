import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;

/**
 * The only purpose of this class is to describe what a MancalaPit looks like.
 * @author Team Dragon
 *
 */
public class MancalaPit extends Pit
{
	/**Constructor for a MancalaPit.  Ties it to the Model m, gives it JLabels for parent and counter, and a specific pit
	 * */
	public MancalaPit(Model m, JLabel newParent, JLabel marbleCount, int pit)
	{
		model = m;
		parent = newParent;
		pitNumber = pit;
		counter = marbleCount;
		pitWidth = 50;
		pitHeight = 250;
		pitShape = new Ellipse2D.Double(0, 0, pitWidth, pitHeight);
	}
	@Override
	/**This method returns false to indicate this pit is a MancalaPit
	 * @return false
	 * */
	public boolean isRegularPit()
	{	return false;	}
}