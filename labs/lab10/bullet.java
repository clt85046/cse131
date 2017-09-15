package lab10;

import sedgewick.StdDraw;

public class bullet implements move{
	private double x,y,radius,speed;
	private boolean active;
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param radius
	 * @param speed
	 */
	public bullet(double x,double y,double radius,double speed){
		this.x = x;
		this.active = true;
		this.y = y+2*speed;
		this.radius = radius;
		this.speed = speed;
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(x, y, radius/2, radius);
		
		//this.shooted = false;
	}
	
	/**
	 * return x position
	 * @return x position
	 */
	public double getx(){
		return x;
	}
	
	/**
	 * return y position
	 * @return y position
	 */
	public double gety(){
		return y;
	}
	
	/**
	 * return radius
	 * @return radius
	 */
	public double getr(){
		return radius;
	}
	
	/**
	 * collide with objects
	 * @param p
	 */
	public void collided(Player p,Enemy e){
		double px = p.getx();
		double py = p.gety();
		double pr = p.getradius();
		double[] ex = e.getrx();
		double[] ey = e.getry();
		double er = e.getradius();
		if(p.getlife()>=0){
			
			for(double i = x-radius/2;i<x+radius/2;i++){
				for(double j = y-radius;j<y+radius;j++){
					if(i<=px+pr&&i>px-pr&&j<=py+pr&&j>py-pr){
						System.out.println("work!");
						System.out.println("life = "+p.getlife());
						p.setlife(p.getlife()-1);
						p.setActive(false);
						active=false;break;
					}
				}
				if(!p.getActive()){
					break;
				}
			}
			for(int i = ex.length-1;i>=0;i--){
				if(e.getactive(i)){
					if(((x-ex[i])*(x-ex[i])+(y-ey[i])*(y-ey[i]))<(er+radius)*(er+radius)){
						e.setactive(i, false);
						active =false;
						p.addScore(p.getScore()+e.getScore());
					}
					
				}
				if(active == false){
					break;
				}
			}
		}
		
	}
	
	/**
	 * bullet move function
	 */
	public void move(){
			if(active){
				y = y+ speed;
				
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(x, y, radius/2, radius);
				
			}
			
	
		
	}
}
