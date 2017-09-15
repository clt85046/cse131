package netpresentvalue;

import static org.junit.Assert.*;

import org.junit.Test;

public class NPVTester {
	/**
	 * Based on the write up, 
	 *    what is a dollar worth fifty years from now?
	 */
	
	@Test
	public void dollarWorthInFiftyYears() {
		double dw = NPV.futureValue(1, 50, 0.10);
		assertEquals("Dollar fifty years from now", 117, dw, 1.0);
	}
	
	/**
	 * Based on the write up,
	 *    if I received $1 fifty years from now, what is that 
	 *    dollar's value today?
	 */
	@Test
	public void futureDollarWorthNow() {
		double dw = NPV.presentValue(1, 50, 0.10);
		assertEquals("Dollar from fifty ywars worth now", 0.0085, dw, 0.001);
	}

	/**
	 * Based on the story of two friends 
	 *    in the description for this assignment
	 */
	@Test
	public void twoFriends() {
		double friendOne = NPV.presentValue( 5,  0, 0.10);
		double friendTwo = NPV.presentValue(10, 50, 0.10);
		assertEquals("Friend one's present value", 5.0,  friendOne,  0.1 );
		assertEquals("Friend two's present value", 0.08, friendTwo,  0.01);
	}
	
	/**
	 * Produce the table and result from the product development
	 *    story on the web page for this assignment
	 */

	@Test
	public void productStory() {
		//
		// Story parameters
		//
		int investment = 100000;
		int payout     = 10000;
		double r       = 0.10;
		double net     = 0.0;
		
		//
		// Yearly activity
		//
		double[] cashFlows = new double[] {
				-investment,
				payout, payout, payout, payout,
				payout, payout, payout, payout,
				payout, payout, payout, payout,
		};
		for (int year=0; year<cashFlows.length; ++year) {
			double thisYear = NPV.presentValue(cashFlows[year], year, r);
			net = net + thisYear;
			System.out.println("Year " + String.format("%2d",year) + " Computaton Result  " + String.format("%10.2f", thisYear) + " Net Present Value " + String.format("%10.2f",net));
		}
		//
		// Check final result
		//
		assertEquals("Final net value", -31863, net, 1.0);
	}
	
	/**
	 * Repeat of the story, measuring just the final outcome
	 *   and testing the netPresentValue method
	 */
	@Test
	public void testNPV() {
		double net = NPV.netPresentValue(100000, 12, 10000, 0.10);
		assertEquals("Product development story NPV", -31863, net, 1.0);
	}
}
