package project;

import java.util.LinkedList;

import sedgewick.StdDraw;

public class Alienblock implements Moveable {
	private Alien alien;
	private int x,y;
	private LinkedList<Alien> aliens;
	private double speed;
	public Alienblock(int x,int y,Alien alien){
		this.x = x;
		this.y = y;
		this.alien = alien;
		this.aliens = new LinkedList<Alien>();
		this.speed = alien.getspeed();
		for(int i =0;i<x;i++){
			for(int j = 0;j<y;j++){
				Alien a = new Alien(alien.getPosX()+i*alien.getWidth(), alien.getPosY()+j*alien.getHeight(),speed,alien.getUpdown());
				aliens.add(a);
			}
		}
	}
	
	public LinkedList<Alien> getAliens(){
		return aliens;
	}
	public void draw() {
		
		for(Alien a : aliens){
			a.draw();
		}
	}

//	public boolean isOffScreen() {
//		return (this.posX > 1 || this.posX < -1 || this.posY > 1 || this.posY < -1);
//	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		for(Alien a : aliens){
			if(a.isOffScreen()){
				speed *= -1;
				break;
			}
		}
		for(Alien a : aliens){
			a.setX(a.getPosX()+speed );
		}
	}


	
}
