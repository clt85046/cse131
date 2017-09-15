package lab0;

public class RobotInstructions  {

	/*
	 * Below you see a method called "act".
	 * It has one parameter, called "robot".
	 * For now, the way in which the code below fits into what you see on
	 * the screen will seem mysterious.  That's OK.
	 * 
	 * For now, please accept that the instructions below cause the robot to
	 * move forward, turn left, or turn right.
	 */
	public void act(RobotMotionAdapter robot) {
		
		/**
		 * Each of the following lines of code executes in turn.  The
		 * first line causes the robot to move forward 60 "pixels".  A pixel is
		 * a measurement of distance on a computer screen.
		 * 
		 * The second line causes the robot to turn left.  Based on what you see,
		 * what does "90" represent?
		 * 
		 * Run the program as instructed in the lab write-up and observe how the robot
		 * moves in response to the code you see below.
		 * 
		 * You will add instructions at the end of the code to cause the robot to move
		 * as you desire.
		 */
		robot.forward(60);
		robot.turnLeft(90);
		robot.forward(270);
		robot.turnRight(90);
		robot.forward(80);
	}

}
