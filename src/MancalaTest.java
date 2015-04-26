import javax.swing.JFrame;

public class MancalaTest
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(800, 400);
		Board board = new Board();
		frame.add(board);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
