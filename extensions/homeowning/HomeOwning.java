package homeowning;

import cse131.ArgsProcessor;

public class HomeOwning {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);	
		String apartmentName = ap.nextString("enter the apartment name");
		int zipcode = ap.nextInt("enter the zip code");
		double monthlyRent = ap.nextDouble("enter rent per month");
		double dailyInterest = ap.nextDouble("enter daily interest");
		long yearlyRents = Math.round(monthlyRent * 12);
		double weeklyRents = Math.round(yearlyRents / 52.0*100.0)/100.0;
		double yearlyInterest = Math.round(dailyInterest *365*100)/100.0;
		double weeklyInterest = Math.round(dailyInterest *7*100)/100.0;
		String decision = yearlyRents < yearlyInterest ? "rent" : "own";
	    System.out.println(apartmentName+" is located in the Zip Code "+zipcode);
	    System.out.println("Rent per year: "+ yearlyRents);
	    System.out.println("Rent per week: " + weeklyRents+'\n'+'\n');
	    System.out.println("Interest paid per year: "+yearlyInterest);
	    System.out.println("Interest paid per week: "+ weeklyInterest+'\n'+'\n');
	    System.out.println("I should "+decision);

	}

}
