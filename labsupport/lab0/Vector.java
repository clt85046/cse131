package lab0;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * Name: Jake Gordon
 * Lab Section: H
 * Date: 10/1/11
 * Vector.java
 * CSE 131 Lab 4
 */

public class Vector {

	private double deltaX;
	private double deltaY;
	private final static Vector NORTH = getNorth();
	private final static Vector SOUTH = getSouth();
	private final static Vector EAST = getEast();
	private final static Vector WEST = getWest();
	
	private static final Set<Vector> defaultSnaps = new HashSet(
			Arrays.asList(new Vector[] { NORTH, SOUTH, EAST, WEST })
			);

	/**
	 * constructor
	 * @param deltaX - change in X for vector
	 * @param deltaY - change in Y for vector
	 */
	public Vector(double deltaX, double deltaY){
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	/**
	 * returns the vector as a string in the form of "[deltaX deltaY}
	 */
	public String toString(){
		return "[" + deltaX + " " + deltaY + "]";
	}

	/**
	 * 
	 * @return - returns deltaX
	 */
	public double getDeltaX(){
		return deltaX;
	}

	/**
	 * 
	 * @return - returns deltaY
	 */
	public double getDeltaY(){
		return deltaY;
	}

	/**
	 * 
	 * @return - returns magnitude of vector
	 */
	public double magnitude(){
		return Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2)); //calculates magnitude through pathagorean theoreum.
	}

	/**
	 * Rotate, produce a new Vector
	 */

	public Vector rotate(int degreesCounterClockwise) {
		// TA
		return this;
	}

	/**
	 * 
	 * @return - returns identical vector with oppoiste x value
	 */
	public Vector deflectX(){
		return new Vector(-deltaX, deltaY);
	}

	/**
	 * 
	 * @return - returns idential vector with opposite y value
	 */
	public Vector deflectY(){
		return new Vector(deltaX, -deltaY);
	}

	/**
	 * 
	 * @param v2 - vector to be added 
	 * @return - returns the sum of two vectors
	 */
	public Vector plus(Vector v2){
		return new Vector(this.deltaX + v2.getDeltaX(), this.deltaY + v2.getDeltaY());
	}

	/**
	 * 
	 * @param v2 - vector to be subtracted
	 * @return - returns the difference between two vectors
	 */
	public Vector minus(Vector v2){
		return new Vector(this.deltaX - v2.getDeltaX(), this.deltaY - v2.getDeltaY());
	}

	/**
	 * 
	 * @param factor - factor by which to scale vector
	 * @return - returns vector scaled by factor
	 */
	public Vector scale(double factor){
		return new Vector(deltaX*factor, deltaY*factor);
	}

	/**
	 * 
	 * @param magnitude - magnitude that returned vector should have
	 * @return - returns new vector in same direction with specified magnitude
	 */
	public Vector rescale(double magnitude){
		double factor;
		if (this.magnitude() == 0)
			return new Vector(magnitude, 0);
		else
			factor = magnitude/this.magnitude();
		return scale(factor);
	}

	public Vector snapTo() {
		return snapTo(defaultSnaps);
	}
	
	public Vector snapTo(Set<Vector> snaps) {
		double diffDegrees = 360; //  can be no bigger
		Vector closest = null;
		for (Vector s : snaps) {
			double sDiff = Math.abs(this.getAngle() - s.getAngle()) % 360.0;
			if (sDiff < diffDegrees) {
				diffDegrees = sDiff;
				closest = s;
			}
		}
		return closest.rescale(this.magnitude());
	}
	/**
	 * returns a unit vector in the specified direction
	 * @return
	 */
	public static Vector getNorth(){
		return new Vector(0, -1);
	}
	/**
	 * returns a unit vector in the specified direction
	 * @return
	 */
	public static Vector getSouth(){
		return new Vector(0, 1);
	}
	/**
	 * returns a unit vector in the specified direction
	 * @return
	 */
	public static Vector getEast(){
		return new Vector(1, 0);
	}
	/**
	 * returns a unit vector in the specified direction
	 * @return
	 */
	public static Vector getWest(){
		return new Vector(-1, 0);
	}

	public double getAngle(){
		double degrees = Math.toDegrees(Math.atan2(deltaY, deltaX));
		return degrees + 90;

	}

	public static Vector getUnitVector(int angle){
		return new Vector(Math.cos(Math.toRadians(angle - 90)), Math.sin(Math.toRadians(angle - 90)));
	}

}
