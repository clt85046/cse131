package exercises4;

import sedgewick.StdIn;
import cse131.ArgsProcessor;

public class Stats {

	public static void main(String[] args) {
		// prompt the user for the file to be used for this run
		ArgsProcessor.useStdInput("datafiles/average");
        double sum = 0;
        int count = 0;
        double d;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        while(!StdIn.isEmpty())
        {
        	d = StdIn.readDouble();
        	System.out.println(d);
        	if(d>max)
        	{
        		max = d;
        	}
        	if(d < min)
        	{
        		min = d;
        	}
        	sum = sum + d;
        	count = count + 1;
        }
        double average = sum/count;
        System.out.println("sum is "+sum+'\n'+"count is "+count+'\n'+"average is "+average+'\n'+"max is "+max+'\n'+"min is "+min);
		//
		//  Read in the data from the opened file, computing the
		//     sum, average, count, max, and min
		//  of the data
		//
		//  count is the number of doubles read from the file
		//  The other statistics should be clear from their names
		//

	}

}
