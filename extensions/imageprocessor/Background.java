package imageprocessor;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;

import cse131.ArgsProcessor;
import sedgewick.Picture;

public class Background {

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
				}),

				GUI.genMenuTransform("bgSubtract (exact)", new ColorFilter() {

					@Override
					public Color filter(Color in[]) {
						return Filters.bgSubtract(in[0], in[1], 0);
					}
				}),
				GUI.genMenuTransform("bgSubtract (sat tol 10)", new ColorFilter() {

					@Override
					public Color filter(Color in[]) {
						return Filters.bgSubtract(in[0], in[1], 10);
					}
				}),
				
				GUI.genMenuTransform("bgSubtract (sat tol 30)", new ColorFilter() {

					@Override
					public Color filter(Color in[]) {
						return Filters.bgSubtract(in[0], in[1], 30);
					}
				}),

				GUI.genMenuTransform("bgSubtract (sat tol 50)", new ColorFilter() {

					@Override
					public Color filter(Color in[]) {
						return Filters.bgSubtract(in[0], in[1], 50);
					}
				}),

				GUI.genMenuTransform("bgReplace", new ColorFilter() {
					
					@Override
					public Color filter(Color in[]) {
						return Filters.bgReplace(in[0], in[1]);
					}
				})
		};

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(menus);
					frame.setVisible(true);
					frame.addPictureToTopBar(new File("images/two-bearsrev.jpg"));
					frame.addPictureToTopBar(new File("images/chicken.jpg"));
					frame.getSource1().setPicture(new Picture("images/two-bears.jpg"));
					frame.getSource2().setPicture(new Picture("images/one-bear.jpg"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}

}
