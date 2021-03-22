package a_classTraits.carExample;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<Car>();

        // Car car = new Car("N/A", 0, 0); Since abstract we cannot do it!

        Honda SI = new Honda(120, 1100, "SI", "Sports Edition", "Navigation");
        Toyota CAMRY = new Toyota(110, 1400, "CAMRY", "Low Miles", "Heated Seats");

        cars.add(SI); cars.add(CAMRY);

        for(Car car: cars){
            //  ** Using --"instanceof"-- **
            if(car instanceof Honda){
                ((Honda) car).printFeatures();
            }
            else if(car instanceof Toyota){
                ((Toyota) car).printFeatures();
            }


            System.out.println();
        }

        System.out.println("Testing Garage");

        ParkingGarage garage = new ParkingGarage("Flexer's Garage");
        // Print if spot is empty
        System.out.println(garage.isSpotAvailable(0) + ", spot is empty.");

        // Parking
        garage.parkAtSpot(0, SI);

        // Print to see if spot is empty
        System.out.println(garage.isSpotAvailable(0) + ", spot is taken by " + SI.getBrand());

        // Print
        System.out.println("Taken by " + ((Honda)garage.carInfoAtSpot(0)).toString());

        // Leaving garage prints car and sets false and null to arrays
        garage.carLeaving(0);
        System.out.println(garage.isSpotAvailable(0) + ", spot is empty.");



    }

}
