import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * The only purpose of this class is to describe what a marble looks like.
 * @author Team Dragon
 *
 */
public class Marble
{
	int width;
	int height;
	int x;
	int y;
	public Marble(int count)
	{
		width = 10;
		height = 10;
		x = 0; //these will be changed
		y = 0; //these will be changed
	}

	public void draw(Graphics2D g2)
	{
		g2.fill(new Ellipse2D.Double(x, y, width, height));
	}
}