package biofindframe;

import java.io.File;

import org.biojava3.core.sequence.DNASequence;

import biojava.SequenceLoader;
import cse131.ArgsProcessor;

public class FindTheFrame {
	
	//
	// Do not change any code from here....
	//

	public static void main(String[] args) {
		File file = ArgsProcessor.chooseFile("genomes");
		System.out.println("For " + file + ", best reading frame is " + runsolution(file));
	}
	
	public static int runsolution(File file) {
		//
		// Load the sequence into a DNASequence object
		//
		SequenceLoader sequenceLoader = new SequenceLoader();
		DNASequence dnaSequence = sequenceLoader.loadDNASequence(file);
		
		//
		// Convert the sequence to a string and then a char array
		//
		String dnaAsString = dnaSequence.getSequenceAsString().toUpperCase();
		char[] dnaAsCharArray = dnaAsString.toCharArray();
		
		//
		// Call your solution to compute the result
		//
		int frame = bestReadingFrame(dnaAsCharArray);
		
		return frame;
	}
	
	//
	// ... to here, so we can unit test your solution
	//
	
	/**
	 * 
	 * @param dna an array of char.  Each element is a nucleotide:  one of A, T, C, or G.
	 * @return the index at which the best reading frame occurs.  This would be 0, 1, or 2.
	 */
	public static int bestReadingFrame(char[] dna) {
		
		// Below, define each of the three Stop Codons as a separate array of char,
		//     named ochre, amber, and opal
		//     See http://en.wikipedia.org/wiki/Genetic_code#Start.2Fstop_codons
		char[] ochre = { 'T','A','A' };
		char[] amber = {'T','A','G'};
		char[] opal = {'T','G','A'};
		
		
		// Below, define the Start Codon (Methionine) as an array of char
		//Start Codon
		char[] methionine = {'A','T','G'};
		
		int ans = -1;  // returned if no appropriate sequences was found
		int end = -1;
		int length1 = 0;
		int length2 = 0;
		int length3 = 0;
		int start = 0;
		//
		// Follow the instructions in the extension write up
		//
		if(dna.length>=6){
			//find 0-frame-start
			for(int i=0;i<dna.length-5;i=i+3){	
				if(dna[i]==methionine[0]&&dna[i+1]==methionine[1]&&dna[i+2]==methionine[2]){
					
					//ans = 0;
					end = i+2;
					for(int j = end+1;j<dna.length;j=j+3){
						if((dna[j]==ochre[0]&&dna[j+1]==ochre[1]&&dna[j+2]==ochre[2])||(dna[j]==amber[0]&&dna[j+1]==amber[1]&&dna[j+2]==amber[2])||(dna[j]==opal[0]&&dna[j+1]==opal[1]&&dna[j+2]==opal[2])){
							ans = 0;
							if(length1<(j-i-3))
							{
							length1 = j - i;
							}
							
							i = j;
							start = j+3;
							break;
						}
					}
					
				}
				else
				{
					if(start==0){
						ans = -1;
					}
					
				}
				
			}
			//System.out.println("length1 is "+length1);
			//find 1-frame-start 
			//find 1
			start = 1;
			for(int i=1;i<dna.length-5;i=i+3){	
				if(dna[i]==methionine[0]&&dna[i+1]==methionine[1]&&dna[i+2]==methionine[2]){
					
					end = i+2;
					for(int j = end+1;j<dna.length;j=j+3){
						if((dna[j]==ochre[0]&&dna[j+1]==ochre[1]&&dna[j+2]==ochre[2])||(dna[j]==amber[0]&&dna[j+1]==amber[1]&&dna[j+2]==amber[2])||(dna[j]==opal[0]&&dna[j+1]==opal[1]&&dna[j+2]==opal[2])){
							
							if(ans == -1){
								ans = 1;
							}
							if(length2<(j-i-3))
							{
							length2= j - i-3;
							//System.out.println("j is "+j+"i is "+i);
							}
								
							i = j;
							start = j+3;
							break;
						}
					}
					
				}
				if(length2>length1){
					ans = 1;
				}
				if(start==1&&ans==-1){
					ans = -1;
				}
			}
			//System.out.println("length2 is "+length2);
			start = 2;
			for(int i=2;i<dna.length-5;i=i+3){	
				if(dna[i]==methionine[0]&&dna[i+1]==methionine[1]&&dna[i+2]==methionine[2]){
					
					end = i+2;
					for(int j = end+1;j<dna.length;j=j+3){
						if((dna[j]==ochre[0]&&dna[j+1]==ochre[1]&&dna[j+2]==ochre[2])||(dna[j]==amber[0]&&dna[j+1]==amber[1]&&dna[j+2]==amber[2])||(dna[j]==opal[0]&&dna[j+1]==opal[1]&&dna[j+2]==opal[2])){
							
							if(ans==-1){
								ans = 2;
							}
							if(length3<(j-i-3))
							{
							length3 = j - i-3;
							//System.out.println("j is "+j+"i is "+i);
							}
							
							i = j;
							start = j+3;
							break;
						}
					}
					
				}
				if(length3>length2&&length3>length1){
					ans = 2;
				}
				if(start==2&&ans==-1){
						ans = -1;
				}
			}
		}
		//System.out.println("length3 is "+length3);
		
		return ans;
	}
}
