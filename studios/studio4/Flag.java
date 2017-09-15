package studio4;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class Flag {

	
	public static void main(String[] args) {
		//
		//  Add code for your studio below here.
		//

		try {
			System.setIn(new FileInputStream("music/Ascale.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ArgsProcessor.useStdInput("music");
		StdDraw.setPenColor(Color.red);
		StdDraw.filledRectangle(0.5, 0.5, 0.6, 0.35);
		StdDraw.setPenColor(Color.yellow);
		double[] x = {0.05,0.20,0.08,0.125,0.17};
		double[] y = {0.70,0.70,0.61,0.75,0.61};
		StdDraw.filledPolygon(x, y);
		StdDraw.filledCircle(0.31,0.7, 0.02);
		StdDraw.filledCircle(0.28,0.78, 0.02);
		StdDraw.filledCircle(0.31,0.62, 0.02);
		StdDraw.filledCircle(0.28,0.54, 0.02);
		StdDraw.setPenColor();
		StdDraw.setPenRadius(0.03);
		StdDraw.rectangle(0.5, 0.5, 0.55, 0.36);
		//StdDraw.setFont(32);
		StdDraw.text(0.5, 0.75, "China!");
		double m = 0.05;
		double n = 0.8;
		while (m<=1&&n>=0)
		{
			StdDraw.text(m,n, "China!");
			m = m+0.1;
			n= n -0.06;
			StdDraw.show(200);
		}
		
		  //System.out.println("repeat ");
	      while (!StdIn.isEmpty()) {

	            // read in the pitch, where 0 = Concert A (A4)
	            int pitch = StdIn.readInt();
	            
	            // read in duration in seconds
	            double duration = StdIn.readDouble();
	            //System.out.println("duration ");
	            //System.out.println("pitch "+pitch);
	            // build sine wave with desired frequency
	            double hz = 440 * Math.pow(2, pitch / 12.0);
	            int N = (int) (StdAudio.SAMPLE_RATE * duration);
	            double[] a = new double[N+1];
	            for (int i = 0; i <= N; i++) {
	                a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);  
	            }
	            	
	            // play it using standard audio
	            StdAudio.play(a);
	            
	   		
	        }
		//StdDraw.text(0.5, 0.75, "China!");
	
	}

}
