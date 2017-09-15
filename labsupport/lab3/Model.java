package lab3;

public class Model {

	private boolean[][] mines;

	private static boolean[][] genMines(int numRows, int numCols, double percentMines) {
		boolean[][] mines = new boolean[numRows][numCols];
		for (int rows = 0; rows < mines.length; rows++) {
			for (int cols = 0; cols < mines[rows].length; cols++) {
				double x = Math.random();
				if (x < percentMines) {
					mines[rows][cols] = true;
				} else {
					mines[rows][cols] = false;
				}
			}
		}
		return mines;

	}

	/**
	 * Generate a model based on the supplied parameters
	 * @param numRows
	 * @param numCols
	 * @param percentMines
	 */
	public Model(int numRows, int numCols, double percentMines) {
		this(genMines(numRows, numCols, percentMines));
	}

	/**
	 * Generate a model based on the supplied array that indicates the bombs' positions
	 * @param mines
	 */
	public Model(final boolean[][] mines) {
		this(
				new Interface() {

					@Override
					public int getRows() {
						return mines.length;
					}

					@Override
					public int getCols() {
						return mines[0].length;
					}

					@Override
					public boolean isMine(int row, int col) {
						return mines[row][col];
					}

				}
		);
	}

	/**
	 * Generate a model based on anything that implements the interface
	 * @param mss
	 */
	public Model(Interface mss) {
		this.mines = new boolean[mss.getRows()][mss.getCols()];
		for (int r=0; r < mss.getRows(); ++r) {
			for (int c = 0; c < mss.getCols(); ++c) {
				mines[r][c] = mss.isMine(r, c);
			}
		}
	}

	public void print(boolean showCounts) {
		for (int r = 0; r < mines.length; r++) {
			for (int c = 0; c < mines[r].length; c++) {
				if (mines[r][c]) {
					System.out.print(" * ");
				} 
				else {
					System.out.print(" " + (showCounts ? nearbyBombs(r, c) : ".") + " ");
				}
			}
			System.out.println();
		}
	}

	public int nearbyBombs(int row, int col) {
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i + row >= 0 && i + row < mines.length) {
					if (j + col >= 0 && j + col < mines[row].length) {
						if (mines[i + row][j + col]) {
							count += 1;
						}
					}
				}
			}
		}
		return count;
	}

	public int getRows() {
		return mines.length;
	}

	public int getCols() {
		return mines[0].length;
	}

	public boolean get(int row, int col) {
		return mines[row][col];
	}
}
