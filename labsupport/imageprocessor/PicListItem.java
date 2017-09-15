package imageprocessor;

import java.io.File;

import javax.swing.JLabel;

/**Created by Logan Sorrentino on 5/29/2012**/

public class PicListItem implements java.io.Serializable {
	
	public JLabel label;
	public File file;
	PicListItem next;
	PicListItem prev;
	public int ID;
	
	public PicListItem(JLabel label, int ID){
		this.label=label;
		this.ID =ID;
	}
	
	
	public JLabel getJLabel(){
		return label;
	}
	
	public int getID(){
		return ID;
	}
	
	public String info(PicListItem item){
		return "This ListItem, " + item +" -ID # " + ID + "- is a file with path: " + item.file +" , points next to: " + next 
				+ "and points prev to: " + prev;
	}
	

}
