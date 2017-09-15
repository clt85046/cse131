package project;

import sedgewick.StdDraw;

public class Alien implements Moveable {
	
	private double posX;
	private double posY;
	private final double startX;
	private final double startY;
	private final double width = 0.15;
	private final double height = 0.15;
	private double speed;	
	private boolean upDown;
	private boolean isAlive = true;
	
	/**
	 * Creates an Alien object to be implemented in the game
	 * @param x- x-coordinate of alien (center)
	 * @param y- y-coordinate of alien (center)
	 * @param speed- speed at which the alien moves 
	 * @param upDown- true if alien moves up/down pattern; false if alien moves side-to-side pattern
	 */
	public Alien(double x, double y, double speed, boolean upDown) {
		this.posX = x;
		this.posY = y;
		this.startX = x;
		this.startY = y;
		this.speed = -speed;
		this.upDown = upDown;
	}
	
	/**
	 * get x position
	 * @return
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * get y position
	 * @return
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * get width of alien
	 * @return
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * get height of alien
	 * @return
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * set x position
	 * @param x
	 */
	public void setX(double x){
		this.posX = x;
	}
	
	/**
	 * get speed of alien
	 * @return
	 */
	public double getspeed() {
		return this.speed;
	}
	
	/**
	 * get Updown of alien
	 * @return
	 */
	public boolean getUpdown(){
		return this.upDown;
	}
	/**
	 * draw aliens
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
	}
	
	/**
	 * move function of aliens
	 */
	public void move() {
		if (isOffScreen()) {
			speed *= -1;
		}
		if (upDown) {
			this.posY += speed;
		} else {
			this.posX += speed;
		}

	}
	
	/**
	 * alien fire function
	 * @return
	 */
	public boolean fire() {
		return (Math.random()>0.7); //key w pushed
	}
	
	/**
	 * Determine if alien is out of bounds
	 * @return
	 */
	public boolean isOffScreen() {
		return (this.posX > 1 || this.posX < -1 || this.posY > 1 || this.posY < -1);
	}
		
	/**
	 * reset the aliens position
	 */
	public void moveToStart() {
		this.posX = startX;
		this.posY = startY;
	}
	
	/**
	 * find whether alien has been destroyed
	 * @return
	 */
	public boolean isAlive() {
		return this.isAlive;
	}
	
	/**
	 * make alien be destroyed
	 */
	public void die() {
		this.isAlive = false;
	}
	

}
