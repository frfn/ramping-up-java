package CarExample;

import java.util.ArrayList;
import java.util.Collections;

public class Honda extends Car {

    ArrayList<String> featureList = new ArrayList<String>(); // if static, every time a new instantiation is created, it will affect every object

    private final String brand = "Honda";
    private final String model;

    public Honda(String model, String colorOfCar, double speedOfCar, double costOfCar, double liter, double horsepower) {
        super(colorOfCar, speedOfCar, costOfCar, liter, horsepower);
        this.model = model;
    }

    public void addFeatures(String... features) {
        // features is an array
        Collections.addAll(featureList, features);

        /*

        * -----------------------------*
        *  THEY ALL DO THE SAME THING  *
        * -----------------------------*

        They add all the items in the ArrayList

        1. for(String feature: features) {
             featureList.add(feature);
           }

        2. featureList.addAll(Arrays.asList(features));

        3. Collections.addAll(featureList, features);

        */
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        return brand + " " + model + " | " + super.toString() + " " + featureList.toString();
    }

}
