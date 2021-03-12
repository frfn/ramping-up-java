package a_CarExample;

public class ParkingGarage {

    private int spotsAvailable = 200;
    private boolean[] isSpotAvailable;
    private Car[] carsAtSpot;
    private String nameOfGarage;

    // initialization block, notice NO public keywords, no identifiers, just brackets.
    {
        isSpotAvailable = new boolean[spotsAvailable];
        for(int i = 0; i < isSpotAvailable.length; i++){
            isSpotAvailable[i] = true;
        }
        // setting all the boolean values to be true.
    }

    {
        carsAtSpot = new Car[spotsAvailable];
        for(int i = 0; i < carsAtSpot.length; i++){
            carsAtSpot[i] = null;
        }
    }

    public ParkingGarage(String nameOfGarage) {
        this.nameOfGarage = nameOfGarage;
    }

    public void parkAtSpot(int parkingNumber, Car car) {
        isSpotAvailable[parkingNumber] = false;
        carsAtSpot[parkingNumber] = car;
    }

    public boolean carLeaving(int parkingNumber) {
        if(parkingNumber > -1 && parkingNumber < 200) {
            System.out.println(carInfoAtSpot(parkingNumber));
            isSpotAvailable[parkingNumber] = true;
            carsAtSpot[parkingNumber] = null;
        }else{
            return false;
        }
        return true;
    }

    public boolean isSpotAvailable(int parkingNumber){
        return isSpotAvailable[parkingNumber];
    }

    public Car carInfoAtSpot(int parkingNumber) {
        return carsAtSpot[parkingNumber];
    }

}
