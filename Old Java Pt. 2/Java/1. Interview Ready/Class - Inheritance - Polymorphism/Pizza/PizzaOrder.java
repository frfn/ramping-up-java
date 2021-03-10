package Pizza;

public class PizzaOrder {
	
	String orderNum;
	private Pizza pizza1, pizza2;
	
	public PizzaOrder(String orderNum, Pizza pizza1, Pizza pizza2) {
		this.orderNum = orderNum;
		this.pizza1 = pizza1;
		this.pizza2 = pizza2;
	}
	
	public int calculatePizzaOrder() {
		return pizza1.calculateCost() + pizza2.calculateCost();
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("Order Number: " + orderNum);
		build.append("\nTotal Cost: $" + Integer.toString(calculatePizzaOrder()));
		return build.toString();
	}
}
