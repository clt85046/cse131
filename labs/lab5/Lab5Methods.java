package lab5;

public class Lab5Methods {
	/**
	 * @param n :integer n
	 * @return :return sum of postive integer n + (n-2) + (n-4) +...
	 */
	public static int sumDownBy2(int n){
		int sum=0;
		for (int i=0;i<=n;i=i+2)
		{
			if(n-i>=0)
			{
				sum = sum+n-i;
			}
		}
		return sum;
	}
	/**
	 * 
	 * @param n:a positive integer, n
	 * @return :the sum 1 + 1/2 + 1/3 +... + 1/(n-1) + 1/n
	 */
	public static double harmonicSum(int n){
		double sum=0.0;
		for (int i=1;i<=n;i++)
		{
			sum = sum+1.0/i;
		}
		return sum;
	}
	/**
	 * 
	 * @param k: a non-negative integer, k
	 * @return : : the sum 1 + 1/2 + 1/4 + 1/8 + ... + 1/Math.pow(2,k)
	 */
	public static double geometricSum(int k){
		double sum=0;
		for (int i=0;i<=k;i++)
		{
			sum = sum+1/Math.pow(2, i);
		}
		return sum;
	}
	/**
	 * 
	 * @param j :integer j
	 * @param k :integer k
	 * @return : the product of abs of j*k
	 */
	public static int multPos(int j,int k){
		j = Math.abs(j);
		k = Math.abs(k);
		int sum = 0;
		for (int i=0;i<j;i++){
			sum = sum + k;
		}
		return sum;
	}
	/**
	 * 
	 * @param j : integer j
	 * @param k : integer k
	 * @return : the product of j * k
	 */
	public static int mult(int j,int k){
		int x;
		if((j>=0&&k>=0)||(j<0&&k<0))
		{
			x=multPos(j,k);
		}
		else
		{
			x=multPos(j,k)*(-1);
		}
		return x;
		
	}
/**
 * 
 * @param n : integer n
 * @param k : integer k,where k>0
 * @return : the value of n to the power k
 */
	public static int expt(int n,int k){
		int expt=0;
		if(k==0)
		{
			expt=1;
		}
		if(k > 0)
		{
			expt = n;
		}
			
		for(int j = 0; j < k - 1; j++)
		{
			expt = expt * n;
			//System.out.println("expt "+expt+" n "+n+" j "+j);
		}
		return expt;
	}
	
 


}
