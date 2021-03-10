package chapter4ReturnDoubleObjects;

public class Main {
	
	public static void main(String[] friends) {
		
		DoubleObjects amigos = new DoubleObjects(1);
		
		System.out.println(amigos.returnBothWithValidation());
		
		amigos.doWork();
		
		System.out.println(amigos.returnBothWithValidation());
		
		System.out.println(amigos.toString());
		
		System.out.println(amigos.getFlexer());
		
		System.out.println(amigos.getMelvin());
		
	}

}
