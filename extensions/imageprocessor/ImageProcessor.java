package imageprocessor;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;

import sedgewick.Picture;

public class ImageProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final MenuTransformable[] menus = new MenuTransformable[] {			
				GUI.genMenuTransform("darker", new ComponentFilter() {
					@Override
					public int filter(int in[]) {
						return Filters.darker(in[0]);
					}
				}),

				GUI.genMenuTransform("combine", new ComponentFilter() {
					@Override
					public int filter(int in[]) {
						return Filters.combine(in[0], in[1]);
					}
				}), GUI.genMenuTransform("composite", new ComponentFilter() {
					@Override
					public int filter(int in[]) {
						return Filters.composite(in[0], in[1]);
					}
				}), GUI.genMenuTransform("purplish", new ColorFilter() {

					@Override
					public Color filter(Color[] in) {
						return Filters.purplish(in[0]);
					}
				}), GUI.genMenuTransform("copy", new ComponentFilter() {
					@Override
					public int filter(int in[]) {
						return Filters.copy(in[0]);
					}
				}),

				GUI.genMenuTransform("negative", new ComponentFilter() {
					@Override
					public int filter(int in[]) {
						return Filters.negative(in[0]);
					}
				}),

				GUI.genMenuTransform("posterize", new ComponentFilter() {
					@Override
					public int filter(int in[]) {
						return Filters.posterize(in[0]);
					}
				}), GUI.genMenuTransform("brighter", new ColorFilter() {
					@Override
					public Color filter(Color[] in) {
						return Filters.brighter(in[0]);
					}
				}),

				GUI.genMenuTransform("grayscale", new ColorFilter() {
					@Override
					public Color filter(Color in[]) {
						return Filters.grayscale(in[0]);
					}
				}),
				
				GUI.genMenuTransform("black and white", new ColorFilter() {
					@Override
					public Color filter(Color in[]) {
						return Filters.blackAndWhite(in[0]);
					}
				}),

				GUI.genMenuTransform("combineBrighter", new ColorFilter() {
					@Override
					public Color filter(Color in[]) {
						return Filters.combineBrighter(in[0], in[1]);
					}
				})
		};

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(menus);
					frame.setVisible(true);
					frame.addPictureToTopBar(new File("images/BunnyStatue.jpg"));
					frame.addPictureToTopBar(new File("images/HolmesLounge.jpg"));
					frame.addPictureToTopBar(new File("images/SymbolStatue.jpg"));
					frame.addPictureToTopBar(new File("images/wrighton.jpg"));
					frame.addPictureToTopBar(new File("images/brookings.jpg"));
					frame.addPictureToTopBar(new File("images/chicken.jpg"));
					frame.addPictureToTopBar(new File("images/arch.jpg"));
					//frame.addPictureToTopBar(new File("images/FranAllen.jpg"));
					frame.getSource1().setPicture(new Picture("images/brookings.jpg"));
					frame.getSource2().setPicture(new Picture("images/wrighton.jpg"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}

}
