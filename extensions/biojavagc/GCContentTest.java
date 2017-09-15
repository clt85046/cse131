package biojavagc;

import static org.junit.Assert.*;

import org.biojava3.core.sequence.DNASequence;
import org.junit.Test;


public class GCContentTest {

	@Test
	public void test() {
		convertAndTest((1.0/3.0)*100, "ATC");
		convertAndTest((0.0), "ATTAATTTATAT");
		convertAndTest(100.0, "CCCCCCCCCC");
		convertAndTest(100.0, "GGGGGGGGGG");
		convertAndTest(50.0, "AGAGAGAGAG");
		convertAndTest(0.0, "");
	}
	
	private void convertAndTest(double expectedAnswer, String sequence) {
		sequence = sequence.toUpperCase();
		assertEquals(expectedAnswer, GCContent.percentGC(new DNASequence(sequence).getSequenceAsString().toCharArray()), .01);
	}

}
