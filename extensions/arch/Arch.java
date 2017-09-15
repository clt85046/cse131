package arch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

import lab0.Vector;


import sedgewick.StdDraw;

/**
 * Models an arch using masses and springs.
 * 
 */
public class Arch implements ActionListener {

	final private int CANVAS_WIDTH = 512;
	final private int CANVAS_HEIGHT = 512;
	final private int TOTAL_MASS = 50;     // combined mass of the rectangles
	final private Timer timer;

	public Arch(int numMasses) {
		// initiate Sedgewick StdDraw
		StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		StdDraw.setXscale(0, CANVAS_WIDTH);
		StdDraw.setYscale(0, CANVAS_HEIGHT);

		timer = new Timer(20, this);
		
        /**
         * Below, set up the simulation by depositing the specified
         * number of masses onto the panel, with springs
         * between each adjacent pair of masses.
         */

		// FIXME
	}

	/**
	 * Run one round of the simulation.
	 * Between the FIXME lines below, place your code which should
	 * 1) Compute for each mass (but don't apply) the force that the mass
	 *    experiences
	 * 2) Then for each mass, apply the force over a period of time of your choice
	 *    This will cause the mass to experience acceleration, which will cause it
	 *     to move.
	 * 3) When the masses have all moved, relocate the springs so that they connect
	 *     the masses as they should.
	 */
	public void round() {
		StdDraw.show(0);
		StdDraw.clear();

		// FIXME -- your code goes below here
		
		
		// FIXME -- your code goes above here
		StdDraw.show(0);
	}
	
	/**
	 * Start the swing timer
	 */
	public void run() {
		timer.start();
	}

	/**
	 * Stop the swing timer
	 */
	public void stop() {
		timer.stop();
	}
	
	/**
	 * Each clock tick, perform one round of the
	 * simulation.
	 */
	public void actionPerformed(ActionEvent e) {
		round();
	}
}
