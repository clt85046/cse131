package book.ch1;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;

public class Sound {
	
	public static void main(String[] args) {
		StdAudio.play(ArgsProcessor.chooseFile("sound").toString());
	}

}
