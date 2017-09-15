package lab3.viz;

import lab3.Model;

public class Board {

	private SingleMine[][] viz;
	private Model model;

	public Board(Model model){
		this.model = model;
		viz = new SingleMine[model.getRows()][model.getCols()];
		for(int rows = 0; rows < model.getRows(); rows ++){
			for (int cols = 0; cols < model.getCols(); cols ++){
				viz[rows][cols] = new SingleMine();
				viz[rows][cols].value = model.get(rows, cols);
				viz[rows][cols].nearbybombs = model.nearbyBombs(rows, cols);
			}
		}
	}

	public SingleMine getButton(int row, int col){
		return viz[row][col];
	}

	public boolean isMine(int row, int col) {
		return model.get(row, col);
	}

	public void press(int row, int col) {
		if(model.get(row, col)){
			showBombs();
		}
		viz[row][col].press();
		if(model.nearbyBombs(row, col) == 0){
			checkNeighbors(row,col);
		}
		if(checkWin()){
			System.out.println("WON");
			showBombs();
		}
	}

	public void rightClick(int row, int col) {
		viz[row][col].rightClick();
		if(checkWin()){
			System.out.println("WON");
			showBombs();
		}
	}

	private boolean checkWin(){
		boolean won = true;
		for (int row = 0; row < model.getRows(); row ++){
			for(int col = 0; col <model.getCols(); col++){
				if(!model.get(row, col) && !isDisplayed(row,col)){
					won = false;
				}
			}
		}
		return won;
	}

	private boolean isDisplayed(int rows, int cols) {
		return viz[rows][cols].displayed;
	}

	private void checkNeighbors(int rows, int cols) {
		for(int i = -1; i <=1; i ++){
			for (int j = -1; j <=1; j ++){
				if (i+rows >= 0 && i+rows < model.getRows()){
					if( j+cols >= 0 && j+cols < model.getCols()){
						if (!model.get(i+rows, j+cols)){
							if(!isDisplayed(rows+i, cols+j)){
								viz[rows+i][cols+j].press();
								if(model.nearbyBombs(rows+i, cols+j) == 0){
									checkNeighbors(rows+i, cols+j);
								}
							}
						}
					}
				}		
			}
		}
	}
	
	private void showBombs() {
		for (int rows = 0; rows < model.getRows(); rows ++){
			for (int cols = 0; cols < model.getCols(); cols ++){
				if (model.get(rows, cols)){
					viz[rows][cols].press();
				}
			}
		}		
	}

}
