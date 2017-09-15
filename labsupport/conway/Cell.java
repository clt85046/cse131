package conway;

import java.awt.Container;
import java.beans.PropertyChangeSupport;

public class Cell {
	
	Conway conway;
	int row;
	int col;
	PropertyChangeSupport pcs;
	
	public Cell(Conway conway, int row, int col){
		this.conway = conway;
		this.row = row;
		this.col = col;
		this.pcs = new PropertyChangeSupport(this);
	}
	
	public Conway getConway(){
		return this.conway;
	}

	public PropertyChangeSupport getPCS() {
		return this.pcs;
	}
	
	
	

}
