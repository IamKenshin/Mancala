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
		
		Model model = new Model(3);
		new Board(model);
	}
}
