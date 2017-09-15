package lab6;

public class Beer {
	/**
	 * 
	 * @param n number of bottles
	 * @return return the song 
	 */
	public static String bottlesOfBeer(int n){
		if(n==0){
			return " 0 bottles of beer on the wall.";
		}
		else{
			return n+" bottles of beer on the wall,"+n+" bottles of beer; you take one down, pass it around,"+(n-1)+" bottles of beer on the wall."+'\n'+bottlesOfBeer(n-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bottlesOfBeer(5));
	}

}
