package lab10;

import sedgewick.StdDraw;

public class gamecontroller2 {
	private Enemy enemy;
	private Player player;
	/**
	 * constructor
	 * @param enemy
	 * @param player
	 */
	public gamecontroller2(Enemy enemy,Player player){
		this.enemy = enemy;
		this.player = player;
		int k = 4;
		while(true){
//			k=k-1;
//			StdDraw.setPenColor(StdDraw.BLACK);
//			StdDraw.filledSquare(0, 0, 1.2);
//			System.out.println(k);
			if(player.getlife()>=0){
				
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare(0, 0, 1.2);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(0, 1, "Life : "+player.getlife());
				StdDraw.text(0.9, 1, "Score : "+player.getScore());
				enemy.move();
				enemy.shoot();
				player.move();
				player.shoot();
				player.collided(player,enemy);
				enemy.collided(player,enemy);
//			
				StdDraw.show(300); 
			}
			else{
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare(0, 0, 1.2);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(0.5, 0.75, "GameOver!");
				StdDraw.text(0.5, 0.5, "Score : "+player.getScore());
				StdDraw.text(0.5, 0.2, "Press W to restart");
				if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)){
					player.reset();
					enemy.reset();
					
				}
				System.out.println(player.getlife());
				StdDraw.show(300); 
			}
		}
		//while(k<=0){
		//System.out.println("jimo");	
		//}
		
		
	}

}
