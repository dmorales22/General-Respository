import java.io.*;
import java.util.*;

public class Execute  {
    //This is the method that would read the inventory from the text file, and insert the attributes extracted from the text file into a Bike array.
    public static Bike[] readInventoryFromFile(String filename) throws FileNotFoundException, IOException,  NumberFormatException {
		try {
			//Declaring the filereader instances. 
			FileReader fr = new FileReader(filename);
			FileReader br = new FileReader(filename); 
			BufferedReader textReader = new BufferedReader(fr);
			BufferedReader counter = new BufferedReader(br);
			int cout = 0;
	    
			while (counter.readLine() != null)  { //This while loop counts the total number of lines in the inventory textfile. 
				cout++;
			}

			String[][] bikeStd = new String[cout][9]; //A 2D String is declared using the cout size and 9 (typical number of elements in the textfile).
	    
			//This for loop splits elements from the textfile by commas.  
			for (int i = 0; i < cout; i++) {
				bikeStd[i] = textReader.readLine().split(",");		
			}
	    
			int coutM = 0; //A counter for the next for loop.
			int[] cLines = new int[cout]; //An temp. array to store locations of completed lines. 

			//This for loop will check for complete, and store the index values in mLines and add to the counter.
			for (int i = 0; i < cout; i++) {
				if (bikeStd[i].length == 9) { //Checks the number elements per line if it has nine elements.  
					cLines[coutM] = i; //Will store the completed line index values into the array. 
					coutM++;
				}
			}
	    
			int[] completedLines = new int[coutM]; //New array the store locations of completed lines with the correct array size. 

			//Transfers over the values from cLines to completedLines. 
			for (int i = 0;  i < coutM; i++) {
				completedLines[i] = cLines[i];
			}
     
			String[][] bikeString = new String[coutM][9]; //New bike string with the corrected line size. 

			//This for loop transfers the contents with bikeStd into bikeString.
			for (int i = 0; i < coutM; i++) { 
				for (int j = 0; j < bikeString[0].length; j++) {
					bikeString[i][j] = bikeStd[completedLines[i]][j]; //bikeStd uses values stored in completedLines.  
				}
			}

			//This for loop erases whitespaces in the string array using the .trim function. 
			for (int i = 0; i < bikeString.length; i++) {
				for (int j = 0; j < bikeString[0].length; j++) { 
					bikeString[i][j] = bikeString[i][j].trim();
				}
			}

			Bike[] B = new Bike[bikeString.length]; //Bike array is declared with the size from the integer cout.
			String std; //A temp. string to be using in when assigning the attributes. 

			//This for loop with assign the attributes into objects that would inserted into the Bike array. The string locations are hard coded. 
			for (int i = 0; i < bikeString.length; i++) {
				if (bikeString[i][0].equals("Mountain Bike")) { //This checks if the first element of string array to check what bike type it is. 
					MountainBike BM1 = new MountainBike(); //Declares new object type for the bike type. 
					BM1.setbikeType(bikeString[i][0]); //Assigns string into the object using the attributes. 
					BM1.setmodelNum(bikeString[i][1]);
					std = bikeString[i][2]; //Temp. string is assigned with retail and purchase prices to be split up later. 
					BM1.setpurPrice(Double.parseDouble(std.substring(1))); //String is parse for a double value. A substring is used to remove the dollar sign within the string.
					std = bikeString[i][3]; 
					BM1.setretailPrice(Double.parseDouble(std.substring(1)));
					BM1.setcolor(bikeString[i][4]);
					BM1.setnumBikes(Integer.parseInt(bikeString[i][5]));
					BM1.setageRange(bikeString[i][6]); 
					BM1.setuserLevel(bikeString[i][7]);
					BM1.setWheelSize(Integer.parseInt(bikeString[i][8]));
					B[i] = BM1; //Object is then added onto the Bike array. 
				}
				
				if (bikeString[i][0].equals("Road Bike")) {
					RoadBike RM1 = new RoadBike();
					RM1.setbikeType(bikeString[i][0]);
					RM1.setmodelNum(bikeString[i][1]);
					std = bikeString[i][2];
					RM1.setpurPrice(Double.parseDouble(std.substring(1)));
					std = bikeString[i][3]; 
					RM1.setretailPrice(Double.parseDouble(std.substring(1)));
					RM1.setcolor(bikeString[i][4]);
					RM1.setnumBikes(Integer.parseInt(bikeString[i][5]));
					RM1.setageRange(bikeString[i][6]);
					RM1.setGears(Integer.parseInt(bikeString[i][7]));
					RM1.setWeight(Double.parseDouble(bikeString[i][8]));
					B[i] = RM1;
				}
				
				if (bikeString[i][0].equals("City Bike")) {
					CityBike CM1 = new CityBike();
					CM1.setbikeType(bikeString[i][0]);
					CM1.setmodelNum(bikeString[i][1]);
					std = bikeString[i][2];
					CM1.setpurPrice(Double.parseDouble(std.substring(1)));
					std = bikeString[i][3]; 
					CM1.setretailPrice(Double.parseDouble(std.substring(1)));
					CM1.setcolor(bikeString[i][4]);
					CM1.setnumBikes(Integer.parseInt(bikeString[i][5]));
					CM1.setageRange(bikeString[i][6]); 
					CM1.setnumBaskets(Integer.parseInt(bikeString[i][7]));
					CM1.setBrake(bikeString[i][8]);
					B[i] = CM1;
				}

			}
			return B; //Returns the completed Bike array. 
		}
	
		catch(NullPointerException npEX) { //This expection is used to return an error if the textfile is not formatted correctly. 
			throw new NullPointerException("Make sure the text file is formatted correctly.");
		}
		catch(FileNotFoundException fnfE) { //This exception prints message if file inputed not found. 
			throw new FileNotFoundException("File was not found. Make sure it's typed correctly.");
		}
		catch(IOException ioEX) { //This expection is used if the file not found. 
			throw new IOException("IOException");
		}
		catch(NumberFormatException nfEX) { //This exception used to return an error if certain values are misplaced.
			throw new NumberFormatException("Make sure that the textfile has proper format and values.");
		}
    }

    //This method will read the clientrequest textfile, seperate the attributes, update the inventory, and create a new textfile for missing items. 
    public static double updateInventoryBasedOnClientsRequests(Bike[] B, String filename) throws FileNotFoundException, IOException, NumberFormatException {
		try {
			//Up to line 184, it is the same code as an readInventoryFromFile. So it will not be commented. 
			FileReader fr = new FileReader(filename);
			FileReader br = new FileReader(filename); 
			BufferedReader textReader = new BufferedReader(fr);
			BufferedReader counter = new BufferedReader(br);

			int cout = 0;
			
			while (counter.readLine() != null)  {
				cout++;
			}

			String[][] bikeStd = new String[cout][4];

			for (int i = 0; i < cout; i++) {
				bikeStd[i] = textReader.readLine().split(", ");
			}

			int coutM = 0;
			int[] cLines = new int[cout]; 

			for (int i = 0; i < cout; i++) {
				if (bikeStd[i].length == 4) {
					cLines[coutM] = i;
					coutM++;
				}
			}
			
			int[] completedLines = new int[coutM];

			for (int i = 0;  i < coutM; i++) {
				completedLines[i] = cLines[i];
			}
     
			String[][] bikeString = new String[coutM][4];

			for (int i = 0; i < coutM; i++) {
				for (int j = 0; j < bikeString[0].length; j++) {
					bikeString[i][j] = bikeStd[completedLines[i]][j];
				}
			}
			
			for (int i = 0; i < bikeString.length; i++) {
				for (int j = 0; j < bikeString[0].length; j++) { 
					bikeString[i][j] = bikeString[i][j].trim();
				}
			}
			

			String std;
			Bike[] C = new Bike[bikeString.length];

			//Seperates the attributes from the clientrequests file similar in the readInventory method. 
			for (int i = 0; i < bikeString.length; i++) {
				if (bikeString[i][0].equals("Mountain Bike")) {
					MountainBike BM1 = new MountainBike();
					BM1.setbikeType(bikeString[i][0]); 
					BM1.setmodelNum(bikeString[i][1]);
					BM1.setcolor(bikeString[i][2]); 
					BM1.setnumBikes(Integer.parseInt(bikeString[i][3]));
					C[i] = BM1;
				}
				
				if (bikeString[i][0].equals("Road Bike")) {
					RoadBike RM1 = new RoadBike();
					RM1.setbikeType(bikeString[i][0]); 
					RM1.setmodelNum(bikeString[i][1]);
					RM1.setcolor(bikeString[i][2]); 
					RM1.setnumBikes(Integer.parseInt(bikeString[i][3]));
					C[i] = RM1;
				}
				
				if (bikeString[i][0].equals("City Bike")) {
					CityBike CM1 = new CityBike();
					CM1.setbikeType(bikeString[i][0]); 
					CM1.setmodelNum(bikeString[i][1]);
					CM1.setcolor(bikeString[i][2]); 
					CM1.setnumBikes(Integer.parseInt(bikeString[i][3]));
					C[i] = CM1;
				}	
			}

			//Declaring variables that would be later used in the loops. 
			double purchaseTotal = 0; //For the purchase price total calculated from the inventory and request files. 
			double retailTotal = 0; //For the retail price total calculated from the inventory and request files. 
			int missSet = 0; //Served to store a negative value when the clientrequest is more than what's in the inventory.  
			int set = 0; //This value is used for setnumBikes to update the number of bikes within the inventory. 
			int diff = 0; //This value is used to store the difference calculated the inventory and clientrequest. 
		
			//This nested for loop that would be used get the totals of the purchase and retail prices, and update the inventory.
			for (int i = 0; i < C.length; i++) {
				for (int j = 0; j < B.length; j++) {
					if (B[i].getbikeType().equals(C[j].getbikeType()) && B[i].getmodelNum().equals(C[j].getmodelNum()) && B[i].getcolor().equals(C[j].getcolor())) { //This if statement is true if all the attributes matched from both files. 
						if (B[i].getnumBikes() < C[j].getnumBikes()) { //If client's request textfile lines is more than inventory. 
							missSet = B[i].getnumBikes() - C[j].getnumBikes(); //Subtracts the bike count, should be a negative value. 
							purchaseTotal = purchaseTotal + (B[i].getpurPrice() * B[i].getnumBikes()); //Gets purchase total.
							retailTotal = retailTotal + (B[i].getretailPrice() * B[i].getnumBikes()); //Gets retail total. 
							B[i].setnumBikes(missSet); //Sets the negative value (will be changed later). 
						}
						else if (B[i].getnumBikes() == C[j].getnumBikes()) { //If client's request textfile lines is equal to the inventory stock. 
							purchaseTotal = purchaseTotal + (B[i].getpurPrice() * B[i].getnumBikes());
							retailTotal = retailTotal + (B[i].getretailPrice() * B[i].getnumBikes());
							B[i].setnumBikes(0); //Sets to zero. 
						}
						else {
							set = B[i].getnumBikes() - C[j].getnumBikes(); //Gets updated inventory stock. 
							diff = C[j].getnumBikes(); //Get number from client's request.
							purchaseTotal = purchaseTotal + (B[i].getpurPrice() * diff); //Gets purchase total by multiplying the int diff. 
							retailTotal = retailTotal + (B[i].getretailPrice() * diff); //Gets retail total by multiplying the int diff.
							B[i].setnumBikes(set); //Sets the updated inventory stock 
						}
					}
				}
			}
			
			int counters = 0; //A counter for the next for loop.
			double profit = retailTotal - purchaseTotal; //Gets the profit by substracting the retail total and purchase total. 
			int index = 0; //An integer that would store the Bike array value for bikes missing from the inventory. 
			int[] arrayIndex = new int[C.length]; //This array will stores those index values.

			//This for loop tries to find the bikes missing from the clientrequest, and stores the location values into an array. 
			for (int i = 0; i < C.length; i++) {
				counters = 0;
				for (int j = 0; j < B.length; j++) {
					if (!C[i].getbikeType().equals(B[j].getbikeType()) || !C[i].getmodelNum().equals(B[j].getmodelNum()) || !C[i].getcolor().equals(B[j].getcolor())) { //This if statement is true if no bike in the inventory matches any of it's attributes.  
					counters++;
						if (C.length == B.length) { //This if statement is true if there are same amouut of lines within the
						//clientsrequest file and inventory file to properly add the index values in arrayIndex.
							if (counters >= C.length) {
								arrayIndex[index] = i;
								index++;
							}
						}
						else if (C.length < B.length) { //This if statement is true if there are more lines in the inventory file. 
							if (counters >= B.length) { //If counters is more than or equal the lines in the inventory.  
								arrayIndex[index] = i; //The index is the counter for the arrayIndex and assigned to i.
								index++;
							}
						}
						else if (C.length > B.length) { //This if statement is true if there are more lines in the clientsrequest file.  
							if (counters >= B.length) {
								arrayIndex[index] = i;
								index++;
							}
						}
					}
				}
			}
			
			int[] missingArray = new int[index]; //Declares an array at the size of the index counter. (So the correct size array).
			Bike[] M = new Bike[index]; //Declares new bike array for the missing bikes in the inventory. 
			
			for (int i = 0; i < index; i++) { //For loop assigns the arrayIndex values into missingArray array. 
				missingArray[i] = arrayIndex[i];
			}
			
			for (int i = 0; i < missingArray.length; i++) { //The M Bike array is assigned with C Bike array values using the values from missingArray. 
				M[i] = C[missingArray[i]]; 
			}

			int[] nBikes = new int[B.length]; //Temp. array for bikes that have negative number of bikes.  
			int cout1 = 0; //A counter.
			
			for (int i = 0; i < B.length; i++) { //For loop that detects if numBikes are negative, adds to counter, and assigns the values to the array. 
			//into nBikes array. 
				if (B[i].getnumBikes() < 0) {
					nBikes[cout1] = i;
					cout1++; 
				}
			}
			
			int[] negativeBikes = new int[cout1]; //New array to be assigned with values from nBike into a correctly sized array.  
			int indexM = negativeBikes.length + M.length; //Integer to set size of a new Bike array. 
			Bike[] M2 = new Bike[indexM]; //New correctly sized Bike array to have all bikes missing from inventory. 

			//This for loop assigns values from the nBikes array into the negativeBikes array (which is the correct size array), and
			//assigns bikes from the inventory array into M2 with the values of the negativeBikes array.
			for (int i = 0; i < negativeBikes.length; i++) {
				negativeBikes[i] = nBikes[i];
				M2[i] = B[negativeBikes[i]];
			}

			int cout2 = negativeBikes.length; //Assigns with the value of the length of the negativeBikes array. 
			
			//The for loop merges the Bike arrays to complete total missing bikes in the inventory. 
			for (int i = 0; i < M.length; i++) {
				M2[cout2] = M[i];
				cout2++; 
			}

			String[][] writerString = new String[M2.length][4]; //New 2D string array with size of M2 and 4 (typical elements in the clientsrequest file.

			//This for loop assigns the writerString with contents of M2.  
			for (int i = 0; i < M2.length; i++) {
				writerString[i][0] = M2[i].getbikeType();
				writerString[i][1] = M2[i].getmodelNum();
				writerString[i][2] = M2[i].getcolor();
				if (M2[i].getnumBikes() < 0) { //Checks for negative values, and changes it back to positive (for filename.missing)
					writerString[i][3] = Integer.toString(M2[i].getnumBikes() * -1);
				}
				else {
					writerString[i][3] = Integer.toString(M2[i].getnumBikes());
				}
			}

			//This section is for printing the missing inventory into a text file.
			PrintWriter writer = new PrintWriter("filename.missing");

			//This nested for loop writes the contents of the 2D string into a the text file.  
			for (int i = 0; i < writerString.length; i++) {
				for (int j = 0; j < writerString[0].length - 1; j++) { 
					writer.print(writerString[i][j] + ", "); 
				}
				writer.print(writerString[i][writerString[0].length - 1]); //Writes the last element.
				writer.println("");
			}
			
			writer.close();

			//This for loop sets the inventory "Number of Bikes" attribute to zero if it's negative.
			for (int i = 0; i < B.length; i++) {
				if (B[i].getnumBikes() < 0) {
					B[i].setnumBikes(0);
				}
			}
			
			return profit; //returns the double. 
		}
		catch(FileNotFoundException fnfE) { //This exception prints message if file inputted not found. 
			throw new FileNotFoundException("File was not found. Make sure it's typed correctly.");
		}
		catch(IOException ioEX) {
			throw new IOException("IOException");
		}
		catch(NullPointerException npEX) {
			throw new NullPointerException("Make sure the text file is formatted correctly.");
		}
		catch(NumberFormatException nfEX) {
			throw new NumberFormatException("Make sure that the textfile has proper format and values.");
		}				   
    }

    //This method just prints out the inventory using the printRecord methods within the object types. (See the printRecord method in the other java files.) 
    public static void printInventory(Bike[] B) {
		for (int i = 0; i < B.length; i++) {
			B[i].printRecord(); 
			System.out.println("");
		}
    }

    //Main method declares the initial variables, assigns them by the running the methods above, and prints them.
    public static void main (String[] args) throws FileNotFoundException, IOException {
		try { 
			Bike[] B;
			double profit; 
			B = readInventoryFromFile(args[0]);
			profit = updateInventoryBasedOnClientsRequests(B, args[1]);
			System.out.println("-------------------------------------------------------------------");
			System.out.println("The overall profit is : $" + profit);
			System.out.println("-------------------------------------------------------------------");
			System.out.println("");
			System.out.println("Current Inventory: ");
			System.out.println("");
			printInventory(B);
		}
		catch(FileNotFoundException fnfE) { //This exception prints message if file inputted not found. 
			throw new FileNotFoundException("File was not found. Make sure it's typed correctly.");
			}
		catch(IOException ioEX) {
			throw new IOException("IOException");
		}
    }    
}