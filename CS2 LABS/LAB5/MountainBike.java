public class MountainBike extends Bike {
	//Declaring variables unique to this class.
    private String uL;
    private int wS;

	//Getters 
    public String getuserLevel() {
		return this.uL;
    }
    public int getWheelSize() {
		return this.wS;
    }
    
	//Setters
    public void setuserLevel(String userLevel) {
		this.uL = userLevel; 
    }
	
	public void setWheelSize(int wheelSize) {
		this.wS = wheelSize;
    }

    @Override
	//printRecord overides the the master class method to add the additional attributes. 
    public void printRecord() { 
		super.printRecord(); 
		System.out.println("User Level: " + this.uL);
		System.out.println("Wheel Size: " + this.wS);
    }
}
