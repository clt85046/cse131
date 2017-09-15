package lab10;

import java.util.LinkedList;

import sedgewick.StdDraw;

public class Player implements move {
	private double x,y,radius,speed,initialx,initialy;
	private LinkedList<bullet> bullets;
	private boolean active;
	private int life,scores;
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param radius
	 * @param speed
	 */
	public Player(double x,double y,double radius,double speed){
		this.x = x;
		this.y = y;
		this.scores = 0;
		this.active = true;
		this.radius = radius;
		this.speed = speed;
		this.bullets = new LinkedList<bullet>();
		initialx = x;
		this.life = 2;
 		initialy = y;
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledSquare(x,y,radius);
		//move();
	}
	
	/**
	 * return x position
	 * @return x position
	 */
	public int getlife(){
		return life;
	}
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
	public double getradius(){
		return radius;
	}
	
	/**
	 * return speed
	 * @return speed
	 */
	public double getspeed(){
		return speed;
	}
	
	/**
	 * return scores
	 * @return
	 */
	public int getScore(){
		return scores;
	}
	/**
	 * return active
	 * @return
	 */
	public boolean getActive(){
		return active;
	}
	

	/**
	 * return bullet
	 * @return
	 */
	public LinkedList<bullet> getbullet(){
		return bullets;
	}
	
	/**
	 * set active
	 * @param k
	 */
	public void setActive(boolean k){
		active = k;
	}
	
	/**
	 * set lifes
	 * @param lifes
	 */
	public void setlife(int lifes){
		life = lifes;
	}
	
	/**
	 * add score
	 * @param score
	 */
	public void addScore(int score){
		scores= score;
	}
	
	/**
	 * player move function
	 */
	
	/**
	 * reset the state
	 */
	public void reset(){
		scores = 0;
		life = 2;
		this.bullets = new LinkedList<bullet>();
	}
 	public void move(){

 		if(active == true){
 			if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT)&&(x<1)){
 				x = x +speed;
 			}
 			if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_LEFT)&&(x>0)){
 				x = x - speed;
 			}
 			StdDraw.setPenColor(StdDraw.BLACK);
 			StdDraw.filledSquare(x,y,radius);
 			if(bullets != null){
 				
 				for(bullet BULLET : bullets){
 					BULLET.move();
 				}
 				
 			}
 			
 		}
 		else{
 			StdDraw.setPenColor(StdDraw.BLACK);
 			StdDraw.filledSquare(initialx,initialy,radius);
 			active = true;
 			x=initialx;
 			y=initialy;
 		}
 	}
 	
 	/**
 	 * player shoot function
 	 */
 	public void shoot(){
 		if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)&&(x>0)){
				bullet b = new bullet(x,y,radius,speed);
				bullets.add(b);
				//System.out.println(b);
				
				//bullets = b;
				//bullets.move();
			}
 	}
 	
 	
 	/**
 	 * player collided function
 	 * @param e
 	 */
 	public void collided(Player p,Enemy e){
 		LinkedList<bullet> enemy_bullets = e.getbullets();//System.out.println(enemy_bullets);
 		for(bullet e_b : enemy_bullets){
 			e_b.collided(p,e);
 			//System.out.println(e_b);
// 			double b_x = e_b.getx();
// 			double b_y = e_b.gety();
// 			double b_r = e_b.getr();
// 	
// 			for(double i = b_x-b_r;i<b_x+b_r;i++){
// 				for(double j = b_y-b_r;j<b_y+b_r;j++){
// 					if(i<=x+radius&&i>x-radius&&j<=y+radius&&j>=y-radius){
// 						System.out.println("work!");
// 						active = false;break;
// 					}
// 				}
// 				if(active == false){
// 					break;
// 				}
// 			}
 		}
 		double[] ex = e.getrx();
 		double[] ey = e.getry();
 		double er = e.getradius();
 		for(int i = ex.length-1;i>=0;i--){
 			if(((x-ex[i])*(x-ex[i])+(y-ey[i])*(y-ey[i]))<(er+radius)*(er+radius)){
 				active = false;
 				if(life>=0){
 					this.setlife(life-1);
 				}
 				System.out.println("life = "+this.getlife());
 			}
 			if(active == false){
 				break;
 			}
 		}
 		
 	}
 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Player k = new Player(0.5,0,0.05,0.05);
//	bullet b = new bullet(0.5,0.5,0.05);
//	LinkedList<bullet> bullets = new LinkedList<bullet>();
//	bullets.add(b);
//	for(bullet s : bullets){
//		s.move();
//	}
	
//		while(true){
//			while (!StdDraw.hasNextKeyTyped())
// 			{
// 				StdDraw.pause(100);
// 			}
//			System.out.println(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT));
//		}
			
		
	}

}
