package arrays;
import cse131.ArgsProcessor;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);	
		int N = ap.nextInt("enter number of rows");
		N = N+1;
		if(N<=0){
			
		}
		else{
			
		
		int[][] tri = new int[N][N];
		for (int i=0;i<N;i++)
		{
			for (int j=0;j<=i;j++)
			{
				if(j==0||j==i)
				{
					tri[i][j]=1;
				}
				else
				{
					tri[i][j]=tri[i-1][j-1]+tri[i-1][j];
				}
			}
		}
		for (int i=0;i<N;i++)
		{
			for (int j=0;j<=i;j++)
			{
				System.out.print(tri[i][j]);
			}
			System.out.println();
		}
	}

}
}
	