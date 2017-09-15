package timing;



/**
 * You have to do work in this class
 * 
 * Runs a specified Runnable, keeping track of
 *   when it started and ended,
 *   so that the Duration of the Runnable can be returned
 *   
 * @author roncytron
 *
 */
public class TimedRunnable implements Runnable {

	final private Runnable runnable;
	private long start = -1;
	private long end = -1;

	/**
	 * Construct but do not yet run the Runnable
	 * @param r The Runnable that will be run
	 */
	public TimedRunnable(Runnable r) {
		this.runnable = r;
	}

	/**
	 * 1) Mark time (variable start), 
	 * 2) Run the Runnable, 
	 * 3) Mark time (variable end)
	 */
	@Override
	public void run() {
		this.start = System.nanoTime();    // (1)
		try {
			runnable.run();            // (2)
		}
		finally {
			this.end = System.nanoTime();  // (3)
			Wrappers.notifyAll(this); //Notifies everyone that this.end might have changed
		}
	}

	/**
	 * If the Runnable as not yet completed execution, wait
	 * 
	 * @return the Duration of time taken by the Runnable
	 */
	public long getTime() {
		
		while(this.end == -1){
			Wrappers.wait(this);	//waits for the Runnable to finish
		}

		return end - start;
	}

}
