package studio7;

public class Rectangle {
	/**
	 * 	Instance variables
	 */
	private double length,width;
	/**
	 * constructor
	 * @param length
	 * @param width
	 */
	public Rectangle(double length,double width){
		this.length = length;
		this.width = width;
	}
	
	/**
	 * Accessor
	 * @param length
	 * @param width
	 * @return return the rectangle`s area
	 */
	public static double area(double length,double width){
		double areas = length*width;
		return areas;
	}
	
	/**
	 * Accessor
	 * @param length
	 * @param width
	 * @return return rectangle`s perimeter
	 */
	public static double perimeter(double length,double width){
		return 2*(length+width);
	}
	
	/**
	 * Accessor 
	 * @param length
	 * @param width
	 * @return hether it is in fact a square.
	 */
	public static boolean isSquare(double length,double width){
		return (length==width);
	}
	
	/**
	 * Accessor
	 * @param length2
	 * @param width2
	 * @return whether it is smaller than another
	 */
	public static boolean compare(double length,double width,double length2,double width2){
		return ((length2*width2)>Rectangle.area(length, width));
	}

}
