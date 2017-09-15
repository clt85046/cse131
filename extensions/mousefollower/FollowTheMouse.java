package mousefollower;

import sedgewick.StdDraw;

public class FollowTheMouse {
//	private double[] mouseposition;
//	
//	
	/**
	 * return mouse position
	 * @return
	 */
	public static double[] getMousePosition(){
		double[] position=new double[2];
		position[0] = StdDraw.mouseX();
		position[1] = StdDraw.mouseY();
		return position;
	}
	
	/**
	 * draw a ball
	 * @param position
	 * @param radius
	 */
	public static void drawBall(double[] position, double radius){
	   double x = position[0];
	   double y = position[1];
	   StdDraw.filledCircle(x, y, radius);
	}
	
	/**
	 * change position to mousePosition in fixed speed
	 * @param position
	 * @param mousePosition
	 * @param speed
	 * @return
	 */
	public static double[] changePosition(double[] position, double[] mousePosition, double speed){
		double x0 = position[0];
		double x1 = mousePosition[0];
		double y0 = position[1];
		double y1 = mousePosition[1];
		double k = (y1-y0)/(x1-x0);
		double[] newposition = new double[2];
		if(x0<x1){
		newposition[0] = x0+speed;
		newposition[1] = y0+speed*k;
		}
		if(x0>=x1){
			newposition[0] = x0-speed;
			newposition[1] = y0-speed*k;
		}
		return newposition;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] tester = new double[]{.5, .5};
		
		drawBall(tester, .2);
		StdDraw.show(1000);
		StdDraw.clear();
		while (true){
			drawBall(tester,.02);
			
			StdDraw.show(300);
			
			double[] mouseposition = getMousePosition();
			tester = changePosition(tester,mouseposition,0.05);
			System.out.println("mp"+mouseposition[0]);
			System.out.println(tester[0]);
		}
	}

}
