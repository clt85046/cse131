package book.ch1;
import cse131.ArgsProcessor;
import sedgewick.*;
/*************************************************************************
 *  Compilation:  javac TwentyQuestions.java
 *  Execution:    java TwentyQuestions
 *  Dependencies  StdIn.java
 *
 *  % java TwentyQuestions 
 *  I'm thinking of a number between 1 and 1,000,000 
 *  What's your guess? 500000 
 *  Too high 
 *  What's your guess? 250000 
 *  Too low 
 *  What's your guess? 375000 
 *  Too high 
 *  What's your guess? 312500 
 *  Too high 
 *  What's your guess? 300500 
 *  Too low 
 *  ... 
 *
 *************************************************************************/

public class TwentyQuestions {

    public static void main(String[] args) {

        // Generate a number and answer questions
        // while the user tries to guess the value.
        int N = 1 + (int) (Math.random() * 1000000);

        ArgsProcessor ap = new ArgsProcessor(args);
        StdOut.print("I'm thinking of a number ");
        StdOut.println("between 1 and 1,000,000");
        int m = 0; 
        while (m != N) {

            // Solicit one guess and provide one answer
            m = ap.nextInt("What is your guess?"); 
            if (m == N) StdOut.println("You win!");
            if (m < N)  StdOut.println("Too low ");
            if (m > N)  StdOut.println("Too high");
        }
    }
} 
