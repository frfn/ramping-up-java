package CarExample;

public class Main {
    public static void main(String[] args){
        // Creating instances
        Honda SI = new Honda("SI", "Black", 170, 11000, 2, 217);
        Honda TypeR = new Honda("R", "Black", 190, 17000, 2.4, 350);

        // Testing out the Array list
        SI.addFeatures("Navigation", "Heated Seats", "DVD Player");
        TypeR.addFeatures("Navigation", "Heated Seats", "DVD Player", "Launch Control");

        // Testing out the interface methods
        System.out.println(SI.isFaster(TypeR));
        System.out.println(TypeR.isMoreExpensive(SI));
    }
}
