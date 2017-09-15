package chords.gui;

/**
 * A bounding box with a method to test containment of a Point.
 * @author cytron
 *
 */
public class BoundingBox {
	
	private final SWPoint ll, ur;
	
	/**
	 * A box specified by its lower-left and upper-right corners
	 * @param ll this box's lower-left corner
	 * @param ur this box's upper-right corner
	 */
	public BoundingBox(SWPoint ll, SWPoint ur) {
		this.ll = ll;
		this.ur = ur;
	}

	public SWPoint getLl() {
		return ll;
	}

	public SWPoint getUr() {
		return ur;
	}
	
	/**
	 * Is the specified point inside this bounding box?
	 * @param p the point of interest
	 * @return true iff the specified point is inside this bounding box
	 */
	public boolean inside(SWPoint p) {
		return 
				ll.getX() <= p.getX() 
				&& p.getX() <= ur.getX() 
				&& ll.getY() <= p.getY()
				&& p.getY() <= ur.getY();
	}

}
