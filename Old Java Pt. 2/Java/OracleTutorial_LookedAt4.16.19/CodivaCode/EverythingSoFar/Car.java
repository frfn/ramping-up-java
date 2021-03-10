package EverythingSoFar;

class Car implements FasterCar {
	  
	 /**
	   Protected fields
	    - These are of "protected" visibility so I can use it in different classes.
	    - The variables here can only be used in PACKAGE scope!
	  */
	
	  protected String model, brand;
	  protected int speed;
	  
	  /**
	   Default constructor
	   	- Will utilize "this" key word
	   */
	  public Car(){
	    this("No model", "No brand", 0);
	  }
	  
	  /**
	   Constructor
	   - Uses the three fields
	  */
	  
	  public Car(String model, String brand, int speed){
	    this.model = model;
	    this.brand = brand;
	    this.speed = speed;
	  }
	  
	  /**
	   Notice it's not a toString() method
	   - Doing this for polymorphism purposes
	   - Will have in Toyota class
	  */
	  public void carInfo(){
	    System.out.println("Brand: " + brand + "\nModel: " + model +	
	                      	"\nSpeed: " + speed);
	  }
	  
	  /**
	   getSpeed() method
	   - I want to get speed value so I can compare them to each other
	   - Comparing two different objects speed
	  */
	  
	  public int getSpeed(){
	    return speed;
	  }
	  
	  public void startUp() {
		  System.out.println("Vroom, vroom!");
	  }
	 
	    // -- Using the interface -- //
	  
	  /**
	   args.fasterThan(args) method
	   	- Will return a boolean value (true or false)
	   	- Parameter takes in Car value
	   */
	  
	  public boolean fasterThan(FasterCar args){
	    
	    Car otherCar = (Car)args; // <-- This code here...
	    
	    /**
	     Basically this is how that code goes ...
	      - The argument that is being passed in the parameter will be of type Car
	      - (Car) is casted because args is of type FasterCar
	      - And by usually, otherCar can use getSpeed() method
	     */
	   
	    if(this.getSpeed() > otherCar.getSpeed()){
	      return true;
	    }else{
	      return false;
	    }
	    
	  }

	}
