package chords.gui;

import java.awt.Color;

import sedgewick.StdDraw;

/**
 * A 2-D GUI for controlling applications based on the current mouse location.
 * @author cytron
 *
 */
public class TwoDimensionalGUI {

	private final double minx, maxx, miny, maxy;
	private final String xAxis, yAxis;
	private boolean showLabels;

	/**
	 * Construct this 2-D GUI
	 * @param minx the minimum value for the x axis
	 * @param maxx the maximum value for the x axis
	 * @param miny the minimum value for the y axis
	 * @param maxy the maximum value for the y axis
	 * @param xAxis the label (String) for the x axis
	 * @param yAxis the label (String) for the y axis
	 */
	public TwoDimensionalGUI(double minx, double maxx, double miny,
			double maxy, String xAxis, String yAxis) {
		this.minx = minx;
		this.maxx = maxx;
		this.miny = miny;
		this.maxy = maxy;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.showLabels = true;
		StdDraw.setXscale(minx, maxx);
		StdDraw.setYscale(miny, maxy);
	}

	/**
	 * Should we show the labels on the axes?
	 * @param val yes or no
	 */
	public void setShowLabels(boolean val) {
		this.showLabels = val;
	}

	/**
	 * Local method to compute percentages of current values
	 *   based on min and max allowed values.
	 * @param min smallest allowable value for val
	 * @param max largest allowable value for val
	 * @param val the actual val
	 * @return the percentage of val in the allowable range [min,max]
	 */
	private static int pctg(double min, double max, double val) {
		double range = max - min;
		return (int)Math.round((val-min)*100/range);
	}

	/**
	 * A la Sedgewick, this updates the screen based on the current
	 *    mouse position.
	 * To allow for other similar methods to modify the screen, this 
	 *   method simply draws on the screen as-is.
	 *   Any clearing of the screen prior to drawing, or pausing afterwards,
	 *   is the responsibility of the caller of this method.
	 * @return the current mouse location
	 */
	public SWPoint update() {
		double x = StdDraw.mouseX();
		double y = StdDraw.mouseY();
		//
		// Do not let x or y go outside their limits
		//
		x = Math.min(Math.max(minx, x), maxx);
		y = Math.min(Math.max(miny, y), maxy);
		if (showLabels) {
			//
			// Label the axes
			//
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.textLeft(minx,  maxy, yAxis + " " + pctg(miny,maxy,y) + "%");
			StdDraw.textRight(maxx, miny, xAxis + " " + pctg(minx,maxx,x) + "%");
		}
		return new SWPoint(x, y);
	}


}
