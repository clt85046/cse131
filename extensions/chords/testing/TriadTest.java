package chords.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import chords.music.DiatonicScale;
import chords.music.Samples;
import chords.music.SingleTone;
import chords.music.Triad;

public class TriadTest {

	@Test
	public void test() {
		for (int i=0; i < 12; ++i) {
			DiatonicScale ds = new DiatonicScale(i);
			Triad t = new Triad(ds, 0);
			SingleTone[] tones = t.getTones();
			double[] freqs = { tones[0].getFrequency(), tones[1].getFrequency(), tones[2].getFrequency() };
			assertEquals("Middle note of triad not right", freqs[1]/freqs[0], Math.pow(2, 4.0/12.0), .01);
			assertEquals("Top note of traid not right", freqs[2]/freqs[0], Math.pow(2, 7.0/12.0), .01);
		}
	}

	@Test
	public void testAmplitude() {
		DiatonicScale ds = new DiatonicScale(0);
		Triad t = new Triad(ds, 0);
		for (int i=0; i < 100; ++i) {
			double amp = Math.random();
			Samples samples = t.getSamples(amp, 1);
			assertTrue("You must scale the triad's tones to have the desired amptlude", samples.getMax() <= amp);
			assertTrue("You must scale the triad's tones to have the specified amptlude", samples.getMin() >= -amp);
		}
	}

}
