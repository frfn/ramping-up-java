package a_CarExample;

public class HondaGarageArray {

    private final String nameOfGarage = "Honda Garage";
    private final int sizeLimit = 20;
    private Car[] spotsAvailable; // Even though I'm parking my Honda cars, they extend Car class!


    public HondaGarageArray() {
        // initialization block, the array are all of null value
        {
            spotsAvailable = new Car[sizeLimit];
            for(int i = 0; i < sizeLimit; i++ ){
                spotsAvailable[i] = null;
            }
        }
    }

    // returns car info
    public Car carInformationAtSpot(int parkingNumber) {
        return spotsAvailable[parkingNumber];
    }

    // parking at spot
    public String partAtSpot(int parkingNumber, Car car) {
        if(parkingNumber > 19 || parkingNumber < 0) {
            return "Invalid request, parking number does not exist. Try again";
        }

        if(spotsAvailable[parkingNumber] == null ) {
            spotsAvailable[parkingNumber] = car;
            return "Success, you have parked your " + car + " at spot " + parkingNumber;
        }
        else {
            return "There is a car already parked at this spot! You can not park your " + car;
        }
    }

    // sees if spot is available
    public String isSpotAvailable(int parkingNumber) {
        if(parkingNumber > 19 || parkingNumber < 0) {
            return "Invalid request, parking number does not exist. Try again";
        }
        if (spotsAvailable[parkingNumber] != null) {
            return "Spot is taken! Please check another or see what is available!";
        }
        return "Spot is not taken! You can park here!";
    }

    // shows all the spots the are available
    public String spotsAvailable() {
        StringBuilder spots = new StringBuilder("Spots available: ");

        for(int i = 0; i < spotsAvailable.length; i++) {
            if(spotsAvailable[i] == null) {
                spots.append(i);
                spots.append(", ");

            }
        }
        return spots.toString();
    }
}
