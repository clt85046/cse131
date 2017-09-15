package imagetransforms;


import imageprocessor.ColorFilter;
import imageprocessor.ComponentFilter;
import imageprocessor.GUI;
import imageprocessor.Filters;
import imageprocessor.MenuTransformable;
import imageprocessor.PictureFilter;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;

import sedgewick.Picture;


public class Main {

	public static void main(String[] args) {
		final MenuTransformable[] menus = new MenuTransformable[] {			

				GUI.genMenuTransform("flip horizontally", new PictureFilter() {

					@Override
					public void filter(Picture[] in) {
						Transforms.flipHoriz(in[0], in[1]);
					}
				}),
				
				GUI.genMenuTransform("flip vertically", new PictureFilter() {

					@Override
					public void filter(Picture[] in) {
						Transforms.flipVert(in[0], in[1]);
					}
				}),

				GUI.genMenuTransform("flip left half", new PictureFilter() {

					@Override
					public void filter(Picture[] in) {
						Transforms.flipHorizLeftHalf(in[0], in[1]);
					}
				}),

				GUI.genMenuTransform("flip bottom half", new PictureFilter() {

					@Override
					public void filter(Picture[] in) {
						Transforms.flipVertBotHalf(in[0], in[1]);
					}
				}),
				GUI.genMenuTransform("gradient", new PictureFilter() {

					@Override
					public void filter(Picture[] in) {
						Transforms.gradient(in[1]);
					}
				}),
				GUI.genMenuTransform("edge detect", new PictureFilter() {

					@Override
					public void filter(Picture[] in) {
						Transforms.edgeDetect(in[0], in[1]);
					}
				}),
				GUI.genMenuTransform("filter", new PictureFilter() {

					@Override
					public void filter(Picture[] in) {
						Transforms.digitalFilter(in[0], in[1]);
					}
				}),
		};


		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					GUI frame = new GUI(menus);
					frame.setVisible(true);
					frame.addPictureToTopBar(new File("images/wrighton.jpg"));
					frame.addPictureToTopBar(new File("images/brookings.jpg"));
					frame.addPictureToTopBar(new File("images/chicken.jpg"));
					frame.addPictureToTopBar(new File("images/arch.jpg"));
					frame.getSource1().setPicture(new Picture("images/brookings.jpg"));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});


	}
}
