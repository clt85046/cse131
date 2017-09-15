package book.ch1;

import cse131.ArgsProcessor;

/*************************************************************************
*  Compilation:  javac Arrays.java
*  Execution:    java Arrays
*
*  Typical array processing code.
*
*  % java Arrays 5
*  a[]
*  -------------------
*  0.04851944273872377
*  0.8311550808965679
*  0.5288965750549762
*  0.5053593215147596
*  0.6162362251917868
*
*  a = [D@f62373
*
*  max = 0.8311550808965679
*  average = 0.5060333290793628
*
*  b[]
*  -------------------
*  0.6162362251917868
*  0.5053593215147596
*  0.5288965750549762
*  0.8311550808965679
*  0.04851944273872377
*
*  dot product of a[] and b[] = 1.1795943990991937
*
*************************************************************************/

public class Arrays {
   public static void main(String[] args) {
	   ArgsProcessor ap = new ArgsProcessor(args);
       int N = ap.nextInt("Size of array?");

       // initialize to random values between 0 and 1
       double[] a = new double[N];
       for (int i = 0; i < N; i++) {
           a[i] = Math.random();
       }

       // print array values, one per line
       System.out.println("a[]");
       System.out.println("-------------------");
       for (int i = 0; i < N; i++) {
           System.out.println(a[i]);
       }
       System.out.println();
       System.out.println("a = " + a);
       System.out.println();

       // find the maximum
       double max = Double.NEGATIVE_INFINITY;
       for (int i = 0; i < N; i++) {
           if (a[i] > max) max = a[i];
       }
       System.out.println("max = " + max);


       // average
       double sum = 0.0;
       for (int i = 0; i < N; i++) {
           sum += a[i];
       }
       System.out.println("average = " + sum / N);

       // copy to another array
       double[] b = new double[N];
       for (int i = 0; i < N; i++) {
           b[i] = a[i];
       }

       // reverse the order
       for (int i = 0; i < N/2; i++) {
           double temp = b[i];
           b[i] = b[N-i-1];
           b[N-i-1] = temp;
       }

       // print array values, one per line
       System.out.println();
       System.out.println("b[]");
       System.out.println("-------------------");
       for (int i = 0; i < N; i++) {
           System.out.println(b[i]);
       }
       System.out.println();


       // dot product of a[] and b[]
       double dotProduct = 0.0;
       for (int i = 0; i < N; i++) {
           dotProduct += a[i] * b[i];
       }
       System.out.println("dot product of a[] and b[] = " + dotProduct);

   }

}
