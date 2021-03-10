package hypoSimulator;

public class testForLoop {
	
	public static void main(String[] forloop) {
		
		int evenSum = 0;
	
		/*for(int i = 0; i < 100; i++) {
			
			if (i % 2 == 0) {
				
				evenSum = evenSum + i;
				
			}
			
			
		}
			System.out.print(evenSum);
	*/
		
		
	
		
		for(int i = 98; i > 0; i-=2) {
			
			evenSum = evenSum + i; // 2;
			
		}
	
	System.out.println(evenSum);
		
		//for(int i = 0; i <= 99; i++) {
			
		//	evenSum = evenSum + i;
			
	//	}
		
	//	int result = evenSum / 2;
	
	//	System.out.println(result);
		
	//}
	/*int i = 1;
	while(i < 100) {
		
		evenSum = evenSum + i / 2;
		i++;
	}
	
	*///System.out.print(evenSum);

}
}

