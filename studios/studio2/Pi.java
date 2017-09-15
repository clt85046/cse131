package studio2;
public class Pi {

  public static void computePi() {
     double ans = 0.0;
     int numbers=0;
      for (int i=0;i<=5000;i++)
      {
    	  if (Math.random()>0.21)
    	  {
    		  numbers=numbers+1;
    	  }
      }
      ans = ((double)numbers/5000.0)*4;
     //  fill in to compute ans = Pi

     System.out.println("Our group shows Pi = " + ans);
  }

  public static void main(String[] args) {
     computePi();
  }
}
