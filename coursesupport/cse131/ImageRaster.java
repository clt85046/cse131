package cse131;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.JPanel;

public class ImageRaster extends BufferedImage{
	/**
	 * 
	 */
	private static Applet applet;
	private static final long serialVersionUID = 1L;
	int width, height;
	Dimension size;
	final int DEFAULT_SIZE = 128;
	MediaTracker tracker = new MediaTracker(new JPanel());
	int imageId = 1;
	BufferedImage image;
	HashMap<String,java.awt.Image> imagesFromFiles = new HashMap<String,java.awt.Image>();
	public ImageRaster(int width, int height) {
		super(width, height, BufferedImage.TYPE_INT_ARGB);
		this.width = width;
		this.height = height;
		size = new Dimension(width,height);
		
	}
	
	java.awt.Image getImage(String imageFile) {

		if (!imagesFromFiles.containsKey(imageFile)) {
			try {
				// Use an image tracker to wait fot the image to load completely.
				
				java.awt.Image img = null;
				if (applet != null) {
					try {
						img = applet.getImage(applet.getDocumentBase(),imageFile);
					} catch (Exception e) {
						//System.err.println("Image " + imageFile + " not loaded from server." + e);
					}
				}
				if (img == null)
					img = Toolkit.getDefaultToolkit().getImage(imageFile);
				if (img == null)
					throw new IllegalArgumentException("Image file " + imageFile + "not found");
				if (tracker == null) 
					tracker = new MediaTracker(new JPanel()); // use dummy component
				tracker.addImage(img,imageId++);
				tracker.waitForAll();
				imagesFromFiles.put(imageFile, img);
			} catch (InterruptedException ioe) {
				System.err.println("Interrupted while loading image from file " + imageFile);
			}
		}
		return imagesFromFiles.get(imageFile);
	}

	public void loadImage(String imageFile) {
		//fillRegion(0,0,width,height,Color.WHITE);
		//fillRegion(0,0,width,height,new Color(0,0,0,0));
		java.awt.Image img = getImage(imageFile);
		if (img == null) {
			System.err.println("Image file could not be loaded: " + imageFile);
			return;
		} 	
		// Calculate the maximum dimensions for displaying the image.
		int imgWidth = img.getWidth(null);
		int imgHeight = img.getHeight(null);
		double scale = ((double) width) / imgWidth;
		if (imgHeight * scale > height)
			scale = ((double) height) / imgHeight;
		int startX = (int) (width - scale*imgWidth) / 2;
		int startY = (int) (height - scale*imgHeight) / 2;

		Graphics g = getGraphics();
		//System.out.println("Drawing at: " + startX +","+startY+":" + ((int) (scale*imgWidth)) + "x" + ((int) (scale*imgHeight)));
		g.drawImage(img, startX, startY,(int) (scale*imgWidth), (int) (scale*imgHeight), null);
	}
	
	
}
