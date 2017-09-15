package studio5;

public class Methods {
	
	/**
	 * Implemented correctly
	 * @param x one thing to add
	 * @param y the other thing to add
	 * @return the sum
	 */
	public static int sum(int x, int y) {
		return x+y;
	}
	
	/**
	 * 
	 * @param x one factor
	 * @param y another factor
	 * @return the product of the factors
	 */
	public static int mpy(int x, int y) {
		return x*y;  // FIXME
	}
	public static double avg3(double x, double y,double z){
		return (x+y+z)/3;
	}
	public static double sumArray(double[] x){
		double sum = 0;
		for (int i = 0;i<x.length;i++)
		{
			sum = sum + x[i];
		}
		return sum;
	}
	public static double average(double[] x){
		double sum = 0;
		for (int i = 0;i<x.length;i++)
		{
			sum = sum + x[i];
		}
		return sum/x.length;
	}
	public static String pig(String x){
		String y = x.substring(0,1)+"ay";
		y = x.substring(1)+y;
		return y;
	}
	


}
