package chords.testing;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import chords.music.Samples;

public class SamplesTest {
	
	private Random rand = new Random();
	
	private void verifySize(Samples samples, int size) {
		assertEquals("Make sure your array in Samples is the right size", size, samples.getNumSamples());
	}

	@Test
	public void testZeroDefault() {
		int size = rand.nextInt(1000)+1;
		Samples samples = new Samples(size);
		verifySize(samples, size);
		for (int i=0; i < size; ++i) {
			verifyZero(samples.getSample(i));
		}
	}
	
	private double[] genArray(int size) {
		double[] ans = new double[size];
		for (int i=0; i < size; ++i) {
			ans[i] = rand.nextDouble();
		}
		return ans;
	}
	
	private double[] genArray() {
		return genArray(rand.nextInt(1000)+1);
	}
	
	@Test
	public void testConstructor() {
		int size = rand.nextInt(1000)+1;
		double[] array = genArray(size);
		double[] arrayCopy = array.clone();
		Samples samples = new Samples(array);
		for (int i=0; i < size; ++i) {
			array[i] = 0.0;
		}
		verifySize(samples, size);
		for (int i=0; i < size; ++i) {
			assertEquals("Array contents must be copied by your constructor, not just assigned from the input parameter", arrayCopy[i], samples.getSample(i), .01);
		}
	}
	
	@Test
	public void testGetNumSamples() {
		assertEquals(0, new Samples(0).getNumSamples());
		assertEquals(100, new Samples(new double[100]).getNumSamples());
	}
	
	@Test
	public void testConcat() {
		double[] one = genArray();
		double[] two = genArray();
		Samples sone = new Samples(one);
		Samples stwo = new Samples(two);
		Samples concat = sone.concat(stwo);
		assertEquals("Concat samples not the right length", one.length+two.length, concat.getNumSamples());
		assertEquals("You are not allowed to modify existing samples in concat.  You must create new samples.",
				sone.getNumSamples(), one.length);
		assertEquals("You are not allowed to modify existing samples in concat.  You must create new samples.",
				stwo.getNumSamples(), two.length);
		for (int i=0; i < one.length; ++i) {
			assertEquals("First array not in concat properly", one[i], concat.getSample(i), .01);
		}
		for (int i=0; i < two.length; ++i) {
			assertEquals("Second array not in concat properly", two[i], concat.getSample(one.length+i), .01);
		}
	}
	
	private void testUnchanged(double[] orig, Samples samp) {
		assertEquals("You may not alter existing samples for combine", samp.getNumSamples(), orig.length);
		for (int i=0; i < orig.length; ++i) {
			assertEquals("You may not alter existing samples for combine", orig[i], samp.getSample(i), .0001);
		}
	}
	
	@Test
	public void testCombine() {
		double[] one = genArray();
		double[] two = genArray();
		Samples sone = new Samples(one);
		Samples stwo = new Samples(two);
		Samples combine = sone.combine(stwo);
		assertEquals("Combined samples should be the max of the two", Math.max(one.length, two.length), combine.getNumSamples());
		for (int i=0; i < Math.max(one.length, two.length); ++i) {
			double check = 0.0;
			if (i < one.length) 
				check += one[i];
			if (i < two.length)
				check += two[i];
			assertEquals("Combined sample should be the sum of the two samples", check, combine.getSample(i), .01);
						
		}
		testUnchanged(one, sone);
		testUnchanged(two, stwo);
	}
	
	@Test
	public void testMaxAndMin() {
		double[] array = genArray(10000);
		Samples samples = new Samples(array);
		double max = samples.getMax();
		double min = samples.getMin();
		for (double d : array) {
			if (d > max) {
				fail("You found the max to be " + max + " but the samples also contain " + d);
			}
			if (d < min) {
				fail("You found the min to be " + min + " but the samples also contain " + d);
			}
		}
	}

	private void verifyZero(double sample) {
		assertEquals("Sample should be zero initially", 0.0, sample, .01);
		
	}

}
