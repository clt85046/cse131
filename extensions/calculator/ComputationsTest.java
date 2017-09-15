package calculator;

/**
 * unit test by Arman Hemmati
 * misspelled methods fixed by Jyoti Parwatikar
 */
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class ComputationsTest {
	private static Random r = new Random();


	@Test
	public void addDoublesTest() {
		for (Double[] ds : genDoubles()) {
			assertEquals(ds[0] + ds[1], Computations.addDoubles(ds[0], ds[1]), .1);
		}
	}
	@Test
	public void subtractDoublesTest() {
		for (Double[] ds : genDoubles()) {
			assertEquals(ds[0] - ds[1], Computations.subtractDoubles(ds[0], ds[1]), .1);
		}
	}
	@Test
	public void multiplyDoublesTest() {
		for (Double[] ds : genDoubles()) {
			assertEquals(ds[0] * ds[1], Computations.multiplyDoubles(ds[0], ds[1]), .1);
		}
	}
	@Test
	public void divideDoublesTest() {
		for (Double[] ds : genDoubles()) {
			if (ds[1] != 0.0)
				assertEquals(ds[0] / ds[1], Computations.divideDoubles(ds[0], ds[1]), .1);
		}
		assertEquals("Your code is not handling dividing by zero correctly!",Computations.divideDoubles(1, 0), 0, .00000001);
	}

	private static List<Double[]> genDoubles() {
		List<Double[]> ans = new LinkedList<Double[]>();
		for (int i=0; i < 100; ++i) {
			ans.add(new Double[] { r.nextDouble(), r.nextDouble() });
		}
		return ans;
	}

	@Test
	public void addIntsTest() {
		for (int[] is : genInts()) {
			assertEquals(is[0] + is[1], Computations.addInts(is[0], is[1]), .1);
		}
	}

	@Test
	public void subtractIntsTest() {
		for (int[] is : genInts()) {
			assertEquals(is[0] - is[1], Computations.subtractInts(is[0], is[1]), .1);
		}
	}
	@Test
	public void multiplyIntsTest() {
		for (int[] is : genInts()) {
			assertEquals(is[0] * is[1], Computations.multiplyInts(is[0], is[1]), .1);
		}
	}
	@Test
	public void divideIntsTest() {
		for (int[] is : genInts()) {
			if (is[1] != 0)
				assertEquals(is[0] / is[1], Computations.divideInts(is[0], is[1]), .1);
		}
		assertEquals("Your code is not handling dividing by zero correctly!",Computations.divideDoubles(1, 0), 0, .00000001);
	}

	private static List<int[]> genInts() {
		List<int[]> ans = new LinkedList<int[]>();
		for (int i=0; i < 100; ++i) {
			ans.add(new int[] { r.nextInt(), r.nextInt() });
		}
		return ans;
	}
	
	private static char[] alpha = new char[26];
	static {
		for (char c = 'a'; c <= 'z'; ++c) {
			alpha[c-'a'] = c;
		}
	}


	private String genRandomString() {
		int length = r.nextInt(100);
		String ans = "";
		for (int i=0; i < length; ++i) {
			ans = ans + alpha[r.nextInt(alpha.length)];
		}
		return ans;
	}
	
	@Test
	public void concatenationTest(){
		String s1= genRandomString();
		String s2= genRandomString();
		assertEquals(s1+s2, Computations.concatenate(s1, s2));
		assertEquals(s2+s1, Computations.concatenate(s2, s1));		
	}

	@Test
	public void andTest(){
		for (boolean b1 : new boolean[] { true, false }) {
			for (boolean b2 : new boolean[] { true, false})  {
				assertEquals(b1 && b2, Computations.andBoolean(b1,b2));
			}
		}
	}

	@Test
	public void orTest(){
		for (boolean b1 : new boolean[] { true, false }) {
			for (boolean b2 : new boolean[] { true, false})  {
				assertEquals(b1 || b2, Computations.orBoolean(b1,b2));
			}
		}
	}

	@Test
	public void intToIntTest(){
		for (int[] is : genInts()) {
			assertEquals(is[0], Computations.intToInt(is[0]));
		}
	}

	@Test
	public void doubleToIntTest(){
		for (int i=0; i<5; i++){
			double x = Math.random()*50;
			assertEquals((int)x, Computations.doubleToInt(x));
		}
	}

	@Test
	public void stringToIntTest(){
		try{
			Computations.stringToInt("");
			fail("ints can not be converted to booleans. You must throw an exception");
		} catch(UnsupportedOperationException e){
			//cool
		}
	}

	@Test
	public void booleanToIntTest(){
		try{
			Computations.booleanToInt(true);
			fail("booleans can not be converted to ints. You must throw an exception");
		} catch(UnsupportedOperationException e){
			//cool
		}
	}

	@Test
	public void intToDoubleTest(){
		for (int i=0; i<5; i++){
			double x = (Math.random()*50);
			int y = (int)x;
			assertEquals(x, Computations.intToDouble(y), 1);
		}
	}

	@Test
	public void doubleToDoubleTest(){
		for (int i=0; i<5; i++){
			double x = r.nextDouble()*50;
			assertEquals(x, Computations.doubleToDouble(x), .1);
		}
	}

	@Test
	public void stringToDoubleTest(){
		try{
			Computations.stringToDouble("");
			fail("strings can not be converted to doubles. You must throw an exception");
		} catch(UnsupportedOperationException e){
			//cool
		}
	}

	@Test
	public void booleanToDoubleTest(){
		try{
			Computations.booleanToDouble(true);
			fail("booleans can not be converted to doubles. You must throw an exception");
		} catch(UnsupportedOperationException e){
			//cool
		}
	}

	@Test
	public void intToStringTest(){
		for (int i=0; i<5; i++){
			int x = (int)Math.random()*50;
			assertEquals("" + x, Computations.intToString(x));
		}
	}

	@Test
	public void doubleToStringTest(){
		for (int i=0; i<5; i++){
			double x = Math.random()*50;
			assertEquals("" + x, Computations.doubleToString(x));
		}
	}

	@Test
	public void stringToStringTest(){
		for (int i=0; i<5; i++){
			double x = Math.random()*50;
			String y = "" + x;
			assertEquals("" + x, Computations.stringToString(y));
		}
	}

	@Test
	public void booleanToStringTest(){
		boolean x = true;
		String y = "" + x;
		assertEquals(y, Computations.booleanToString(x));
		x = false;
		y = "" + x;
		assertEquals(y, Computations.booleanToString(x));				
	}

	@Test
	public void intToBooleanTest(){
		try{
			Computations.intToBoolean(0);
			fail("ints can not be converted to booleans. You must throw an exception");
		} catch(UnsupportedOperationException e){
			//cool
		}
	}

	@Test
	public void doubleToBooleanTest(){
		try{
			Computations.doubleToBoolean(0);
			fail("doubles can not be converted to booleans. You must throw an exception");
		} catch(UnsupportedOperationException e){
			//cool
			System.out.print("sad"
					+ "");
		}
	}

	@Test
	public void stringToBooleanTest(){
		try{
			Computations.stringToBoolean("");
			fail("strings can not be converted to booleans. You must throw an exception");
		} catch(UnsupportedOperationException e){
			//cool
		}
	}

	@Test
	public void booleanToBooleanTest(){
		boolean b = true;
		assertEquals(b, Computations.booleanToBoolean(b));
	}
}
