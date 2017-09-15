package project;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;

import lab10.ArcadeKeys;
import sedgewick.StdDraw;

/**
 * Plays game by using all created objects and Moveable interface
 * @author Zachary Polsky
 *
 */

public class Game {
	
	private LinkedList<Alien> aliens;
	private LinkedList<Moveable> move;
	private LinkedList<Bullet> bullets,alien_bullets;
	private Player player;
	private Alienblock alienblock;
	private double alienSpeed;
	private int score,level,playtime,highscore,highestlevel;
	
	/**
	 * create a game with aliens,player and bullets
	 */
	public Game() {
		aliens = new LinkedList<Alien>();
		move = new LinkedList<Moveable>();
		bullets = new LinkedList<Bullet>();
		alien_bullets = new LinkedList<Bullet>();
		StdDraw.setScale(-1, 1);
		player = new Player(0, -.9, .04, 3);
		move.add(player);
		
		alienSpeed = 0.02;
		addAliens();
		score = 0;
		level = 1;
		highestlevel = 1;
		highscore = 0;
		playtime = 0;
	}
	
	/**
	 * draw the background and score player have
	 * @param score
	 */
	public void drawBoard(int score) {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(0.75, 0.9, "Score: " + score);
		StdDraw.text(-0.75, 0.9, "Lives: " + player.getLives());
		StdDraw.text(0, 0.9, "Levels: " + level);
	}
	
	/**
	 * Determine if game is over
	 * @return
	 */
	public boolean isOver() {
		return (!(player.getLives() > 0));
	}
	
	/**
	 * add aliens to the game
	 */
	public void addAliens(){
		addAlien(0.5, 0.5, alienSpeed, true);
		addAlien(-0.5, 0.5, alienSpeed, true);
		addAlien(-0.9, 0.5, alienSpeed, false);
		addAlienblock(0.5, 0.5, alienSpeed, false);
	}
	
	/**
	 * add a alien to the aliens list
	 * @param x new alien`s x position
	 * @param y new alien`s y position
	 * @param speed new alien`s speed
	 * @param upDown new alien`s move direction
	 */
	private void addAlien(double x, double y, double speed, boolean upDown)
	{
		Alien a = new Alien(x, y, speed, upDown);
		aliens.add(a);
		move.add(a);
	}
	
	private void addAlienblock(double x, double y, double speed, boolean upDown){
		Alien a = new Alien(x, y, speed, upDown);
		alienblock = new Alienblock(3,3,a);
		move.add(alienblock);
	}
	/**
	 * set the play rules for the game
	 */
	public void play(){
		// display the score player have
		drawBoard(score);
		for (Moveable m : move) {
			m.move();
			m.draw();
		}
		
		// shoot bullet if player has fired and the bullet on screen is less than 3
		if (player.fire() && bullets.size() < 3) {
			Bullet b = new Bullet(player.getPosX(), player.getPosY() + .15, .05);
			move.add(b);
			bullets.add(b);
		}
		
		// if player collide with a alien,player will lose one life and lose 10 points
		// if bullet hit an alien,the player will earn 50 points,the alien and bullet will clear from the screen
		// if a bullet get out of the bound,it will be cleared.
		/*CODE A*/ // start
		for (Alien a : aliens) {
			
			if (a.fire() && alien_bullets.size() < 3) {
				Bullet c = new Bullet(a.getPosX(), a.getPosY() - .15, -.05);
				move.add(c);
				alien_bullets.add(c);
			}
		}
		
		LinkedList<Alien> alienblocks = alienblock.getAliens();
		//System.out.println(alienblocks);
		for (Alien a : alienblocks){
			for (Bullet b : bullets) {
				if (b.collide(a,player)==1) {
					a.die();
					b.setOffScreen();
					score += 50;
				}
				else if (b.getPosY() >= 1){
					b.setOffScreen();
				}
			}
		}
		
		
		for (Alien a : aliens) {
			if (player.collide(a,player)==1) {
				player.die();
				score -= 10;
			}
			for (Bullet b : bullets) {
				if (b.collide(a,player)==1) {
					a.die();
					b.setOffScreen();
					score += 50;
				}
				else if (b.getPosY() >= 1){
					b.setOffScreen();
				}
			}
			for (Bullet b : alien_bullets) {
				if(player.getLives()>0)
				if (b.collide(a,player)==2) {
					player.die();
					b.setOffScreen();
					score -= 10;
				}
				else if (b.getPosY() <= -1){
					b.setOffScreen();
				}
			}
		}
		/*CODE A*/ //end
		
		// Used to prevent concurrent modification errors
		Iterator<Alien> alienIter = aliens.iterator();
		while (alienIter.hasNext()) {
		    Alien a = alienIter.next();
		    if (!a.isAlive()) {
		    	alienIter.remove();
		    	move.remove(a);
		    }
		}
		
		Iterator<Alien> alienIter1 = alienblocks.iterator();
		while (alienIter1.hasNext()) {
		    Alien a = alienIter1.next();
		    if (!a.isAlive()) {
		    	alienIter1.remove();
		    	move.remove(a);
		    }
		}
		
		Iterator<Bullet> bulletIter = bullets.iterator();
		while (bulletIter.hasNext()) {
		    Bullet b = bulletIter.next();
		    if (b.getIsOffScreen()) {
		    	bulletIter.remove();
		    	move.remove(b);
		    }
		}
		Iterator<Bullet> a_bulletIter = alien_bullets.iterator();
		while (a_bulletIter.hasNext()) {
		    Bullet b = a_bulletIter.next();
		    if (b.getIsOffScreen()) {
		    	a_bulletIter.remove();
		    	move.remove(b);
		    }
		}
		
		// Determine aliens has been cleared and get into a new level
		levelUp();
		StdDraw.show(60);
		
		if (isOver()){
			drawGameEnd();
		}
	}
	
	/**
	 * build faster speed aliens if the aliens has been cleared
	 */
	public void levelUp() {
		if (aliens.isEmpty()) {
			StdDraw.clear();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(0, 0, 1, 1);
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(0, 0, "Next Level");
			StdDraw.show(1000);
			alienSpeed *= 1.5;
			level++;
			move.clear();
			aliens.clear();
			bullets.clear();
			alien_bullets.clear();
			move.add(player);
			
			//System.out.println(alienblock);
			addAliens();
			//System.out.println(alienblock);
		}
	}
	
	/**
	 * set the gameover scene
	 */
	public void drawGameEnd()
	{	
		playtime = playtime + 1;
		while(player.getLives()<=0){
			
			StdDraw.clear();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(0, 0, 1, 1);
			StdDraw.setPenColor(Color.WHITE);
			highscore = (highscore>score?highscore:score);
			highestlevel = (highestlevel>level?highestlevel:level);
			
			StdDraw.text(0, 0, "GAME OVER");
			StdDraw.text(0, 0.7, "HighScore : "+highscore);
			StdDraw.text(0, 0.9, "Highestlevel : "+highestlevel);
			StdDraw.text(0, 0.3, "Playtime "+playtime);
			StdDraw.text(0, 0.5, "Score : "+score);
			StdDraw.text(0, -0.3, "Press W to restart");
			if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)){
				level = 1;
				alienSpeed = 0.02;
				player = new Player(0, -.9, .04, 3);
				move.clear();
				aliens.clear();
				bullets.clear();
				alien_bullets.clear();
				move.add(player);
				score = 0;
				//System.out.println(alienblock);
				addAliens();
		}
			
			
			StdDraw.show(100);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		while (!game.isOver()){
			
			game.play();
		}
		
	}

}
