package chords.testing;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import chords.music.Pitch;

public class PitchTest {
	
	private Random rand = new Random();
	
	private void assertNonZero(double f) {
		assertTrue("Value of pitch frequency should not be zero", f != 0);
	}
	
	@Test
	public void testConcertA() {
		assertEquals("Concert A should be 440 Hz", 440, new Pitch(0).getHertz(), .01);
	}

	@Test
	public void testFreq() {
		for (int i=0; i < 100; ++i) {
			int s1 = rand.nextInt(50)-25;
			int s2 = rand.nextInt(50)-25;
			Pitch p1 = new Pitch(s1);
			Pitch p2 = new Pitch(s2);
			assertNonZero(p1.getHertz());
			assertNonZero(p2.getHertz());
			assertEquals(440 * Math.pow(2, s1/12.0), p1.getHertz(),.01);
			assertEquals(440 * Math.pow(2, s2/12.0), p2.getHertz(),.01);
			assertEquals("Chromatic pitch relative did not work!", p2.getHertz(), p1.getChromaticRelative(s2-s1).getHertz(), .01);
		}
	}

}
