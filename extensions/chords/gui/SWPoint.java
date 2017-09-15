package chords.gui;

/**
 * Standard representation for an (x,y) pair as a 2-D point used for Sedgewick's StdDraw
 * @author cytron
 *
 */
public class SWPoint {
	
	private double x, y;

	/**
	 * An (x,y) pair in the traditional sense of a point.
	 * @param x
	 * @param y
	 */
	public SWPoint(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
