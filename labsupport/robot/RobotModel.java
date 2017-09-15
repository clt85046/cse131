package robot;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


import lab0.Point;
import lab0.Vector;

public class RobotModel {
	
	private Point curLocation;	// in standard graphics coordinates
	private Vector velocity;	// in standard graphics	
	final public PropertyChangeSupport pcs;
	private int speed;
	
	public RobotModel() {
		pcs = new PropertyChangeSupport(this);
		this.moveTo(new Point(0,0));
		this.setVelocity(new Vector(0,-1));  // look up
		this.speed = 10;
	}

	private void moveTo(Point newLoc) {
		Point oldLoc = this.curLocation;
		this.curLocation = newLoc;
		pcs.firePropertyChange("moved", oldLoc, this.curLocation);
	}
	

	
	//
	// NB:  Need a lock to do the following reliably
	//
	public void step() {
		moveTo(curLocation.plus(velocity));
	}
	
	public void setLocation(int x, int y){
		Point oldLoc = curLocation;
		curLocation = new Point(x,y);
		pcs.firePropertyChange("setlocation", oldLoc, curLocation);
	}
	
	public void setVelocity(Vector newVelocity) {
		Vector oldVel = this.velocity;
		this.velocity = newVelocity;
		pcs.firePropertyChange("velocitychanged", oldVel, this.velocity);
	}
	
	public void setSpeed(int pixelsPerStep){
		int oldspeed = speed;
		speed = pixelsPerStep;
		pcs.firePropertyChange("speedchanged", oldspeed, speed);
	}
	public Point getLocation(){return curLocation;}
	
	public Vector getVelocity(){return velocity;}
	
	public void addPropertyListener(PropertyChangeListener l){
		pcs.addPropertyChangeListener(l);
	}


}
