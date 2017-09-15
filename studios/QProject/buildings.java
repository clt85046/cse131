package QProject;

import java.awt.Color;

import sedgewick.StdDraw;

public class buildings implements Draw{
	private double height;
	private int nums;
	private double[] buildings = new double[nums];
	
	/**
	 * create a random building
	 * @param midpoint x point of building
	 * @param height height of building
	 * @param width width of building
	 */
	public buildings() {
		
	}
	
	/**
	 * set parameters for building
	 */
	public void getPara() {
		this.nums = (int)(Math.random()*2 + 6);
		buildings = new double[nums];
		for (int i = 0; i < nums; i++) {
			this.height = Math.random()*1.1;
			buildings[i] = height;
		}
	}
	
	/**
	 * draw buildings
	 */
	public void draw() {
		for (int i = 0; i < nums; i++) {
			double width = 2.0/nums;
			double midpoint = -1 + width / 2 + i * width;
			if (Math.random() < 0.33) {
				StdDraw.setPenColor(Color.BLUE);
			} else if (Math.random() < 0.66) {
				StdDraw.setPenColor(Color.CYAN);
			} else {
				StdDraw.setPenColor(Color.GREEN);
			}
			StdDraw.filledRectangle(midpoint, buildings[i]/2 - 1, width/2, buildings[i]/2);
		}
	}
	
	/**
	 * get first building`s height
	 * @return first building`s height
	 */
	public double startheight() {
		return buildings[0];
	}
	
	/**
	 * get last buildings height
	 * @return last buildings height
	 */
	public double endheight() {
		return buildings[nums - 1];
	}
	
	/**
	 * collide detection
	 */
	public boolean collide(QBall ball) {
		double x = ball.getPosX();
		double y = ball.getPosY();
		//System.out.println("x = " + x);
		for (int i = 0; i < nums; i++) {
			double width = 2.0/nums;
			if (x < -1 + (1 + i) * width && x >= -1 + i * width ) {
				//System.out.println("y= " + y);
				System.out.println("buildings[i] " + (buildings[i] - 1));
				if (y <= buildings[i] - 1) {
					return false;
				}
			}
		}
		return true;
	}
	
}
