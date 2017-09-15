package book.ch3;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.Picture;

/*************************************************************************
 *  Compilation:  javac Fade.java
 *  Execution:    java Fade N image1.jpg image2.jpg
 *  Data files:   http://introcs.cs.princeton.edu/31datatype/Darwin.jpg
 *                http://introcs.cs.princeton.edu/31datatype/mandrill.jpg
 *
 *  Produce animated effect, fading from image1.jpg to image2.jpg,
 *  using N-1 intermediate frames.
 *  
 *
 *************************************************************************/



public class Fade {

    public static Color combine(Color c1, Color c2, double alpha) {
        int r = (int) (alpha * c1.getRed()   + (1 - alpha) * c2.getRed());
        int g = (int) (alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
        int b = (int) (alpha * c1.getBlue()  + (1 - alpha) * c2.getBlue());
        return new Color(r, g, b);
    }

    public static void main(String[] args) {
    	ArgsProcessor ap = new ArgsProcessor(args);
        int N = ap.nextInt("Enter number of frames:");     // # of frames
        String s1 = ArgsProcessor.chooseFile("images").toString();
        String s2 = ArgsProcessor.chooseFile("images").toString();
        Picture pic1 = new Picture(s1);   // begin picture
        Picture pic2 = new Picture(s2);   // end picture
        int width  = Math.min(pic1.width(),pic2.width());
        int height = Math.min(pic1.height(), pic2.height());
        Picture pic = new Picture(width, height);
        for (int n = 0; n <= N; n++) {
            double alpha = 1.0 * n / N;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    Color c1 = pic1.get(i, j);
                    Color c2 = pic2.get(i, j);
                    pic.set(i, j, combine(c2, c1, alpha));
                }
            }
            pic.show();
        }
    }
}
