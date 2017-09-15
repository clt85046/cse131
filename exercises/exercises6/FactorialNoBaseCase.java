package exercises6;

public class FactorialNoBaseCase {
	
	public static int factorial(int n) {
		return n * factorial(n-1);
	}

	public static void main(String[] args) {
		int ans = factorial(2);
		System.out.println("Answer is " + ans);
	}
}
