package chords.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import sedgewick.StdAudio;
import chords.music.Samples;
import chords.music.SingleTone;

public class SingleToneTest {
	
	private void verifyMin(double m, Samples samples) {
		for (int i=0; i < samples.getNumSamples(); ++i) {
			if (samples.getSample(i) < m) {
				fail("Sample " + i + " was less than " + m + " but shouldn't have been");
			}
		}
	}

	private void verifyMax(double m, Samples samples) {
		for (int i=0; i < samples.getNumSamples(); ++i) {
			if (samples.getSample(i) > m) {
				fail("Sample " + i + " was greater than " + m + " but shouldn't have been");
			}
		}
	}

	@Test
	public void testConstructorAndSamples() {
		SingleTone st = new SingleTone(1);
		Samples samples = st.getSamples(0, 2);
		assertTrue("Wrong number of samples for 2 seconds: " + samples.getNumSamples(), Math.abs(samples.getNumSamples()-2*StdAudio.SAMPLE_RATE) < 5);
		verifyMin(0.0, samples);
		verifyMax(0.0, samples);
	}
	
	
	@Test
	public void testOvertones() {
		SingleTone st = new SingleTone(440).getOvertone(1, 2);
		assertTrue("Make sure you use double arithmetic for the fraction", st.getSamples(1, 1).getMax() > 0);
		assertTrue("Make sure you use double arithmetic for the fraction", st.getSamples(1, 1).getMin() < 0);
	}

}
