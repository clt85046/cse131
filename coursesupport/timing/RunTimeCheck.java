package timing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import com.csvreader.CsvWriter;

public class RunTimeCheck {
	private LinkedList<Long> minRunTimes = new LinkedList<Long>();
	private LinkedList<Integer> inputs = new LinkedList<Integer>();
	private String name;
	Iterator<Integer> iter;
	
	/**
	 * Times the run time of the runnable provided by T at the input values
	 * from the iterator
	 * 
	 * @param T a class than implements the RunTimeTestable interface
	 */
	public RunTimeCheck(RunTimeTestable T) {
		this.name = T.getFileName();
		Iterator<Integer> iter = T.getInputSizes();
		
		while(iter.hasNext()) {
			PriorityQueue<Long> q = new PriorityQueue<Long>();
			
			int n = iter.next(); 
			inputs.add(n);
			
			for(int j = 0; j < 10; j++) {
				Runnable r = T.genRunnable(n);
				q.add(calcRunTime(r));
			}
	
			Long avg = (q.remove() + q.remove() + q.remove()) / 3;
			minRunTimes.add(avg);
		}
	}

	private long calcRunTime(Runnable r) {
		TimedRunnable tr = new TimedRunnable(r);
		//run the garbage collector in an attempt to reduce runtime variation
		System.gc();
		tr.run();
		
		return tr.getTime();	
	}

	/**
	 * Generates a csv file in the outputs folder that will allow you to graph
	 * the asymptotic complexity of your algorithm in excel. 
	 * 
	 *  NOTE: YOU NEED TO REFRESH YOUR OUTPUTS FOLDER AFTER CALLING THIS METHOD
	 *  THE FIRST TIME TO SEE THE FILE.
	 */
	public void genCSV() {
		String outputFile = "outputs/" + name + ".csv";

		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

				csvOutput.write("Input Size");
				csvOutput.write("Run Time (ns)");
				csvOutput.endRecord();


			for(int i = 0; i < inputs.size(); i++) {
				csvOutput.write("" + inputs.get(i));
				csvOutput.write("" + minRunTimes.get(i));
				csvOutput.endRecord();
			}
			
			csvOutput.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
