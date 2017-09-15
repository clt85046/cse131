package exercises4;

import cse131.ArgsProcessor;

public class Pitches {

	public static void main(String[] args) {
		// encoding has 0 as concert A
		//    1 would be Bb, just above A
		//   -1 would be Ab, just below A
		ArgsProcessor ap = new ArgsProcessor(args);
		int pitch = ap.nextInt("what pitch ? ");
		int pitch1 = ap.nextInt("what pitch1 ? ");
		int pitch2 = ap.nextInt("what pitch2 ? ");
		double freq = 440.0*Math.pow(2, pitch1/12.0);
		double freq2 = 440.0*Math.pow(2,(pitch2)/12.0);
		System.out.println("For pitch "+ pitch1);
		System.out.println("we get frequency "+ freq);
		System.out.println("we get frequency7 "+ freq2);


	}

}
