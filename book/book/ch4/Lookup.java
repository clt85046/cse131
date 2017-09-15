package book.ch4;

import java.io.ByteArrayInputStream;

import cse131.ArgsProcessor;
import sedgewick.In;
import sedgewick.StdIn;
import sedgewick.StdOut;
import sedgewick.StdRandom;

/*************************************************************************
 *  Compilation:  javac Lookup.java
 *  Execution:    java Lookup file.csv keyField valField
 *  Dependencies: BST.java In.java StdIn.java
 *  Data files:   http://www.cs.princeton.edu/introcs/44st/amino.csv
 *                http://www.cs.princeton.edu/introcs/44st/ip.csv
 *                http://www.cs.princeton.edu/introcs/44st/DJIA.csv
 *  
 *  Reads in a set of key-value pairs from a two-column CSV file
 *  specified on the command line; then, reads in keys from standard
 *  input and prints out corresponding values.
 * 
 *  % java Lookup amino.csv 0 3      % java Lookup ip.csv 0 1 
 *  TTA                              www.google.com 
 *  Leucine                          216.239.41.99 
 *  ABC                               
 *  Not found                        % java Lookup ip.csv 1 0 
 *  TCT                              216.239.41.99 
 *  Serine                           www.google.com 
 *                                 
 *  % java Lookup amino.csv 3 0      java Lookup DJIA.csv 0 1 
 *  Glycine                          29-Oct-29 
 *  GGG                              252.38 
 *                                   20-Oct-87 
 *                                   1738.74
 *
 *************************************************************************/

public class Lookup {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		In in = new In(ArgsProcessor.chooseFile("datafiles/lookup"));
		int keyField = ap.nextInt("Key field (an integer):");
		int valField = ap.nextInt("Value field (an integer):");
		String[] database = in.readAll().split("\n");
		StdRandom.shuffle(database);
		BST<String, String> st = new BST<String, String>();
		for (int i = 0; i < database.length; i++) {
			String[] tokens = database[i].split(",");
			String key = tokens[keyField];
			String val = tokens[valField];
			st.put(key, val);
		}
		
		
		System.setIn(new ByteArrayInputStream(ap.nextString("Enter keywords for search, separated by spaces:").getBytes()));
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (st.contains(s)) StdOut.println(st.get(s));
			else                StdOut.println("Not found");
		}
	}
}
