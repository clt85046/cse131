package book.ch1;
import sedgewick.StdIn;
import sedgewick.StdOut;
import cse131.ArgsProcessor;
/*************************************************************************
 *  Compilation:  javac RangeFilter.java
 *  Execution:    java RangeFilter lo hi < input.txt
 *  Dependencies: StdIn.java
 *
 *  Read in a sequence of integers from standard input and print
 *  out those values between lo and hi.
 *
 *************************************************************************/

public class RangeFilter {
    public static void main(String[] args) {

        // read in two command-line arguments
    	ArgsProcessor ap = new ArgsProcessor(args);
        int lo = ap.nextInt("The lowest number");
        int hi = ap.nextInt("The highest number");
        ArgsProcessor.useStdInput("datafiles/range");

        // repeat as long as there's more input to read in
        while (!StdIn.isEmpty()) {

            // read in the next integer
            int t = StdIn.readInt();

            // print out the given integer if it's between lo and hi
            if (t >= lo && t <= hi) {
                StdOut.print(t + " ");
            }
        }
        StdOut.println(); 
    } 
} 
