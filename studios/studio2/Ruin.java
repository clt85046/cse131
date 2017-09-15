package studio2;

import cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int startAmount = ap.nextInt("Your startAmount");
		double winChance = ap.nextDouble("Your winChance");
		int winAmount = ap.nextInt("Your goal of winAmount");
		int totalPlays = ap.nextInt("Times you total play");
		double lossChance = 1.0-winChance;
		double ruin;
		int wintime=0;
		int losetime=0;
		if (lossChance != winChance)
		{
		 ruin = (Math.pow((lossChance/winChance),startAmount)-Math.pow((lossChance/winChance),winAmount))/(1-Math.pow(lossChance/winChance, winAmount));
		}
		else
		{
			ruin = 1 - startAmount/winAmount;
		}
		for (int i=1;i<32;i++)
		{  int amount = startAmount;
		   int round =0;
		   String result;
			while (amount >0 && amount < winAmount)
			{
				if (Math.random()>winChance)
				{
					amount = amount - 1; 
					round = round +1;
				}
				else 
				{
					amount = amount +1;
					round = round +1;
				}
			}
			
			if (amount == 0)
			{    
				losetime = losetime + 1;
				result = "LOSE";
				
			}
			else
			{
				wintime = wintime+1;
				result = "WIN";
			}
			System.out.println("Simulation "+ i + ": " + round +"rounds"+ "          " + result);
		}
		System.out.println();
		System.out.println("LOSSES: "+losetime+" Simulations: "+ totalPlays);
		System.out.println("Actual Ruin Rate: "+((double)losetime/(double)totalPlays)+"  Expected Ruin Rate: "+ruin);
		
	}

}
