package PP2_HospitalEmployee;

public class Main {
	
	public static void main(String[] args) {
		
		
		/*
		System.out.println("Possible Employee Hires");
		System.out.println("------------------------");
		
		Employee emp = new Employee();
		Employee emp2 = new Employee("Jonah Grauman", "White");
		Employee emp3 = new Employee("Josh Lynch", "Black", "Doctor", 170000);
		Employee emp4 = new Employee("Zion Chilagan", "Asian", "Administrator", 90000);
		Employee emp5 = new Employee("Gabe Estrada", "Hispanic", "Nurse", 14, 8);
		
		emp.viewEmployeeHourlyInformation(); //will be a bunch of null values
		emp2.viewNewEmployee();
		emp3.viewEmployeeSalaryInformation();
		emp4.viewEmployeeSalaryInformation();
		emp5.viewEmployeeHourlyInformation();
		*/
		Patient pat = new Patient("Teacher");
		
		System.out.println();
		Doctor doc = new Doctor(pat);
		System.out.println("Doctor: \'What\'s your favorite number?\'");
		System.out.println(pat.name + ": \'" + pat.favoriteNumber(7) +"\'");
		doc.changePatientName(pat, "Executive");
		System.out.println("Doctor: What\'s your job?: " + pat.name);
		
		System.out.println("New Doctors"); 
		System.out.println("------------");
		//Doctors are salary paid -- use viewSalaryInformation
		
		Doctor doc1 = new Doctor("Cam Tougas", "White");
		Doctor doc2 = new Doctor("Maru Chan", "Mixed", 160000);
		
		doc.viewEmployeeSalaryInformation();
		doc1.viewEmployeeSalaryInformation();
		doc2.viewEmployeeSalaryInformation();
		
		System.out.println("");
		
		System.out.println("New Surgeons");
		System.out.println("-------------");
		
		Surgeon sur = new Surgeon("Nicole Stanton", "White");
		
		sur.viewEmployeeSalaryInformation();
		
		/**
		 * Polymorphism Test
		 *  - Utilizing Employee
		 */
		
		//These will print "Please make Employee..."
		//It is normal for output!
		Employee test = new Doctor();
		Employee test2 = new Nurse();
		Employee test3 = new Administrator();
		Employee test4 = new Surgeon();
		//Employee test5 = new Employee();
		
		System.out.println();
		
		Employee[] employeeGroup = new Employee[4];
		employeeGroup[0] = test;
		employeeGroup[1] = test2;
		employeeGroup[2] = test3;
		employeeGroup[3] = test4;
		//employeeGroup[4] = test5;
		
		/*
		for(Employee viewMessage : employeeGroup) {
			viewMessage.whoAmI();
		}
		*/
		
		try {
		for(int i = 0; i <= employeeGroup.length ; i++) {
			System.out.println(employeeGroup[i]);
		}
		}
		catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("Dont worry...");
		}
		
	}

}
