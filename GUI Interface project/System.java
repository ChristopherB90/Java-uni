/*
 * Author: Christopher Bond
 * 
*/
public class System {
	private String make; // variables private so can only be access via the methods outlines below.
	private String model;
	private int speed;
	private int memorySize; // MB	
	private double hardDiskSize; // in GB
	private double purchaseCost;
	
	public System(String makeIn, String modelIn,int speedIn) //Constructor for the system.
	{
		make = makeIn;
		model= modelIn;
		speed = speedIn;
	}
	// Methods for setting/accessing the private variables
	public String getMake() { // Returns make, of type String.
		return make;
	}
	public String getModel() {// Returns model, of type String.
		return model;
	}
	public int getSpeed() {// Returns speed, of type Int.
		return speed;
	}
	public void setMemory(int newMemory) { // Sets memorySize, taking input of Int.
		memorySize = newMemory;
	}
	public void setHardDisk(double newHardDisk) {// Sets hardDiskSize, taking input of Double.
		hardDiskSize = newHardDisk;
	}
	public void setPurchaseCost(double newPurchaseCost) { // Sets newPurchaseCost, taking input of Double.
		purchaseCost =  newPurchaseCost;
	}
	public String displayDetails() { // Returns String of getMake(), getSpeed(), memorySize(), hardDiskSize() and purchaseCost(), which descriptors.
		return ("Make: "+ getMake() + "\nModel: " +getModel()+"\nSpeed: "+getSpeed()+"\nMemory: "+memorySize+" MB"+"\nHard Disk Size: "+hardDiskSize+" GB"+"\nPurchase Cost: "+"£"+purchaseCost);
	}
	public String checkHDStatus() { // Returns String of either 'low' or 'OK' based on hardDiskSize().
		if (hardDiskSize < 2){
			return "low";}
		else {
			return "OK";
		}
	}
	public Boolean goodMemorySize() {; // Returns boolean, 'true' if equal to or above 128, so good size, or false if at 127 or below, not a good size.
		return (memorySize >= 128);
	}
	public String diagnoseSystem() { // Returns String combining checkHDStatus() and goodMemorySize() with descriptor.
		return ("Hard disk size = " + checkHDStatus() +"\n"+"Memory size OK: "+goodMemorySize());
	}
	
	public String displaySystemProperties() { // Returns String commenting on operating system, and shows the System properties.
		String message; // Initialises empty string variable.
		if (java.lang.System.getProperty("os.name").equals("Windows 10")) { // Assigns value to empty string variable 'message' to add to the end of the returns statement.
			message ="Nice operating system!";
		}
		else if (java.lang.System.getProperty("os.name").equals("linux")) { // if OS is linux, returns negative message.
			message = "Not-so-nice operating system.";
		}
		else {
			message ="An ok operating system.";
		}
		return (("Operating System Architecture: "+java.lang.System.getProperty("os.arch")+"\nOperating System Name: " + java.lang.System.getProperty("os.name")
		+"\noperating System Version: "+ java.lang.System.getProperty("os.version")+"\nUser Account Name: " + java.lang.System.getProperty("user.name")
		+"\nJava version: "+ java.lang.System.getProperty("java.version")) + ("\n"+message));
	}
}