package book.ch3;

import cse131.ArgsProcessor;
import book.ch2.Bernoulli;
import sedgewick.StdDraw;
import sedgewick.StdStats;

/*************************************************************************
 *  Compilation:  javac Histogram.java
 *
 *  This data type supports simple client code to create dynamic
 *  histograms of the frequency of occurrence of values in [0, N).
 *  The frequencies are kept in an instance-variable array, and
 *  an instance variable max tracks the maximum frequency (for scaling).
 *
 *  % java Histogram 50 1000000 
 *
 *************************************************************************/

public class Histogram {
    private final double[] freq;   // freq[i] = # occurences of value i
    private double max;            // max frequency of any value

    // Create a new histogram. 
    public Histogram(int N) {
        freq = new double[N];
    }

    // Add one occurrence of the value i. 
    public void addDataPoint(int i) {
        freq[i]++; 
        if (freq[i] > max) max = freq[i]; 
    } 

    // draw (and scale) the histogram.
    public void draw() {
        StdDraw.setYscale(0, max);
        StdStats.plotBars(freq);
    }
 
    // See Program 2.2.6.
    public static void main(String[] args) {
    	ArgsProcessor ap = new ArgsProcessor(args);
        int N = ap.nextInt("Number of coins:");   // number of coins
        int T = ap.nextInt("Number of trials:");   // number of trials

        // create the histogram
        Histogram histogram = new Histogram(N+1); 
        for (int t = 0; t < T; t++) {
            histogram.addDataPoint(Bernoulli.binomial(N));
        }

        // display using standard draw
        StdDraw.setCanvasSize(500, 100);
        histogram.draw();
    } 
} 
