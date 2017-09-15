package conway;

/**
 * 
 *
 */
public class Conway {
	private int rows;
	private int cols;
	private boolean[][] liveness;

	/**
	 * constructor
	 * @param rows
	 * @param cols
	 */
	public Conway(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		this.liveness = new boolean[rows][cols];
		
	}

	
	/**
	 * accessor
	 * @return
	 */
	public int getRows(){
		return this.rows;             // FIXME
	}

	/**
	 * accessor
	 * @return
	 */
	public int getColumns(){
		return this.cols;             // FIXME
	}

	/**
	 * Sets the current status of the cell at (row, col)
	 * @param b if true, the cell is alive; if false, the cell is dead 
	 * @param row
	 * @param col
	 */
	public void setLiveness(boolean b, int row, int col){
		liveness[row][col] = b;
		// FIXME
	}


	/**
	 *  
	 * @param row
	 * @param col
	 * @return whether or not a cell at a specific row and column is alive. 
	 *    If row or col is out of bounds, you must return false.
	 */
	public boolean isAlive(int row, int col){
		if(row<rows&&row>=0&&col>=0&&col<cols){
			return liveness[row][col];   
		}
		else{
			return false;
		}
	}


	/**
	 * Make every cell not alive
	 */
	public void clear(){
		for(int i=0;i<rows;i++){
			for (int j = 0;j<cols;j++){
				liveness[i][j] = false;
			}
		}
	}


	/**
	 * Consider the 3x3 cell array that has the cell at (row, col) at its center.
	 * Let's call all cells but that center cell the neighbors of that center cell.
	 * This method returns the number of neighbors that are alive.
	 * 
	 *   n  n  n
	 *   n  c  n
	 *   n  n  n
	 *   
	 *  Above, if c represents the cell at (row, col), each n is
	 *  a neighbor of c, according to the above definition.
	 *  The result is at most 8 and at least 0.
	 * 
	 * @param row
	 * @param col
	 * @return the number of living neighbors
	 */
	public int countLivingNeighbors(int row, int col){
		int count = 0;
		for (int i = -1;i<2;i++){
			for (int j = -1;j<2;j++){
				if(i!=0||j!=0){
					if(row+i>=0&&col+j>=0&&row+i<rows&&col+j<cols){
						if(liveness[row+i][col+j]){
						count = count+1;
					}
					}
					
				}
			}
		}
		return count;    // FIXME
	}

	/**
	 * Executes a generation of life.  Be sure to read the specification
	 * for this assignment, because it points out a common mistake students
	 * make when implementing this method.
	 * 
	 */
	public void step(){
		Conway next = new Conway(rows,cols);
		for(int i = 0;i<rows;i++){
			for(int j = 0;j<cols;j++){
				next.setLiveness(this.isAlive(i, j),i,j);
			}
		}
		int ln= 0;
		for (int i = 0;i<rows;i++){
			for(int j = 0;j<cols;j++){
				ln = this.countLivingNeighbors(i,j);
				if(ln == 3){
					next.setLiveness(true,i, j);
				}
				if(ln<2){
					next.setLiveness(false,i, j);
				}
				if(ln>3){
					next.setLiveness(false,i, j);
				}
				
//				if(this.liveness[i][j]){
//					if(ln<2){
//						next.liveness[i][j]= false;
//					}
//					else{
//						if(ln>3){
//							next.liveness[i][j] = false;
//						}
//					}
//				}
//				else{
//					if(ln == 3){
//						next.liveness[i][j] = true;
//					}
//				}
//				System.out.println("now the cell "+i+" "+j+" is "+next.isAlive(i,j));
			}
		}
		this.liveness = next.liveness;
		// FIXME
	}

	/**
	 * creates a blinker
	 */
	public void blinker() {

		if (this.getRows() < 3 || this.getColumns() < 3) {
			System.out.println("Grid is too small for premade pattern Blinker. " +
					"Conway must be at least 3x3");
		}
		else {
			this.setLiveness(true, 1, 0);
			this.setLiveness(true, 1, 1);
			this.setLiveness(true, 1, 2);
		}
	}

	public void fourBlinkers() {
		clear();
		if (this.getRows() < 9 || this.getColumns() < 9) {
			System.out.println("Grid is too small for premade pattern Four Blinkers. " +
					"Conway must be at least 9x9");
		}
		else {
			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					this.setLiveness(true, i, j);
				}
			}
		}
	}


	public void gosperGliderGun() {
		clear();
		if (this.getRows() < 50 || this.getColumns() < 50) {
			System.out.println("Grid is too small for premade pattern Gosper Glider Gun. " +
					"Conway must be at least 50x50");
		}
		else {
			this.setLiveness(true,0,27);
			this.setLiveness(true,1,25);
			this.setLiveness(true,1,27);
			this.setLiveness(true,2,15);
			this.setLiveness(true,2,16);
			this.setLiveness(true,2,23);
			this.setLiveness(true,2,24);
			this.setLiveness(true,2,37);
			this.setLiveness(true,2,38);
			this.setLiveness(true,3,14);
			this.setLiveness(true,3,18);
			this.setLiveness(true,3,23);
			this.setLiveness(true,3,24);
			this.setLiveness(true,3,37);
			this.setLiveness(true,3,38);
			this.setLiveness(true,4,3);
			this.setLiveness(true,4,4);
			this.setLiveness(true,4,13);
			this.setLiveness(true,4,19);
			this.setLiveness(true,4,23);
			this.setLiveness(true,4,24);
			this.setLiveness(true,5,3);
			this.setLiveness(true,5,4);
			this.setLiveness(true,5,13);
			this.setLiveness(true,5,17);
			this.setLiveness(true,5,19);
			this.setLiveness(true,5,20);
			this.setLiveness(true,5,25);
			this.setLiveness(true,5,27);
			this.setLiveness(true,6,13);
			this.setLiveness(true,6,19);
			this.setLiveness(true,6,27);
			this.setLiveness(true,7,14);
			this.setLiveness(true,7,18);
			this.setLiveness(true,8,15);
			this.setLiveness(true,8,16);


		}
	}

	public void glider() {
		clear();
		if (this.getRows() < 10 || this.getColumns() < 10) {
			System.out.println("Grid is too small for premade pattern Four Blinkers. " +
					"Conway must be at least 10x10");
		}
		else {

			this.setLiveness(true,1,1);
			this.setLiveness(true,1,3);
			this.setLiveness(true,2,2);
			this.setLiveness(true,2,3);
			this.setLiveness(true,3,2);

		}
	}

	public void yourDesignOne() {
		fourBlinkers();
		

	}

	public void yourDesignTwo() {
		gosperGliderGun();
		
		


	}


	public void logAndCapture() {
		System.out.println("Beginning of Log and Capture");
		for(int i = 0;i<rows;i++){
			for(int j = 0;j<cols;j++){
				if(isAlive(i,j)){
					System.out.println("setLiveness(true, "+i+", "+j+");");
				}
			}
		}
		System.out.println("End of Log and Capture");

	}

}