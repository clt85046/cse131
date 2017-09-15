package QProject;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class Player implements Draw {
	
	private double posX;
	private double posY; 
	private final double width = 0.1;
	private final double height = 0.1;
	private Color color;
	/**
	 * Creates a Player object to be implemented in the game
	 * @param posX- x-coordinate of player (center)
	 * @param posY- y-coordinate of player (center)
	 */
	public Player(double x, double y) {
		this.posX = x;
		this.posY = y;
	}
	
	/**
	 * 
	 * find if player is collided with ball
	 */
	public boolean qCollided(QBall a){
		double BottominsideR = Math.sqrt((height/2) * (height/2) + (width/2) * (width/2));
		double TopinsideR = Math.sqrt((height/6) * (height/6) + (width/6) * (width/6));
		double radius = a.getRadius();
		double Toplength = radius + TopinsideR;
		double Bottomlength = radius + BottominsideR;
		double x = a.getPosX();
		double y = a.getPosY();
		double realLength = Math.sqrt((x - posX) * (x - posX) + (y - posY) * (y - posY));
		return ((realLength >= Toplength && realLength >= Bottomlength));
	}

	/**
	 * Draw the Player.
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
		StdDraw.filledRectangle(this.posX, (this.posY + this.height/1.5), this.width/6, this.height/6);
	}
	
	/**
	 * Getter of posX.
	 * @return Return posX.
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * Getter of posY.
	 * @return Return posY.
	 */
	public double getPosY() {
		return this.posY;
	}
}

