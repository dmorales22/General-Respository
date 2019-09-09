public class RoadBike extends Bike {
	//Declaring variables unique to this class.
    private int ng;
    private double nw;
   
	//Setters 
    public void setGears(int numGears) {
		this.ng = numGears; 
    }
    public void setWeight(double numWeight) {
		this.nw = numWeight;
    }
	//Getters
    public int getGears() {
		return ng;
    }
    public double getWeight() {
		return nw;
    }
   
    @Override
	//printRecord overides the the master class method to add the additional attributes.
    public void printRecord() {
		super.printRecord(); 
		System.out.println("Number of Gears: " + this.ng);
		System.out.println("Weight: " + this.nw);
    }
}
