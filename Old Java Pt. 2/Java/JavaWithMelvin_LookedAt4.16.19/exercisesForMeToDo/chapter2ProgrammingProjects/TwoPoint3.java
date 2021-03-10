package chapter2ProgrammingProjects;

//Fixed floating numbers, produce their sum, difference and product

public class TwoPoint3 {
	
	public static void main(String[] usingFloat) {
		
		float num = 10.5f, num2 = 20.5f;
		float sum, difference, product;
		
		sum = num + num2;
		difference = num2 - num;
		product = num * num2;
		
		System.out.println("Values of num and num2 are " + num + " and " + num2 + "respectively");
		System.out.println("Sum is: " + sum);
		System.out.println("Difference is: " + difference);
		System.out.println("Product is: " + product);
		
		
		
		
	}

}
