public class ExecuteWithArrays {

    public static int ChildrenRonde(int[] C, int s) {
		if (s <= 0 || C.length <= 0) { //If the steps are negative, then it prints something and exits the program.
			System.out.println("The steps are zero or negative, or size is zero (which means empty array). Exiting."); 
			System.exit(0);
		}
		
		int cout = 0; //Counter for the loop 
		
		//This for loop populates the array with values 1, 2, 3, 4... and so on.  
		for (int i = 1; i < C.length + 1; i++) { 
			C[cout] = i;
			cout++;
		}
		
		int counter = 0; //Main counter, served as an index to where to delete children, and to transverse the array.
		
		//Main for loop that runs total steps of the game. 
		for (int i = 0; i < C.length - 1; i++) { 
		
			//This for loop runs the steps (defined in main as "steps") to the point where the nth child would get removed.  
			for (int j = 1; j < s; j++) {
				if (counter >= C.length) { //This if statement checks if counter is greater the array length to prevent out of bound errors, and to set it to a correct index. 
					counter = counter - C.length; //Subtracts counter with array length to correct the counter. 
				}
				while (C[counter] == 0) { //This while loop adds to counter if the counter value lands on a zero in the array index so it can skip it. 
					counter++; 
					if (counter >= C.length) { //Same if statement from above. ^ 
						counter = counter - C.length;
					}
				}
				counter++; //Adds to counter.
				if (counter >= C.length) { //Same if statement from above ^
					counter = counter - C.length;
				}
			}
			
			while (C[counter] == 0) { //Same while loop above to skip zeros. 
				counter++;
				if (counter >= C.length) { 
					counter = counter - C.length;
				}
			}
			
			C[counter] = 0; //Assigns the array index defined by counter with zero (this is the part where it removes child by assigning zero).  
			counter = counter + 1;  //Adds one to counter for new starting point to count. 
		}
		
		int winner = 0; //Declares integer to store number of the last child from the game.  
		
		//For loop to find the single number that is not zero in the array, and assign it to winner (because it is the winner). 
		for (int i = 0; i < C.length; i++) {
			if (C[i] > 0) { 
				winner = C[i];
			}
		}
		
		//Prints something and returns winner. 
		System.out.print("Child #"); 
		return winner; 
	}
    
    public static void main(String[] args) {
        int size = Integer.valueOf(args[0]);
        int step = Integer.valueOf(args[1]);
        int[] children = new int[size];
        int last = ChildrenRonde(children, step);
        System.out.println(last);
    }
}