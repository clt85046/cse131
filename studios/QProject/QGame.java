package QProject;

import java.awt.Color;
import cse131.ArgsProcessor;
import sedgewick.StdDraw;


public class QGame {
	private Player playerA;
	private Player playerB;
	private QBall ball;
	private int scoreA;
	private int scoreB;
	private buildings building;
	/**
	 * This is the constructor of the game. Here we initialize all the variables.
	 * @param scoreA playerA`s score
	 * @param scoreB playerB`s score
	 * @param building random buildings
	 */
	public QGame() {
		StdDraw.setScale(-1, 1);
		//playerA = new Player(-0.90, -0.95, 3);
		//playerB = new Player(0.90, -0.95, 3);
		scoreA = 0;
		scoreB = 0;
		this.building = new buildings();
	}
	
	/**
	 * Draw the board. The background is set to be black and the score's color
	 * is white.
	 * @param score The score of the player.
	 */
	public void drawBoard(int scoreA,int scoreB) {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(-0.75, 0.9, "ScoreA: " + scoreA);
		StdDraw.text(0.75, 0.9, "ScoreB: " + scoreB);
		//drawGround();
		building.draw();
		StdDraw.setPenColor(Color.WHITE);
	}
	
	public void drawBuilding() {
		StdDraw.setPenColor(Color.gray);
	}
	/**
	 * 
	 * @param x The x coordinate of the shooting started.
	 * @param y The y coordinatez of the shooting started.
	 * @param speed The speed of the shooting
	 * @param angle The angle of the shotting
	 * @param param The wind velocity
	 * @param playerNo The player : A or B.
	 */
	private void shootThatGuy(double x, double y, double speed, double angle, double wind){
		double saferange = speed/300.0 > 0.17 ? speed/300.0 : 0.17;
		System.out.println("range = " + saferange);
		this.ball = new QBall(x, y + saferange, speed, angle);
		while(playerA.qCollided(ball) && playerB.qCollided(ball) && building.collide(ball) && ball.getPosX() > -1.2 && ball.getPosX() < 1.2) {
			//System.out.println("posX = " + ball.getPosX());
			//System.out.println("posY = " + ball.getPosY());
			drawBoard(scoreA,scoreB);
			playerA.draw();
			playerB.draw();
			//playerA.draw();
			//playerB.draw();
			ball.draw();
			ball.move();
			StdDraw.show(100);
		}
		if (!playerA.qCollided(ball)) {
			scoreB++;
			drawExplostions();
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(0, 0, "playeB earn a point!");
			playerB.draw();
			StdDraw.show(800);
		} else if (!playerB.qCollided(ball)) {
			scoreA++;
			drawExplostions();
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(0, 0, "playeA earn a point!");
			playerA.draw();
			StdDraw.show(800);
		}
		else if(!building.collide(ball)) {
			drawExplostions();
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(0, 0, "NEXT ONE");
			playerA.draw();
			playerB.draw();
			StdDraw.show(800);	
		} else {
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(0, 0, "NEXT ONE");
			playerA.draw();
			playerB.draw();
			StdDraw.show(800);	
		}
	}
	

	
	public void play(String[] args, int turn){
		//draw the gameBoard and enter the paragram
		drawBoard(scoreA,scoreB);
		ArgsProcessor ap = new ArgsProcessor(args);
		double point = ap.nextInt("The points one should get:");
		//start game
		while (scoreA < point && scoreB < point) {
			building.getPara();
			drawBoard(scoreA,scoreB);
			this.playerA = new Player(-0.95, -0.95 + building.startheight());
			this.playerB = new Player(0.95, -0.95 + building.endheight());
			playerA.draw();
			playerB.draw();
			StdDraw.show(500);
			//enter speed and angles by player
			double velocity1 = ap.nextDouble("enter your speed");
			double angle1 = ap.nextDouble("enter your angle ");
			//decided player`s turn
			if(turn%2 == 0){
				turn++;
				//playerA.getSpeed(velocity1, angle1);
				shootThatGuy(playerA.getPosX(), playerA.getPosY(), velocity1, angle1, 0);
				//turn++;
			}
			else{
				turn--;
				//playerB.getSpeed(velocity1, angle1);
				angle1 = 180 - angle1;
				shootThatGuy(playerB.getPosX() , playerB.getPosY(), velocity1, angle1, 0);
				//turn++;
			}
		}
			StdDraw.show(600);
			drawWinner();
			
	}

	/**
	 * darw explostions
	 */
	public void drawExplostions() {
		drawBoard(scoreA,scoreB);
		//different show for different situation
		if (!playerA.qCollided(ball)) {
			double x = playerA.getPosX();
			double y = playerA.getPosY();
			StdDraw.setPenColor(Color.RED);
			StdDraw.filledCircle(x, y, 0.1);
			StdDraw.text(x , y + 0.1, "BOOM!");
		} else if (!playerB.qCollided(ball)) {
			double x = playerB.getPosX();
			double y = playerB.getPosY();
			StdDraw.setPenColor(Color.RED);
			StdDraw.filledCircle(x, y, 0.1);
			StdDraw.text(x , y + 0.1, "BOOM!");
		} else if(!building.collide(ball)) {
			double x = ball.getPosX();
			double y = ball.getPosY();
			StdDraw.setPenColor(Color.RED);
			StdDraw.filledCircle(x, y, 0.1);
			StdDraw.text(x , y + 0.1, "BOOM!");
		}
	}

	/**
	 * draw the final winner
	 * @param player
	 */
	public void drawWinner() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		if (scoreA > scoreB) {			
			StdDraw.text(0, 0, "winner is playerA");
		} else {
			StdDraw.text(0, 0, "winner is playerB");
		}
		StdDraw.show(2000);
		double i = -1.0;
		while (i < 0){
			StdDraw.clear();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(0, 0, 1, 1);
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(i, 0, "Game over");
			i = i + 0.2;
			StdDraw.show(500);

		}
		StdDraw.show(2000);
		scoreA = 0;
		scoreB = 0;
		drawBoard(scoreA,scoreB);
		StdDraw.show(60);
	}
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QGame game = new QGame();
		int turn = 0;
		while (true){
			game.play(args, turn);
			turn ++;
		}
	}

}
