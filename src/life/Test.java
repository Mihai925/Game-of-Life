package life;

import javax.swing.JFrame;

public class Test extends JFrame{
	public static void main(String[] args) {

		Test gui = new Test();
		gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gui.setSize(200, 200);
		gui.setVisible(true);
		gui.setTitle("Test GUI");
	}
}
