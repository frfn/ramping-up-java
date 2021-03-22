package a_classTraits.carExample;

import java.util.ArrayList;

//Note: extends Car
public class Honda extends Car {

    // Note: You MUST put the = new ArrayList<>(); LMAOOO!!
    // Note: Do NOT make into static, DO NOT... interesting. I wonder why. lol.
    // I remember now.
    // If new object is created, then those new objects will ALL have the same features!
    ArrayList<String> features = new ArrayList<String>();

    public Honda(double speed, double cost, String... args){
        // Constructor in Car class.
        super("Honda", speed, cost);

        for(String str: args)
            features.add(str);
    }

    public void printFeatures(){
        System.out.println(features.toString());
    }

    public String toString(){
        return "Honda Car";
    }

    public void addFeatures(String... args){
        for(String str: args){
            features.add(str);
        }
    }

    public void deleteFeatures(String... args){
        for(String str: args){
            if(features.contains(str)){
                features.remove(str);
            }
        }
    }

    @Override
    public boolean isFaster(Compare car) {
        if(car instanceof Car){
            double otherCarSpeed = ((Car) car).getSpeed();
            if(this.getSpeed() > otherCarSpeed) {
                return true;
            }
        }
        else {
            Car otherCar = (Car)car;
            double otherCarSpeed = otherCar.getSpeed();
            if(this.getSpeed() > otherCarSpeed){
                return true;
            }
        }
        return false;
    }

    //Note: @Overrides came FROM Car class FROM the Compare class
    @Override
    public boolean isMoreExpensive(Compare car) {
        if(car instanceof Car){
            double otherCarCost = ((Car)car).getCost();
            if(this.getCost() > otherCarCost){
                return true;
            }
        }
        else{
            Car otherCar = (Car)car;
            double otherCarCost= otherCar.getCost();
            if(this.getCost() > otherCarCost){
                return true;
            }
        }
        return false;
    }
}
