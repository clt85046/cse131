package lab3.viz;


public class StreamToBoardAdapter {

	private boolean[][] board;
	private int row;
	private int col;

	public StreamToBoardAdapter(String s, int cols, int rows) {
		board = new boolean[rows][cols];
		row = 0;
		col = 0;
		process(s);
	}
	
	private void process(String s) 
	{
			String[] str = s.split("\n"); //get each line
			for (int j = 0; j < str.length; ++j) {
				str[j] = str[j].replaceAll("\\s", ""); //get each non whitespace character
				for (int i = 0; i < str[j].length(); ++i) {
					if (row >= board.length) 
					{	
						return;
					}
					if (str[j].charAt(i) == '*') {
						board[row][col] = true;
						++col;
					}
					else if (str[j].charAt(i) == '.'){
						board[row][col] = false;
						++col;
					}
					//
					// Ignore all else, it's probably the bomb counts
					//
					if (col >= board[0].length) {
						++row;
						col = 0;
						break;
					}
				}
			}

	}

	public boolean[][] getBoard() {
		return this.board;
	}
}
