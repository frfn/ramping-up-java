package chapter4PP4point1and2;

/*
 * Design a class called PairOfDice – has two die objects
 * Create another class called BoxCars that will role the pair
 * 1000 times, counting the number of BoxCars
 */

public class BoxCars {
	
	
	final static int rollMax = 1000;
	final static int boxCar = 12;
	
	
	public static void main(String[] boxCars) {
		
		PairOfDice objectHasTwoDie = new PairOfDice();
		
		int totalValueOfDice, count = 0;
		
		
		
		for(int i = 0; i <= rollMax; i++ ) {
			
			objectHasTwoDie.roll();
			
			totalValueOfDice = objectHasTwoDie.totalOfDice();
			
			if(totalValueOfDice == boxCar) {
				count++;
			}
			
		}
		
		System.out.println("Box cars that happened after 1000 rolls: " + count);
		
		int boxCarCount = 0;
		
		for(int i = 0; i <= rollMax; i++) {
			
			
			
			objectHasTwoDie.roll();
			
			if(objectHasTwoDie.getDie1Value() == 6 && objectHasTwoDie.getDie2Value() == 6) {
				boxCarCount++;
			}
			
		}
		
		System.out.println("Box cars that happened after 1000 rolls: " + boxCarCount);
		
		
		if(count == boxCarCount) {
			System.out.print("Shit is rigged, what the fuck? -_-\'");
		}else {
			System.out.print("Not rigged.");
		}
		
	}

}
