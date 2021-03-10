package Car;

public class Main {
	
	public static void main(String[] args) {
		
		//AbstractCar car = new AbstractCar();  // cannot because it is abstract, I don't want anyone to instantiate it
		
		Honda hondaCar = new Honda();
		Honda hondaCar2 = new Honda(80, 2500);
		
		Toyota toyotaCar = new Toyota();
		Toyota toyotaCar2 = new Toyota(78, 3200);
		
		Si si = new Si();
		Camry camry = new Camry();
		
		/*
		 * System.out.println(hondaCar); System.out.println(hondaCar2);
		 * 
		 * System.out.println();
		 * 
		 * System.out.println(toyotaCar); System.out.println(toyotaCar2);
		 * 
		 * System.out.println();
		 * 
		 * System.out.println(si); System.out.println(camry);
		 */
		
		AbstractCar[] list = new AbstractCar[6];
		list[0] = hondaCar;
		list[1] = hondaCar2;
		list[2] = toyotaCar;
		list[3] = toyotaCar2;
		list[4] = si;
		list[5] = camry;
				
		for(AbstractCar view : list) {
			System.out.println(view);
			System.out.println();
		}
		
	}

}
