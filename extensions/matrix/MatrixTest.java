package matrix;

import java.util.Random;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author Ron Cytron, Arman Guerra, Fede Rozenberg, Jyoti Parwatikar
 *
 */
public class MatrixTest extends TestCase {

	double[][] values = new double[][] { 
			{ 1, 2, 3},
			{ 4, 5, 6}
	};

	Matrix m1 = new Matrix(
			values
			);

	Matrix m1too = new Matrix(
			new double[][] { 
					{ 1, 2, 3},
					{ 4, 5, 6}
			}
			);


	Matrix m1Plusm1 = new Matrix(
			new double[][] { 
					{ 2, 4, 6},
					{ 8, 10, 12}
			}
			);

	Matrix prod = new Matrix(
			new double[][] {
					{14, 32},
					{32, 77}
			}
			);

	Matrix addedRow = new Matrix (
			new double[][] {
					{1, 2, 3},
					{5, 7, 9}

			}
			);
	
	@Test
	public void testarraysAreEqual(){
		int x = (int)(Math.random()*20+1);
		int y = (int)(Math.random()*20+1);
		int z = y + 1;
		double[][] one = new double[x][y];
		double[][] two = new double[x][y];
		double[][] three = new double[y][z];
		for (int i = 0; i<100; i++){
			for (int j = 0; j < x; j++){
				for (int k = 0; k<y; k++){
					double rand = Math.random();
					one[j][k] = rand;	
					two[j][k] = rand+1;
				}
			}
			for (int j = 0; j < y; j++){
				for (int k = 0; k < z; k++){
					three[j][k] = Math.random();
				}
			}	
			Matrix m1 = new Matrix(one);
			Matrix m1a = new Matrix(one);
			Matrix m2 = new Matrix(two);
			Matrix m3 = new Matrix(three);
			assertTrue("These two arrays are equal but youre saying that they're not!", m1.equals(m1a));
			assertTrue("These two arrays are not equal but youre saying that they are!", !m1.equals(m2));
			assertTrue("These two arrays are different sizes buut youre saying that they're equal!", !m3.equals(m2));
		}
	}

	@Test
	public void testScaleRow(){
		for (int i = 0; i < 100; i++){
			int x = (int)(Math.random()*20+2);
			int y = (int)(Math.random()*20+1);
			double factor = Math.random();
			double[][] mat = new double[x][y];
			for (int j = 0; j < x; j++){
				for (int k = 0; k < y; k++){
					mat[j][k] = Math.random();
				}
			}
			double[][] cone = mat.clone();
			Matrix c = new Matrix(cone);
			c.scaleRow((int)x/2, factor);
			for(int j = 0; j < y; j++){
				assertEquals(c.getValue((int)x/2,j), mat[(int)x/2][j]*factor, .1); 
			}

		}
	}


		@Test
		public void testinit() {
			assertEquals(m1, m1);
			assertEquals(m1too, m1too);
			assertEquals("Implement arraysAreEqual", m1, 
					m1too);
			assertEquals(m1too, m1);
	
			double save = values[1][1];
			values[1][1] = 0; // Matrix should have copied this array, so this assignment should have no effect
	
			assertEquals("Matrix constructor failed to copy the array", m1, m1too);
	
			assertFalse(m1.equals(m1Plusm1));
			assertFalse(m1Plusm1.equals(m1too));
			values[1][1] = save;
		}

	@Test
	public void testTimes() {
		assertEquals(prod, m1.times(m1.transpose()));
	}

	@Test
	public void testScale() {
		Matrix m1copy = new Matrix(values);
		m1copy.scaleRow(0, 2);
		m1copy.scaleRow(1, 2);
		assertEquals(m1copy, m1Plusm1);
	}

	@Test
	public void testAddRow() {
		Matrix m1copy = new Matrix(values);
		m1copy.addRows(0, 1);
		assertEquals(m1copy, addedRow);
	}


	/*
	 * The following tries to add a 2x3 matrix to its transpose,
	 * which should throw an error.  The test case expects the error.
	 */
	@Test
	public void testbadPlus() {
		try {
			m1.plus(m1.transpose());
		}
		catch (IllegalArgumentException e) {
			return;
		}
		fail("Need to throw new IllegalArgumentException() for bad inputs");
	}

	@Test
	public void testPlus(){
		for (int i = 0; i < 10; i++){
			int x = (int)(Math.random()*20 + 1);

			double[][] one = new double[x][x];

			for (int j = 0; j < x; j++){
				for (int k = 0; k< x; k++){
					one[j][k] = Math.random();
				}
			}

			Matrix m = new Matrix(one);
			Matrix doub = m.plus(m);
			for (int j = 0; j < x; j++){
				for (int k = 0; k< x; k++){
					assertEquals(doub.getValue(j, k), one[j][k]*2, .01);
				}
			}
		}
	}

	/**
	 * The following multiplies a 2x3 matrix by itself, which should
	 * throw an error.  Remember:  the number of columns of the first matrix
	 * should equal the number of rows in the second matrix.
	 */
	@Test
	public void testbadTimes() {
		try {
			m1.times(m1);
		}
		catch (IllegalArgumentException e) {
			return;
		}
		fail("Need to throw new IllegalArgumentException() for bad inputs");
	}

	/**
	 * Trying to scale a row that is out-of-bounds, which should throw
	 * an error.
	 */
	@Test
	public void testbadScale() {
		try {
			m1.scaleRow(values.length, 1.0);
		} catch(IllegalArgumentException e) {
			return;
		}
		fail("Need to throw new IllegalArgumentException() for bad inputs");
	}

	@Test
	public void testTranspose() {
		Matrix trans = m1.transpose();
		assertFalse(m1.equals(trans));
		assertEquals(m1, m1.transpose().transpose());
		for (int i = 0; i < 10; i++){
			int x = (int)(Math.random()*20 + 1);
			int y = (int)(Math.random()*20 + 1);
			double[][] neugh = new double[x][y];
			for (int j = 0; j < x; j++){
				for (int k = 0; k < y; k++){
					neugh[j][k] = Math.random();
				}
			}
			Matrix naeut = new Matrix(neugh);
			Matrix gnaioulle = naeut.transpose();
			for (int j = 0; j < x; j++){
				for (int k = 0; k < y; k++){
					assertEquals(naeut.getValue(j, k), gnaioulle.getValue(k,j));
				}
			}
		}
	}

	@Test
	public void print() {
		System.out.println("m1: " + m1);
		System.out.println("m1 transpose " + m1.transpose());
		System.out.println("m1 x m1.transpose() " + m1.times(m1.transpose()));
	}
	
	@Test
	public void testExchange() {
		for(int i=0; i<10; i++){
			int a = new Random().nextInt(4);
			int b = new Random().nextInt(4);
			
			while(b==a){
				b = new Random().nextInt(4);
			}
			double[][] test = new double[5][5];
			double[][] test2 = new double[5][5];
			
			for(int j=0; j<test[a].length; j++){
				test[a][j]=1;
				test[b][j]=2;
				test2[a][j]=2;
				test2[b][j]=1;
			}
			
			Matrix testExchange = new Matrix(test);
			Matrix testExchange2 = new Matrix(test2);
			testExchange.exchangeRows(a, b);
			for(int j=0; j<test.length; j++){
				for(int k=0; k<test[j].length; k++){
					assertEquals(testExchange.getValue(j,k), testExchange2.getValue(j,k));
				}
			}
		}
	}

}
