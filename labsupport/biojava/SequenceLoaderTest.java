package biojava;

import static org.junit.Assert.*;

import java.io.File;

import org.biojava3.core.sequence.ProteinSequence;
import org.junit.Test;

public class SequenceLoaderTest {

	@Test
	public void test() {
		SequenceLoader loader = new SequenceLoader();
		File file = new File("genomes/Test.fasta");
		
		assertEquals("CAGTGGCTGN", loader.loadProteinSequence(file).toString());
	}

}
