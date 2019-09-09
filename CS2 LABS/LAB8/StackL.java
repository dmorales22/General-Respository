public class StackL {
	//Attributes 
	private Node top;
	private int size; 
	
	//Constructors 
	public StackL() {} 

	public StackL(Node N) { 
		top = N; 
		size = 1; 
	}
	
	//Getters 
	public int getSize() { 
		return size; 
	}
	
	public void push(int A)  {
		Node N = new Node(A); //Creates new node from data. 
		if (top == null) { //If the top is null (empty list), then the new node is assigned to be top.
			top = N; 
			size = 1; 
			return; 
		}
		
		N.setNext(top); //N's next pointer is set to the the top. 
		top = N; //N becomes the new top. 
		size++; 
	}
	
	public void pop() { 	
		if (top == null) { //If the top is null, then it just returns. 
			return; 
		}
		
		if (size == 1) { //If the stack is only one size, then the top is deleted. 
			top = null; 
			size = 0; 
			return; 
		}
	
		top = top.getNext();  //Top is assigned to the next node, thus deleting the node. 
		size--;
	}
	
	public int peek() { 
		if (top == null)  { 
			return 0; 
		}
		return top.getData(); //Justs gets data from the top. 
	}
	
	public void clear() { 
		top = null; //Deletes the stack by nullifying the top. 
		size = 0; 
	}
	
	public boolean isEmpty() { 
		if (size == 0 || top == null) { //If size is zero or the top is null, then it returns true.   
			return true; 
		}
		return false; 
	}
}