package studio7;

public class fraction {
	private int numerator,denominator;
	/**
	 * constructor
	 * @param numerator
	 * @param denominator
	 */
	public fraction(int numerator,int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Accessor
	 * @param numerator1
	 * @param denominator2
	 * @return the sum of two fractions
	 */
	public String add(int numerator1,int denominator1){
		
		return numerator*denominator1+numerator1*denominator+"/"+denominator1*denominator;
	}
	
	/**
	 * Accessor
	 * @param numerator1
	 * @param denominator1
	 * @return multiply of two fractions
	 */
	public String mult(int numerator1,int denominator1){
		return numerator1*numerator+"/"+denominator1*denominator;
	}
	
	/**
	 * Accessor
	 * @return reciprocal of fraction
	 */
	public String reci(){
		return denominator+"/"+numerator;
	}
	
	/**
	 * 
	 * @param numerator1
	 * @param denominator1
	 * @return
	 */
	public String simplify(int numerator1,int denominator1){
		int newnum = numerator*denominator1+numerator1*denominator;
		int newdenom = denominator1*denominator;
		for(int i=1;i<=newnum;i++){
			if(newdenom%i == 0){
				newdenom = newdenom/i;
				newnum = newnum/i;
				//System.out.println(i);
			}
			if(newdenom==newnum)
			{
				newdenom = 1;
				newnum = 1;
			}
		}
		return newnum+"/"+newdenom;
	}
	
	public static void main(String[] args) {
		fraction f1 = new fraction(2,5);
		System.out.println("Adding " + f1.add(11,35));
		System.out.println("Multiplying" + f1.mult(1,5));
		System.out.println("reciprocal " + f1.reci());
		System.out.println("Simplify " + f1.simplify(11,35));
		System.out.println("Simplify " + f1.simplify(3,5));
	}

}
