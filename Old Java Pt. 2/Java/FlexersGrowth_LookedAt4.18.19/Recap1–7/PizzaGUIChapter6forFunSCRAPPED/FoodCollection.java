package PizzaGUIChapter6forFunSCRAPPED;

import PizzaGUI_UseAsLearningModel.Pizza;

public class FoodCollection {
	
	/**
	 * Possible Class Deletion.
	 *  - May use
	 *  - Keep for now
	 */
	
	private Food[] food = new Food[5];
	private int count = 0;
	
	
	private void increase() {
		Food[] temp = new Food[food.length * 2];
		
		for(int i = 0; i < food.length; i++) {
			temp[i] = food[i];
		}
		
		food = temp;
		
	}
	
	public void addDrink(Food drink) {
		
		food[count] = drink;
		count++;
		
		if(count == food.length) {
			increase();
		}
		
	}
	
	public void addPizza(Food pizza) {
		
		food[count] = pizza;
		count++;
		
		if(count == food.length) {
			increase();
		}
		
	}

}
