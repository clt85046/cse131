package lab10;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Environment k = new Environment();
		Enemy e = new Enemy(16,0.03,0.03,10);
		Player p = new Player(0.5,0.05,0.05,0.05);
		gamecontroller2 game = new gamecontroller2(e,p);
		

	}

}
