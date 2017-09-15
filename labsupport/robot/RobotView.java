package robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


import lab0.Point;
import lab0.Vector;

public class RobotView {

	private Robot robot;
	private Point oldPoint;

	public RobotView(PropertyChangeSupport pcs) {
		oldPoint = new Point(0,0);
		robot = new Robot("images/robot.gif", (int) oldPoint.getX(), (int) oldPoint.getY(), 40, 40);
		pcs.addPropertyChangeListener(
				"moved",
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent change) {
						Point p = (Point) change.getNewValue();
						int distance = (int) p.distance(oldPoint);
						robot.forward(distance);
						oldPoint = p;
					}
				});

		pcs.addPropertyChangeListener(
				"setlocation",
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent change) {
						Point location = (Point)change.getNewValue();
						robot.setCenter((int)location.getX(), (int)location.getY());
						oldPoint = location;
					}
				});
		pcs.addPropertyChangeListener(
				"velocitychanged",
				new PropertyChangeListener(){
					public void propertyChange(PropertyChangeEvent change){
						Vector newVelocity = (Vector)change.getNewValue();
						int degrees = (int)newVelocity.getAngle();
						robot.changeHeading(degrees);
					}
				});
		pcs.addPropertyChangeListener(
				"speedchanged",
				new PropertyChangeListener(){
					public void propertyChange(PropertyChangeEvent change){
						robot.changeSpeed((Integer)change.getNewValue());					}
				});

	}

	public Robot getRobot() {return robot;}

	public void reset() {
		robot.resetPath();
	}


}
