import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MancalaTest


{
	/*public static void modelCaller (int a){
		
		Model model = new Model(a);
		
		new Board(model);
	}*/
	
	public static void main(String[] args)
	{
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		
		Model model = new Model();
		//Board b = new Board(model);
		
		new Board(model);
		//b.initializeCenter();// we need to call the actionPerformed method here i think. 
		// and then we need to call the above method : modelCaller() 
		// and then we can be set. 
		
	}
}
