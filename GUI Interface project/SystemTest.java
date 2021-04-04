/*
 * Author: Christopher Bond
 * 
*/
import java.util.*;
public class SystemTest {
	static Scanner sc = new Scanner(java.lang.System.in);

	public static boolean integerTest(String entry) { // Returns boolean, checks whether or not the argument can be converted to Integer without throwing exception and disrupting program.
		try
			{
			Integer.parseInt(entry);
			 return true;
			}
		catch(Exception error)
			{
			return false;
			}
	}
	
	public static boolean doubleTest(String entry) { // Returns boolean, checks whether or not the argument can be converted to Double without throwing exception and disrupting program.
		try
			{
			Double.parseDouble(entry);
			 return true;
			}
		catch(Exception error)
			{
			return false;
			}
	}
							//     * * * * * This MAIN method is to be uncommented and the other MAIN method be commented for the Command Line test. * * * * * * * * * *
/*	
	public static void main(String[] args) // Main method for testing Part A. Initialises and can be run in CMD prompt.
	{
		java.lang.System.out.print("Initalising with make as 'Intel', model as 'SpeedyPC', and processor speed (speed) as '150'");
		System newpc = new System("Intel","SpeedyPC",150); // constructor for System class
		java.lang.System.out.print("\n"+newpc.getMake()); // prints Make
		java.lang.System.out.print("\n"+newpc.getModel()); // prints Model
		java.lang.System.out.print("\n"+newpc.getSpeed()); // prints Speed
		java.lang.System.out.print("\nSetting Memory (RAM) to 128 (MB), Hard Disk space to 50 (GB), and Purchase Cost to 800 (£)");
		newpc.setMemory(128); // sets memorySize to 128, just above cutoff for goodMemorySize to test later. 
		newpc.setHardDisk(50); // Sets hardDiskSize to value to show. 
		newpc.setPurchaseCost(800.00); // sets cost for value to show.
		java.lang.System.out.print("\nSystem details are: "+newpc.displayDetails());
		java.lang.System.out.print("\nAs Hard Disk size greater than 2 GB, checkHDStatus returns 'OK':\n"+newpc.checkHDStatus());
		newpc.setHardDisk(1.5); // Sets hardDiskSize to value below 2 to show.
		java.lang.System.out.print("\nSetting it to less than 2 GB makes checkHDStatus return 'low':\n"+newpc.checkHDStatus());
		java.lang.System.out.print("\nPrinting goodMemorySize (RAM); since it is at 128, it will return 'true': \n");
		java.lang.System.out.print(newpc.goodMemorySize());
		java.lang.System.out.print("\nChanging memorySize (by setMemory(X)) to 127 (lower than 128, will return false: \n");
		newpc.setMemory(127);
		java.lang.System.out.print(newpc.goodMemorySize());
		java.lang.System.out.print("\nThe diagnoseSystem() method returns methods, combining the above two tests: \n");
		java.lang.System.out.print(newpc.diagnoseSystem());
		java.lang.System.out.print("\nThe displaySystemProperties() method returns an output based on the system architecture, on my computer will display windows 10, calling it a nice operating system: \n");
		java.lang.System.out.print(newpc.displaySystemProperties());
	}
}
	*/
	public static void menu() // Method for printing the menu into the console, has its own method as is used a few times.
	{
		java.lang.System.out.print("Please select from the following options: "
				+ "\n[1] - Print System Details \n[2] - Display System Properties"
				+ "\n[3] - Diagnose System \n[4] - Set Details \n[5] - Quit the program.\n");
	}
	
	
	public static void main(String[] args) { // main method
		 

		System newpc = new System("Intel","speedypc",120); // constructor initialising newpc instance
		String back;
		// create empty input variables.

		int choiceIn= 0;
		String ramIn;
		String HDIn;
		String purchIn;
		
		java.lang.System.out.print("Please select from the following options: "
				+ "\n[1] - Print System Details \n[2] - Display System Properties"
				+ "\n[3] - Diagnose System \n[4] - Set Details \n[5] - Quit the program.\n");
		String StringchoiceIn = sc.next(); // takes first input.
		while (integerTest(StringchoiceIn)==false) { // first loop, ensures first input string CAN be converted to integer, loops and asks for new entry, continues if it can.
			java.lang.System.out.print("Invalid input, please re-enter: ");
			StringchoiceIn = sc.next();
		}

		while (choiceIn != 5 || integerTest(StringchoiceIn) == false)  // begin WHILE loop, main loop of program. Repeats the loop while choiceIn != 5, as 5 is the exit button, or if the intput string cannot parse to INT.
		{
			if (integerTest(StringchoiceIn) == false) { // checks if input string can be parsed to INT.
				java.lang.System.out.print("Invalid input, please re-enter: ");
				StringchoiceIn = sc.next();
			}
			else if ((Integer.parseInt(StringchoiceIn) <= 0) || (Integer.parseInt(StringchoiceIn) > 5 )) { // Then makes sure the entry is 0-4, if 5 skips ahead
				java.lang.System.out.print("Entry out of bounds, please enter number between 1 and 5: ");
				StringchoiceIn = sc.next();
			}
			else {	// At this point choice will be 1,2,3 or 4
				choiceIn =Integer.parseInt(StringchoiceIn);
				if (choiceIn==1){	
					java.lang.System.out.print(newpc.displayDetails());
					java.lang.System.out.print("\n");
					java.lang.System.out.print("Back to menu? 'N' to quit or any button to go back to menu: "); // After displaying info, asks if wants to go back to initial menu.
					back = sc.next();
					if (back.toUpperCase().equals("N")) { // if selects "N" or "n" then takes choiceIn as 5, and ends the program. Else, returns to main menu.
						choiceIn = 5;
					}
					else {
						menu();
						StringchoiceIn = sc.next();
					}
				}
				else if(choiceIn==2) {
					java.lang.System.out.print(newpc.displaySystemProperties());
					java.lang.System.out.print("\n");
					java.lang.System.out.print("Back to menu? 'N' to quit or any button to go back to menu: ");
					back = sc.next();
					if (back.toUpperCase().equals("N")) { // if selects "N" or "n" then takes choiceIn as 5, and ends the program. Else, returns to main menu.
						choiceIn = 5;
					}
					else {
						menu();
						StringchoiceIn = sc.next();
					}	
				}
				else if(choiceIn == 3) {
					java.lang.System.out.print(newpc.diagnoseSystem());
					java.lang.System.out.print("\n");
					java.lang.System.out.print("Back to menu? 'N' to quit or any button to go back to menu: ");
					back = sc.next();
					if (back.toUpperCase().equals("N")) { // if selects "N" or "n" then takes choiceIn as 5, and ends the program. Else, returns to main menu.
						choiceIn = 5;
					}
					else {
						menu();
						StringchoiceIn = sc.next();
					}
				}
				else if(choiceIn ==4) {

					java.lang.System.out.print("Enter new RAM value in MB: ");
					ramIn = sc.next();
					while ((integerTest(ramIn) == false || Integer.parseInt(ramIn) <=0 )) { // check if can parse as INT and is positive, loops if not.
						java.lang.System.out.print("Invalid Input, please enter RAM value in MB: ");	
						ramIn = sc.next();
					}
					newpc.setMemory(Integer.parseInt(ramIn)); // if CAN parse as INT, takes input and sets Memory.
							
					java.lang.System.out.print("Enter new Hard Disk size in GB: ");	
					HDIn = sc.next();
					while (doubleTest(HDIn) == false || Double.parseDouble(HDIn) <=0) { // check if can parse as Double and is positive, loops if not.
						java.lang.System.out.print("Invalid input, please enter new Hard Disk size in GB: ");	
						HDIn = sc.next();
					}
					newpc.setHardDisk(Double.parseDouble(HDIn));// if CAN parse as Double, takes input and sets hard Disk size.
					
					java.lang.System.out.print("Enter purchasing cost (£): ");
					purchIn = sc.next();
					while (doubleTest(purchIn) == false || Double.parseDouble(purchIn) <=0) { // check if can parse as Double and is positive, loops if not.
						java.lang.System.out.print("Invalid input, please enter purchasing cost (£): ");	
						purchIn = sc.next();
					}
					newpc.setPurchaseCost(Double.parseDouble(purchIn));
											
					java.lang.System.out.print("\n");
					java.lang.System.out.print("Back to menu? 'N' to quit or any button to go back to menu: ");
					back = sc.next();

					if (back.toUpperCase().equals("N")) { // if selects "N" or "n" then takes choiceIn as 5, and ends the program. Else, returns to main menu.
						choiceIn = 5;

					}
					else {
						menu();
						StringchoiceIn = sc.next();
					}					
				}
			}
	
		}
		java.lang.System.out.print("END");
	}
		
}
