package chords.gui;

import java.awt.Color;

import sedgewick.StdDraw;

public class TwoDimesionalGUIExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwoDimensionalGUI sizeAndShade = new TwoDimensionalGUI(0, 1, 0, 1, "size", "shade");
		while (true) {
			StdDraw.clear();
			//
			// Draw our own background in yellow so
			//   that even a white circle will show up
			//
			StdDraw.setPenColor(Color.YELLOW);
			StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);

			SWPoint xy = sizeAndShade.update();
			//
			// Compute the radius of our circle
			//
			double size = xy.getX()/2;
			//
			// Compute the intensity of the shade
			//
			int shade = (int) (xy.getY()*255);
			//
			// Draw the specified circle
			//
			StdDraw.setPenColor(new Color(shade, shade, shade));
			StdDraw.filledCircle(0.5, 0.5, size);
			
			StdDraw.show(100);
		}
	}

}
