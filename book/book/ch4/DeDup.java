package book.ch4;

import cse131.ArgsProcessor;
import sedgewick.StdIn;
import sedgewick.StdOut;

/*************************************************************************
 *  Compilation:  javac DeDup.java
 *  Execution:    java DeDup < words.txt
 *  Dependencies: SET.java StdIn.java
 *
 *  Read in a list of words from standard input and print out
 *  each word, removing any duplicates.
 *
 *************************************************************************/

public class DeDup {  
    public static void main(String[] args) {
    	ArgsProcessor.useStdInput("datafiles/textfiles");
        SET<String> distinct = new SET<String>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!distinct.contains(key)) {
                distinct.add(key);
                StdOut.println(key);
            }
        }
    }
}
