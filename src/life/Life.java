package life;

import javax.swing.JApplet;

public class Life extends JApplet {
	// enum for managing the basic three colours of the cells
	// RED and GREEN cells are alive, GREY cells are dead
	/*
	 * public enum Colour { RED, GREEN, GREY; }
	 */

	protected GridAdapter grid;
	protected GUI gui;

	// called by the html page to draw the applet
	@Override
	public void init() {
		grid = GridFactory.getGrid();
		// setSize(700,700);
		gui = new GUI(this);
		gui.start();
		add(gui.getPanel());
		grid.setGui(gui);
		setVisible(true);

	}

	/*
	 * The autotest will assume the following interfaces on the class life.Life
	 * You are free to implement these methods in any way you wish Note: we are
	 * assuming a standard coordinate system, that is with (0,0) referring to
	 * the bottom left cell, x being col no. and y being row no.
	 */

	// read the colour of the cell at coord (x,y)
	public Colour readCell(int x, int y) {
		return null;
	}

	// read the turn count
	public int readTurn() {
		return 0;
	}

	// kill the cell at coord (x,y)
	public void kill(int x, int y) {
		grid.setCellState(x, y, Colour.GRAY);
	}

	// create a live sell with the specified colour at coord (x,y)
	public void resurrect(int x, int y, Colour c) {
		grid.setCellState(x, y, c);
	}

	// clear the board and reset the turn count to 0
	public void clear() {
		grid = GridFactory.getGrid(gui);
		gui.updateGUI();
	}

	// step the simulation through one application of the rules and increment
	// the turn counter
	public void step() {
		int[] states;
		GridAdapter newGrid = GridFactory.getGrid(gui);
		for (int i = 0; i < Grid.SIZE; i++)
			for (int j = 0; j < Grid.SIZE; j++) {
				states = grid.getCellState(i, j);
				if (grid.getCell(i, j).isAlive()
						&& (states[0] + states[1] < 2 || states[0] + states[1] > 3))
					newGrid.setCellState(i, j, Colour.GRAY);
				else if (!grid.getCell(i, j).isAlive()
						&& states[0] + states[1] == 3) {
					if (states[0] > states[1])
						newGrid.setCellState(i, j, Colour.RED);
					else
						newGrid.setCellState(i, j, Colour.GREEN);
				} else if (grid.getCell(i, j).isAlive()
						&& (states[0] + states[1] == 2 || states[0] + states[1] == 3)) {
					newGrid.setCellState(i, j, grid.getCell(i, j).getColour());
				}

			}
		grid = newGrid;
	}

}