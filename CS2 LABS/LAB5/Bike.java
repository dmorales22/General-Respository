public class Bike {

    //Attributes

    /* These are just declaring attributes for the user defined type. This are the default attributes of all bike types.*/
    private String bikeType;
    private String modelNum;
    private String ageRange; 
    private int numBikes; 
    private double purPrice; 
    private double retailPrice;
    private String color; 
	
    //Constructors

    /* The first constructor sets up the whole information of the bike types if all the attributes are inputed */
    public Bike() {

	this.bikeType = bikeType; 
	this.modelNum = modelNum;
	this.ageRange = ageRange;
	this.numBikes = numBikes;
	this.purPrice = purPrice; 
	this.retailPrice = retailPrice;
	this.color = color; 
    }
    
    //Getters
    
    public String getbikeType() {
	return this.bikeType;
    }
    public String getmodelNum() {
	return this.modelNum;
    }
    public String getageRange() {
	return this.ageRange;
    }
    public int getnumBikes() {
	return this.numBikes;
    }
    public double getpurPrice() {
	return this.purPrice;
    }
    public double getretailPrice() {
	return this.retailPrice;
    }
    public String getcolor() {
	return this.color;
    }

    //Setters

    public void setbikeType(String bt) {
	this.bikeType = bt;
    }
    public void setmodelNum(String mn) {
	this.modelNum = mn;
    }
    public void setageRange(String ar) {
	this.ageRange = ar;
    }
    public void setnumBikes(int nb) {
	this.numBikes = nb;
    }
    public void setpurPrice(double pp) {
	this.purPrice = pp;
    }
    public void setretailPrice(double rp) {
	this.retailPrice = rp;
    }
    public void setcolor(String c) {
	this.color = c;
    }

    //This is method is the print method that would print out the default attributes. 
    public void printRecord() {
	if (this.numBikes <= 0) { //It will print out of stock if numBikes are zero. 
	    System.out.println("[OUT OF STOCK]");
	}
	System.out.println("Bike Type: " + this.bikeType);
	System.out.println("Model Number: " + this.modelNum);
	System.out.println("Age Range: " + this.ageRange);
	System.out.println("Number of Bikes: " + this.numBikes);
	System.out.println("Purchase Price: " + this.purPrice);
	System.out.println("Retail Price: " + this.retailPrice);
	System.out.println("Color: " + this.color);

    }

}
