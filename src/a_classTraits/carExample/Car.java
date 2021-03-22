package a_classTraits.carExample;

// simple interface
interface ICarName extends Compare{
    String owner = "Flexer";
    void showOwner();
}
public class Car implements ICarName {
    // not final!
    private String color;
    private double speed, cost;
    private Engine carEngine; // Composition Example

    // constructor
    public Car(String colorOfCar, double speedOfCar, double costOfCar) {
        this.color = colorOfCar;
        this.speed = speedOfCar;
        this.cost = costOfCar;
        carEngine = new Engine(0 , 0); // Composition Example
    }

    // overloading to include Engine constructor arguments
    public Car(String colorOfCar, double speedOfCar, double costOfCar, double liter, double horsepower) {
        this.color = colorOfCar;
        this.speed = speedOfCar;
        this.cost = costOfCar;
        carEngine = new Engine(liter , horsepower); // Composition Example
    }

    // must be implemented because of the interface
    public void showOwner() {
        System.out.println("The owner is " + owner); // owner comes from the Interface
    }

    // setter
    public void setCost(double newCost) {
        cost = newCost;
    }
    public void setCarEngineLiter(double newLiter) {
        carEngine.setHorsepower(newLiter);
    }
    public void setCarEngineHorsepower(double newHorsepower) {
        carEngine.setHorsepower(newHorsepower);
    }

    // getter
    public String getColor() {
        return color;
    }
    public double getCost() {
        return cost;
    }
    public double getSpeed() {
        return speed;
    }
    public double getHorsepower() { return carEngine.getHorsepower();}
    public double getLiter() { return  carEngine.getLiter(); }

    // stringify
    public String toString() {
        return color + ", " + speed + " MPH, $" + cost + ", " + carEngine;
    }

    // Compare interface
    public boolean isFaster(Compare object){
        // created a car instant <-- type casted object as Car
        Car carToBeCompared = ((Car)object);
        return this.getSpeed() > carToBeCompared.getSpeed();

        /*
        if(this.getSpeed() > ((Car) object).getSpeed()){
            return true;
        }
        return  false
         */
    }
    public boolean isMoreExpensive(Compare object) {
        Car carToBeCompared = ((Car)object);
        return this.getCost() > carToBeCompared.getCost();
    }
}