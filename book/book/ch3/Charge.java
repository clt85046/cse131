package book.ch3;

import cse131.ArgsProcessor;
import sedgewick.StdOut;

/*************************************************************************
 *  Compilation:  javac Charge.java
 *  Execution:    java Charge x y
 *
 *************************************************************************/

public class Charge {
    private double rx, ry;   // position
    private double q;        // charge

    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q  = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx*dx + dy*dy);
    }

    public String toString() {
        return q + " at " + "(" + rx + ", " + ry + ")";
    }

    public static void main(String[] args) {
    	ArgsProcessor ap= new ArgsProcessor(args);
        double x = ap.nextDouble("Enter x:");
        double y = ap.nextDouble("Enter y:");
        Charge c1 = new Charge(.51, .63, 21.3);
        Charge c2 = new Charge(.13, .94, 81.9);
        System.out.println(c1);
        System.out.println(c2);
        double v1 = c1.potentialAt(x, y);
        double v2 = c2.potentialAt(x, y);
        StdOut.println(v1+v2);
    }
}

