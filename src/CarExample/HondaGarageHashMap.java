package CarExample;

import java.util.HashMap;

public class HondaGarageHashMap {

    private HashMap<Integer, Car> spotsAvailable;
    private final String brand = "Honda Garage";

    public HondaGarageHashMap() {
        {
            spotsAvailable = new HashMap<Integer, Car>();
        }
    }

    // parking
    public String parkAtSpot(int parkingNumber, Car car) {
        if(parkingNumber > 19 || parkingNumber < 0) {
            return "Invalid request, parking number does not exist. Try again";
        }
        if(spotsAvailable.get(parkingNumber) == null ) {
            spotsAvailable.put(parkingNumber, car);
            return "Success, you have parked your " + car + " at spot " + parkingNumber;
        }
        else {
            return "There is a car already parked at this spot! You can not park your " + car;
        }
    }

    // return car info
    public String returnCarInfo(int parkingNumber) {
        if(parkingNumber > 19 || parkingNumber < 0) {
            return "Invalid request, parking number does not exist. Try again";
        }
        if(spotsAvailable.containsKey(parkingNumber)) {
            Car car = spotsAvailable.get(parkingNumber);
            return car.toString();
        }
        else {
            return "There is no car parked at this spot! You can park here!";
        }
    }

}
