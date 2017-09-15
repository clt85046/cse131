package biojava;

import java.io.File;
import java.util.LinkedHashMap;

import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.ProteinSequence;
import org.biojava3.core.sequence.compound.*;
import org.biojava3.core.sequence.io.*;

public class SequenceLoader {
	
	public SequenceLoader() {
		
	}
	
	public ProteinSequence loadProteinSequence(File file) {
		try {
			//Method 1
			LinkedHashMap<String, ProteinSequence> proteinProxySequences = FastaReaderHelper.readFastaProteinSequence(file);
			ProteinSequence proteinSequence = proteinProxySequences.get(proteinProxySequences.keySet().toArray()[0]);
			
			/*//Method 2
			FastaReader<ProteinSequence, AminoAcidCompound> fastaProxyReader = new FastaReader<ProteinSequence, AminoAcidCompound>(file, new GenericFastaHeaderParser<ProteinSequence, AminoAcidCompound>(), new FileProxyProteinSequenceCreator(file, AminoAcidCompoundSet.getAminoAcidCompoundSet()));
			LinkedHashMap<String, ProteinSequence> proteinProxySequences = fastaProxyReader.process();			
			*/
			
			return proteinSequence;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public DNASequence loadDNASequence(File file) {
		try {
			//one method for reading from a fasta file.  See GCContent for a second method
			LinkedHashMap<String, DNASequence> dnaProxySequences = FastaReaderHelper.readFastaDNASequence(file);
			DNASequence dnaSequence;
			
			//Loop to get all sequences.  Our Fasta file only contains one sequence
			for(String key : dnaProxySequences.keySet()){
				dnaSequence = dnaProxySequences.get(key);
				return dnaSequence;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

}
