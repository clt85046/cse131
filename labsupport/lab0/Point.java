package lab0;


/**
 * Name: Jake Gordon
 * Lab Section: H
 * Date: 10/1/11
 * Vector.java
 * CSE 131 Lab 4
 */
public class Point {

	private double x;
	private double y;
	
	/**
	 * Constructor
	 * @param x - x value of point
	 * @param y - y value of point
	 */
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @return- returns x value of point
	 */
	public double getX(){
		return x;
	}
	/**
	 * 
	 * @return - returns y value of point
	 */
	public double getY(){
		return y;
	}
	/**
	 * returns string in the form of (x, y)
	 */
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	/**
	 * adds a vector to a point 
	 * @param v vector to be added
	 * @return the point at the end of the vector
	 */
	public Point plus(Vector v){
		return new Point(x+v.getDeltaX(), y+v.getDeltaY());
	}
	/**
	 *  subtracts two points
	 * @param p2 point to be subtracted
	 * @return a vector that is the difference between the two points
	 */
	public Vector minus(Point p2){
		return new Vector(x-p2.getX(), y-p2.getY());
	}
	/**
	 *  calculates the distance between two points
	 * @param p2 2nd point to calc distance
	 * @return distance between two points
	 */
	public double distance(Point p2){
		Vector v = minus(p2); // new vector that is the difference between the points
		return v.magnitude(); // the magnitude of the new vector is the distance
	}
	
	
	
}
