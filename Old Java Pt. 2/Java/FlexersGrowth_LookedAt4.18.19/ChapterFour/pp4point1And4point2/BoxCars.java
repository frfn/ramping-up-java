package pp4point1And4point2;

public class BoxCars {
	public static void main(String[] args) {
	
		PairOfDice dice = new PairOfDice();
		int boxCar = 0;
		int boxCarr = 0;
		
		for(int i = 0; i <= 1000; i++) {
			
			dice.rollBoth();
			
			///System.out.println("Die One Value: " + dice.getDieValue());
			//System.out.println("Die Two Value: " + dice.getDieTwoValue());
			
			if(dice.getDieValue() == 6 && dice.getDieTwoValue() == 6) {
				boxCar++;
			}
			
			if(dice.getDieValueOfBoth() == 12) {
				boxCarr++;
			}
		}
		System.out.println("Total of Box Cars after rolling 1000 times: " + boxCar);
		System.out.println("Total of Box Cars after rolling 1000 times: " + boxCarr);
	}
}
