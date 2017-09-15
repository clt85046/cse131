package exercises3;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};

		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}

		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		String[] shuffled = new String [original.length];
		for (int i= shuffled.length-1;i>=0;i--)
		{
		 int c = (int)(Math.random()*(i+1));
		 System.out.println(c);
		 shuffled [i] = original[c];
		 for (int j=c;j<shuffled.length-1;++j)
		 {
			 original[j]=original[j+1];
		 }
		}
		for (int i=0; i < original.length; ++i) {
			System.out.println("shuffeled at " + i + " is " + shuffled[i]);
		}

	}
	
}