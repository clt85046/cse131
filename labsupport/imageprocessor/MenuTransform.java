package imageprocessor;

import java.awt.Color;

import sedgewick.Picture;

abstract public class MenuTransform implements MenuTransformable {

	public MenuTransform() {
		super();
	}

	public abstract String getMenuName();

	public ColorFilter makeColorFilter(final ComponentFilter cf) {
		return new ColorFilter() {

			@Override
			public Color filter(Color[] in) {
				int[] reds = new int[in.length];
				int[] greens = new int[in.length];
				int[] blues = new int[in.length];
				for (int i=0; i < in.length; ++i) {
					reds[i] = in[i].getRed();
					greens[i] = in[i].getGreen();
					blues[i] = in[i].getBlue();
				}
				return new Color(Math.min(cf.filter(reds),255), Math.min(cf.filter(greens),255), Math.min(cf.filter(blues),255));
			}

		};

	}

	public void processPixels(Picture source1, Picture source2, Picture target, ComponentFilter cf) {
		processPixels(source1, source2, target, makeColorFilter(cf));
	}
	
	private static Color getColor(Picture p, int x, int y) {
		Color ans = Color.white;
		try {
			ans = p.get(x,y);
		}
		catch (Throwable t) {
			
		}
		return ans;
	}
	
	/**
	 * Transform a picture to fit a standard reference
	 * @param in the picture to be transformed
	 * @param standard the reference width and height
	 * @return the transformed picture
	 */
	private static Picture scalePicture(Picture in, Picture standard) {
		double w = in.width();
		double h = in.height();
		Picture ans = new Picture(standard.width(), standard.height());
		for (int x=0; x < ans.width(); ++x) {
			double xx = 1.0 * x / ans.width() * w;
			for (int y=0; y < ans.height(); ++y) {
				double yy = 1.0 * y / ans.height() * h;
				ans.set(x,y, getColor(in, (int)xx, (int)yy));
			}
		}		
		return ans;
	}

	public void processPixels(Picture source1, Picture source2, Picture target, ColorFilter ccf) {
		source1 = scalePicture(source1, target);
		source2 = scalePicture(source2, target);
		Color[] colors = new Color[2];
		for (int x=0; x < source1.width(); ++x) {
			for (int y=0; y < source1.height(); ++y) {
				colors[0] = getColor(source1,x,y);
				colors[1] = getColor(source2,x,y);
				target.set(x, y, ccf.filter(colors));
			}
		}

	}
	
	public void processPixels(Picture source1, Picture source2,
			Picture target, PictureFilter pf) {
		pf.filter(new Picture[] { scalePicture(source1,target), target });
		
	}
	
	public String toString() {
		return getMenuName();
	}

}