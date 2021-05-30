package stack;

import stacknode.StackNode;

public class Stack<DataType> {
	private StackNode<?> top;
	private int count; 
	
	public Stack() { // Big O f(1)
		this.top = null;
		this.count = 0;
	}
	
	@SuppressWarnings("unused")
	public void push(DataType data) { // Big O f(1)
		StackNode<DataType> temp = new StackNode<DataType>(data);

		if(temp != null) {
			if(this.top == null) {
				this.top = temp;
				this.count += 1;
			}
			else {
				temp.setNextNode(this.top);
				this.top = temp;
				this.count += 1;
			}
		}
		else {
			System.err.println("Error pushing a node on the stack. Out of Memory");
		}
	}
	
	@SuppressWarnings("unchecked")
	public synchronized final DataType pop() { // Big O f(1) - Synchronized for Mutual Exclusion
		StackNode<?> temp;
		DataType data = null;
		
		if(!this.isEmpty()) {
			temp = this.top;
			this.top = this.top.getNextNode();
			
			data = (DataType) temp.getData();
			temp = null;
			
			this.count -= 1;
		}
		
		return data;
	}
	
	public void destroy() { // Big O f(n)
		while(!this.isEmpty()) {
		    this.pop(); // Big O f(1)
		}
	}
	
	public synchronized final boolean isEmpty() { // Big O f(1) - Synchronized for Mutual Exclusion
		if (this.top == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	public final boolean isFull() { // Big O f(1)
		StackNode<DataType> node = new StackNode<DataType>();
		
		if (node != null) {
			node = null;
			return false;
		}
		else {
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public final DataType top() { // Big O f(1)
		StackNode<?> temp = this.top;
		DataType data = null;

		if(temp != null) {
			data = (DataType) temp.getData();
		}
		
		return data;
	}
	
	public synchronized final int getCount() { // Big O f(1) - Synchronized for Mutual Exclusion
		return this.count;
	}
}
