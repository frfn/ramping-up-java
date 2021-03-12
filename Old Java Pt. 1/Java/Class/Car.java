package a_CarExample;


// Note: abstract
// Note: implements Compare
// Note: implementing MUST include all methods in Compare class
// In abstract classes, you do not need to, but when making concrete classes through extends, you MUST!
public abstract class Car implements Compare{
    /**
     * Things to take away -
     *
     * Abstract Classes can not be instantiated, just extended to another
     * abstract class or to a concrete class.
     *
     * Three access modifiers:
     * 	- Private   : Only in class can be used
     * 	- Public    : All classes can use (if no access modifier, this is default)
     * 	- Protected : Only in package can be used
     *
     */

    private String brand;
    private double speed, cost;

    public Car(String brand, double speed, double cost){
        this.brand = brand;
        this.speed = speed;
        this.cost = cost;
    }

    public void setCost(double newValue){
        cost = newValue;
    }

    public String getBrand(){
        return brand;
    }

    public double getSpeed(){
        return speed;
    }

    public double getCost(){
        return cost;
    }
}