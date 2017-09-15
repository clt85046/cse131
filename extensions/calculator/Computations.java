package calculator;

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

public class Computations {

	/**
	 * Create the static methods as described on the 
	 * description for this assignment.
	 */
	/**
	 * add function for double
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double addDoubles(double d1, double d2){
		return d1+d2;
	}
	
	/**
	 * subtract function for double
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double subtractDoubles(double d1, double d2){
		return d1-d2;
	}
	
	/**
	 * divide function for double
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double divideDoubles(double d1, double d2){
		if(d2==0){
			return 0;
		}
		return d1/d2;
	}
	
	/**
	 * multiply function for double
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double multiplyDoubles(double d1, double d2){
		return d1*d2;
	}
	
	/**
	 * add function for integer
	 * @param i1
	 * @param i2
	 * @return
	 */
	public static int addInts(int i1, int i2){
		return i1+i2;
	}
	
	/**
	 * subtract function for integer
	 * @param i1
	 * @param i2
	 * @return
	 */
	public static int subtractInts(int i1, int i2){
		return i1-i2;
	}
	
	/**
	 * divide function for integer
	 * @param i1
	 * @param i2
	 * @return
	 */
	public static int divideInts(int i1, int i2){
		if(i2==0){
			return 0;
		}
		return i1/i2;
	}
	
	/**
	 * multiply function for integer
	 * @param i1
	 * @param i2
	 * @return
	 */
	public static int multiplyInts(int i1, int i2){
		return i1*i2;
	}
	
	/**
	 * concatenate function for string
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String concatenate(String s1, String s2){
		return s1+s2;
	}
	
	/**
	 * and function
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static boolean andBoolean(boolean b1, boolean b2){
		return (b1&&b2);
	}
	
	/** 
	 * or function 
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static boolean orBoolean(boolean b1, boolean b2){
		return (b1||b2);
	}
	
	/**
	 * intToDouble function
	 * @param in
	 * @return
	 */
	public static double intToDouble(int in){
		return (double)in;
	}
	
	/**
	 * double to double function
	 * @param in
	 * @return
	 */
	public static double doubleToDouble(double in){
		return in;
	}
	
	/**
	 * String to double function
	 * @param in
	 * @return
	 */
	public static double stringToDouble(String in){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * boolean to double function
	 * @param in
	 * @return
	 */
	public static double booleanToDouble(boolean in){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * int to int function
	 * @param in
	 * @return
	 */
	public static int intToInt(int in){
		return in;
	}
	
	/**
	 * double to int function		
	 * @param in
	 * @return
	 */
	public static int doubleToInt(double in){
		return (int)in;
	}
	
	/**
	 * String to int function
	 * @param in
	 * @return
	 */
	public static int stringToInt(String in){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * boolean to int function
	 * @param in
	 * @return
	 */
	public static int booleanToInt(boolean in){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * int to string function
	 * @param in
	 * @return
	 */
	public static String intToString(int in){
		return ""+in;
	}
	
	/**
	 * double to string function
	 * @param in
	 * @return
	 */
	public static String doubleToString(double in){
		return ""+in;
	}
	
	/**
	 * string to string function
	 * @param in
	 * @return
	 */
	public static String stringToString(String in){
		return in;
	}
	
	/**
	 * boolean to String function
	 * @param in
	 * @return
	 */
	public static String booleanToString(boolean in){
		if(in){
			return "true";
		}
		else{
			return "false";
		}
	}
	
	/**
	 * int to boolean function
	 * @param in
	 * @return
	 */
	public static boolean intToBoolean(int in){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * double to boolean function
	 * @param in
	 * @return
	 */
	public static boolean doubleToBoolean(double in){
		throw new UnsupportedOperationException();
	}

	/**
	 * String to boolean function
	 * @param in
	 * @return
	 */
	public static boolean stringToBoolean(String in){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * boolean to boolean function
	 * @param in
	 * @return
	 */
	public static boolean booleanToBoolean(boolean in){
		return in;
	}
	
	
}
