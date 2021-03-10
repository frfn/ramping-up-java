package PizzaGUI_UseAsLearningModel;

public class PizzaCollection {
	
	private Pizza[] pizza;
	private int count;
	
	public PizzaCollection() {
	
		pizza = new Pizza[5];
		count = 0;
		
	}
	
	private void increase() {
		Pizza[] temp = new Pizza[pizza.length * 2];
		
		for(int i = 0; i < pizza.length; i++) {
			temp[i] = pizza[i];
		}
		
		pizza = temp;
		
	}
	
	public void addPizza(String size, String sauce, String crust, String... topping) {
		
		if(count == pizza.length) {
			increase();
		}
		
		pizza[count] = new Pizza(size, sauce, crust, topping);
		
		count++;
	}
	
	public void printSpecificPizza(int num) {
		System.out.print(pizza[num]);
	}
	
	public String toString() {
		String str = "";
		
		for(int i = 0; i<count;i++) {
			str += pizza[i].toString();
		}
		
		return str;
	}

}
