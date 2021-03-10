package PP8_12_ElectronicEquipment_GO_BACK_AND_COMMENT;

public class Main {
	
	public static void main(String[] args) {
		
		Computer newComputer = new Computer(8, 799, "Microsoft");
		Computer newComputer2 = new Computer(16, 2799, "Microsoft");
		Computer newComputer3 = new Computer(16, 999, "Microsoft");
		Computer newComputer4 = new Computer(16, 399, "Microsoft");
		
		System.out.println("Computer 2 more expensive than"
				+ " Computer 1?: " + newComputer2.isMoreExpensive(newComputer));
		
		System.out.println("By how much?: $" + newComputer2.difference(newComputer));
		
		newComputer.setRAM(16);
		
		System.out.println(newComputer);
		
		double withTax = newComputer.withTax();
		System.out.println("With Tax: " + withTax);
		
		/**
		 * Failed Experiment
		 *  - Thought it will work, varying parameters with interface as type
		Computer totalPrice = new Computer(0, 0, "Microsoft");
	    totalPrice.totalPrice(newComputer, newComputer2, newComputer3, newComputer4);
		System.out.println(totalPrice);
		*/
		
		CellPhone cell = new CellPhone("iOS", 999, "Apple");
		CellPhone cell2 = new CellPhone("Android", 799, "Samsung");
		
		System.out.println();
		System.out.println(cell);
		System.out.println("Is cell phone more expensive than laptop?: " + cell.isMoreExpensive(newComputer));
		
		System.out.println();
		System.out.println(cell2);
		System.out.println("Is cell2 phone more expensive than laptop?: " + cell2.isMoreExpensive(newComputer));

		
		Camera newCamera = new Camera("720p", 1499, "Canon");
		newCamera.upgradeQuality(4);
		
		System.out.println();
		System.out.println(newCamera);
		System.out.println();
		
		System.out.println("List");
		System.out.println("-----");
		
		Tech[] list = new Tech[10];
		
		list[0] = cell;
		list[1] = newComputer;
		list[2] = newCamera;
		
		for(int i = 0; i < 5; i++) {
			System.out.println(list[i]);
			System.out.println();
		}
		
		
	}

}
