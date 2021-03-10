package interfaceTutorial;

public class Main {	
	
	/**
	 * 
	 * @param args
	 * 
	 * Re-do this!!
	 * 
	 * This is very interesting, using interfaces and using it as a data type!!
	 */

	public static void main(String[] args) {
	    
	    Point point = new Point(); //x:0 , y:0
	    RectanglePlus rect1 = new RectanglePlus(point, 100, 20); //1
	    rect1.rectNum = 1;
	    System.out.println("Rect1: " + rect1.getRectNum());
	    System.out.println(rect1.getArea());
	    
	    RectanglePlus rect2 = new RectanglePlus(point, 10, 30); //2
	    rect2.rectNum = 2;
	    System.out.println("Rect2: " + rect2.getRectNum());
	    
	    System.out.println(rect2.getArea());
	    
	    int x = rect1.isLargerThan(rect2);
	    
	    System.out.println("Rect1: " + rect1.getRectNum());
	    System.out.println("Rect2: " + rect2.getRectNum());
	    
	    System.out.println(x);
	    
	    
	    RectanglePlus obj1 = new RectanglePlus(); //3
	    
	    System.out.println("OBJ1: " + obj1.getRectNum());
	    
	    obj1 = (RectanglePlus)obj1.findLargest(rect2, rect1);
	    
	    System.out.println(obj1);
	      
	    
	   
	  }
}
