package Car;

public class TestCase_UsingVarArgs {

	public static void main(String[] args) {
		print("Hello", "World");
		
		print2("Hello", "World");
	}
	// Using index
	public static void print2(String...strings) {
		for(int i=0; i<strings.length; ++i) {
			System.out.print(strings[i] + " ");
		}
	}
	// Using enhanced for loop
	public static void print(String...strings) {
		for(String string : strings) {
			System.out.print(string + " ");
		}
	}
	
}
