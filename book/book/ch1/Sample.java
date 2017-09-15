package book.ch1;
import cse131.ArgsProcessor;
/*************************************************************************
 *  Compilation:  javac Sample.java
 *  Execution:    java Sample M N
 *
 *  This program takes two command-line arguments M and N and produces
 *  a random sample of M of the integers from 0 to N-1.
 *
 *  % java Sample 6 49
 *  10 20 0 46 40 6
 *
 *  % java Sample 10 1000
 *  656 488 298 534 811 97 813 156 424 109
 *
 *************************************************************************/

public class Sample {
    public static void main(String[] args) {
    	ArgsProcessor ap = new ArgsProcessor(args);
        int M = ap.nextInt("Choose this many elements");    		// choose this many elements
        int N = ap.nextInt("From 0...N-1, for what value of N?") ;   // from 0, 1, ..., N-1

        // create permutation 0, 1, ..., N-1
        int[] sample = new int[M];
        for (int i = 0; i < sample.length; i++) {
            sample[i] = (int)(N*Math.random());
        }


        // print results
        for (int i = 0; i < M; i++)
            System.out.print(sample[i] + " ");
        System.out.println();
    }
}
