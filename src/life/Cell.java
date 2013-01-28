package life;

public class Cell {

	private Colour colour;
	
	public Cell(Colour colour) {
		this.colour = colour;
	}
	
	Colour getColour() {
		return colour;
	}
	
	boolean isAlive() {
		return colour != Colour.GRAY;
	}
	
	void setColour(Colour colour) {
		this.colour = colour;
	}
}
