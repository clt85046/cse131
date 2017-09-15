package hello;

import java.awt.Color;

import sedgewick.StdDraw;

public class Emerson {

	public static void emote(double xCenter, double yCenter, double halfWidth, double halfHeight, double howHot, double howHappy, double howOther){
		double faceRad = 0.9*Math.min(halfWidth, halfHeight);		
		// face
		int red = (int)(255+255*howHot);
		int blue = (int)(-255*howHot);
		if (red < 0)
			red = 0;
		if (red > 255)
			red = 255;
		if (blue < 0)
			blue = 0;
		if (blue > 255)
			blue = 255;
		StdDraw.setPenColor(new Color(red, 255-(int)(255*Math.abs(howHot)), blue)); 
		StdDraw.filledCircle(xCenter, yCenter, faceRad);
		// eyeballs
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledCircle(xCenter-(faceRad/3), yCenter+(faceRad/4.5), faceRad/4.5);
		StdDraw.filledCircle(xCenter+(faceRad/3), yCenter+(faceRad/4.5), faceRad/4.5);
		// pupils
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledCircle(xCenter-(faceRad/3), yCenter+(faceRad/4.5), .3*(faceRad/4.5));
		StdDraw.filledCircle(xCenter+(faceRad/3), yCenter+(faceRad/4.5), .3*(faceRad/4.5));
		// eyebrows
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(xCenter-(faceRad/3), yCenter+(faceRad/1.875)+(howOther*(faceRad/5)), (faceRad/3.75), (faceRad/9)); 
		StdDraw.filledRectangle(xCenter+(faceRad/3), yCenter+(faceRad/1.875)+(howOther*(faceRad/5)), (faceRad/3.75), (faceRad/9));
		// mouth
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(faceRad/90);
		if (howHappy == 0)
			StdDraw.point(xCenter, yCenter-(faceRad/2.25));
		else if (howHappy > 0){ // happy
			StdDraw.arc(xCenter, yCenter-(faceRad/4.5), (faceRad/4.5), 270-(90*howHappy), 270+(90*howHappy));
		}
		else{ // sad
			StdDraw.arc(xCenter, yCenter-(faceRad/1.5), (faceRad/4.5), 90+(90*howHappy), 90-(90*howHappy));
		}
		
	}
	
	public static void main(String[] args) {
//		(xCenter, yCenter, halfWidth, halfHeight, howHot,howHappy, howOther)
		emote(.5, 	.5, 	.5,  		1,			1,	 	1, 		-1);
//		hot = 1, cold = -1
//		happy = 1, sad = -1
//		surprised = 1, bored = -1
		
	}

}

