package fibonacci;

import java.util.Iterator;

import timing.RunTimeTestable;

abstract public class FibTimer implements RunTimeTestable {

	private String fname;

	public FibTimer(String fname) {
		this.fname = fname;
	}

	@Override
	public String getFileName() {
		return fname;
	}

	@Override
	public Iterator<Integer> getInputSizes() {
		return new Iterator<Integer>() {
			
			private int i = 0;

			@Override
			public boolean hasNext() {
				return i < 25;
			}

			@Override
			public Integer next() {
				Integer ans = i;
				i = i + 1;
				return ans;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}

}
