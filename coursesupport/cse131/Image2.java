package cse131;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Image2 extends AugmentedJPanel{

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_SIZE = 128;
	private double rotation;
	private double scaleFactor = 1;
	private ImageRaster raster;

	/**
	 * Creates a new Image with a default width and height.
	 */
	public Image2() {
		this(DEFAULT_SIZE, DEFAULT_SIZE);
	}

	/**
	 * Creates a new Image with the given width and height.
	 * @param width in pixels
	 * @param height in pixels
	 */
	public Image2(int width, int height) {
		  this(new ImageRaster(width,height));
	}

	Image2(ImageRaster raster) {
		setRaster(raster);
		setSize(raster.getWidth(),raster.getHeight());
		setLineColor(Color.WHITE);
		
	}
	
	private void setRaster(ImageRaster raster) {
		if (raster == null)
			throw new IllegalArgumentException("The image mainImage must not be null.");
		this.raster = raster;
		repaint();
	}
	
	public void loadImage(String imageFile) {
		raster.loadImage(imageFile);
	}

	public void setRotation(double degrees) {
		rotation = degrees/180 * Math.PI; // convert to radians
	}
	
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		if (raster != null) {
			Graphics2D g2 = (Graphics2D) g;
			g2.rotate(rotation,getWidth()/2,getHeight()/2); 
			g.translate((int) ((w - w*scaleFactor)/2), (int) ((h - h*scaleFactor)/2));
			g2.scale(scaleFactor,scaleFactor);
			g.drawImage(raster,0,0,w,h,null);
			// undo the  scaling, translating, and rotating
			g2.scale(1/scaleFactor,1/scaleFactor);
			g.translate((int) ((w*scaleFactor - w)/2), (int) ((h*scaleFactor - h)/2));
			g2.rotate(-rotation,getWidth()/2,getHeight()/2);
		}
		if (selected) {
			g.setColor(getForeground());
			g.drawRect(0,0,w-1,h-1);
		}
	}
}

