package EverythingSoFar;

/*

In this class, we will be coding the following:

	- implementing an interface class
    	- WhoIsFaster
        	- fasterCar() method - which car is faster
    
    - using inheritance
    	- Car class
        	- Toyota
            - Nissan
        
    - using polymorphism
    	- creating
        	- Car list
            - Different methods
            - Re-watch newboston YouTube videos

*/

class Main {
  public static void main(String[] args) {
    
  	Toyota car = new Toyota();
  	Car car2 = new Car("3", "TESLA", 100);
  	
  	car.startUp();
    
    boolean imFaster = car.fasterThan(car2);
    
    System.out.println(imFaster);
    System.out.println();
    car.carInfo();
    System.out.println();
    car2.carInfo();
    
    System.out.println();
    Toyota newCar = new Toyota("Camry", 120);
    newCar.carInfo();
       
  }
}


