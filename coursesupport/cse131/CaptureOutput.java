package cse131;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class CaptureOutput {
	
	private Runnable r;
	private byte[] captured;

	public CaptureOutput(Runnable r) {
		this.r = r;
	}
	
	public void run() {
		System.out.flush();
		PrintStream saved = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream temp = new PrintStream(baos);
		System.setOut(temp);
		try {
			r.run();
		}
		finally {
			temp.flush();
			this.captured = baos.toByteArray();
			System.setOut(saved);
		}
	}
	
	public byte[] getBytes() {
		return this.captured;
	}
	
	public InputStream getInputStream() {
		if (this.captured == null)
			throw new Error("Must close the output stream before the bytes are available.");

		return new InputStream() {

			private int b=0;
			private byte[] copy = getBytes();
			@Override
			public int read() throws IOException {
				if (b >= copy.length)
					return -1;
				else 
					return copy[b++];
			}
			
		};
	}

}
