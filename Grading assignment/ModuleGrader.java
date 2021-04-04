/*
 * @author Christopher Bond
 * @version 07/07/2020
*/
import java.util.*; // Imports the scanner package.

public class ModuleGrader {
	
	Scanner sc = new Scanner(System.in); // Initialises scanner to be used later.
	
	public String gradeModule(double percentage) // Returns the String Grade based on their score in the module.
	{
		if (percentage >= 70 ) 
		{
			return "Excellent";
		}
		else if (percentage <= 69 && percentage >= 60)
		{
			return "Good";
		}
		else if ((percentage <= 59) && (percentage >= 50 )) {
			return "Satisfactory";
		}
		else if( percentage <= 49 && percentage >= 40 ) {
			return "Comprehensive fail";
		}
		else {
			return "Outright fail";
		}
	}
	
	public boolean isItDouble(String input){  // New method to check if inputs are of Double type, for below for methods in ModuleGrader +  DegreeGrader classes.
		try
		{
			Double.parseDouble(input); // If able to complete this line, returns true.
			return true;
		}
		catch(Exception e)
		{	
			return false;
		}
	}
	
	public double getValidModuleMark() 
	{	
		String StringscoreIn;	 // Input variable
		double scoreIn = -1;	// Initialiser, will always be overwritten. 
		boolean StillNotDouble = false;		// Safety check variable on if string input can be changed to double
		boolean OutOfBounds = false;		// Safety check variable on if Double.parseDouble(StringscoreIn) is within 0-100 range.

		System.out.println("Enter module score percentage (Between 0 - 100 %) : ");
		StringscoreIn =  sc.next(); // Takes input of module mark as a string to accept all kinds of input without throwing excepton.
		
		if((isItDouble(StringscoreIn) ==true)) // checks if first input is already able to convert to double. If so, checks if in 0-100 range,
		{									   //  and if so, returns. If not,  sets OutOfBounds to true, and enters the next while loops.
			scoreIn =Double.parseDouble(StringscoreIn); 

			if (scoreIn < 0 || scoreIn > 100)
			{
				OutOfBounds = true;
				System.out.print("Number is out of bounds! ");
			}
			else 
			{
				return scoreIn;
			}
		}
	
		while (isItDouble(StringscoreIn) !=true || StillNotDouble == true|| OutOfBounds == true  ) // checks if input/re-input can be converted to double or if out of bounds, if any true then will prompt for re-input.
		{  
			System.out.println("Invalid input, please enter new score (Between 0 - 100 %)");
			StringscoreIn = sc.next(); 
		
			//check if the re-input string can be converted to double, and if not, sets StillNotDouble to true,
			//moves through ELSE to parse it.
			if (isItDouble(StringscoreIn) == false)
			{
				StillNotDouble = true;
				System.out.print("Not a number! ");
			}
			else
			{
				// now input is convertible to double.
				StillNotDouble = false;
				
				scoreIn =Double.parseDouble(StringscoreIn); 
				
				// now check if in 0-100 range.
				if (scoreIn < 0 || scoreIn > 100)
				{	 
					OutOfBounds = true;
					System.out.print("Out of bounds! ");
				}
				else
				{
					OutOfBounds = false;
					return scoreIn;
				}	
			}
		}
		return scoreIn; // returns a valid score of double type and between 0-100.
		
	}
	
	
	public void startModuleGrading() {
		double value;
		System.out.println("*********** Module Grading Program *********"); // Prints title.
		value = getValidModuleMark(); // Calls above method to acquire an acceptable module score from the user.
		System.out.println("Your grade is: "+gradeModule(value)); // Prints out the grade once acquired from the used.
	}
	

}













