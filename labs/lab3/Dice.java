package lab3;

import cse131.ArgsProcessor;

public class Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);	
        int N = ap.nextInt("Enter the number of dice used in this simulation");
        int t = ap.nextInt("Enter the number of times the dice are thrown.");
        int[][] diceThrown = new int[t][N];
        int[] sum = new int[t];
        int[] sumtimes = new int[5*N+1];
        int sametimes = 0;
        for (int i=0;i<5*N+1;i++)
        {
        	sumtimes[i] = i+N;
        }
        for (int i=0;i<t;i++)
        {
        	for (int j=0;j<N;j++)
        	{
        		diceThrown[i][j] = (int) (Math.random()*6)+1;
        		sum[i]=sum[i]+diceThrown[i][j];
        	}
        }
        for (int i=0;i<t;i++)
        {   int sameNumberEachTime =1;
        	int k = diceThrown[i][0];
        	for (int j=1;j<N;j++)
        	{
        		if(diceThrown[i][j]==k)
        		{
        			sameNumberEachTime++;
        		}
        	}
        	if(sameNumberEachTime==N)
        	{
        		sametimes=sametimes+1;
        	}
        }
        for (int i=0;i<t;i++)
        {
        	System.out.println("The sum of the "+(i+1)+"th throw is "+sum[i]);
        	System.out.println("The number of the "+(i+1)+"th throw are :");
        	for (int j=0;j<N;j++)
        	{
        		System.out.println(diceThrown[i][j]);
        	}
        	System.out.println();
        }
        
        System.out.println(" same value times is "+sametimes);
        System.out.println(" same value times fraction is "+((double)sametimes/t));
        
        for (int i=0;i<5*N+1;i++)
        {   int times = 0;
        	for (int j=0;j<t;j++)
        	{
        		if(sumtimes[i]==sum[j])
        		{
        			times = times + 1;
        		}
        	}
        	System.out.println("Number of times Sum "+sumtimes[i]+" was seen is "+times);
        	System.out.println("Number of times Sum "+sumtimes[i]+" occurs "+((double)times/t*100)+ "% of all of the throws "+'\n');
        }
	}

}
