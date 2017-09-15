package cse131;

import java.awt.BasicStroke;
import java.awt.Stroke;

import javax.swing.JPanel;

public abstract class AugmentedJPanel extends JPanel {

	private static final long serialVersionUID = -2618830072283902312L;
	protected static final Stroke THICK_STROKE = new BasicStroke(1);
	boolean selected;
	
	public void setCenter(int x, int y) {
		setLocation(x-getWidth()/2, y-getHeight()/2);
	}
	
	public int getCenterX() {
		return getX()+getWidth()/2;
	}
	
	public int getCenterY() {
		return getY()+getHeight()/2;
	}
	
	public void setLineColor(java.awt.Color c) {
		setForeground(c);
	}
}
