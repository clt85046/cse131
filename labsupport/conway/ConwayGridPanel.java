package conway;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ConwayGridPanel extends JPanel {

	final private CellViz[][] cells;
	final private int rows;
	final private int cols;
	final Conway conway;
	public ConwayGridPanel(Conway conway, int cellWidth) {
		rows = conway.getRows();
		cols = conway.getColumns();
		this.conway = conway;
		cells = new CellViz[rows][cols];
		setLayout(new GridLayout(rows, cols));


		for (int i=0; i<rows; ++i) {
			for (int j=0; j<cols; ++j) {
				Cell c = new Cell(conway, i, j);
				CellViz cell = new CellViz(c, cellWidth, i, j, conway);
				cells[i][j] = cell;
				this.add(cell);
			}
		}
	}

	public void displayLiveness() {
		for (int r=0; r < rows; ++r) {
			for (int c=0; c < cols; ++c) {
				cells[r][c].displayLiveness(conway.isAlive(r, c));
			}
		}
	}

}
