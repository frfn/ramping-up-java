package Ternary_Operators;

public class ex5_InsideStrings {

	public static void main(String[] args) {
		
		Person person = new Person(1);
		Person person2 = new Person(0);
		
		System.out.println("You are " + (person.isMale() ? "Mr. " : "Mrs. ") + "Fadrigalan. :)");
		System.out.println("You are " + (person2.isMale() ? "Mr. " : "Mrs. ") + "Fadrigalan. :)");
		
	}
	
	// Note: without static, this class will not work. 
	// Note: this is a class!
	// Static means it is globally available, which makes sense.
	public static class Person {
		
		private final int MALE = 1;
		private final int FEMALE = 0;
		private int gender;
		
		public Person(int gender) {
			this.gender = gender;
		}
		
		public int getGender() {
			return gender;
		}
		
		public boolean isMale() {
			if(gender == MALE) return true; else if (gender == FEMALE) return false;
			
			// something went wrong, will always return false :)
			return false;
		}
	}
	
}
