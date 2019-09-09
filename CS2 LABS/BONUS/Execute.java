import java.io.*;
import java.util.Scanner;
import java.util.*; 

public class Execute { 

	public static Entry[] readFileToArray(String filename) throws FileNotFoundException, IOException { 
	
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);
		Entry[] EN = new Entry[2]; 
		int lines = countLines(filename);
		String[] temp = new String[3]; //A new string array to temporary hold information paresed from textfile
		String[][] std = new String[lines][10]; 
		int cout = 0; 
		
		for (int i = 0; i < lines; i++) { //This for loop reads the lines in the textfile, splits the elements by one whitespace, and adds it in the std.  
			std[i] = textReader.readLine().split(",   "); 
		}
	
		for (int i = 0; i < lines; i++) { //This nested for loop creates objects, parses them from the string array, sets it attributes, and adds it to the Family array. 
			Entry ENS = new Entry(); 				
			ENS.setNumber(Integer.parseInt(std[i][0])); 
			temp = std[i][1].split("-");
			ENS.setMonth(Integer.parseInt(temp[0])); 
			ENS.setDay(Integer.parseInt(temp[1])); 
			ENS.setYear(Integer.parseInt(temp[2])); 
			ENS.setTitle(std[i][2]); 
			if (std[i][3].equals("*")) { 
				ENS.setImportance(true);
			}
			
			else { 
				ENS.setImportance(false);
			}
			
			ENS.setContent(std[i][4]); 
			EN[cout] = ENS;
			cout++;  //Adds to counter. 
		}

		return EN; 
	}
	
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

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = args[0];
		Entry[] EN = readFileToArray(filename);
		System.out.println(EN[0].getTitle()); 
		
		
		
	}
}
