package life;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI {
	final JButton[][] cells = new JButton[Grid.SIZE][Grid.SIZE];
	private JButton step = new JButton("Step");
	private JButton reset = new JButton("Clear");
	private JButton run = new JButton("Run");
	private JSlider slider = new JSlider(SwingConstants.VERTICAL, 1, 10, 1);
	private JLabel counter = new JLabel("turns: 0", SwingConstants.CENTER);
	private int count = 0;
	final JPanel panel = new JPanel();
	private Life life;
	final MouseAdapter ma = new MyMouseAdapter();
	Timer t;

	public GUI(Life life) {
		this.life = life;
	}

	void updateGUI() {
		for (int i = 0; i < Grid.SIZE; i++)
			for (int j = 0; j < Grid.SIZE; j++) {
				updateCellColour(i, j,
						Grid.colorMap.get(life.grid.getCell(i, j).getColour()));
			}
	}

	public void updateTurn() {
		++count;
		counter.setText("turns: " + count);
		//counter.setName("turns: " + count);
	}
	public void start() {
		JPanel grid = new JPanel();
		t = new Timer(2000 / slider.getValue(), new TimerListener());
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				t.setDelay(2000 / slider.getValue());

			}

		});
		grid.setLayout(new GridLayout(Grid.SIZE, Grid.SIZE));
		for (int i = 0; i < Grid.SIZE; i++)
			for (int j = 0; j < Grid.SIZE; j++) {
				cells[i][j] = new CellButton(i, j);
				Dimension d = new Dimension();
				d.height = d.width = Grid.CELLSIZE;
				cells[i][j].setPreferredSize(d);
				updateCellColour(i, j, Color.GRAY);
				grid.add(cells[i][j]);
				cells[i][j].addMouseListener(ma);
			}

		JPanel buttons = new JPanel(new FlowLayout());
		step.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				life.step();
			}

		});

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				life.clear();

			}

		});

		run.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (run.getText() == "Run") {
					run.setText("Pause");
					t = new Timer(2000 / slider.getValue(), new TimerListener());
					t.start();
				} else {
					run.setText("Run");
					t.stop();
				}

			}

		});
		buttons.add(reset);
		buttons.add(step);
		buttons.add(run);
		
		panel.setLayout(new BorderLayout());
		panel.add(counter,BorderLayout.NORTH);
		panel.add(grid, BorderLayout.CENTER);
		panel.add(buttons, BorderLayout.SOUTH);
		panel.add(slider, BorderLayout.EAST);
	}

	public void updateCellColour(int i, int j, Color c) {
		cells[i][j].setBackground(c);
	}

	public JPanel getPanel() {
		return panel;
	}

	public class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			life.step();

		}

	}

	public class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent event) {
			CellButton b = (CellButton) event.getSource();
			int x = b.getMyX();
			int y = b.getMyY();
			if (SwingUtilities.isLeftMouseButton(event))
				life.resurrect(x, y, Colour.RED);
			else if (SwingUtilities.isMiddleMouseButton(event))
				life.kill(x, y);
			else if (SwingUtilities.isRightMouseButton(event))
				life.resurrect(x, y, Colour.GREEN);

		}
	}

}
