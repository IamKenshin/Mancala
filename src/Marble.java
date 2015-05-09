import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * The only purpose of this class is to describe what a marble looks like.
 * @author Team Dragon
 *
 */
public class Marble
{
	private static int width = 17;
	private static int height = 17;
	private static int pitWidth = 60;
	private static int pitHeight = 50;
	private Marble()
	{}
	public static void draw(Graphics2D g2, int numberToDraw)
	{
		if(numberToDraw == 1)
		{	drawOne(g2);	}
		else if(numberToDraw == 2)
		{	drawTwo(g2);	}
		else if(numberToDraw == 3)
		{	drawThree(g2);	}
		else if(numberToDraw == 4)
		{	drawFour(g2);	}
		else if(numberToDraw == 5)
		{	drawFive(g2);	}
		else if(numberToDraw >= 6)
		{	drawSix(g2);	}
	}
	private static void drawOne(Graphics2D g2)
	{
		int x = (pitWidth/2) - (width / 2);
		int y = (pitHeight/2) - (height / 2);
		Ellipse2D.Double marble = new Ellipse2D.Double(x, y, width, height);
		g2.setColor(Color.RED);
		g2.fill(marble);
		g2.setColor(Color.BLACK);
		g2.draw(marble);
	}
	private static void drawTwo(Graphics2D g2)
	{
		int x = (pitWidth/2) - ((width + (width / 2)) / 2);
		int y = (pitHeight/2) - (height / 2);
		Ellipse2D.Double marble1 = new Ellipse2D.Double(x, y, width, height);
		Ellipse2D.Double marble2 = new Ellipse2D.Double(x + width / 2, y, width, height);
		g2.setColor(Color.RED);
		g2.fill(marble1);
		g2.setColor(Color.BLACK);
		g2.draw(marble1);
		g2.setColor(Color.RED);
		g2.fill(marble2);
		g2.setColor(Color.BLACK);
		g2.draw(marble2);
	}
	private static void drawThree(Graphics2D g2)
	{
		int x = (pitWidth/2) - ((width + (width / 2)) / 2);
		int y = (pitHeight/2) - ((height + (height / 2)) / 2);
		Ellipse2D.Double marble1 = new Ellipse2D.Double(x, y, width, height);
		Ellipse2D.Double marble2 = new Ellipse2D.Double(x + width / 2, y, width, height);
		Ellipse2D.Double marble3 = new Ellipse2D.Double((pitWidth/2) - (width / 2), y + height / 2, width, height);
		g2.setColor(Color.RED);
		g2.fill(marble1);
		g2.setColor(Color.BLACK);
		g2.draw(marble1);
		g2.setColor(Color.RED);
		g2.fill(marble2);
		g2.setColor(Color.BLACK);
		g2.draw(marble2);
		g2.setColor(Color.RED);
		g2.fill(marble3);
		g2.setColor(Color.BLACK);
		g2.draw(marble3);
	}
	private static void drawFour(Graphics2D g2)
	{
		int x = (pitWidth/2) - ((width + (width / 2)) / 2);
		int y = (pitHeight/2) - ((height + (height / 2)) / 2);
		Ellipse2D.Double marble1 = new Ellipse2D.Double(x, y, width, height);
		Ellipse2D.Double marble2 = new Ellipse2D.Double(x + width / 2, y, width, height);
		Ellipse2D.Double marble3 = new Ellipse2D.Double(x, y + height / 2, width, height);
		Ellipse2D.Double marble4 = new Ellipse2D.Double(x + width / 2, y + height / 2, width, height);
		g2.setColor(Color.RED);
		g2.fill(marble1);
		g2.setColor(Color.BLACK);
		g2.draw(marble1);
		g2.setColor(Color.RED);
		g2.fill(marble2);
		g2.setColor(Color.BLACK);
		g2.draw(marble2);
		g2.setColor(Color.RED);
		g2.fill(marble3);
		g2.setColor(Color.BLACK);
		g2.draw(marble3);
		g2.setColor(Color.RED);
		g2.fill(marble4);
		g2.setColor(Color.BLACK);
		g2.draw(marble4);
	}
	private static void drawFive(Graphics2D g2)
	{
		int x = (pitWidth/2) - ((width + (width / 2)) / 2);
		int y = (pitHeight/2) - ((height + (height / 2)) / 2);
		Ellipse2D.Double marble1 = new Ellipse2D.Double(x, y, width, height);
		Ellipse2D.Double marble2 = new Ellipse2D.Double(x + width / 2, y, width, height);
		Ellipse2D.Double marble3 = new Ellipse2D.Double(x - width / 2, y + height / 2, width, height);
		Ellipse2D.Double marble4 = new Ellipse2D.Double(x + width / 4, y + height / 2, width, height);
		Ellipse2D.Double marble5 = new Ellipse2D.Double(x + width, y + height / 2, width, height);
		g2.setColor(Color.RED);
		g2.fill(marble1);
		g2.setColor(Color.BLACK);
		g2.draw(marble1);
		g2.setColor(Color.RED);
		g2.fill(marble2);
		g2.setColor(Color.BLACK);
		g2.draw(marble2);
		g2.setColor(Color.RED);
		g2.fill(marble3);
		g2.setColor(Color.BLACK);
		g2.draw(marble3);
		g2.setColor(Color.RED);
		g2.fill(marble4);
		g2.setColor(Color.BLACK);
		g2.draw(marble4);
		g2.setColor(Color.RED);
		g2.fill(marble5);
		g2.setColor(Color.BLACK);
		g2.draw(marble5);
	}
	private static void drawSix(Graphics2D g2)
	{
		int x = (pitWidth/2) - ((width + (width / 2)) / 2);
		int y = (pitHeight/2) - ((height + (height / 2)) / 2);
		Ellipse2D.Double marble1 = new Ellipse2D.Double(x - width / 2, y, width, height);
		Ellipse2D.Double marble2 = new Ellipse2D.Double(x + width / 4, y, width, height);
		Ellipse2D.Double marble3 = new Ellipse2D.Double(x + width, y, width, height);
		Ellipse2D.Double marble4 = new Ellipse2D.Double(x - width / 2, y + height / 2, width, height);
		Ellipse2D.Double marble5 = new Ellipse2D.Double(x + width / 4, y + height / 2, width, height);
		Ellipse2D.Double marble6 = new Ellipse2D.Double(x + width, y + height / 2, width, height);
		g2.setColor(Color.RED);
		g2.fill(marble1);
		g2.setColor(Color.BLACK);
		g2.draw(marble1);
		g2.setColor(Color.RED);
		g2.fill(marble2);
		g2.setColor(Color.BLACK);
		g2.draw(marble2);
		g2.setColor(Color.RED);
		g2.fill(marble3);
		g2.setColor(Color.BLACK);
		g2.draw(marble3);
		g2.setColor(Color.RED);
		g2.fill(marble4);
		g2.setColor(Color.BLACK);
		g2.draw(marble4);
		g2.setColor(Color.RED);
		g2.fill(marble5);
		g2.setColor(Color.BLACK);
		g2.draw(marble5);
		g2.setColor(Color.RED);
		g2.fill(marble6);
		g2.setColor(Color.BLACK);
		g2.draw(marble6);
	}
}