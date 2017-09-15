package project;

import sedgewick.StdDraw;

public class Bullet implements Moveable,collision{
	
	private double posX;
	private double posY; 
	private double width = 0.05;
	private double height = 0.05;
	private double speed;
	private boolean isOffScreen = false;
	
	/**
	 * Creates a Bullet object to be implemented in the game
	 * @param x- x-coordinate of bullet (center)
	 * @param y- y-coordinate of bullet (center)
	 * @param speed- speed at which the bullet moves 
	 */
	public Bullet(double x, double y, double speed) {
		this.posX = x;
		this.posY = y;
		this.speed = speed;
	}
	
	/**
	 * draw bullets
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
	}
	
	/**
	 * move function of bullet
	 */
	public void move() {
		this.posY += speed;
	}
	
	/**
	 * get bullet x position
	 * @return
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * get bullet y position
	 * @return
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * Determine if bullet is out of bounds
	 */
	public boolean getIsOffScreen() {
		return this.isOffScreen;	
	}
	
	/**
	 * Remove bullet if off screen or collides with alien
	 */
	public void setOffScreen() {
		this.isOffScreen = true;
	}
	
	/**
	 * Determine if a bullet and alien collide based on comparing upper left and bottom right coordinates of each
	 * @param a- alien that bullet potentially collided with
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
		
		double otherTopLeftX1 = p.getPosX() - p.getWidth()/2;
		double otherTopLeftY1 = p.getPosY() + p.getHeight()/2;
		double otherBottomRightX1 = p.getPosX() + p.getWidth()/2;
		double otherBottomRightY1 = p.getPosY() - p.getHeight()/2;
		if(myTopLeftY >= otherBottomRightY && myBottomRightY <= otherTopLeftY && myBottomRightX >= otherTopLeftX && myTopLeftX <= otherBottomRightX){
			x = 1;
		}
		if(myTopLeftY >= otherBottomRightY1 && myBottomRightY <= otherTopLeftY1 && myBottomRightX >= otherTopLeftX1 && myTopLeftX <= otherBottomRightX1){
			x = 2;
		}
		//||(myTopLeftY >= otherBottomRightY && myBottomRightY <= otherTopLeftY && myBottomRightX >= otherTopLeftX && myTopLeftX <= otherBottomRightX)
		return x;
	}

}
