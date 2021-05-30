package main;

import java.util.Random;

import constants.ProcessConstants;
import constants.ThreadConstants;
import processcontrolblock.ProcessControlBlock;
import semaphore.Semaphore;
import stack.Stack;
import threads.BartenderThread;
import threads.StudentThread;

public class Driver {
	private Stack<String> barrel;
	private Semaphore semaphore;
	
	public Driver() {
		this.barrel = new Stack<String>();
		this.semaphore = new Semaphore(true);
		
		this.populateBarrel();
		this.initiateBartenderThread();
		this.initiateStudentThreads();
	}
	
	private void populateBarrel() {
		int counter = new Random().nextInt(50);
		
		for (int index = 0; index < counter; index++) {
			this.barrel.push("Light Beer: "+(index+1));
		}
		
		System.out.println("Initially filled the barrel with "+ counter+ " light beer"+(counter == 1 ? "\n": "s\n"));
	}
	
	private void initiateStudentThreads() {
		for (int index = 0; index < 10; index++) {
			int lightBeerRequired = new Random().nextInt(20);
			
			ProcessControlBlock processControlBlock = new ProcessControlBlock();
			processControlBlock.setProcessId(index);
			processControlBlock.setArrivalTime(System.currentTimeMillis());
			processControlBlock.setLightBearRequired(lightBeerRequired == 0? 1: lightBeerRequired);
			processControlBlock.setThreadState(ThreadConstants.waiting);
			processControlBlock.setProcessType(ProcessConstants.student);
			
			Thread thread = new Thread(new StudentThread(this.barrel, processControlBlock));
			processControlBlock.setThreadId(thread.getId());
			
			thread.start();
		}
	}
	
	private void initiateBartenderThread() {
		ProcessControlBlock processControlBlock = new ProcessControlBlock();
		processControlBlock.setProcessId(105);
		processControlBlock.setProcessType(ProcessConstants.bartender);
		
		Thread thread = new Thread(new BartenderThread(this.barrel, this.semaphore, processControlBlock));
		processControlBlock.setThreadId(thread.getId());
		
		thread.start();
	}
	
	public static void main(String []args) {
		new Driver();
	}
}
