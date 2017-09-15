package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class GraphicsDemo {

	public static void main(String[] args) {
		// blue point (look carefully, will be very small on your screen)
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.point(0.5, 0.5);
		
		// larger green point
		StdDraw.setPenColor(Color.green);
		StdDraw.setPenRadius(.05);
		//StdDraw.point(0.25, 0.5);
		// unfilled red triangle
		StdDraw.setPenRadius();
		StdDraw.setPenColor(Color.red);
		//StdDraw.line(0,0,0,1);
		//StdDraw.line(0,0,1,1);
		//StdDraw.line(0,1,1,1);
		double[] a = {0,0,0.5,0.5};
		double[] b = {0.5,1,1,0.5};
		
		// yellow circle, filled
		StdDraw.setPenColor(Color.yellow);
        //StdDraw.filledCircle(0.25, 0.5, 0.1);
		// filled blue rectangle
        StdDraw.filledPolygon(a,b);
        StdDraw.filledRectangle(0.5, 0.5, 0.2, 0.1);
        
		


	}

}
