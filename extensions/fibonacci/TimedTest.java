package fibonacci;

import timing.RunTimeCheck;
import timing.RunTimeTestable;
import timing.TimedRunnable;

public class TimedTest {
	public static void main(String[] args){
		
		RunTimeTestable iterFib = new FibTimer("iter") {

			@Override
			public Runnable genRunnable(final int n) {
				return new Runnable() {

					@Override
					public void run() {
						int toss = Fibonacci.iterative(n);
					}
					
				};
			}
			
		};
		
		RunTimeTestable recurFib = new FibTimer("recur") {

			@Override
			public Runnable genRunnable(final int n) {
				return new Runnable() {

					@Override
					public void run() {
						int toss = Fibonacci.recursive(n);
					}
					
				};
			}
			
		};
		RunTimeCheck ifib = new RunTimeCheck(iterFib);
		RunTimeCheck rfib = new RunTimeCheck(recurFib);
		ifib.genCSV();
		rfib.genCSV();
	}
}
