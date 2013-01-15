package life;

public class Grid {

	public static final int SIZE = 30;
	Cell[][] cells;
	public Grid() {
		cells = new Cell[SIZE][SIZE];
		for(int i = 0; i<SIZE; i++)
			for(int j = 0; j<SIZE; j++)
				cells[i][j] = new Cell(Colour.GREY);
	}
	
	Cell getCell(int l, int c) {
		if(l>0 && l<SIZE && c>0 && c<SIZE)
			return cells[l][c];
		return null;
	}
	
	void setCellState(int l, int c, Colour colour) {
		getCell(l,c).setColour(colour);
	}
	
	void killCell(int l, int c) {
		cells[l][c].setColour(Colour.GREY);
	}
}
