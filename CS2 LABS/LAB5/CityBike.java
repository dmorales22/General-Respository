public class CityBike extends Bike { //Extends from master class.
    //Declares attributes unique to this class. 
    private int nB;
    private String AoD;

    //Setters
    public void setBrake(String brakeType) {
		this.AoD = brakeType; 
    }
    public void setnumBaskets(int numBaskets) {
		this.nB = numBaskets;
    }
    //Getters
    public String getBrake() {
		return AoD;
    }
    public int getnumBaskets() {
		return nB;
    }
    
    @Override //Overrides master printRecord method. 
    public void printRecord() {
		super.printRecord();  //Prints out the additional attributes at the end using super function. 
		System.out.println("Brake Type: " + this.AoD);
		System.out.println("Wheel Size: " + this.nB);
    }
}
