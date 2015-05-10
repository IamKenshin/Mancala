import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;

/**
 * The only purpose of this class is to describe what a MancalaPit looks like.
 * @author Team Dragon
 *
 */
public class MancalaPit extends Pit
{
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
	public boolean isRegularPit()
	{	return false;	}
}