/*
 * @author Christopher Bond
 * @version 07/07/2020
*/
import java.util.*; 

public class DegreeGrader {
	
	Scanner sc = new Scanner(System.in); // Initalises scanner to be used later.
	
	public String gradeDegree(double moduleAverage, double ISMAverage, int compFails, int outFails ) {
		String result = "";			// Initialises variable ready to return.
		
		//filter out fails, as any fails more than 0 or Compensatable fails more than 30 automatically fail.
		if (outFails ==0 || compFails >= 30) 
		{
			if (moduleAverage >= 70 && ISMAverage >= 70) 
			{
			
				if (compFails ==0) 	// So can only get distinction if failed nothing and AVG still over 70.
				{
					result = "Distinction";
				}
				else if(compFails <=15) // any Compensatible fails up to 15 may still receive a Merit.
				{
					result = "Merit";
				}
				else {
					result = "Pass"; // We can end here as we know they haven't failed if they have got this far.
				}
			}
			else if (moduleAverage >= 60 && ISMAverage >= 60)
			{
				// We start at Merit because due to grade, Distinction isn't possible.
				if (compFails <= 15) 
				{
					result = "Merit";
				}
				else 
				{
					result = "Pass";
				}
			}
			// If we arrive here Pass is best that can be achieved.
			else if ( moduleAverage >=50 && ISMAverage >=50) 
			{
				result = "Pass";
			}
			else
			{
				result = "Fail";
			}
		}
		else
		{
			result = "Fail";
		}
		return result;
	}
	
	public boolean isItDouble(String input){  // New method to check if inputs are of Double type, for below for methods in ModuleGrader +  DegreeGrader classes.
		try
		{
			Double.parseDouble(input); // If able to complete this line, returns true.
			return true;
		}
		catch(Exception e)
		{	
			return false; // if Exception is raised, will return false.
		}
	}
	
	public boolean isItInt(String input){  // New method to check if inputs are of Integer type, for below for methods,
		try
		{
			Integer.parseInt(input); // If able to complete this line, returns true.
			return true;
		}
		catch(Exception e)
		{	
			return false;
		}
	}
	
	public double getModuleAverage()
	{
		String StringModIn;	 // Input variable
		double scoreIn = -1;	// Initialiser, will always be overwritten. 
		boolean StillNotDouble = false;		// Safety check variable on if string input can be changed to double
		boolean OutOfBounds = false;		// Safety check variable on if Double.parseDouble(StringscoreIn) is within 0-100 range.
		
		System.out.println("Enter the average taught module score (Between 0 - 100 %): ");
		StringModIn = sc.next();
		
		if((isItDouble(StringModIn) ==true)) // checks if first input is already able to convert to double. If so, checks if in 0-100 range,
		{									 //  and if so, returns. If not,  sets OutOfBounds to true, and enters the next while loops.
			scoreIn =Double.parseDouble(StringModIn); 

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
		
		// calls isItDouble method to make sure input can be converted to double (so is a score not a word), else prompts for another input.
		while (isItDouble(StringModIn) !=true || StillNotDouble == true|| OutOfBounds == true  ) // checks if input/re-input can be converted to double or if out of bounds, if any true then will prompt for re-input.
		{  
			System.out.println("Invalid input, please enter new score (Between 0 - 100 %)");
			StringModIn = sc.next(); 
		
			//check if the re-input string can be converted to double, and if not, sets StillNotDouble to true,
			//moves through ELSE to parse it.
			if (isItDouble(StringModIn) == false)
			{
				StillNotDouble = true;
				System.out.print("Not a number! ");
			}
			else
			{
				// now input is convertible to double.
				StillNotDouble = false;
				
				scoreIn =Double.parseDouble(StringModIn); 
				
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
	
	public double getISMAverage() 
	{
		String StringISMIn;
		double ISMIn = -1;	// Initialiser, will always be overwritten. 
		boolean StillNotDouble = false;		// Safety check variable on if string input can be changed to double
		boolean OutOfBounds = false;		// Safety check variable on if Double.parseDouble(StringscoreIn) is within 0-100 range.

		System.out.println("Enter Independant Study module score percentage (Between 0 - 100 %) : ");
		StringISMIn =  sc.next(); // Takes input of module mark as a string to accept all kinds of input without throwing excepton.
		
		if((isItDouble(StringISMIn) ==true)) // checks if first input is already able to convert to double. If so, checks if in 0-100 range,
		{									   //  and if so, returns. If not,  sets OutOfBounds to true, and enters the next while loops.
			ISMIn =Double.parseDouble(StringISMIn); 

			if (ISMIn < 0 || ISMIn > 100)
			{
				OutOfBounds = true;
				System.out.print("Number is out of bounds! ");
			}
			else 
			{
				return ISMIn;
			}
		}
		
		while (isItDouble(StringISMIn) !=true || StillNotDouble == true|| OutOfBounds == true  ) // checks if input/re-input can be converted to double or if out of bounds, if any true then will prompt for re-input.
		{  
			System.out.println("Invalid input, please enter new score (Between 0 - 100 %)");
			StringISMIn = sc.next(); 
		
			// check if the re-input string can be converted to double, if not will ask again and sets StillNotDouble to true, if it is (in the "else" section) moves on.
			if (isItDouble(StringISMIn) == false)
			{
				StillNotDouble = true;
				System.out.print("Not a number! ");
			}
			else
			{
				// now input is convertible to double.
				StillNotDouble = false;
				
				ISMIn =Double.parseDouble(StringISMIn); 
				
				// now check if in 0-100 range.
				if (ISMIn < 0 || ISMIn > 100)
				{	 
					OutOfBounds = true;	
				}
				else
				{
					OutOfBounds = false;
				}	
			}
		}

		return ISMIn;
	}
	
	public int getCompFailed()
	{
		String StringCompFailedIn;
		int CompFailedIn = -1;	// Initialiser, will always be overwritten. 
		boolean StillNotInt = false;		// Safety check variable on if string input can be changed to int
		boolean OutOfBounds = false;		// Safety check variable on if Integer.parseInt(StringscoreIn) is within 0-100 range.

		System.out.println("Enter amount of credits compensatably failed (Between 0 - 180) : ");
		StringCompFailedIn =  sc.next(); // Takes input of module mark as a string to accept all kinds of input without throwing exception.
		
		if((isItInt(StringCompFailedIn) ==true)) // checks if first input is already able to convert to int. If so, checks if in 0-180 range,
		{									   //  and if so, returns. If not,  sets OutOfBounds to true, and enters the next while loops.
			CompFailedIn =Integer.parseInt(StringCompFailedIn); 

			if (CompFailedIn < 0 || CompFailedIn > 180)
			{
				OutOfBounds = true;
				System.out.print("Number is out of bounds! ");
			}
			else 
			{
				return CompFailedIn;
			}
		}
		
		while (isItInt(StringCompFailedIn) !=true || StillNotInt == true|| OutOfBounds == true  ) // checks if input/re-input can be converted to int or if out of bounds, if any true then will prompt for re-input.
		{  
			System.out.println("Invalid input, please enter a correct amount of credits (Between 0 - 180)");
			StringCompFailedIn = sc.next(); 
		
			// check if the re-input string can be converted to int, if not will ask again and sets StillNotInt to true,
			//if it is (in the "else" section) moves on.
			if (isItInt(StringCompFailedIn) == false)
			{
				StillNotInt = true;
				System.out.print("Not a number! ");
			}
			else
			{
				// now input is convertible to Int.
				StillNotInt = false;
				
				CompFailedIn =Integer.parseInt(StringCompFailedIn); 
				
				// now check if in 0-180 range.
				if (CompFailedIn < 0 || CompFailedIn > 180)
				{	 
					OutOfBounds = true;	
				}
				else
				{
					OutOfBounds = false;
				}	
			}
		}
		return CompFailedIn;
	}
	
	public int getOutFailed() // Unlike the other modules this returns INT, as number of modules is a whole number.
	{
		String  StringFailedIn;
		int FailedIn = -1;	// Initialiser, will always be overwritten. 
		boolean StillNotInt = false;		// Safety check variable on if string input can be changed to int
		boolean OutOfBounds = false;		// Safety check variable on if Integer.parseInt(StringscoreIn) is within 0-11 range.

		System.out.println("Enter number of modules outright failed (0 - 11) : ");
		StringFailedIn =  sc.next(); // Takes input of module mark as a string to accept all kinds of input without throwing exception.
		
		if((isItDouble(StringFailedIn) ==true)) // checks if first input is already able to convert to double. If so, checks if in 0-100 range,
		{									   //  and if so, returns. If not,  sets OutOfBounds to true, and enters the next while loops.
			FailedIn =Integer.parseInt(StringFailedIn); 

			if (FailedIn < 0 || FailedIn > 11)
			{
				OutOfBounds = true;
				System.out.print("Number is out of bounds! ");
			}
			else 
			{
				return FailedIn;
			}
		}
		while (isItInt(StringFailedIn) !=true || StillNotInt == true|| OutOfBounds == true  ) // checks if input/re-input can be converted to int or if out of bounds, if any true then will prompt for re-input.
		{  
			System.out.println("Invalid input, please correct amount of modules outright failed (0 - 11)");
			StringFailedIn = sc.next(); 
		
			// check if the re-input string can be converted to int, if not will ask again and sets StillNotDouble to true,
			//if it is (in the "else" section) moves on.
			if (isItInt(StringFailedIn) == false)
			{
				StillNotInt = true;
				System.out.print("Not a number! ");
			}
			else
			{
				// now input is convertible to int.
				StillNotInt = false;
				
				FailedIn =Integer.parseInt(StringFailedIn); 
				
				// now check if in  0 - 11 range.
				if (FailedIn < 0 || FailedIn > 11)
				{	 
					OutOfBounds = true;	
					System.out.print("Out of bounds! ");
				}
				else
				{
					OutOfBounds = false;
					return FailedIn;
				}	
			}
		}
		return FailedIn;
	}
	
	public void startDegreeGrading() // calls gradeDegree() from the line 7, and takes the inputs from the 4 above methods as its args.
	{
		System.out.println("*********** Degree Classification Program *********");
		System.out.print(gradeDegree(getModuleAverage(),getISMAverage(),getCompFailed(),getOutFailed())); //returns the grade once t
	}
	
}	

















































