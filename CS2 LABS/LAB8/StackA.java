public class StackA { 
	//Attributes
	private int[] array; 
	private int size; 
	
	//Constructors 
	public StackA(int S) {
		array = new int[S]; 
		size = 0; 
	}
	
	//Getters (only for size) 
	public int getSize() { 
		return size; 
	}
	
	public void push(int A) {
		if (isFull()) { //If the stack is full, it prints something and return. 
			System.out.println("Stack is full."); 
			return; 
		}
		
		array[size] = A; //Adds the integer to the top of the stack (using the size integer as an index). 
		size++; //Adds to size. 
	}
	
	public void pop() {
		array[size - 1] = 0; //"Removes" the top by placing a zero at the location. 
		size--; //Decreases the size. 
	}
	
	public int peek() { 
		if (isEmpty()) { //Checks if stack is empty. It prints something, and returns zero. 
			System.out.println("Stack is empty."); 
			return 0; 
		}
		return array[size - 1]; //Just returns the top of the stack using the size value. 
	}
	
	public void clear() { 
		for (int i = 0; i < array.length; i++)  { //This for loop adds zero to every element of the array. Thus, "clearing" it. 
			array[i] = 0; 
		}
		size = 0; //Resets the size. 
	}
	
	public boolean isEmpty() { 
		int counter = 0; 
		for (int i = 0; i < array.length; i++) { //This for loop counts the amount of zeros detected in the array. 
			if (array[i] == 0) { 
				counter++;
			}
		}
		if (counter == array.length) { //If the counter value is equal to the array.length, it returns true. 
			return true; 
		}
		return false; //Else returns false. 
	}
	
	public boolean isFull() { 
		int counter = 0;
		for (int i = 0; i < array.length; i++) { //This for loop counts the amount of non-zero elements in the array. 
			if (array[i] != 0) { 
				counter++;
			}
		}
		if (counter == array.length) { 
			return true; 
		}
		return false; 
	}

}