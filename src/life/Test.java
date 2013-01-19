package life;

public class Test {
	public static void main(String[] args) {
		GridAdapter g = new GridAdapter(new Grid());
		g.setCellState(1, 2, Colour.RED);
		g.setCellState(2, 2, Colour.GREEN);
		int[] t = g.getCellState(1,1);
		System.out.println(t[0] + " " + t[1] + " " + t[2]);

		/*for(int i=0; i<Grid.SIZE; i++) {
			for(int j=0; j<Grid.SIZE; j++) {
				Cell c = g.getCell(i, j);
				System.out.print(c.getColour() + " ");
			}
			System.out.println();
		}*/
	}
}
