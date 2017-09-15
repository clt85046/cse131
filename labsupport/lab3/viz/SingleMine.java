package lab3.viz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SingleMine extends JButton {
	public boolean value;
	public int nearbybombs;
	public boolean displayed = false;
	private boolean rightClicked = false;
	private ImageIcon flag = new ImageIcon("images/icons/flag.png");

	public void press(){
		if(!value){
			if (nearbybombs == 0){
				this.setBackground(Color.WHITE);
				this.setIcon(null);
			}else{
				this.setIcon(null);
				this.setText("" + nearbybombs);
				this.setBackground(Color.WHITE);
			}
		}else if(value){
			this.setBackground(Color.RED);
			this.setOpaque(true);
			this.setBorderPainted(false);
		}
		displayed = true;
	}

	public void rightClick() {
		if(rightClicked){
			this.setBackground(null);
			this.setIcon(null);
			rightClicked = false;
		}else{
			// flag
			this.setIcon(flag);
			this.repaint();
			//this.setBackground(Color.red);
			rightClicked = true;
		}
	}
}
