package life;

import java.applet.*;
import java.awt.*;

public class Life extends Applet {
	// enum for managing the basic three colours of the cells
	// RED and GREEN cells are alive, GREY cells are dead
/*	public enum Colour {
		RED, GREEN, GREY;
	}*/
	GridAdapter grid = new GridAdapter(new Grid());
	// called by the html page to draw the applet
	public void paint(Graphics g) {
		// draw the applet
		
		g.drawString("ToDo: write a Life applet and a nice webpage", 25, 50);
	
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
		grid.setCellState(x, y, Colour.GREY);
	}

	// create a live sell with the specified colour at coord (x,y)
	public void resurrect(int x, int y, Colour c) {
		grid.setCellState(x, y, c);
	}

	// clear the board and reset the turn count to 0
	public void clear() {
		grid = new GridAdapter(new Grid());
	}

	// step the simulation through one application of the rules and increment
	// the turn counter
	public void step() {
		int[] states;
		GridAdapter newGrid = new GridAdapter(new Grid());
		for(int i = 0; i<Grid.SIZE; i++)
			for(int j = 0; j<Grid.SIZE; j++) {
				states = grid.getCellState(i, j);
				if(grid.getCell(i, j).isAlive() && (states[0]+states[1]<2 || states[0]+states[1]>3))
					newGrid.setCellState(i, j, Colour.GREY);
				else if(!grid.getCell(i, j).isAlive() && states[0]+states[1]==3) {
					if(states[0]>states[1])
						grid.getCell(i, j).setColour(Colour.RED);
					else
						grid.getCell(i, j).setColour(Colour.GREEN);
				}
					
			}
		grid = newGrid;
	}

}