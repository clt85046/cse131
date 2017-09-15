package exercises4;

import sedgewick.StdDraw;

public class WaitPoint {

	public static void main(String[] args) {
		// wait for the mouse to be pressed and released
        while(!StdDraw.mousePressed())
        {
        	//StdDraw.pause(5000);
        }
        System.out.println("pressed");
        while(StdDraw.mousePressed())
        {
        	
        }
        System.out.println("released");
		// here, the mouse has been pressed

		// here the mouse is released
		
		
		// draw a point at the location of the mouse
		StdDraw.setPenRadius(0.1);
		StdDraw.point(StdDraw.mouseX(),StdDraw.mouseY());
		
		
		// here, a q has been typed
		char got = ' ';
		while(got != 'q')
		{
		while (!StdDraw.hasNextKeyTyped())
		{
			StdDraw.pause(100);
		}
		got = StdDraw.nextKeyTyped();
		}
		
		
			StdDraw.text(0.5, 0.5, "Farewell!");
		
		//StdDraw.text(0.5, 0.5, "Farewell!");

	}

}
