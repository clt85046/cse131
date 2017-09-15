package biofindframe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Much better tests contributed by Hunter LaTourette
 * TestMiddle still needs to go...
 * @author h.latourette
 *
 */
public class FindTheFrameTest {

	private static String startcodon = "ATG";
	private static String[] stops = { "TAG", "TAA", "TGA" };
	private static Set<String> stopcondons = new HashSet<String>();
	private static String[] alphabet = { "A", "T", "C", "G" };
	private static List<String> allCodonsButStops = new ArrayList<String>(64);

	static {
		for (String stop : stops) {
			stopcondons.add(stop);
		}
		for (String base1 : alphabet) {
			for (String base2 : alphabet) {
				for (String base3 : alphabet) {
					String codon = base1 + base2 + base3;
					if (!stopcondons.contains(codon)) {
						allCodonsButStops.add(codon);
					}
				}
			}
		}
		//		System.out.println("Codons are " + codons);
	}

	/*
	 * Return a random int x  low <= x < high
	 */
	private static int rand(int low, int high) {
		int extent = high - low;
		int r = (int) (Math.random() * extent);
		return low + r;
	}

	private static String genCodons(int length) {
		String ans = "";
		for (int i=0; i < length; ++i) {
			ans = ans + allCodonsButStops.get(rand(0,allCodonsButStops.size()));
		}
		return ans;
	}

	private static String genBases(int length) {
		String ans = "";
		for (int i=0; i < length; ++i) {
			ans = ans + alphabet[rand(0,alphabet.length)];
		}
		return ans;
	}
	
	/**
	 * Generate a string of bases all of the same type (all A, T, C, or G)
	 * @param length
	 * @param base - (0 = A, 1 = T, 2 = C, 3 = g)
	 * @return
	 */
	public static String genConstantBases(int length, int base){
		String ans = "";
		for (int i = 0; i < length; i++){
			ans = ans + alphabet[base];
		}
		return ans;
	}
	
	/**
	 * Generate an encoding of a protein.  We begin with a start codon,
	 *    continue for the specified number of amino acids, and then
	 *    end with a stop codon.  None of the amino acids will be a stop
	 *    codon, but some of them may encode methionine (the start codon)
	 * @param numAA
	 * @return a string with the start and end nicely displayed
	 */
	private static String genEncoding(int numAA) {
		return "   >>>" + startcodon + genCodons(numAA) + stops[rand(0,3)] + "<<<   ";
	}
	
	
	public static String genConstantEncoding(int length, int base){
		return "   >>>" + startcodon + genConstantBases(length*3, base) + stops[rand(0,3)] + "<<<   ";
	}
	
	public static String genConstantEncodingSpecifyStop(int numAA, int stop, int base) {
		return "   >>>" + startcodon + genConstantBases(numAA *3, base) + stops[stop] + "<<<   ";
	}

	
	/**
	 * Assesses whether or not the correct frame has been returned.
	 * If the correct frame has not been reported, it will print the frame in
	 * which the test failed, the DNA strand that it failed on, and a probable
	 * diagnosis for the problem.
	 * @param expected
	 * @param dna
	 * @param message
	 */
	private void expect(int expected, String dna, String message) {
		//
		// the incoming string has spaces and angle brackets to show
		//    the protein
		// we have to remove those to send the string to the student's code
		//
		String supplied = dna.replaceAll("[< >]", "");
		//
		// Run the student's code
		//
		int ans = FindTheFrame.bestReadingFrame(supplied.toCharArray());
		
		//
		// Check the answer, but say something if it's wrong
		//
		
		if (ans != expected) {
			System.out.println("About to fail for DNA (angle brackets show the best frame contents): " + dna);
			System.out.println("Expected " + expected + " but you computed " + ans);
			System.out.println("Diagnosis:  " + message + '\n');
		}
		
		assertEquals(expected, ans);
	}


	/**
	 * Protein occurs within 10 bases of the start of the string
	 * These are easy to see visually, so they are great for debugging your code.
	 */
	@Test
	public void testBeginning() {
		for (int aas=1; aas < 10; ++aas) {
			String encoding = genEncoding(aas);
			for (int j=0; j < 3; ++j) {
				expect(j, genBases(j) + encoding, "Failed to find Start-Stop in reading frame " + j);
			}
		}
	}

	
	/**
	 * These occur within 30 bases of the start, 
	 * and they have random stuff afterwards
	 */
	// @Test
	public void testMiddle() {
		String encoding = genEncoding(100);
		for (int b=1; b < 10; ++b) {
			for (int i=0; i < 3; ++i) {
				expect(i, genBases(3*b) + genBases(i) + encoding + genBases(rand(0,300)), "Failed to find Start-Stop in reading frame " + i);
			}
		}

	}
	
	
	/**
	 * This is the most realistic test.
	 * The encode protein has between 250 and 350 amino acids
	 * Random DNA of perhaps considerable length occurs on either side.
	 */
	@Test
	public void testAnywhere() {
		String encoding = genEncoding(rand(250,350));
		for (int i=0; i < 3; ++i) {
			String s = genBases(3*rand(0,300)) + genBases(i) + genBases(3*rand(0,300)) + encoding + genBases(rand(0,300));
			expect(i, s, "Failed to find Start-Stop in reading frame " + i);
		}

	}
	
	/**
	 * Tests to see if FindTheFrame passes if the DNA sequence is only
	 * made up of a start immediately followed by a stop (i.e. there
	 * are no "middle" codons in the chain).
	 */
	@Test
	public void testEmpty() {
		String encoding = genEncoding(0);
		for (int i=0; i < 3; ++i) {
			expect(i, genBases(i) + encoding, "Failed to find Start-Stop in reading frame " + i);
		}
	}
	
	
	/**
	 * Tests to see if the student's code returns -1 if there are no ideal reading frames (ie there is 
	 * no start-stop sequence present)
	 */
	@Test
	public void testNoStartStop() {
		String encoding = startcodon + genCodons(rand(0,10));
		for (int i = 0; i < 3; i++){
			expect(-1, genBases(i) + encoding, "Failed to not that this sequence contains no valid reading frames");
		}
	}
	
	
	/**
	 * Test to see if the entire array is analyzed.
	 * More specifically, tests to make sure that the students bestReadingFrame() method does not
	 * stop checking after reaching the first stop codon (if that stop codon is not the end of the 
	 * char array).
	 */
	@Test
	public void testPersistence(){
		
		for (int i = 0; i < 3; i++){
			String encoding = genBases(i) + genConstantEncoding(5, 2) + genConstantEncoding(10, 2) + genConstantBases(rand(1,3), rand(0,4)) + genConstantEncoding(7, 2) ; 
			expect(i, encoding , "Your code stops reading the array after it reaches a stop in a reading frame." + '\n' +
								 "            For example, if a frame contains two start-stop sequences, it will only see the first one. This means that if the second sequence is longer, " + '\n' +
								 "            your FindTheFrame code will not see it and will believe the frame does not contain the longer sequence.");
		}
	}
	
	/**
	 * Tests to make sure that if they found a start, they didn't miss a stop.
	 * If they missed a stop, they'll return a frame that is the combination
	 * of two shorter DNA strands, when there is another frame that contains a 
	 * DNA that is longer than those two (separated, not combined).
	 */
	@Test
	public void testNoSkippedStops(){
		
		String encoding = genConstantEncodingSpecifyStop(5, 2, 0) + genConstantEncodingSpecifyStop(3, 1, 0) + "AA" + stops[rand(0,3)] ;
		expect(2, encoding, "Your found a start, but missed a stop");
		
		for(int i = 0; i < 3; i++){
			
		}
		
		//expect( , , "You found a start but missed a stop, and instead saw a sequence that was longer than it actually was");
	}
	
	
	/**
	 * Tests to make sure that all 3 stop codons are recognized.
	 */
	@Test
	public void testStops(){
		for(int j = 0; j < 3; j++){
			for (int i = 0; i < stops.length; i++){
				String encoding = genBases(j) + genConstantEncodingSpecifyStop(rand(0,10), i, 2);
				expect(j , encoding , "Failed to recognize the stop codon " + stops[i]);
			}
		}
	}
	
	
	
	
}
