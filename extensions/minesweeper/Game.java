package lab3;

import java.io.PrintStream;

import lab3.viz.Controller;
import lab3.viz.StreamToBoardAdapter;

import cse131.ArgsProcessor;
import cse131.CaptureOutput;

public class Game {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);

		final int cols = ap.nextInt("How many columns?");
		final int rows = ap.nextInt("How many rows?");
		final double percent = ap.nextDouble("What is the probability of a bomb?");

		//
		// Run the student's game, capturing the output to create the game board
		//
		CaptureOutput co = new CaptureOutput(
				new Runnable() {

					@Override
					public void run() {
						String[] a = {"" + cols,"" + rows, "" + percent};
						MineSweeper.main(a);
					}

				}
		);
		co.run();
		byte[] output = co.getBytes();
		
		//
		// Here is what the student's code printed
		//
		System.out.println("Output from student's code:");
		System.out.println("---------------------------------------");
		System.out.println(new String(output));
		System.out.println("---------------------------------------");
		
		
		StreamToBoardAdapter myStream = new StreamToBoardAdapter(new String(output), cols, rows);
		Model model = new Model(myStream.getBoard());
		System.out.println("\nGame will be played based on this board:");
		model.print(true);
		Controller game = new Controller(model);
		game.run();
	}

}
