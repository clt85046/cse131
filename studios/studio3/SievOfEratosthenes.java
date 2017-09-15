package studio3;
import cse131.ArgsProcessor;
public class SievOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);	
		int n = ap.nextInt("enter length of array");
		int[] nums = new int[n];
		int k =0;
		int x = 0;
		for (int i = 0;i < n;i++)
		{
			nums[i] = i+2;
		}
		for (int i=0;i<n;i++)
		{
			if(nums[i]!=0)
			{    
				x = x+1;
				for (int j = i+1;j < n ;j++)
				{
					if (nums[j] % nums[i] == 0)
					{
						nums[j]=0;
					}
				}	
			}
		}
		int[] primes = new int[x];
		for (int i = 0;i < n; i++)
		{
			if(nums[i]!=0)
			{   
				primes[k]=nums[i];
				k = k+1;
			}
		}
		System.out.print("Primes under "+n+" = ");
        for (int i = 0;i < primes.length;i++)
		{
			if(i<primes.length-1)
			{
				System.out.print(primes[i]+", ");	
			}
			else
			{
				System.out.print(primes[i]);
			}
        	
		}

	}

}
