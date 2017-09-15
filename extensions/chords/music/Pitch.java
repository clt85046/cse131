package chords.music;


/**
 * This class wraps a Sedgewick pitch.  Of particular interest is its
 * frequency
 * @author roncytron
 *
 */
public class Pitch {
	
	private final int p;
	
	/**
	 * Following Sedgewick, pitches are constructed based on their chromatic
	 *   distance from concert A (the A above middle C on a piano)
	 * @param p
	 */
	public Pitch(int p) {
		this.p = p;
	}
	
	/**
	 * Return the pitch that is diff away from this pitch, chromatically.
	 * For example, if this pitch is a C natural, then getChromaticRelative(1) returns
	 *    the pitch corresponding to a C sharp
	 * @param diff the chromatic difference from this pitch, could be positive, negative, or zero
	 * @return the pitch that is diff away from this pitch
	 */
	public Pitch getChromaticRelative(int diff) {
		return new Pitch(p+diff);
	}
	
	/**
	 * Uses equal temperament so that a Sedgewich pitch of integer value p has
	 *   frequency  440 * Math.pow(2, p/12.0)
	 * @return the equal temperament frequency of this pitch
	 */
	public double getHertz() {
		return 440 * Math.pow(2, p/12.0);
	}
		
	public String toString() {
		return "Pitch " + p + " (" + Math.round(getHertz()) + " Hz)";
	}

}
