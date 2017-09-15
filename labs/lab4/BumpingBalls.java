package lab4;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class BumpingBalls {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
    	int ballnumber = ap.nextInt("Enter number of balls:");
    	int iternumber = ap.nextInt("Enter number of iterations:");
    	int pause = ap.nextInt("Enter pause time:");
    	double radius =0.05;
    	int p =0;
    	double[] vx=new double[ballnumber];
    	double[] rx=new double[ballnumber];
    	double[] ry=new double[ballnumber];
    	double[] vy=new double[ballnumber];
    	
    	StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        for (int i=0;i<ballnumber;i++)
        {
        	rx[i] = Math.random();ry[i] = Math.random(); 
        	vx[i] = Math.round(Math.random()*1000)/25000.0+0.02;
        	vy[i] =  Math.round(Math.random()*1000)/25000.0+0.02;
        	//System.out.println(vx);
        	//System.out.println(vy);
        }
        	 while(p<iternumber) { 
        		 StdDraw.setPenColor(StdDraw.GRAY);
                 StdDraw.filledSquare(0, 0, 1.0);
        		 for (int i=0;i<ballnumber;i++)
        		 {
        			 if (Math.abs(rx[i] + vx[i]) > 1.0 - radius) vx[i] = -vx[i];
                     if (Math.abs(ry[i] + vy[i]) > 1.0 - radius) vy[i] = -vy[i];
                     for(int t=0;t<ballnumber;t++)
                     {
                    	if(t!=i)
                    	 {
                    		 if (Math.sqrt(Math.abs(rx[i] - rx[t])*Math.abs(rx[i] - rx[t])+Math.abs(ry[i] - ry[t])*Math.abs(ry[i] - ry[t]))<=2*radius)
                    		 {
                    			 vx[i] = -vx[i]; vy[i] = -vy[i];vy[t] = -vy[t];vx[t] = -vx[t];
                    		 }
                    	 }
                     }

                     // update position
                     rx[i] = rx[i] + vx[i]; 
                     ry[i] = ry[i] + vy[i]; 

                     // clear the background
                     

                     // draw ball on the screen
                     StdDraw.setPenColor(StdDraw.BLACK); 
                     StdDraw.filledCircle(rx[i], ry[i], radius); 

                     // display and pause for 20 ms
                     
                    
        		 }
                 // bounce off wall according to law of elastic collision
        		
                 StdDraw.show(pause); 
                p=p+1;
                
             } 

        
	}

}
