package business;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * A class to represent Money. It assumes that all Money objects will be represented in Dollars, 
 * and provides the necessary arithmetic and accessor methods. All Money objects have a scale of two
 * to ensure accuracy.
 * @author dshook
 *
 */
public class Money implements Comparable<Money>{
	
	private final int scale = 2;
	private final RoundingMode rounding = RoundingMode.HALF_UP;
	
	/**
	 * A constructor that builds a Money object by passing the given string to a BigDecimal and setting the scale.
	 * @param s String value representing the amount of money to be stored in the object.
	 */
	public Money(String s) {
		value = new BigDecimal(s);
		value = value.setScale(scale, rounding);
	}
	
	/**
	 * A constructor that builds a Money object by passing the given double to a BigDecimal (first converting it to a String) and setting the scale.
	 * @param d double value representing the amount of money to be stored in the object.
	 */
	public Money(double d) {
		value = new BigDecimal(String.valueOf(d));
		value = value.setScale(scale, rounding);
	}
	
	/**
	 * A constructor that builds a Money objects by storing the given BigDecimal object, after setting the proper scale.
	 * @param bd the BigDecimal object that represents the amount of money to be stored.
	 */
	public Money(BigDecimal bd) {
		value = bd.setScale(scale, rounding);
	}
	
	/**
	 * Returns the value currently stored within this Money object.
	 * @return value of this Money object, with a scale of 2.
	 */
	public BigDecimal getValue() {
		return value;
	}
	
	public double getDoubleValue() {
		return value.doubleValue();
	}
	
	/**
	 * Sums the supplied Money object with this money object.
	 * @param a the amount of Money to be added.
	 * @return a new Money object that is the sum of the value of this Money object and the supplied Money object, with a scale of 2.
	 */
	public Money plus(Money a) {
		return new Money(value.add(a.getValue()));
	}
	
	/**
	 * Computes the difference of the supplied Money object subtracted from this money object.
	 * @param s the amount to be subtracted
	 * @return a new Money object that represents this - s, with a scale of 2.
	 */
	public Money minus(Money s) {
		return new Money(value.subtract(s.getValue()));
	}
	
	/**
	 * Multiplies the current Money object by the supplied factor.
	 * @param f the factor to multiply by.
	 * @return a new Money object with the value of this * f, with a scale of 2.
	 */
	public Money times(double f) {
		return new Money(value.multiply(new BigDecimal(String.valueOf(f))));
	}
	
	/**
	 * Divides the current money object by the supplied divisor
	 * @param d the value to be used as the divisor.
	 * @return a new Money object with the value of this / d, with a scale of 2.
	 */
	public Money divide(double d) {
		return new Money(value.divide(new BigDecimal(String.valueOf(d)), scale, rounding));
	}
	
	/**
	 * Returns the absolute value of this Money object.
	 * @return a new Money object that contains the absolute value of this one.
	 */
	public Money abs() {
		if(value.compareTo(BigDecimal.ZERO) < 0)
			return this.times(-1);
		return this;
	}
	
	/**
	 * Negates the value of this Money object.
	 * @return a new Money object that is the negation of the current Money object, with a scale of 2.
	 */
	public Money negate() {
		return this.times(-1);
	}
	
	/**
	 * Returns the string representation of this Money object, assuming that the value is in Dollars.
	 */
	public String toString() {
		return "$" + value;
	}
	
	/**
	 * Compares this object to the given Money object c. Returns -1, 0, or 1 if this object is less than, equal to, or greater than c. Scale is ignored in this comparison (i.e. 10 compared to 10.00 == 0).
	 */
	public int compareTo(Money c) {
		return value.compareTo(c.getValue());
	}
	
	/**
	 * Compares two Money objects and determines if they are equal, ignoring scale (i.e. 10 compared to 10.00 would return true).
	 * @param c the object of comparison
	 * @return true if the Money objects are equal in value.
	 */
	public boolean equals(Money c) {
		return this.compareTo(c) == 0;
	}
	
	private BigDecimal value;	
	
	public static void main(String args[]) {
		Money m1 = new Money("10");
		Money m2 = new Money("10.22323423234234234");
		Money m3 = new Money("10.225");
		
		System.out.println(m1 + " " + m2 + " " + m3);
	}
}
