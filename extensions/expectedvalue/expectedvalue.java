package expectedvalue;

import cse131.ArgsProcessor;

public class expectedvalue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);	
		Double succeedprob = ap.nextDouble("the  probability to succeed");
		while (succeedprob > 1)
		{
			succeedprob = ap.nextDouble("the probability to succeed,the probability must between 0 to 1");
		}
		long expectedvalue = Math.round(succeedprob * 190000 + (1-succeedprob) * 5000);
		//System.out.print(expectedvalue);
		long salary = Math.round(Math.random()* 50000 )+ 110000;
		double gamer = 3 * Math.sqrt(expectedvalue);
		double programmer = 2 * Math.sqrt(salary);
		System.out.println("Gamer: $"+expectedvalue);
		System.out.println("Programmer: $"+salary);
		System.out.println("You should be a gamer and not a programmer?  "+(expectedvalue>salary));
		System.out.println("EU(Gamer): $"+gamer);
		System.out.println("EU(Programmer): $"+programmer);
		String job = gamer > programmer ? "gamer" : "programmer";
		System.out.println("you should accept the "+(job)+" job");
		
	
	}
}
