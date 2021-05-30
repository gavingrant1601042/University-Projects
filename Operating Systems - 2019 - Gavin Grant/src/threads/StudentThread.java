package threads;

import java.util.Random;

import constants.ThreadConstants;
import processcontrolblock.ProcessControlBlock;
import stack.Stack;

public class StudentThread implements Runnable {
	private Stack<String> barrel;
	private ProcessControlBlock processControlBlock;
	
	public StudentThread() {
		this.barrel = null;
		this.processControlBlock = null;
	}
	
	public StudentThread(Stack<String> barrel, ProcessControlBlock processControlBlock) {
		this.barrel = barrel;
		this.processControlBlock = processControlBlock;
	}
	
	@Override
	public void run() {
		while(true) {
			this.getServing();
		}
	}
	
	private void getServing() {
		if (!this.barrel.isEmpty()) {
			if (this.processControlBlock.getLightBeerConsumption() < this.processControlBlock.getLightBearRequired()) {
				String lightBeer = this.barrel.pop();
				
				if (lightBeer != null) {
					this.processControlBlock.setLightBeerConsumption(this.processControlBlock.getLightBeerConsumption() + 1);
					this.drinkAndThink();	
				}
			}
			else {
				this.processControlBlock.setTerminatedTime(System.currentTimeMillis());
				this.processControlBlock.setThreadState(ThreadConstants.terminated);
				
				this.pauseThread();
			}
		}
		else {
			this.processControlBlock.setThreadState(ThreadConstants.waiting);
			this.pauseThread();
		}
	}
	
	private void drinkAndThink() {
		int randomNumber = new Random().nextInt(2);
		
		if (randomNumber == 0) {
			this.processControlBlock.setThreadState(ThreadConstants.drinking);
		}
		else {
			this.processControlBlock.setThreadState(ThreadConstants.thinking);
		}
		
		this.pauseThread();
	}
	
	private void pauseThread() {
		try {
			System.out.println(this.processControlBlock);
			
			int randomNumber = new Random().nextInt(3);
			
			Thread.sleep(randomNumber == 0? 1000: randomNumber == 1 ? 2000: 3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
