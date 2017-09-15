package timing;

import java.util.Iterator;

public interface RunTimeTestable {

	//Create a runnable containing the method whose run time is being 
	//checked with input size n.
	public Runnable genRunnable(int n);
	
	//Return the name of the output file you want generated
	public String getFileName();
	
	//return an iterator with the desired input sizes for the runtime test
	public Iterator<Integer> getInputSizes();
}
