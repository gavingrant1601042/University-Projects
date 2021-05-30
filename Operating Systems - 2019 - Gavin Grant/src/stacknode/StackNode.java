package stacknode;

public class StackNode<DataType> {
	private DataType data;
	private StackNode<?> nextNode;
	
	public StackNode() { // Big O f(1)
		this.data = null;
		this.nextNode = null;
	}
	
	public StackNode(DataType data) { // Big O f(1)
		this.data = data;
		this.nextNode = null;
	}
	
	public void setData(DataType data) { // Big O f(1)
		this.data = data;
	}
	
	public final DataType getData() { // Big O f(1)
		return this.data;
	}
	
	public void setNextNode(StackNode<?> nextNode) { // Big O f(1)
		this.nextNode = nextNode;
	}
	
	public final StackNode<?> getNextNode() { // Big O f(1)
		return this.nextNode;
	}
}
