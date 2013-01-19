package life;

/*
 * This class adapts the standard, limited size grid to a cyclic one.
 */
public class GridAdapter {

	Grid grid;

	public GridAdapter(Grid grid) {
		this.grid = grid;
	}

	Cell getCell(int l, int c) {
		return grid.getCell(getLC(l), getLC(c));
	}

	private int getCellColourIndice(int l, int c) {
		return getCell(l,c).getColour().ordinal();
	}
	
	private int getLC(int x) {
		return (x+Grid.SIZE) % Grid.SIZE; 
	}
	
	int[] getCellState(int l, int c) {
		int[] ret = new int[3];
		ret[0] = ret[1] = ret[2] = 0;
		ret[getCellColourIndice(l-1,c-1)]++;
		ret[getCellColourIndice(l-1,c)]++;
		ret[getCellColourIndice(l-1,c+1)]++;
		ret[getCellColourIndice(l,c-1)]++;
		ret[getCellColourIndice(l,c+1)]++;
		ret[getCellColourIndice(l+1,c-1)]++;
		ret[getCellColourIndice(l+1,c)]++;
		ret[getCellColourIndice(l+1,c+1)]++;
		return ret;
	}
	
	
	void killCell(int l, int c) {
		grid.killCell(getLC(l), getLC(c));
	}
	
	void setCellState(int l, int c, Colour colour) {
		grid.getCell(getLC(l),getLC(c)).setColour(colour);
	}
	
}
