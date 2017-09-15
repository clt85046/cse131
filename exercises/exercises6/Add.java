package exercises6;

public class Add {
	
	//
	// Complete using the formula:
	//   add(x,y) =           x , if y == 0
	//   add(x,y) = add(x+1,y-1), otherwise
	//
	public static int add(int x, int y) {
		return 0;  // FIXME
	}
	
	//
	// Answer in comments below:
	//
	//  For what values of x and y does your method operate correctly?
	//
	//  Your answer:
	//
	//  Can you complete the following method
	//   so that it calls add but returns the correct answer
	//   for any x and y?
	//  As a hint, consider that  (x+y) = -(-x + -y)
	//
	public static int addAny(int x, int y) {
		if (y >= 0)
			return add(x,y);
		else
			return 0; // FIXME
	}

}
