package project;

import java.awt.Color;

import sedgewick.StdDraw;

public class Player implements Moveable,collision {
	
	private double posX;
	private double posY; 
	private final double startPosX;
	private final double startPosY;
	private final double width = 0.1;
	private final double height = 0.1;
	private Color color;
	private int lives;
	private double speed;
	private final Color [] colors = {StdDraw.RED, StdDraw.YELLOW, StdDraw.WHITE};
	
	/**
	 * Creates a Player object to be implemented in the game
	 * @param x- x-coordinate of player (center)
	 * @param y- y-coordinate of player (center)
	 * @param speed- speed at which the player moves 
	 * @param lives- number of lives the player starts with
	 */
	public Player(double x, double y, double speed, int lives) {
		this.posX = x;
		this.posY = y;
		this.startPosX = x;
		this.startPosY = y;
		this.speed = speed;
		this.lives = lives;
		this.color = colors[(this.lives-1) % 3];
	}
	
	/**
	 * draw the player on the screen
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
		StdDraw.filledRectangle(this.posX, (this.posY + this.height/1.5), this.width/6, this.height/2);
	}
	
	/**
	 * move function of player
	 */
	public void move() {
		
		//If movements are possible:
		if ((ArcadeKeys.isKeyPressed(0, 1)) && (this.posX - this.speed > -1)) {
			this.posX -= this.speed;
		}
		else if ((ArcadeKeys.isKeyPressed(0, 3)) && (this.posX + this.speed < 1)) {
			this.posX += this.speed;
		}
	}
	
	/**
	 * return x position
	 * @return
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * return y position
	 * @return
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * get present lives of player
	 * @return
	 */
	public int getLives() {
		return this.lives;
	}
	
	public void setLives(int live){
		lives = live;
	}
	
	/**
	 * get width of player
	 * @return
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * get height of player
	 * @return
	 */
	public double getHeight() {
		return this.height;
	}
	/**
	 * Determine if bullet is out of bounds
	 * @return
	 */
	public boolean fire() {
		return (ArcadeKeys.isKeyPressed(0, 0)); //key w pushed
	}
	
	/**
	 * Kills player by reducing life and changing colors
	 */
	public void die() {
		this.lives--;
		if (lives != 0) {
			this.color = colors[lives - 1];
		}
		this.posX = this.startPosX;
		this.posY = this.startPosY; //doesn't do anything but good form
	}
	
	/**
	 * Determine if the player and alien collide based on comparing upper left and bottom right coordinates of each
	 * @param a- alien that player potentially collided with
	 * @return true if collision occurred
	 */
	public int collide(Alien a,Player p) {	
		int x = 0;
		double myTopLeftX = posX - width/2;
		double myTopLeftY = posY + height/2;
		double myBottomRightX = posX + width/2;
		double myBottomRightY = posY - height/2;
		
		double otherTopLeftX = a.getPosX() - a.getWidth()/2;
		double otherTopLeftY = a.getPosY() + a.getHeight()/2;
		double otherBottomRightX = a.getPosX() + a.getWidth()/2;
		double otherBottomRightY = a.getPosY() - a.getHeight()/2;
		
		if (myTopLeftY >= otherBottomRightY && myBottomRightY <= otherTopLeftY && myBottomRightX >= otherTopLeftX && myTopLeftX <= otherBottomRightX){
			x=1;
		}
		return x;
	}

}
