package chords.music;

public class Triad {
	
	
	/**
	 * Diatonic triad starting at the specified note
	 * @param ds  Scale for the triad
	 * @param root  Starting note of the triad
	 */
	public Triad(DiatonicScale ds, int root) {
		//FIXME
	}
	
	/**
	 * Returns the root, middle, and top note of the triad as an array
	 * @return an array with the root, middle, top notes of this triad
	 */
	public SingleTone[] getTones() {
		return null;  // FIXME
	}
	
	public String toString() {
		return "A triad";  // FIXME with more detail if you like
	}
	
	/**
	 * Return samples of this triad that have the specified amplitude and duration.
	 * @param amplitude the amplitude of the combined samples.  This means the individual tones must be scaled to fit
	 *    within the specified amplitude.
	 * @param duration the length in seconds of the returned samples
	 * @return samples of this triad at the specified amplitude and duration
	 */
	public Samples getSamples(double amplitude, double duration) {
		return null;  // FIXME
	}

}
