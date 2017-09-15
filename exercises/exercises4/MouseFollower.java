package exercises4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("how much histroy ?");
		double[] histx = new double[N];
		double[] histy = new double[N];
		int cur = 0;
		while (true) {
			StdDraw.clear();
			//
			// Render one frame of your animation below here
			//  
			 	StdDraw.setPenColor(Color.cyan);
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				histx[cur]=x;
				histy[cur]=y;
				cur = cur +1;
				if (cur >= histx.length)
				{
					cur = 0; 
				}
				int oldest = cur;
			    StdDraw.filledCircle(histx[oldest], histy[oldest], 0.1);
			//  
			// End of your frame
			//
			// Stdraw.show(..) achieves double buffering and
			//   avoids the tight spinning loop
			StdDraw.show(200);
		}

	}

}
