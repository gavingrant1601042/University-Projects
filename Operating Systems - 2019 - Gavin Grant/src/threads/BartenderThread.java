package threads;

import java.util.Random;

import constants.ThreadConstants;
import processcontrolblock.ProcessControlBlock;
import semaphore.Semaphore;
import stack.Stack;

public class BartenderThread implements Runnable {
	private Stack<String> barrel;
	private Semaphore semaphore;
	private ProcessControlBlock processControlBlock;
	
	public BartenderThread() {
		this.barrel = null;
		this.semaphore = null;
		this.processControlBlock = null;
	}
	
	public BartenderThread(Stack<String> stack, Semaphore semaphore, ProcessControlBlock processControlBlock) {
		this.barrel = stack;
		this.semaphore = semaphore;
		this.processControlBlock = processControlBlock;
	}
	
	@Override
	public void run() {
		while(true) {
			this.refillBarrel();
		}
	}
	
	private void refillBarrel() {
		if (this.barrel.isEmpty()) {
			this.semaphore.take();
			
			if (this.semaphore.getCount() < 3) {
				this.processControlBlock.setWakeCount(this.processControlBlock.getWakeCount() + 1);
				this.processControlBlock.setThreadState(ThreadConstants.refilling);
				
				System.out.println("\n"+this.processControlBlock);
				
				int randomNumber = new Random().nextInt(50);
				int counter = randomNumber == 0 ? 1: randomNumber;
				
				for (int index = 0; index < counter; index++) {
					this.barrel.push("Light Beer: "+(index+1));
				}
				
				this.processControlBlock.setThreadState(ThreadConstants.waiting);
				System.out.println("Barrel was refilled with "+ counter+ " light beer"+(counter == 1 ? "\n": "s\n"));
			}
			else {
				System.out.println("\nBartender was awaken 3 times. Ending Program!");
				System.exit(0);
			}
			
			this.semaphore.release();
		}
	}
}
