package onerepmax;

import cse131.ArgsProcessor;

public class OneRepMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);	
		int successfulWeight = ap.nextInt("Enter the successfulweight :");
		int successfulreps = ap.nextInt("Enter the successful reps:");
		int Desiredreps = ap.nextInt("Enter the desired reps:");
		int oneRepMax;
		if(successfulreps%2==0)
		{
			double k = successfulWeight/(1-0.05*(successfulreps/2));
			oneRepMax = (int) k;
			System.out.println("One-rep max: "+oneRepMax);
		}
		else
		{
			double k = successfulWeight/(1-0.05*(successfulreps/2));
			oneRepMax = (int) k;
			System.out.println("One-rep max: "+oneRepMax);
		}
		if(Desiredreps%2==1)
		{
			double n = oneRepMax *(1-0.05*((Desiredreps+1)/2));
			System.out.println("Weight for "+Desiredreps+" reps: "+n);
		}
		else
		{
			double n = oneRepMax*(1-0.05*((Desiredreps)/2));
			System.out.println("Weight for "+Desiredreps+" reps: "+n);
		}
	}

}
