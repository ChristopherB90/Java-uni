
/*
 * @author Christopher Bond
 * @version 07/07/2020
*/
public class TestModuleGrader {

	public static void main(String[] args) {
		
		ModuleGrader a = new ModuleGrader();
		
		// Test for gradeModule method
		
		for (int i=0;i<=100;i+=10) 
		{
		System.out.println("For a score of :"+i+" the program return " +a.gradeModule(i)); 
		/* Testing the gradeModule method with increasing score input, value normally passed be passed 
		from the getValidModuleMark() method, which always passes a double.*/
		}
		

		// Test for getValidModuleMark method
			
		a.getValidModuleMark();
	
		// Test for startModuleGrading method
		
		a.startModuleGrading();
		
	}
}


