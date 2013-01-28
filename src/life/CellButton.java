package life;

import javax.swing.JButton;


public class CellButton extends JButton {


	private final int x;
	private final int y;
	
	public CellButton(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getMyX() {
		return x;
	}
	public int getMyY() {
		return y;
	}
}
