package a_CarExample;

public class Main {
    public static void main(String[] args){
        // Creating instances
        Honda SI = new Honda("SI", "Black", 170, 11000, 2, 217);
        Honda TypeR = new Honda("TypeR", "Black", 190, 17000, 2.4, 350);

        // Testing out the Array list
        SI.addFeatures("Navigation", "Heated Seats", "DVD Player");
        TypeR.addFeatures("Navigation", "Heated Seats", "DVD Player", "Launch Control");


        /* --------------------------------- */
        /* Testing out the interface methods */
        /* --------------------------------- */
        // System.out.println(SI.isFaster(TypeR));
        // System.out.println(TypeR.isMoreExpensive(SI))


        /* ------------------------- */
        /* Creating HondaGarageArray */
        /* ------------------------- */
        HondaGarageArray Garage = new HondaGarageArray();

        // Parking my Cars
        System.out.println(Garage.partAtSpot(2, SI));
        System.out.println(Garage.partAtSpot(2, TypeR));

        // Seeing if the spots are available
        System.out.println(Garage.isSpotAvailable(2));
        System.out.println(Garage.spotsAvailable());

        // See info of car
        System.out.println(Garage.carInformationAtSpot(2));

        System.out.println("---");

        /* --------------------------- */
        /* Creating HondaGarageHashMap */
        /* --------------------------- */
        HondaGarageHashMap GarageMap = new HondaGarageHashMap();
        System.out.println(GarageMap.parkAtSpot(5, SI));
        System.out.println(GarageMap.parkAtSpot(5, TypeR));
        System.out.println(GarageMap.parkAtSpot(6, TypeR));
        System.out.println(GarageMap.returnCarInfo(7));
        System.out.println(GarageMap.returnCarInfo(5));

    }
}
