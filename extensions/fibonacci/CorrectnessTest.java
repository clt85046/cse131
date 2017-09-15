package fibonacci;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class CorrectnessTest {
	
	private static int[] fibNums = new int[]{0,1,1,2,3,5,8,13,21,34,55,89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811};

	@Test
	public void test() {
		for(int i=0; i<50; i++){
			int a = new Random().nextInt(fibNums.length);
			assertEquals(fibNums[a], Fibonacci.recursive(a));
			assertEquals(fibNums[a], Fibonacci.iterative(a));
		}
	}

}
