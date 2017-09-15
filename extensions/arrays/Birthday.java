package arrays;
import cse131.ArgsProcessor;

public class Birthday {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("number of student");
		//int[][] mb = new int[N][2];
		int[][] days = new int[12][31];
		double[] monthfrac= new double[12];
		double[] dayfrac = new double[31];
		//int[][] date = new int [12][31];
		double monthaver=0;
		double dayaver=0;
		for (int i=0;i<N;i++)
		{
			int k=(int)(1+Math.random()*12);
			int j=(int)(1+Math.random()*31);
			days[k-1][j-1]= days[k-1][j-1]+1;
		}
		for(int i =0;i<12;i++)
		{
			for(int j=0;j<31;j++)
			{
				
				monthfrac[i]=monthfrac[i]+days[i][j];
			}
			monthfrac[i]=(double)monthfrac[i]/N;
			monthaver = monthaver+monthfrac[i];
			monthfrac[i]=Math.round(monthfrac[i]*1000)/1000.0;
			System.out.println("The fraction of people born in Month "+(i+1)+" is : "+monthfrac[i]);
		}
		System.out.println("The average of the 12 months is : " +(Math.round(monthaver/12*1000))/1000.0+'\n');
		for(int i =0;i<31;i++)
		{
			for(int j=0;j<12;j++)
			{
				
				dayfrac[i]=dayfrac[i]+days[j][i];
			}
			dayfrac[i]=(double)dayfrac[i]/N;
			dayaver = dayaver+dayfrac[i];
			dayfrac[i]=Math.round(dayfrac[i]*1000)/1000.0;
			System.out.println("the fraction of people born on day "+(i+1)+" is : "+dayfrac[i]);
		}
		System.out.println("The average value of the 31days  "+" is : "+(Math.round(dayaver/31*1000))/1000.0+'\n');
		int t = 0;
		for(int i =0;i<12;i++)
		{
			for(int j=0;j<31;j++)
			{
				if(days[i][j]>1){
					t = t+1;
					System.out.println("The fraction of people born on date: "+(i+1)+"/"+" "+(j+1)+" is : "+Math.round((double)days[i][j]/N*1000)/1000.0);
				}
			}
		}
		if(t==0){
			System.out.println("There is no people born on same day");
		}

	}

}
