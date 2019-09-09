/*************************************************************************
 * This class is for a circular linked list. You will notice that it has 
 * the same attributes as in a regular linked list. What will be different 
 * though is the way we manipulate the list.
 * Also, instead of calling a node the head, we call it start since there 
 * is no more head of the list
 *************************************************************************/ 

public class CList<T> {
    private Node<T> start;
    private int size;
    
    // CONSTRUCTORS ******************************************************
    public CList() {}
    
    // TODO 1: Complete the following constructor that takes a node as a parameter
    // Pre-condition: N is a single node
    public CList(Node<T> N) { 
		size = 1; 
		start = N; 
    }
    
    // SETTERS ***********************************************************
    // TODO 2: Write a setter method for setting the attribute start:
    // YOUR CODE (INCLUDING THE SIGNATURE) GOES HERE...
    
    // no setter for the size since it is a consequence of other methods
	
	public void setStart(Node<T> N) { 
		start = N; 
	}
    // GETTERS ***********************************************************
    // TODO 3 & TODO 4: Write a getter method for accessing each of the attributes:
    // YOUR CODE (INCLUDING SIGNATURE) GOES HERE...
    
	public int getSize() { 
		return size; 
	}	
	
	public Node<T> getStart() { 
		return start; 
	}
    
    // OTHER METHODS *****************************************************
    
    // ADDING NODES OR SEQUENCES OF NODES ////////////////////////////////
    /* Method addAtEnd: 
     *      Takes a node N 
     *      Adds it to the circle "at the end", i.e., just before start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtEnd(Node<T> N) { 
		if (start == null) { //if start is null, than N is linked to start, and updates size. 
			start = N;
			N.setNext(N); 
			size++;
		}
		else {  
			Node <T> tail = start;  
			for (int i = 1; i < size; i++) { //This for loop runs size - 1 times. Tail just be last node in the list after the loop.  
				tail = tail.getNext(); 
			} 
			N.setNext(tail.getNext()); //Node N sets next to start. 
			tail.setNext(N); //Tail sets next to N, thus adding N in the list. 
			size++; //Updates size by adding one. 
		}			 
    }
    
    /* Method addDataAtEnd: 
     *      Takes data of type T 
     *      Creates a node that contains T
     *      Adds it to the circle "at the end", i.e., just before start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addDataAtEnd(T data) {
		Node<T> N = new Node<T>(data); //Creates new node from data.  
		if (start == null) {  //If start is null then makes N the start. 
			start = N;
			N.setNext(N); 
			size++; 
		}
		else {
			this.addAtEnd(N); //Uses the previous method since they do the same thing. 
		}
    }
    
    /* Method addAtStart: 
     *      Takes a node N 
     *      Adds it to the circle just before start and makes it the new start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtStart(Node<T> N) {
		if (start == null) { //If start is null then makes N the start. 
			start = N; 
			N.setNext(N);
			size++; 
		}
		else { 
			Node<T> iter = start; //The node iter is assigned for start for later uses. 
			
			for (int i = 1; i < size; i++) { //This for loop transverses the list and makes iter the last node before start. 
				iter = iter.getNext(); 
			}
			
			Node<T> temp = start; //Assigns node temp to start. 
			N.setNext(temp); //N next is set to temp. 
			start = N; //start is assigned to N. 
			iter = iter.getNext(); //iter goes to N. 
			iter = start; //iIter is assigned with start. 
			
			size++; //Size it updated by one.  
		}
    }
    
    /* Method addAtLocation: 
     *      Takes a node N and an integer n
     *      Adds N to the circle just after the n-th node in the circle
     *          (where start is the first node)
     *      Notes: 1/ take into account when the list is null or has 
     *          less than n nodes
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtLocation(Node<T> N, int n) {
		if (start == null) { //If start is null than N is the start. 
			start = N;
			N.setNext(N); 
			size++; 
		}
		
		else { 
			Node<T> iter = start; //iter is set to start; 
			
			for (int i = 1; i < n; i++) { //iter transverses to the node before nth node.  
				iter = iter.getNext(); 
			} 
			
			N.setNext(iter.getNext()); //N sets next to node after to iter. (At location according to n).  
			iter.setNext(N); //Iter to set to N, thus adding the node at location to list. 
	 		size++; 
		}
    }   
    
    /* Method addMultiAtEnd: 
     *      Similar to addAtEnd
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtEnd(Node<T> N) {		
		Node<T> iter = new Node<T>(N.getData()); //Extracts data from node into new node to be adding to the list.  
		this.addAtEnd(iter); //Uses the previous method for this part. 
    }
	
    /* Method addMultiAtStart: 
     *      Similar to addAtStart
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtStart(Node<T> N) {
        Node<T> iter = new Node<T>(N.getData()); //Extracts data from node into new node to be adding to the list. 
		this.addAtStart(iter); //Uses the previous method for this part. 
    }
    
    /* Method addMultiAtLocation: 
     *      Similar to addAtLocation
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtLocation(Node<T> N, int n) {
        Node<T> iter = new Node<T>(N.getData()); //Extracts data from node into new node to be adding to the list. 
		this.addAtLocation(iter, n); //Uses the previous method for this part. 
    }   
    
    // REMOVING NODES OR SEQUENCES OF NODES ////////////////////////////////

    /* Method removeStart: 
     *      Removes the start node
     *      Makes the next node in sequence the start
     *  Notes: 1/ take into account the case where the list is empty or 
     *      has only one node
     *      2/ do not forget to update the value of size
     ********************************************************************/
    public void removeStart() {
		if (start == null) { //Just returns if start is null. 
			return; 
		}
		
		if (size == 1) { //Makes start null. reduces size, and returns. 
			start = null; 
			size--; 
			return; 
		}
	
		Node<T> iter = start.getNext(); //Sets iter to the node next 
		
	    while (iter.getNext() != start)  { 
			iter = iter.getNext();
		} 
	
		start = start.getNext();
		iter.setNext(start);  
		size--; 
    }
    
    /* Method removeLast: 
     *      Removes the node just before start in the circle (i.e., the last node)
     *  Notes: 1/ take into account the case where the list is empty or 
     *      has only one node
     *      2/ do not forget to update the value of size
     ********************************************************************/
    public void removeLast() {
		if (start == null ) {  //If start is null, then it prints something, and returns. 
			System.out.println("List is empty."); 
			return; 
		}
		
		if (size == 1) { //If size is one, then start is nullified, updates size, and returns. 
			start = null;
			size--; 
			return; 
		}
		
		Node<T> tail = start.getNext(); //The node tail assigned with the node next to start. 
		
		while (tail.getNext() != start) { //This while loop gets tail to the node before start. 
			tail = tail.getNext();
		}
		
		Node<T> iter = start; //Iter is set to start. 
		
		while (iter != tail) { //This while loop sets iter to the node before tail. 
			iter = iter.getNext(); 
		}
		
		tail = tail.getNext(); //tail goes to next node. 
		iter.setNext(tail); //iter sets next to tail, thus removing the node from the list. 
		size--; 
    }
    
    /* Method removeNode: 
     *      Takes a node N
     *      Removes this node N from the list if it is in the list
     *  Notes: 1/ take into account the case where N is not in the list,
     *      or the list is empty 
     *      2/ do not forget to update the value of size if relevant
     ********************************************************************/
    public void removeNode(Node<T> N) {
		if (size == 0) {  //If size is zero, then it prints something and returns. 
			System.out.println("List is empty."); 
			return; 
		}
		
		if (N == start) { //If N is start, then it calls the removeStart method and returns. 
			this.removeStart(); 
			return; 
		}
		
		Node<T> tail = start; //tail is assigned to start.  
		
		while (tail.getNext() != N) { //This while loop makes tail transverse the list, and stops at the node before N. 
			tail = tail.getNext();
		}
		
		N = N.getNext(); //N goes to the node next. 
		tail.setNext(N); //tail sets its next to N. Thus deleting the node. 
		size--; //Updates the size. 
    }
   
    /* Method removeLocation: 
     *      Takes an integer n
     *      Removes the n-th node from the list if there is such a node
     *  Notes: 1/ take into account the case there are fewer nodes than n
     *      in the list
     *      2/ do not forget to update the value of size if relevant
     ********************************************************************/
    public void removeLocation(int n) {
		if (n > size) { //If n is greater than size, it prints somethings and returns. 
			System.out.println("Location does not exist. "); 
			return; 
		}
		
        Node<T> N = start; //N is set to start. 
		
		if (n == 1) { //If n is one, then it calls removeStart since it is removing start, and returns. 
			this.removeStart(); 
			return; 
		}
		
		for (int i = 1; i < n - 1; i++) {  //This for loops sets N to node before the nth node. 
			N = N.getNext(); 
		}
		
		Node <T> temp = N.getNext(); //Temp assigned with the nth node. 
		temp = temp.getNext();  //Temp goes to next node. 
		N.setNext(temp); //N sets next to temp, thus removing nth node from the list. 
		size--; 
    }
    
    // PRINTING THE CONTENT OF A CLIST //////////////////////////////////
    /* Method print: 
     *      Prints every element of the circle once
     *      Prints "There is nothing to print" if the list is empty
     ********************************************************************/
    public void print() {
		if (size == 0) { //If size is zero, then it prints something and returns. 
			System.out.println("There is nothing to print.");
			return;
		}
		
		Node <T> iter = start; //Iter is set to start. 
		
        for (int i = 0; i < size; i++) { //This for loop prints the contents of all nodes by transversing the whole list. 
			System.out.println(iter.getData() + " ");
			iter  = iter.getNext(); 
		}
		
		System.out.println(""); 
	}
    
    /*******************************************************************/
    /* Method: ChildrenRonde: 
     * It applies to a circular linked list and takes an integer s 
     *      (given a CList L, you will call it as L.ChildrenRonde(s)). 
     * It successively removes every s-th child from the circle until 
     *      only one child is left. 
     * It does not return anything, but it directly modifies the list 
     *      of children, which contains only one child at the end of 
     *      the game, the winner. 
     * NOTE: make sure to handle special cases like when the list may
     *      be empty
     * ALSO: if the list contains only one element, print out:
     *      "There is only one element remaining: "
     *      and then print the node (its content) using the appropriate
     *      method
     *******************************************************************/
    public void ChildrenRonde(int s) { 
		Node <T> iter = start;
				
		if (start == null) { //If start is null, then it will print something and exit the program.  
			System.out.println("List is empty."); 
			System.exit(0); 
		}
		if (size == 1) { //If size is one (only one node) then it will print the node, and exit the program. 
			System.out.println("There is only one element remaining."); 
			iter.printNode(); 
			System.exit(0); 
		}
		
		while (size != 1) { //This while loop will run until size is one (down to the last node.) 
			for (int i = 1; i < s; i++) { //For loop runs the steps which iter tranverses the linked list.  
				iter = iter.getNext();
			}
			this.removeNode(iter); //The node is removed after the for loop as it is child should be removed. 
			iter = iter.getNext(); //iter is goes to the next node as new starting point, 
		} 
		this.print(); //Prints last node (the winner). 
    }
}