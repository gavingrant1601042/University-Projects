package semaphore;

public class Semaphore {
	private boolean signal = false;
	private int count;

	public Semaphore(boolean signal) {
		this.signal = signal;
		this.count = 0;
	}
	
	public final int getCount() {
		return this.count;
	}
	
	public synchronized void release() {
		this.signal = true;
		
		this.notify();
		
		this.count++;
	}

	public synchronized void take() {
		while(!this.signal) {
			try {
				this.wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.signal = false;
	}
}
