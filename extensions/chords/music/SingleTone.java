package chords.music;

import sedgewick.StdAudio;

/**
 * Wraps a frequency so we can get its samples at a given amplitude and duration.
 * @author roncytron
 *
 */
public class SingleTone {
	
	private double frequency;

	public SingleTone(double frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * Generate the sine wave corresponding to this frequency, at the specified amplitude and for the specified duration
	 * @param amplitude How loud should this wave be?
	 * @param duration How long should this wave last (in seconds)?
	 * @return the Samples corresponding to the desired sine wave
	 */
	public Samples getSamples(double amplitude, double duration) {
		return null;  // FIXME
	}
	
	/**
	 * Compute the specified rational overtone of this frequency
	 * @param numerator top of the fraction
	 * @param denominator bottom of the fraction
	 * @return a SingleTone with this frequency multiplied by the specified fraction
	 */
	public SingleTone getOvertone(int numerator, int denominator) {
		return getOvertone(1.0 * numerator / denominator);
	}

	/**
	 * Compute the specified overtone of this frequency
	 * @param mpy the factor by which to multiply this frequency
	 * @return a SingleTone with this frequency multiplied by the specified factor
	 */
	public SingleTone getOvertone(double mpy) {
		return null;  // FIXME
	}
	
	/**
	 * Accessor to return the frequency of this tone
	 * @return the frequency in Hz of this tone
	 */
	public double getFrequency() {
		return this.frequency;
	}

}
