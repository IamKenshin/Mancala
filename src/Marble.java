import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * This class is designed to describe what a Marble or group of Marbles looks like.
 * @author Team Dragon
 *
 */
public class Marble
{
	private static int width = 17;
	private static int height = 17;
	private static int pitWidth = 60;
	private static int pitHeight = 50;
	
	/**
	 * This constructor is private because a Marble should never be instantiated. 
	 */
	private Marble()
	{}
	
	/**
	 * This method actually draws the Marble or group of Marbles. 6 or more Marbles looks the same so they are not too clustered.
	 * @param g2 The graphics context for drawing.
	 * @param numberToDraw The number of Marbles to be drawn.
	 */
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
	
	/**
	 * Describes the exact steps to draw one Marble
	 * @param g2 The graphics context for drawing
	 */
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
	
	/**
	 * Describes the exact steps to draw two Marbles
	 * @param g2 The graphics context for drawing
	 */
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
	
	/**
	 * Describes the exact steps to draw three Marbles
	 * @param g2 The graphics context for drawing
	 */
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
	
	/**
	 * Describes the exact steps to draw four Marbles
	 * @param g2 The graphics context for drawing
	 */
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
	
	/**
	 * Describes the exact steps to draw five Marbles
	 * @param g2 The graphics context for drawing
	 */
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
	
	/**
	 * Describes the exact steps to draw six or more Marbles
	 * @param g2 The graphics context for drawing
	 */
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