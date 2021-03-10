package EverythingSoFar;


class Toyota extends Car {
	  
	  public Toyota(){
	    super("No Model", "Toyota", 0);
	  }
	  
	  public Toyota(String model, int speed){
	    super(model, "Toyota", speed);
	  }
	  
	  public void carInfo(){
	    System.out.println("Brand: " + brand + "\nModel: " + model +	
	                      	"\nSpeed: " + speed);
	  }
	  
	}