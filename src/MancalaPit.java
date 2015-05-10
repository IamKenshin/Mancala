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
	public MancalaPit(Model m, JLabel newParent, JLabel marbleCount, JLabel aWinner, int pit)
	{
		model = m;
		parent = newParent;
		marbles = marbleCount;
		winner = aWinner;
		pitNumber = pit;
		pitWidth = 50;
		pitHeight = 250;
		pitShape = new Ellipse2D.Double(0, 0, pitWidth, pitHeight);
	}
	@Override
	public boolean isRegularPit()
	{	return false;	}
	
	@Override
	public void stateChanged(ChangeEvent e)
	{
		parent.repaint();
		marbles.setText(""+ model.getNumberOfMarblesInPit(this));
		//winner.setText("" + model.checkForWinner());
	}
}