package life;
import java.util.Map;
import java.util.HashMap;
import java.awt.Color;
public class Grid {

	public static final int SIZE = 30;
	public static final int CELLSIZE = 20;
	Cell[][] cells;
	GUI gui = null;
	public static final Map<Colour, Color> colorMap = new HashMap<Colour, Color>();
	static {
		colorMap.put(Colour.GRAY, Color.GRAY);
		colorMap.put(Colour.GREEN, Color.GREEN);
		colorMap.put(Colour.RED, Color.RED);
	}
	public void setGui(GUI gui) {
		this.gui=gui;
	}
	public Grid() {
		cells = new Cell[SIZE][SIZE];
		for(int i = 0; i<SIZE; i++)
			for(int j = 0; j<SIZE; j++)
				cells[i][j] = new Cell(Colour.GRAY);
	}
	
	
	
	Cell getCell(int l, int c) {
		if(l>=0 && l<SIZE && c>=0 && c<SIZE)
			return cells[l][c];
		return null;
	}
	
	void setCellState(int l, int c, Colour colour)  {
		getCell(l,c).setColour(colour);
		//System.out.println(gui);
		gui.updateCellColour(l, c, colorMap.get(colour));
	}
	
	void killCell(int l, int c) {
		cells[l][c].setColour(Colour.GRAY);
	}
}
