package homeworkOneTesting;



/************************
 *
 * @author flexer
 *
 *
 *		OUTPUT WILL BE 2450
 *
 *				That is the correct value for adding 2 to 100
 *
 *					DO the temp after finding out how to do the evenSum
 *
 *
 *
 ************************/


public class ForLoopTesting {
	
	
	public static void main(String flexer[]) {
		/*
		int temp;
	int evenSum = 0;
	
	
	for(int i = 0; i < 100; i++) {
		
		
		if(i % 2 == 0)
		evenSum = evenSum + i;
		
	}
	
	System.out.print(evenSum);
	
	temp = (550 - evenSum) / 100 * 5;
	if(temp < 0) {
		System.out.print("\nFinal = 1");
	}else {
		System.out.print("\nFinal = 2");
		
		
		
		
		
		
		
	}
	
	*/
	
	int evenSum = 0;
	int R2 = 0;
	
	for(int count = 100; count > 0; count = count - 2 ) {
		
		R2 = R2 + count;
		
	
		
		
	}
	
	evenSum = R2;
	
	System.out.println();
	System.out.println("Output for evenSum: " + evenSum);
	
	
	int temp = (550 - evenSum) / 100 * 5;
	
	System.out.println(temp);
	
	if(temp < 0) {
		System.out.print("\nFinal = 1");
	}else {
		System.out.print("\nFinal = 2");
	
	
	
	

	
	
	}
	}
}
	

