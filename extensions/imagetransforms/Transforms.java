package imagetransforms;

import java.awt.Color;

import sedgewick.Picture;


public class Transforms {
	
	/**
	 * This one is solved for you.
	 * @param source
	 * @param target
	 */
	public static void flipHoriz(Picture source, Picture target) { 
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				//
				// Convince yourself that otherX is the x coordinate flipped,
				//     on the other side of the image by doing the following:
				// Check that this is true when x == 0
				//      then otherX = source.width() - 1
				//      which is indeed the rightmost pixel
				// Check that this is true when x == source.width()-1
				//      then otherX = 0
				//      which is indeed the leftmost pixel
				//
				int otherX = source.width() - 1 - x;  // otherX is the mirror of x
				Color c = source.get(otherX, y);      // get the Color at the mirror point of the source
				target.set(x, y, c);                  // and set it at x,y in the target
			}
		}
	}
	
	public static void flipVert(Picture source, Picture target) {
		// FIXME
		for (int x = 0; x < source.height(); x++) {
			for (int y = 0; y < source.width(); y++) {
				//
				// Convince yourself that otherX is the x coordinate flipped,
				//     on the other side of the image by doing the following:
				// Check that this is true when x == 0
				//      then otherX = source.width() - 1
				//      which is indeed the rightmost pixel
				// Check that this is true when x == source.width()-1
				//      then otherX = 0
				//      which is indeed the leftmost pixel
				//
				int otherX = source.height() - 1 - x;  // otherX is the mirror of x
				Color c = source.get(y,otherX);      // get the Color at the mirror point of the source
				target.set(y,x, c);                  // and set it at x,y in the target
			}
		}
	}
	
	
	public static void flipHorizLeftHalf(Picture source, Picture target) {
		// FIXME
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				//
				// Convince yourself that otherX is the x coordinate flipped,
				//     on the other side of the image by doing the following:
				// Check that this is true when x == 0
				//      then otherX = source.width() - 1
				//      which is indeed the rightmost pixel
				// Check that this is true when x == source.width()-1
				//      then otherX = 0
				//      which is indeed the leftmost pixel
				//
				Color c;
				if(x<=source.width()/2)
					{
						int otherX = source.width() - 1 - x;  // otherX is the mirror of x
					    c = source.get(otherX, y); 
					}  
				else
					{
					c = source.get(x, y); 
					}// get the Color at the mirror point of the source
				target.set(x, y, c);                  // and set it at x,y in the target
			}
		}
	}
	
	public static void flipVertBotHalf(Picture source, Picture target) {
		// FIXME
		for (int y = 0; y < source.height(); y++) {
			for (int x = 0; x < source.width(); x++) {
				//
				// Convince yourself that otherX is the x coordinate flipped,
				//     on the other side of the image by doing the following:
				// Check that this is true when x == 0
				//      then otherX = source.width() - 1
				//      which is indeed the rightmost pixel
				// Check that this is true when x == source.width()-1
				//      then otherX = 0
				//      which is indeed the leftmost pixel
				//
				Color c;
				if(y > source.height()/2)
				{
					int otherY = source.height() - 1 - y;  // otherX is the mirror of x
					c = source.get(x,otherY);      // get the Color at the mirror point of the source
				}
				else
				{
					c = source.get(x,y);   
				}  // otherX is the mirror of x
				     // get the Color at the mirror point of the source
				target.set(x,y, c);                  // and set it at x,y in the target
			}
		}
	}
	
	public static void gradient(Picture target) {
		// FIXME
		int amountRed = 0;
		int amountGreen = 0;
		double m,n;
		for (int x = 0; x < target.width(); x++) 
		{    
			amountRed = (255/target.width())*x;
			for (int y = 0; y < target.height(); y++) 
			{
				n=(double)255/target.height();
				amountGreen = (int) (n*y);
				//amountGreen = (255/target.height())*y;
				//System.out.println(n);
				target.set(x, y, new Color(amountRed, amountGreen, 128));
			}
			
		}
				
	}
	
	public static void edgeDetect(Picture source, Picture target) {
		// FIXME
	}
	
	public static void digitalFilter(Picture source, Picture target) {
		// FIXME	
	}



}
