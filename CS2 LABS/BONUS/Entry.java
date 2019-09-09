/**** This class defines the blueprint of a family member  
 **** A family member has a first name, a last name, and a number of siblings 
 **** The code is given to you: you MUST NOT modify it.
 ****/

public class Entry {
	//Attributes 
    private int number;
    private int month; 
	private int day; 
	private int year;
	private String title; 
	private String content; 
	private boolean importance; 
    
    public Entry() {}
    
	//Constructors
    public Entry(int num, int M, int D, int YR, String TL, String CT, boolean SR) {
        number = num;
        month = M;
        day = D;
		year = YR; 
		title = TL; 
		content = CT; 
		importance = SR; 
    }
	
	//Setters 
    public void setNumber(int num) {
        number = num;
    }
    
    public void setMonth(int M) {
        month = M;
    }
    
    public void setDay(int D) {
        day = D;
    }
	
	public void setYear(int YR) {
		year = YR; 
	}
	
	public void setTitle(String TL) { 
		title = TL; 
	}
	
	public void setContent(String CT) { 
		content = CT; 
	}
	
	public void setImportance(boolean SR) { 
		importance = SR; 
	}
    
	//Getters 
    public int getNumber() {
        return number;   
    }
    
    public int getMonth() {
        return month;   
    }
    
    public int getDay() {
        return day;   
    }
	
	public int getYear() { 
		return year; 
	}
	
	public String getTitle() { 
		return title; 
	}
	
	public String getContent() { 
		return content; 
	}
	
	public boolean getImportance() {
		return importance; 
	}
    
	/*
    public String toString() {
		
    }
	*/
}