package Mario;

public class Mario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a mountain that descends to the right
		System.out.println("Create a mountain that descends to the right");
		for(int i = 0;i<5;i++){
			for (int j=0;j<=i;j++){
				System.out.print("#");
			}
			System.out.print("\n");
		}
		//Make a mountain that resembles the original mountain flipped upside down
		System.out.println("\n"+"Make a mountain that resembles the original mountain flipped upside down");
		for(int i = 5;i>0;i--){
			for (int j=0;j<i;j++){
				System.out.print("#");
			}
			System.out.print("\n");
		}
		
		//Create a mountain that ascends to the right
		System.out.println("\n"+"Create a mountain that ascends to the right");
		String s = "    #" + "\n" + "   ##" + "\n" + "  ###" + "\n" + " ####" + "\n" + "#####";
		System.out.println(s);
		
		//Make a mountain that resembles the  one upside down.
		System.out.println("\n"+"Make a mountain that resembles the  one upside down");
		String s1 = "#####" + "\n" + " ####" + "\n" + "  ###" + "\n" + "   ##" + "\n" + "    #";
		System.out.println(s1);
		
	}

}
