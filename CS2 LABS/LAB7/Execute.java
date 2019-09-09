/**** In this file, you are going to manipulate binary trees. 
 **** The main method is given to you. You will just have to follow instructions and uncomment code as prompted
 **** A set of helper methods are also provided to you: you may or may not elect to use them, it is fine. 
 **** There are 3 main TODOs in this file: TODO 6, TODO 7, and TODO 8.
 ****/

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Execute {

    /* TODO 6: 
     * Method readFamilyIntoArray: 
     * Takes a file name and reads this file with family information, 
     * creates and fills an array tree with family member information.
     * Note: the size of the array tree depends on the number of levels in the family tree
     *      not on the number of family members
     ****************************************************************************************/
    public static FamilyMember[] readFamilyIntoArray(String filename) throws FileNotFoundException, IOException {
        
        // Find out how many family levels there are in the file (i.e., the number of lines)
        int lines = countLines(filename); 
        // --> This gives us the size of the array
        double dSize = (2 * Math.pow(2, lines  - 1))  - 1; 
		int size = (int) dSize;

        // Create an array of FamilyMember elements, with the correct size:
        FamilyMember[] Family = new FamilyMember[size];
        
        // Read the file called filename to gather information into the array
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);
		
		String[][] std = new String[lines][lines]; //Creating a 2D string to place information parse from  the textfile. 
		int cout = 0; 
		
		for (int i = 0; i < lines; i++) { //This for loop reads the lines in the textfile, splits the elements by one whitespace, and adds it in the std.  
			std[i] = textReader.readLine().split(" "); 
		}
		
		String[] temp = new String[lines]; //A new string array to temporary hold information paresed from textfile
		
		for (int i = 0; i < std.length; i++) { //This nested for loop creates objects, parses them from the string array, sets it attributes, and adds it to the Family array. 
			for (int j = 0; j < std[i].length; j++) {
				FamilyMember FM = new FamilyMember(); 
				temp = processLine(std[i][j]); 
				FM.setFName(temp[0]); 
				FM.setLName(temp[1]); 
				FM.setSiblings(Integer.parseInt(temp[2])); 
				Family[cout] = FM;
				cout++;  //Adds to counter. 
			}
		}
		
        textReader.close();
        
        // Returns the filled array
        return Family;
    }
        
    /* TODO 7: 
     * Method readFamilyIntoTree: 
     * Takes a file name and reads this file with family information, 
     * creates and fills a linked-list-based tree with family member information.
     * Note: Father-line nodes go to the left and Mother-line nodes go to the right
     ****************************************************************************************/
    public static BTree<FamilyMember> readFamilyIntoTree(String filename) throws FileNotFoundException, IOException {
        
        // Read the file to gather information into the array
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);
		
        // Create an empty binary tree of Family Members
        BTree<FamilyMember> Tree = new BTree<FamilyMember>();
		int lines = countLines(filename); //Uses the method counterLines to the total amount of lines in the textfile. 
        String[][] std = new String[lines][lines];  //Creates new 2D string array will be resized and modified later.  
		
		for (int i = 0; i < lines; i++) { //This for loop reads the lines in the textfile, splits the elements by one whitespace, and adds it in the std.  
			std[i] = textReader.readLine().split(" "); 
		}
		
		String[] temp = new String[lines]; //A string array used to temporary hold information to be added to an object. 
		
		//This nested for loop is used to the information from the string array into objects, into nodes, and add them to the tree. 
		for (int i = 0; i < std.length; i++) { 
			for (int j = 0; j < std[i].length; j++) { 
				temp = processLine(std[i][j]); //Uses processLine to parse the information we need  into temp. 
				FamilyMember node = new FamilyMember(temp[0], temp[1], Integer.parseInt(temp[2])); //Creates a new object from the information in temp. 
				BTNode<FamilyMember> iter = new BTNode<FamilyMember>(node); 
				Tree.insertDataAtLocation(temp[3], node); //Adds the node and uses the placement string to properly add it in its proper location. 
			}
		}
		
		Tree.resetSize(); //Uses resetSize method to get size. 
		Tree.setHeight(lines - 1); //Manally set height by use the lines value. 
		
        textReader.close();
        
        // NOTE: Make sure that your tree has an updated size and height
        
        // Return the resulting filled tree
        return Tree;

    }
        
    /* TODO 8: 
     * Method ArrayToTree: 
     * Takes and array tree of FamilyMember instances, reads it, and builds the 
     * corresponding linked-list-based tree
     * Note: the array may not be full (some of its elements might be null): it represents a binary tree
     ****************************************************************************************/    
    public static BTree<FamilyMember> ArrayToTree(FamilyMember[] Family) {
        // Create an empty linked-list-based binary tree:
        BTree<FamilyMember> Tree = new BTree<FamilyMember>();
		String dir = ""; //Creating an empty string to be used later. 
		FamilyMember Empty = new FamilyMember("No entry here", "", 0); //Creating a new FamilyMember to fill in empty or null places in the binary tree.  
		int counter = 0; //A counter to get the size of the tree. 
		
        for (int i = 0; i < Family.length; i++) { //This for loop will run through the array and assign the data into a binary tree.  
			if (Family[i] == null) { //If there is a null entry in the array, it will be "plugged" in with the data from Empty. 
				BTNode<FamilyMember> nullNode = new BTNode<FamilyMember>(Empty); //Created the node with the data. 
				dir = Directions(i); //Gets the directions (LLR, LL, R, etc) in a string to where the empty node should be. 
				Tree.insertDataAtLocation(dir, Empty); //Adds the node to the tree using the insertDataAtLocationmethod. 
			}
			else { //If it is not null, then it would get the data from the array, put it into a node, and adds to the tree.  
				BTNode<FamilyMember> iter = new BTNode<FamilyMember>(Family[i]);
				dir = Directions(i); //Gets the directions (LLR, LL, R, etc) in a string to where the node should be. 
				Tree.insertDataAtLocation(dir, Family[i]); 
				counter++; //Adds to counter, will be used to set size. 
			}
		}
		
		Tree.setSize(counter); //Updates the size by setting it.   
		Tree.resetHeight(); //Updates the height by using the resetHeight method. 
		
        // NOTE: Make sure that your tree has an updated size and height
        
        // Return the resulting filled linked-list-based binary tree
        return Tree;
    }
    
    
    /****************************************************************************************   
     * Main Method:
     ****************************************************************************************/    
	public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = args[0];

        // Creates an array tree based on what is read in the file called filename:
        FamilyMember[] Family = readFamilyIntoArray(filename);
        // Prints out the content of the array tree:
        for (int i=0; i<Family.length; i++) {
            if (Family[i] == null) {
                System.out.println("No entry here");
            } else {
                System.out.println(Family[i].toString());
            }
        } 
        System.out.println();
        System.out.println();
        
		
        // Creates a linked-list based tree from the array tree Family:
        BTree<FamilyMember> Tree = ArrayToTree(Family);
		
        // Prints out the content of the linked-list-based tree:
        Tree.print();
        System.out.println();
        
        System.out.println("Tree size = " + Tree.getSize());
        System.out.println("Tree height = " + Tree.getHeight());
        System.out.println();
        System.out.println();
		
		
        // Creates a linked-list-based tree directly from reading the file:
        BTree<FamilyMember> Tree2 = readFamilyIntoTree(filename);
        // Prints out the content of the linked-list-based tree:
        Tree2.print();
		
		System.out.println();
		System.out.println("Tree size = " + Tree2.getSize());
		System.out.println("Tree height = " + Tree2.getHeight());
		System.out.println(); 
		
		BTree<FamilyMember> Tree3 = readFamilyIntoTree(filename); 
		BTNode<FamilyMember> nRoot = Tree3.getRoot(); 
		
		System.out.println("INORDER TRAVERSAL:"); 
		Tree3.inOrderTraversal(nRoot);
    }
    
    /************************************************************************************
     * HELPER METHODS: ******************************************************************
     ************************************************************************************/

    /* Method Directions: 
     * Given an integer, which represent the index of a piece of data in an array tree, 
     * this methode figures out what directions in the tree we should take to "plug" the node
     */
    public static String Directions(int i) {
        String directions = "";
		if (i == 0) {
			directions = "0"; 
			return directions;
		}
		
        int index = i + 1; 
        while (index != 1) {
            if (index % 2 == 1) directions = "R" + directions; //R
            else directions = "L" + directions; //L 
            index /= 2;    
        }
        //System.out.println("Directions for member at index " + i + " is: " + directions);
        return directions;
    }
    
    /* Method processLine:
     * This method is given a String that is one element of the line in the text file for be read.
     * The element is of the following form: <String>-<String>,<int>,<String>
     * Example of such an element: John-Doe,3,LLR
     * It processes this element and produces an array of 4 strings: 
     * [first name, last name, number of siblings, location in the array where it should be stored]
     * In the case of the above example, we would produce the following array: [John, Doe, 3, 8]
     */
    public static String[] processLine(String element) {
        String[] result = new String[5];

        String[] member = element.split(",");
        String[] name = member[0].split("-");
        result[0] = name[0];
        result[1] = name[1];
        result[2] = member[1];
        result[3] = member[2];

        int place = 0;
        if (member[2].equals("0")) place = 0;
        else {
            place = 0;
            while (member[2].length() != 0) {
                if (member[2].charAt(0) == 'F') place = place*2 + 1;
                if (member[2].charAt(0) == 'M') place = place*2 + 2;
                member[2] = member[2].substring(1);   
            }
        }
        
        result[4] = "" + place;
        return result;
    }

    /* Method countLines: 
     * This method takes a file name as a parameter and 
     * returns the number of lines in this file (an int)
     */
    public static int countLines(String filename) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int counter = 0;
        // As long as there is something to read in the file...
        while (textReader.ready()) {
            // we increase our line counter
            counter++;
            // read the line and move to the next to check if there is something to read (the while condition)
            textReader.readLine();   
        }
        
        textReader.close();
        return counter;
    }


}