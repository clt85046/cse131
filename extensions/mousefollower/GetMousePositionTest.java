package mousefollower;
import static org.junit.Assert.*;

import org.junit.Test;

import sedgewick.StdDraw;


public class GetMousePositionTest {

	double[] myMousePos;
	double[] theirMousePos;
	double xPos = 1;
	double yPos = 1;


	@Test
	public void testGetMousePosition() throws InterruptedException{

		for (int i=0; i<50; i++){
			
			StdDraw.clear();
			myMousePos = new double[]{StdDraw.mouseX(), StdDraw.mouseY()};
			theirMousePos = FollowTheMouse.getMousePosition();
			assertTrue("Your x Coordinate is Wrong", Math.abs(myMousePos[0]-theirMousePos[0]) < .01);	
			assertTrue("Your y Coordinate is Wrong", Math.abs(myMousePos[1]-theirMousePos[1]) < .01 );
			xPos = xPos - Math.random()*.05;
			yPos = yPos - Math.random()*.05;
			StdDraw.filledCircle(xPos, yPos, .02);
			StdDraw.show(50);
			
			
		}

	}

}
