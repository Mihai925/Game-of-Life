package life;

public class Cell {

	private Colour colour;
	
	public Cell(Colour colour) {
		this.colour = colour;
	}
	
	Colour getColour() {
		return colour;
	}
	
	void setColour(Colour colour) {
		this.colour = colour;
	}
}
