public class QueueA { 
	//Attributes
	private int[] array; 
	private int size; 
	private int tail;
	private int head; 
	
	//Constructors
	public QueueA(int S) { 
		array = new int[S];
		size = 0; 
		tail = 0; 
		head = 0; 
	}
	
	//Getters
	public int getSize() { 
		return size; 
	}
	
	public void enqueue(int A) { 
		if (isFull()) { //Using the isFull method to determine if the queue is full. If it is, then it prints something and returns. 
			System.out.println("Queue is full."); 
			return; 
		}
		
		array[tail] = A; //Assigning the tail of the array with the new integer.  
		tail = (tail + 1) % array.length; //Updates the tail to the next location, but uses the modulus symbol to prevent array-out-of-bound errors. 
		size++; //Updates size. 
	}
	
	public void dequeue() {
		if (isEmpty()) { //Using the isEmpty method to determine if the queue is empty. If it is, then it just returns. 
			return; 
		}
		
		array[head] = 0; //Assigns the head of the array to zero (to be empty). 
		head = (head + 1) % array.length; //Updates the head to the next location, but uses the modulus symbol to prevent array-out-of-bound  errors. 
		size--;
	}
	
	public int peek() { 
		if (size == 0) { //If size is zero, then it just returns zero. 
			return 0; 
		}
		return array[head]; //Returns the array location of the head. 
	}
	
	public void clear() { 
		for (int i = 0; i < array.length; i++)  { //This for loop assigns the whole array with zeros. To "empty" it out. 
			array[i] = 0; 
		}
		size = 0; //Resets the size. 
	}
	
	public boolean isEmpty() { 
		int counter = 0; //A counter integer. 
		for (int i = 0; i < array.length; i++) { //This for loop counts the amount of zeros in the array.  
			if (array[i] == 0) { 
				counter++;
			}
		}
		
		if (counter == array.length) { //If the amount of zeros are equal to the array.length, the array is empty, and returns true. 
			return true; 
		}
		
		return false; 
	}
	
	public boolean isFull() { 
		int counter = 0; 
		for (int i = 0; i < array.length; i++) { //This for loop counts the amount of non-zero values in the array.  
			if (array[i] != 0) { 
				counter++;
			}
		}
		
		if (counter == array.length) {  //If the amount of zeros are equal to the array.length, the array is full, and returns true. 
			return true; 
		}
		return false; 
	}
}