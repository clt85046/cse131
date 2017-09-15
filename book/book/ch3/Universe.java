package book.ch3;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;
import sedgewick.StdIn;

/*************************************************************************
 *  Compilation:  javac Universe.java
 *  Execution:    java Universe dt < input.txt
 *  Dependencies: Body.java Vector.java StdIn.java StdDraw.java
 *  Datafiles:    http://www.cs.princeton.edu/introcs/34nbody/2body.txt
 *                http://www.cs.princeton.edu/introcs/34nbody/3body.txt
 *                http://www.cs.princeton.edu/introcs/34nbody/4body.txt
 *                http://www.cs.princeton.edu/introcs/34nbody/2bodyTiny.txt
 *
 *  This data-driven program simulates motion in the universe defined
 *  by the standard input stream, increasing time at the rate on the
 *  command line.
 *
 *  %  java Universe 25000 < 4body.txt
 *
 *
 *************************************************************************/

public class Universe {
    private final double radius;     // radius of universe
    private final int N;             // number of bodies
    private final Body[] orbs;       // array of N bodies

    // read universe from standard input
    public Universe() {
    	
 
        // number of bodies
        N = StdIn.readInt(); 

        // the set scale for drawing on screen
        radius = StdIn.readDouble(); 
        StdDraw.setXscale(-radius, +radius); 
        StdDraw.setYscale(-radius, +radius); 

        // read in the N bodies
        orbs = new Body[N]; 
        for (int i = 0; i < N; i++) { 
            double rx   = StdIn.readDouble(); 
            double ry   = StdIn.readDouble(); 
            double vx   = StdIn.readDouble(); 
            double vy   = StdIn.readDouble(); 
            double mass = StdIn.readDouble(); 
            double[] position = { rx, ry }; 
            double[] velocity = { vx, vy }; 
            Flugzeugspur r = new Flugzeugspur(position); 
            Flugzeugspur v = new Flugzeugspur(velocity); 
            orbs[i] = new Body(r, v, mass); 
        } 
    } 

    // increment time by dt units, assume forces are constant in given interval
    public void increaseTime(double dt) {

        // initialize the forces to zero
        Flugzeugspur[] f = new Flugzeugspur[N];
        for (int i = 0; i < N; i++) {
            f[i] = new Flugzeugspur(new double[2]);
        }

        // compute the forces
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    f[i] = f[i].plus(orbs[i].forceFrom(orbs[j]));
                }
            }
        }

        // move the bodies
        for (int i = 0; i < N; i++) {
            orbs[i].move(f[i], dt);
        }
    }

    // draw the N bodies
    public void draw() {
        for (int i = 0; i < N; i++) {
            orbs[i].draw();
        }
    } 


    // client to simulate a universe
    public static void main(String[] args) {
    	ArgsProcessor ap = new ArgsProcessor(args);
    	double dt = ap.nextDouble("Increment time by ____ dt units:");
    	ArgsProcessor.useStdInput("datafiles/universe");
        Universe newton = new Universe();
        while (true) {
            StdDraw.clear(); 
            newton.increaseTime(dt); 
            newton.draw(); 
            StdDraw.show(10); 
        } 
    } 
}
