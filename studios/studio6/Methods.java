package studio6;

public class Methods {

	// Your methods go below this line
	/**
	 * 
	 * @param n :integer n
	 * @return : the factorial of n

	 */
	public static int fact(int n){
		if(n > 0){
			return n*fact(n-1);
		}
		else{
			return 1;
		}
	}
	/**
	 * 
	 * @param n : integer n
	 * @return : Fibonacci sequence of n
	 */
	public static int fib(int n){
		if(n>1){
			return  fib(n-1) + fib(n-2);
		}
		else{
			return n;
		}
	}
	/**
	 * 
	 * @param n : integer n
	 * @return : whether n is odd
	 */
	public static boolean isOdd(int n){
		if(n>0){
			return !isOdd(n-1);
		}
		else{
			return false;
		}
	}
	/**
	 * 
	 * @param a : integer a
	 * @param b : integer b
	 * @return : a+b
	 */
	public static int sum(int a,int b){
		if(b>0){
			return sum(a+1,b-1);
		}
		else{
			return a;
		}
	}
	/**
	 * 
	 * @param n : integer n
	 * @return : n+(n-2)+(n-4)+..
	 */
	public static int sumDownBy2(int n){
		if(n>1){
			return n+sumDownBy2(n-2);
		}
		else{
			if(n>0){
				return 1;
			}
			else{
				return 0;
			}
		}
	}
	/**
	 * 
	 * @param n : integer n
	 * @return : harmonic of n
	 */
	public static double harmonicSum(int n){
		if (n>1){
			return 1.0/n+harmonicSum(n-1);
		}
		else{
			return 1;
		}
	}
	/**
	 * 
	 * @param a :integer a
	 * @param b : integer b
	 * @return : a*b
	 */
	public static int mult(int a,int b){
		if(b>0){
			return a+mult(a,b-1);
		}
		else{
			return 0;
		}
	}
}
