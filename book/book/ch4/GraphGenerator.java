package book.ch4;

import cse131.ArgsProcessor;
import sedgewick.In;
import sedgewick.StdOut;

/*************************************************************************
 *  Compilation:  javac GraphGenerator.java
 *  Dependencies: Graph.java
 *
 *************************************************************************/

public class GraphGenerator {

    public static Graph read(In in, String delimiter) {
        Graph G = new Graph();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            String movie = names[0];
            for (int i = 1; i < names.length; i++) {
                G.addEdge(movie, names[i]);
            }
        }
        return G;
    }

    public static void main(String[] args) {
    	ArgsProcessor ap = new ArgsProcessor(args);
        In in = new In(ArgsProcessor.chooseFile("datafiles/textfiles"));
        String delimiter = ap.nextString("Enter delimiter");
        Graph G = GraphGenerator.read(in, delimiter);
        StdOut.println(G);
    }

}