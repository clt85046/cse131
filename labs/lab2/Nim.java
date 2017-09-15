package lab2;

import cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int sum = ap.nextInt("Enter sum of sticks");
		int left = 0;
		int round = 0;
		int num = 0;
		int computerchoice;
		while (sum <= 0)
		{
			sum = ap.nextInt("Enter sum of sticks,the number must be positive");
		}
		int decision = ap.nextInt("enter 1 to play first,2 to play second");
		while (decision!=1 && decision!=2)
		{
			decision = ap.nextInt("Please enter 1 or 2");
		}
		if (decision == 1)
		{
			System.out.println("Player starts");
			while (sum > 0)
			{
				if (round % 2 == (decision-1))
				{
					num = ap.nextInt("enter number of stick to move(can only move 1 or 2 stick once!)");
					while( num!=1 && num!=2)
					{
						num = ap.nextInt("enter number of stick to move(can only move 1 or 2 stick once!)");	
					}
					left = sum -num;
					System.out.println("Round "+round+", "+sum+" sticks at start, human took "+num+", so "+left+" sticks remain");	
					round = round +1;  		
					sum = left;
				}
				else
				{   
					if(sum >= 2)
					{
						if (Math.random()>0.5)
						{
							computerchoice = 1;
						}
						else
						{
							computerchoice = 2;
						}
					}
					else
					{
						computerchoice = 1;
					}
					left = sum -computerchoice;
					System.out.println("Round "+round+", "+sum+" sticks at start, computer took "+computerchoice+", so "+left+" sticks remain");
					round = round + 1 ;
					sum = left;
				}
			}
			if (round % 2 ==0)
			{
				System.out.println("Computer wins");
			}
			else
			{
				System.out.println("Players wins");
			}
			}
		
		else
		{
			System.out.println("Computer starts");
			while (sum > 0)
			{
				if (round % 2 != 0)
				{
					num = ap.nextInt("enter number of stick to move(can only move 1 or 2 stick once!)");
					while( num!=1 && num!=2)
					{
						num = ap.nextInt("enter number of stick to move(can only move 1 or 2 stick once!)");	
					}
					left = sum -num;
					System.out.println("Round "+round+", "+sum+" sticks at start, human took "+num+", so "+left+" sticks remain");	
					round = round +1;  		
					sum = left;
				}
				else
				{   
					if(sum >=2)
					{
						if (Math.random()>0.5)
						{
							computerchoice = 1;
						}
						else
						{
							computerchoice = 2;
						}
					}
					else
					{
						computerchoice = 1;
					}
					left = sum -computerchoice;
					System.out.println("Round "+round+", "+sum+" sticks at start, computer took "+computerchoice+", so "+left+" sticks remain");
					round = round + 1 ;
					sum = left;
				}
			}
			if (round % 2 ==1)
			{
				System.out.println("Computer wins");
			}
			else
			{
				System.out.println("Players wins");
			}
		}
		
		}
	}

