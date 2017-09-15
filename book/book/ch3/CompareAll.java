package book.ch3;


import cse131.ArgsProcessor;
import sedgewick.StdIn;

/*************************************************************************
 *  Compilation:  javac CompareAll.java
 *  Execution:    java CompareAll 5 10000 < docs.txt
 *
 *************************************************************************/

public class CompareAll {
    public static void main(String[] args) {
    	ArgsProcessor ap = new ArgsProcessor(args);
        int k = ap.nextInt("Enter k:");
        int d = ap.nextInt("Enter d:");
        int N = StdIn.readInt();
        Document[] a = new Document[N];

        // read in documents
        for (int i = 0; i < N; i++) {
            a[i] = new Document(StdIn.readString(), k, d);
        }

        // print header
        System.out.print("    ");
        for (int j = 0; j < N; j++) {
            System.out.printf("    %.4s", a[j].name());
        }
        System.out.println();

        // print N-by-N table
        for (int i = 0; i < N; i++) {
            System.out.printf("%.4s", a[i].name());
            for (int j = 0; j < N; j++) {
                System.out.printf("%8.2f", a[i].simTo(a[j]));
            }
            System.out.println();
        }
    }
}
