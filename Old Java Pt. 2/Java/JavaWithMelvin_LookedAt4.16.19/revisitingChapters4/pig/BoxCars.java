package pig;
/*
 * The purpose of the program is to print Congratulations
 * if the program runs 
 * 
 * SNAKES EYES , which is rolling both pair of dice
 * and getting a 6 !
 * 
 * Roll a thousand times !
 */


public class BoxCars {
	
	private static final int rolls = 1000; //roll variable declared to 1000
	private static final int boxCar = 12; //box car value is 12
	
	/*
	 * Program will be more easier to program if value is 12
	 * You can program and code the logic
	 * 
	 * if(die.getValueOfDie() == 6 && die.getValueOfDie2() {
	 * 
	 * 		increase count by 1;
	 * 
	 * }
	 * 
	 * But since I can just use the value of 12, just compare that to die.totalValue
	 */
	
	public static void main(String[] args) {
		
		PairOfDice die = new PairOfDice();
		
		int totalOfBoxCars=0;
		
		for(int i=0; i<=rolls; i++) { //0 to 1000 iterations!
			
			die.roll(); //calling roll so we can change the values!
			
			if(die.totalOfDieValues() == 12) {
				totalOfBoxCars++;
			} //end of if
			System.out.println(die.getDieValue() +":"+die.getDie2Value() );
		}//end of for
		System.out.println("Total of box cars: " + totalOfBoxCars);
	}//end of min

}
