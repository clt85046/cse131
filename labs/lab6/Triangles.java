package lab6;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class Triangles {
	/**
	 * 
	 * @param x :x position of left bottom point
	 * @param y :y position of left bottom point
	 * @param size :size of triangles 
	 */
	public static void triangles(double x,double y,double size){
		if(size<0.05){
			return;
		}
		double[] x1 = {x,x+size,x+size/2};
		double[] x2 =  {x+size/4,x+size/2+size/4,x+size/2};
		double[] y1 = {y,y,y+size};
		double[] y2 = {y+size/2,y+size/2,y};
		StdDraw.setPenColor(Color.black);
		StdDraw.filledPolygon(x1, y1);
		//StdDraw.line(x,y,x+size,y);
		//StdDraw.line(x+size,y,x+size/2,y+size);
		//StdDraw.line(x+size/2,y+size,x,y);
		StdDraw.setPenColor(Color.white);
		StdDraw.filledPolygon(x2, y2);
		//StdDraw.line(x+size/4, y+size/2, x+size/2+size/4, y+size/2);
		//StdDraw.line(x+size/2+size/4, y+size/2, x+size/2, y);
		//StdDraw.line(x+size/2, y, x+size/4, y+size/2);
		triangles(x,y,size/2);
		triangles(x+size/4,y+size/2,size/2);
		triangles(x+size/2, y,size/2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Math.pow(2, 1));
		triangles(0,0,1);
	}

}
