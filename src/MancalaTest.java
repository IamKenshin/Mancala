import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MancalaTest
{
	public static void main(String[] args)
	{
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		
		
		Board board = new Board();
		//JFrame frame = new JFrame();
		//frame.setLayout(new FlowLayout());
		//JPanel panel = new JPanel();
		//panel.add(new RegularPit(0,0));
		//frame.add(new JLabel(new RegularPit(0,0)));
		//frame.add(new JLabel(new RegularPit(0,0)));
		//frame.add(new JLabel(new RegularPit(0,0)));
		//frame.add(new JLabel(new RegularPit(0,0)));
		//frame.add(new RegularPit(0,0));
		//frame.add(new RegularPit(0,0));

		//frame.setSize(800, 400);
		//frame.pack();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);

	}
}
