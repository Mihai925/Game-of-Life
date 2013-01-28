package life;

public class GridFactory {
	public static GridAdapter getGrid(GUI gui) {
		GridAdapter g = new GridAdapter(new Grid());
		g.setGui(gui);
		return g;
	}
	
	public static GridAdapter getGrid() {
		return new GridAdapter(new Grid());
	}
}
