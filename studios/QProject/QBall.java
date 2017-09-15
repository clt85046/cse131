package QProject;

import QProject.Draw;
import sedgewick.StdDraw;

public class QBall implements Draw {
	
	private double posX;
	private double posY;
	private double radius = 0.02;
	private double velocity;	
	private double degree;
	private boolean upDown;
	private double gravity = 9.8;
	private double vx;
	private double vy;
	/**
	 * Creates an Alien object to be implemented in the game
	 * @param x- x-coordinate of alien (center)
	 * @param y- y-coordinate of alien (center)
	 * @param velocity- ball`s velocity
	 * @param angle - angle of shoot
	 * @param degree - degree of shoot
	 * @param upDown - direction detection
	 */
	public QBall(double x, double y, double velocity, double angle) {
		this.posX = x ;
		this.posY = y ;
		this.velocity = velocity/300;
		///this.angle = angle;
		this.degree = angle / 180 * Math.PI;
		this.upDown = true;
		vx = Math.cos(degree) * this.velocity;
		vy = Math.sin(degree) * (this.velocity) ;
	}
	
	/**
	 * Getter of the posX
	 * @return The posX.
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * Getter of the posY
	 * @return The posY.
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * Getter of the radius
	 * @return The radius
	 */
	public double getRadius() {
		return this.radius;
	}
	
	
	/**
	 * Draw the alien with posX, posY, width, height.
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledCircle(posX, posY, radius);
	}
	
	/**
	 * If it is off screen, reverse its direction. If upDwon is true, it 
	 * will mover vertically. Else, horizontally.
	 */
	public void move() {
//      Bump function
//		if (posX >= 1 || posX <=-1) {
//			degree = Math.PI - degree;
//		} else if (posY >= 1 && upDown == true) {
//			degree = -1 * degree;
//			//System.out.println("posY = " + posY);
//			upDown = false;
//		}
//		if (posY < 1) {
//			upDown = true;
//		}
		this.posX = posX + vx;
		this.posY = posY +  vy ;
		vy = vy - gravity/300;

	}
	
	/**
	 * Getter of the getxSpeed.
	 * @return The getxSpeed.
	 */
	public double getxSpeed() {
		return Math.cos(degree) * velocity;
	}
	
	/**
	 * Getter of the getxSpeed.
	 * @return The getxSpeed.
	 */
	public double getySpeed() {
		return Math.sin(degree) * velocity;
	}

	
	

	

}
