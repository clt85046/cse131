package book.ch2;

import cse131.ArgsProcessor;
import sedgewick.StdOut;

/*************************************************************************
 *  Compilation:  javac Estimate.java
 *  Execution:    java Estiamte N p trials
 *  Dependencies: Percolation.java StdOut.java
 * 
 *  Repeatedly generated N-by-N boolean matrices, where each site
 *  is true with probability p, and compute the probability that
 *  the system percolates.
 *
 *  % java Estimate 32 .4 10000
 *
 *************************************************************************/


public class Estimate {

    // do M trials and return fraction that percolate
    public static double eval(int N, double p, int M) {
        int count = 0;
        for (int k = 0; k < M; k++) {
            boolean[][] open = Percolation.random(N, p);
            if (Percolation.percolates(open))
                count++;
        }
        return (double) count / M;
    }


    public static void main(String[] args) {
    	ArgsProcessor ap = new ArgsProcessor(args);
        int    N = ap.nextInt("Enter N:");
        double p = ap.nextDouble("Enter P:");
        int    M = ap.nextInt("Enter M:");
        double q = eval(N, p, M);
        StdOut.println(q);
    }
}
