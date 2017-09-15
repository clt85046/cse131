package chords.music;

import sedgewick.StdAudio;

/**
 * Represent a double[] samples array.
 * A Samples object has-a double[] array of samples, which it hides and does not expose except through
 *    the methods defined below.
 * @author roncytron
 *
 */

public class Samples {
	
	
	/**
	 * Capture the specified samples in our local array, so that they are safe from modification
	 * @param samples
	 */
	public Samples(double[] samples) {
	}
	
	/**
	 * Construct samples of the specified length, all zero.
	 * @param length
	 */
	public Samples(int length) {
	}
	
	/**
	 * Concatenate this and the other sample, returning a NEW samples object, and leaving the two inputs unchanged
	 * @param other
	 * @return the concatenation of these samples with the other samples
	 */
	public Samples concat(Samples other) {
		return null; // FIXME
	}
	
	/**
	 * Combine this and the other samples, padding by 0 if necessary, returning a NEW samples object, and leaving the two inputs unchanged
	 * @param other
	 * @return the numerical addition of these and the other samples, padded by 0 where necessary
	 */
	public Samples combine(Samples other) {
		return null;  // FIXME
	}
	
	/**
	 * 
	 * @return the number of samples
	 */
	
	public int getNumSamples() {
		return 0; // FIXME
	}
	
	/**
	 * Play these samples, by calling StdAudio.play(..) passing in the double array of samples
	 */
	public void play() {
		// FIXME
	}
	
	public String toString() {
		return "Samples with " + this.getNumSamples() + " values";
	}

	/**
	 * Accessor to return a particular sample
	 * @param i the sample to be returned, with 0 as the first sample
	 * @return the specified sample value
	 */
	public double getSample(int i) {
		return 0.0;  // FIXME
	}
	
	/**
	 * Valid only for a positive number of samples, this method returns the maximum value of all samples
	 * @return the maximum value
	 */
	public double getMax() {
		return 0.0;  // FIXME
	}
	
	/**
	 * Valid only for a positive number of samples, this method returns the minimum value of all samples
	 * @return the minimum value
	 */
	public double getMin() {
		return 0.0;  // FIXME
	}

}
