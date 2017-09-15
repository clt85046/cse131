package matrix;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

//written by Arman Guerra, Tim Huber, and Fede Rozenberg

public class GaussianEliminationTest {

	Random rand = new Random();
	@Test
	public void gaussianEliminationTest() {

		for (int i = 0; i < 10; i++){
			
			for(int v = 2; v <= 7; v++){ //test matrices from size 2x2 to 7x7
				
				int[] vars = new int[v];   //this array will hold our variables, which are
				for(int j=0; j<v; j++){    //ultimately what your Gaussian should return
					int var = rand.nextInt(200)-10;
					vars[j] = var;
				}
				
				List<Integer> primeList = Arrays.asList(2,       3,       5,       7,      11,      13,      17,      19,      23, 

						29,      31,      37,      41,      43,      47,      53,      59,      61, 

						67,      71,      73,      79,      83,      89,      97,     101,     103, 

						107 ,    109,     113,     127,     131,     137,     139,     149,     151, 

						157  ,   163,     167,     173,     179,     181,     191,     193,     197, 

						199   ,  211,     223,     227,     229,     233,     239,     241,     251, 

						257    , 263,     269,     271,     277,     281,     283,     293,     307, 

						311     ,313,     317,     331,     337,     347,     349,     353,     359, 

						367     ,373,     379,     383,     389,     397,     401,     409,     419, 

						421     ,431,     433,     439,     443,     449,     457,     461,     463, 

						467     ,479,     487,     491,     499,     503,     509,     521,     523,
						
						541     ,547     ,557     ,563     ,569     ,571     ,577     ,587     ,593,
						
						601     ,607     ,613     ,617     ,619     ,631     ,641     ,643     ,647,
						
						653     ,659     ,661     ,673     ,677     ,683     ,691     ,701     ,709); 
			
				Collections.shuffle(primeList);
				Integer[] primes = primeList.toArray(new Integer[0]);
				
				//we will need v*v coefficients for our matrix
				int[] coeffs = new int[v * v];
				
				//the primes array has been shuffled, so if we choose a random
				//  index from 0 to (primes.length - coeffs.length) we ensure that we 
				//  won't get out of bounds exceptions (because we need exactly coeffs.length
				//  coefficients and subtracting from primes.length is the equivalent of counting
				//  backwards from the end of the primes array) and that we have a pretty random
				//  selection of primes
				int start = rand.nextInt(primes.length - coeffs.length); //start refers to the start index in the primes array
				
				for(int j = 0; j < coeffs.length; j++){
					int coeff = primes[start+j];
					coeffs[j] = coeff;
				}
				
				//to make our coefficient matrix
				double[][] in = new double[v][v];
				
				for(int j = 0; j < in.length; j++){
					for(int k=0; k<in[j].length; k++){
						in[j][k] = coeffs[(j*in.length)+k]; //(j*in.length) + k is the math to map
					}										//an array of length n^2 to its corresponding
				}                                           //nxn array
				Matrix matCoeffs = new Matrix(in);
				
				double[][] constants = new double[in.length][1];
				//to create the constants array, we want to multiply every 
				//  coefficient in a row of coeffs by the corresponding variable 
				//  in vars and sum the entire row
				for(int j = 0; j < constants.length; j++){
					int constant=0;
					for(int k=0; k<vars.length; k++){
						constant += vars[k]*coeffs[(j*constants.length)+k];
					}
					constants[j][0] = constant;
				}
				
				Matrix matConst = new Matrix(constants);
				
				//a little redundancy here: notice that our original array vars is a double[] 
				//but we need the solutions to be in a double[][] to be able to make a 
				//Matrix out of it
				double[][] sols = new double[vars.length][1];
				for(int j = 0; j < vars.length; j++){
					sols[j][0] = vars[j];
				}
				
				Matrix matSols = new Matrix(sols);
				Gaussian gaus = new Gaussian(matCoeffs, matConst);
				Matrix theirSols = gaus.getSolution();
				
				for(int j = 0; j < matSols.getNumRows(); j++){
					if(j == 0){
						System.out.println();
						System.out.println("     Our value   |   Your value");
					}
					System.out.println("Var #" + j +": " + matSols.getValue(j, 0) + "     |     " + theirSols.getValue(j,0));
				}
				
				for(int j = 0; j < matSols.getNumRows(); j++){
					assertEquals(matSols.getValue(j, 0), theirSols.getValue(j, 0),.01);
				}
				
			}
		}
	}

}



