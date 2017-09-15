package watermelons;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class WatermelonsTest {

	@Test
	public void singleTest() {
		int[] in = { 1, 2, 3 };
		int[] ans = Watermelons.allPairSums(in);
		int[] expect = { 3, 4, 5};
		verifySize(in, ans);
		Arrays.sort(ans);
		if (!Arrays.equals(ans, new int[] { 3, 4, 5})) {
			System.out.println("For input " + Arrays.toString(in));
			System.out.println("Expected " + Arrays.toString(expect));
			System.out.println("But got " + Arrays.toString(ans));
			fail("Wrong result, see output");
		}		
	}

	@Test
	public void testPows() {
		for (int i=1; i < 10; ++i) {
			testPow(i);
		}

	}

	private void testPow(int size) {
		int[] array = genArray(size);
		permute(array);
		int ans[] = Watermelons.allPairSums(array);
		//
		//  Expect size choose 2
		//      = size!  /  (size-2 !  2!)
		//
		verifySize(array, ans);
		for (int e : ans) {
			if (numBitsTrue(e) != 2) {
				fail(" Entry " + e + " not the sum of two elements");
			}
		}

	}

	private void verifySize(int[] in, int[] out) {
		int size = in.length;
		assertEquals("Wrong size of result", size*(size-1)/2, out.length);

	}

	private static int[] genArray(int size) {
		int num = 1;
		int[] ans = new int[size];
		for (int i=0; i < size; ++i) {
			ans[i] = num;
			num = num << 1;
		}
		return ans;
	}

	private static int numBitsTrue(int n) {
		int ans = 0;
		while (n != 0) {
			if ((n & 0x00000001) == 1) {
				++ans;
			}
			n = n >>> 1;
		}
		return ans;
	}

	private static void permute(int[] array) {
		for (int i=array.length-1; i > 0; --i) {
			int loc = (int)(Math.random() * (i+1));
			int t = array[loc];
			array[loc] = array[i];
			array[i] = t;
		}

	}

	public void testPuzzleSolution(int[] theirSoln, int[] ourSoln) {
		int[] allsums = allPairSums(theirSoln);
		verifySize(theirSoln, allsums);
		if (!Arrays.equals(theirSoln, ourSoln)) {
			System.out.println("Your solution does not add up!");
			System.out.println("   Your solution: " + Arrays.toString(theirSoln));
			System.out.println("   Your sums: " + Arrays.toString(allsums));
			System.out.println("   Expected: " + Arrays.toString(ourSoln));
			fail("Wrong solution, see output");
		}
	}

	private static int getFibonacci(int at){
		if (at == 0){
			return 0;
		}
		if (at == 1){
			return 1;
		}
		int x = 0;
		int y = 1;
		int z = 0;
		for (int i=1; i < at; ++i) {
			z = x + y;
			x = y;
			y = z;
		}
		return z;

	}

	private static List<Integer> genIntsSlow() {
		List<Integer> ans = new LinkedList<Integer>();
		for (int i=1; i<12; i++){
			ans.add(i);
		}
		Collections.shuffle(ans);
		return ans.subList(0, 5);
	}
	
	private static List<Integer> genIntsFast() {
		List<Integer> ans = new LinkedList<Integer>();
		for (int i=1; i<9; i++){
			ans.add(i);
		}
		Collections.shuffle(ans);
		return ans.subList(0, 5);
	}
	
	private static int[] genSolution(){
		List<Integer> ans = genIntsFast();
//		List<Integer> ans = genIntsSlow();
		int[] solution = new int[5];
		for (int i = 0; i < 5; i++){
			solution[i] = getFibonacci(ans.get(i));
		}
		
		Arrays.sort(solution);
		return solution;
	}

	public static int[] allPairSums(int[] nums) {
		int spots = 0;
		for (int i = 0; i < nums.length; i++){
			spots = spots + i;
		}
		int[] ans = new int[spots];
		int spot = 0;
		for (int i = 0; i < nums.length; i++){
			for (int j=i+1; j<nums.length; j++){
				ans[spot] = nums[i] + nums[j];
				spot++;
			}
		}
		return ans;
	}
	
	
	@Test
	public void testGetSolution(){
		int[] a = genSolution();
		testPuzzleSolution(Watermelons.getSolution(allPairSums(a)), a);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(Watermelons.getSolution(allPairSums(a))));
//		assertTrue(Watermelons.sameIntArrays(a, Watermelons.getSolution(allPairSums(a))));
	}
	
}
