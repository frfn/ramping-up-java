package Pizza;

public class Pizza {
	
	public static interface Animal {
		
	}
	
	private int size, numOfMeatTopping, numOfVegeTopping;
	
	public Pizza(int size, int numOfMeatTopping, int numOfVegeTopping) {
		this.size = size;
		this.numOfMeatTopping = numOfMeatTopping;
		this.numOfVegeTopping = numOfVegeTopping;
	}
	
	public int calculateCost() {
		int base = -1;
		int totalCost = 0;
		if(size > 0 && size < 4) {
			if(size == 1) {
				base = 8;
			}
			else if(size == 2){
				base = 10;
			}
			else if(size == 3){
				base = 12;
			}
			
			totalCost = base + (numOfMeatTopping * 2) + (numOfVegeTopping  * 2);
			return totalCost;
			
		} else {
			return 0;
		}
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("-- Pizza --\n");
		build.append("Size: " + size + 
					 "\n# of Meat Topping: " + Integer.toString(numOfMeatTopping) + 
					 "\n# of Vegetable Topping: " + Integer.toString(numOfVegeTopping));
		build.append("\nCost of Pizza: $" + Integer.toString(calculateCost()));
		return build.toString();
	}
	
}
