/*
 * @author Christopher Bond
 * @version 07/07/2020
*/
public class TestDegreeGrader {
	public static void main(String[] args) {
		
		DegreeGrader b = new DegreeGrader();
		

		//Tests for gradeDegree method:
		
		System.out.println("Person A has 70 Mod avg, 70 ISM avg, 0 comp fails and 0 outright fails, so is awareded: "+b.gradeDegree(70,70,0,0));
		
		System.out.println("\nPerson B has 70 Mod avg, 70 ISM avg, 15 credit comp fail and 0 outright fails, so is awarded: "+ b.gradeDegree(70,70,15,0));
		
		System.out.println("\nPerson C has 70 Mod avg, 70 ISM avg, 30 credit comp fail and 0 outright fails, so is awarded: "+ b.gradeDegree(70,70,30,0));
		
		System.out.println("\nPerson D has 70 Mod avg, 70 ISM avg, 0 credit comp fail but 1 outright fails, so is awarded: "+ b.gradeDegree(70,70,0,1));
		
		System.out.println("\nPerson E has 65 Mod avg, 85 ISM avg, 0 credit comp fail and 0 outright fails, so is awarded: "+ b.gradeDegree(65,85,0,0));
		
		System.out.println("\nPerson F has 55 Mod avg, 55 ISM avg, 15 credit comp fail and 0 outright fails, so is awarded: "+b.gradeDegree(55,55,15,0));
		

		// Test for getModuleAverage method
		b.getModuleAverage();
		
		// Test for getModuleAverage method
		System.out.print("Independent study move average score: " + b.getISMAverage());
		
		
		// Test for getModuleAverage method
		System.out.print("The amount of compensatible credits failed is: "+b.getCompFailed());
		
		
		// Test for getModuleAverage method
		System.out.print("The amount of modules outright failed is :"+b.getOutFailed());
		
		
		// Test for getModuleAverage method
		b.startDegreeGrading();
		
		
	}

}
