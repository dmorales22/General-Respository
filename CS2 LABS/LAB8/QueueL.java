public class QueueL { 
	//Attributes
	private Node head;
	private int size; 
	private Node tail; 
	
	//Constructors
	public QueueL() {} 

	public QueueL(Node N) { 
		head = N; 
		size = 1; 
		tail = N; 
	}
	
	//Getters
	public int getSize() { 
		return size; 
	}
	
	public void enqueue(int A)  {
		Node N = new Node(A); //New node created from the integer. 
		if (head == null) { //If head is null, then it sets the node has head and tail, and sets size to one. 
			head = N;
			tail = N; 
			size = 1; 
			return;
		}
		
		tail.setNext(N); //Sets the tails next pointer to the the new node. 
		tail = N; //N is the new tail.
		size++; //Updates size.
	}
	
	public void dequeue() { 	
		if (head == null) { //If head is null, it just returns. 
			return; 
		}
		
		if (size == 1) { //If size is one, then head and tail are deleted. 
			head = null; 
			tail = null; 
			size = 0; 
			return; 
		}
	
		head = head.getNext(); //Sets new head to next node (next person in line).
		size--;
	}
	
	public int peek() { 
		if (head == null)  {  //If head is null, then it just returns zero. 
			return 0; 
		}
		return head.getData(); //Gets data from head. 
	}
	
	public void clear() { 
		head = null; //Deletes head. 
		tail = null;  //Deleted tail. 
		size = 0;  
	}
	
	public boolean isEmpty() { 
		if (size == 0 || head == null) { //If size is zero and head is null, then it will return true.   
			return true; 
		}
		
		return false; 
	}
}