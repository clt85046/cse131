package lab10;

import java.util.LinkedList;

import sedgewick.StdDraw;

public class Enemy implements move {
	private int enemy_num,shottime;
	private double speed,radius;
	private double[] rx;
	private double[] ry;
	private LinkedList<bullet> bullets;
	private int score;
	private boolean[] active;
	/**
	 * constructor
	 * @param num
	 * @param speed
	 * @param radius
	 */
	public Enemy(int num,double speed,double radius,int score){
		this.enemy_num = num;
		this.speed = speed;
		this.radius = radius;
		this.shottime = 0;
		this.score = score;
		this.rx = new double[enemy_num];
		this.ry = new double[enemy_num];
		this.active = new boolean[enemy_num];
		this.bullets = new LinkedList<bullet>();
		for (int i = 0;i<enemy_num;i++){
			int k = i/4;
			ry[i] = 1-2*radius*k;
			rx[i] = (2*(i-4*k))*radius;
			active[i] = true;
		}
		//setenemy();
	}
	
	/**
	 * return bullet enemy shoot
	 * @return
	 */
	public LinkedList<bullet> getbullets(){
		return bullets;
	}
	
	/**
	 * return x position
	 * @return
	 */
	public double[] getrx(){
		return rx;
	}
	
	/**
	 * return y position
	 * @return y position
	 */
	public double[] getry(){
		return ry;
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
	 * return enemynum
	 * @return enemy number
	 */
	public int getEnemynum(){
		return enemy_num;
	}
	
	/**
	 * getscore
	 * @return
	 */
	public int getScore(){
		return score;
	}
	
	/**
	 * set enemy active
	 * @param i
	 * @param k
	 */
	public void setactive(int i ,boolean k){
		active[i] = k;
	}
	
	public boolean getactive(int i){
		return active[i];
	}
	
	/**
	 * reset enemy
	 */
	public void reset(){
		for (int i = 0;i<enemy_num;i++){
			int k = i/4;
			ry[i] = 1-2*radius*k;
			rx[i] = (2*(i-4*k))*radius;
			active[i] = true;
			this.bullets = new LinkedList<bullet>();
		}
	}
	@Override
	/**
	 * move function for enemy
	 */
	public void move() {
		// TODO Auto-generated method stub
		if(rx[0]+speed>0&&rx[enemy_num-1]+speed<1.0){
			for(int i = 0;i<enemy_num;i++){
				rx[i] = rx[i]+speed;
				if(active[i]){
					StdDraw.setPenColor(StdDraw.BLACK); 
					StdDraw.filledCircle(rx[i], ry[i], radius); 
				}
					
				}
		}
		else{
			this.speed = -1*this.speed;
			for(int i = 0;i<enemy_num;i++){
				ry[i] = ry[i]-Math.abs(speed);
				if(active[i]){
//					System.out.println("olwafawefa");
					StdDraw.setPenColor(StdDraw.BLACK); 
					StdDraw.filledCircle(rx[i], ry[i], radius); 
					
				}
			}
			
		}
		if(bullets != null){
				
				for(bullet BULLET : bullets){
					BULLET.move();
				}
				
			}
	}
	
	/**
	 * shoot function for enemy
	 */
	public void shoot(){
		int k = enemy_num-4;
		int t = (int) (Math.random()*4)+k;
		if(shottime%8==0){
			
			bullet e_b = new bullet(rx[t],ry[t],radius,-0.03);
			bullets.add(e_b);
		}
		shottime++;
		if(shottime == 31){
			shottime = 0;
		}
	}
	
	/**
	 * collided function for enemy
	 */
	public void collided(Player p,Enemy e){
		LinkedList<bullet> pbs = p.getbullet();
		for(bullet pb:pbs){
			pb.collided(p, e);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
