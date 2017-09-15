package speeding;

import cse131.ArgsProcessor;

public class SpeedLimit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int speed = ap.nextInt("Enter speed");
		int speedlimit = ap.nextInt("Enter speedlimit");
		int speeding = speed - speedlimit;
		speeding = (speeding>0)? speeding : 0;
		int fine = (speeding<=10)? (0) :(50+10*(speeding - 10));
		System.out.println("You reported a speed of "+speed+" MPH for a speed limit of "+speedlimit+" MPH. You went "+speeding+" MPH over the speed limit. Your fine is $"+fine+". ");
	}

}
