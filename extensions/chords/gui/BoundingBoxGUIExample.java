package chords.gui;

import java.awt.Color;

import sedgewick.StdDraw;

public class BoundingBoxGUIExample {

	public static void main(String[] args) {
		final double width =  .20;  // Entire width of rectangle
		final double height = .10;  // Entire height of rectangle
		double xLoc = 0.5;          // Sedgewick x coordinate of center of rectangle
		double yLoc = 0.5;          // Sedgewick y coordinate of center of rectangle
		
		Color rectColor = null;
		int iters=0;

		//
		// Infinite Sedgewick event loop
		//
		while (true) {
			//
			// Clear the Sedgewick panel
			//
			StdDraw.clear();
			//
			// Keep track of the number of iterations we have performed
			//
			iters = iters + 1;
			
			//
			// A Bounding box that represents the rectangle we will draw
			// These are constructed from the lower-left and upper-right corners
			//
			SWPoint ll = new SWPoint(xLoc-width/2, yLoc-height/2);
			SWPoint ur = new SWPoint(xLoc+width/2, yLoc+height/2);
			BoundingBox bb = new BoundingBox(ll, ur);
			
			//
			// Where is the mouse?
			//
			double xmouse = StdDraw.mouseX();
			double ymouse = StdDraw.mouseY();
			
			//
			// Is the mouse currently inside the rectangle?
			//
			if (bb.inside(new SWPoint(xmouse, ymouse))) {
				//
				// Yes choose red for the rectangle's color
				//
				rectColor = Color.RED;
			}
			else {
				//
				// No, choose blue
				//
				rectColor = Color.BLUE;
			}
			
			//
			// Draw the rectangle in its current color
			//
			StdDraw.setPenColor(rectColor);
			StdDraw.filledRectangle(xLoc, yLoc, width/2, height/2);
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(xLoc, yLoc, "Tickle Me");
			//
			// Every 20 iterations change the location
			//    Because each iteration pauses a 1/10 of a second,
			//    the location will change every 2 seconds
			//
			if (iters % 20 == 0) {
				xLoc = Math.random();
				yLoc = Math.random();
			}		
			//
			// Pause for 100 ms ==  1/10 of a second
			//   All Sedgewick event loops should pause for some time!
			//
			StdDraw.show(100);
		}

	}

}
