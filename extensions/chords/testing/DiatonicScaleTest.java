package chords.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import chords.music.DiatonicScale;

public class DiatonicScaleTest {
	
	private KeyPitch[] allAs = {
			new KeyPitch(0,0),     // A major, A
			new KeyPitch(-2,1),    // G major, A
			new KeyPitch(-4, 2),   // F major, A
			new KeyPitch(-5, 3),   // E major, A
			new KeyPitch(-7, 4),   // D major, A
			new KeyPitch(-9, 5),   // C major, A
			new KeyPitch(-11, 6)   // Bb major, A
	};

	@Test
	public void test() {
		for (KeyPitch kp : allAs) {
			int key = kp.key;
			int pitch = kp.pitch;
			assertEquals("Key "  + key + " and pitch " + pitch + " should be concert A (440Hz)", 
					new DiatonicScale(key).getPitch(pitch).getHertz(), 
					440, 
					.001
					);
			
			int octaveAbovePitch = pitch + 7;
			assertEquals("Key "  + key + " and pitch " + octaveAbovePitch + " should be A above concert A (880 Hz)", 
					new DiatonicScale(key).getPitch(octaveAbovePitch).getHertz(), 
					880, 
					.001
					);
			int octaveBelowPitch = pitch - 7;
			assertEquals("Key "  + key + " and pitch " + octaveBelowPitch + " should be A above concert A (880 Hz)", 
					new DiatonicScale(key).getPitch(octaveBelowPitch).getHertz(), 
					220, 
					.001
					);
		}
	}
	
	private class KeyPitch {
		public final int key, pitch;
		public KeyPitch(int key, int pitch) {
			this.key   = key;
			this.pitch = pitch;
		}
	}

}
