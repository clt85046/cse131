package chords.testing;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import chords.gui.SWPoint;
import chords.gui.TwoDimensionalGUI;
import chords.music.Pitch;
import chords.music.SingleTone;
import sedgewick.StdDraw;
import sedgewick.StdIn;
import cse131.ArgsProcessor;

/**
 * Play a specified song (chosen by user input) over and over and over and.....
 * @author roncytron
 *
 */
public class PlayTest {

	public static void main(String args[]) {
		ArgsProcessor.useStdInput("music");
		List<PitchDuration> score = new LinkedList<PitchDuration>();

		// repeat as long as there are more integers to read in
		while (!StdIn.isEmpty()) {
			// read in the pitch, where 0 = Concert A (A4)
			int pitch = StdIn.readInt();

			// read in duration in seconds
			double duration = StdIn.readDouble();
			//
			// remember the song in a list for playback
			//
			score.add(new PitchDuration(pitch, duration));
		}
		
		double wholestep = Math.pow(2,2.0/12);
		TwoDimensionalGUI display = new TwoDimensionalGUI(0.5, 2.0, 1/wholestep, wholestep, "Slowness", "Pitch");

		while (true) {
			for (PitchDuration pd : score) {
				StdDraw.clear();
				SWPoint p = display.update();
				//
				// Show the nominal (x,y) value
				//
				StdDraw.setPenColor(Color.GREEN);
				StdDraw.setPenRadius(.015);
				StdDraw.point(1, 1);

				StdDraw.show(10);
				double freq = new Pitch(pd.pitch).getHertz() * p.getY();
				SingleTone tone = new SingleTone(freq);
				tone.getSamples(0.5, pd.duration * p.getX()).play();
			}
		}
		
	}
}

/**
 * Carrier class for a pitch and duration
 * @author roncytron
 *
 */
class PitchDuration {
	public final int pitch;
	public final double duration;

	public PitchDuration(int pitch, double duration) {
		this.pitch = pitch;
		this.duration = duration;
	}
}



