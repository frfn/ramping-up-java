package interfaceTutorial;

public 
class RectanglePlus implements Relatable {
	 
	  public int rectNum;
	  private int width = 0;
	  private int height = 0;
	  private Point origin;
	 
	  //4 Constructors
	  public RectanglePlus(){
	  	this(0, 0); //using the (int w, int h) construction
	  }
	  public RectanglePlus(Point p){
	    origin = p;
	   
	  }
	  public RectanglePlus(int w, int h){
	    width = w;
	    height = h;
	  
	  }
	  public RectanglePlus(Point p, int w, int h){
		
	    origin = p;
	    width = w;
	    height = h;
	 
	  }
	  
	  //methods that will be in RectanglePlus
	  public int getArea(){
	    return width*height;		//getting area of RectanglePlus
	  }
	  public void move(int x, int y){
	    origin.x = x;				//moving the rectangle origin, abstractly
	    origin.y = y;
	  }
	  public int getRectNum() {
		  return rectNum;
	  }
	  
	  //Using the interface!
	  public int isLargerThan(Relatable other){
	    
	    //RectanglePlus otherRect = new RectanglePlus();
	    //other = otherRect;
	    //(RectanglePlus)other = otherRect;
	    
	    RectanglePlus otherRect = (RectanglePlus)other;
	    
	    //double other = 5;
	    
	    //int num = (int)other; 
	    
	    //initialized otherRect 
	    
	    //otherReact will equals "other"
	    
	    //other is now casted as a (RectanglgePlus), a data type
	    
	    /*
	    
	    First step in using...
	    1.) Create an object
	    2.) Initialize it to the object being passed in the parameter
	    	- in this case "other"
	    3.) Cast "other" with RectanglePlus so it can be used and referred to wiith
	    	RectanglePlus traits
	    4.) otherRect is now other
	    
	    */
	    
	    /*
	    Testing to see if lines 37 and 38 will be the same as line 40
	    EDIT: does not work.
	    */
	    
	    if(this.getArea() < otherRect.getArea()){
	      return -1;
	    }
	    else if(this.getArea() > otherRect.getArea()){
	      return 1;
	    }
	    else return 0;
	  }
	  
	  
	  
	  //GET BACK TO IT
	  public Object findLargest(Object obj1, Object obj2) {
		  Relatable object = (Relatable)obj1;
		  Relatable object2 = (Relatable)obj2;
		  
		  if(object.isLargerThan(object2) > 0) {
			  return object;
		  }
		  	  return object2;
	  }
	  
	  public String toString() {
		  return "Rectangle Number: " + rectNum + "\nWidth: " + width + "\nHeight: " + height;
	  }
	  
	}




