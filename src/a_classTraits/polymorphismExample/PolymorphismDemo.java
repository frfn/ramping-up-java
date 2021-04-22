package a_classTraits.polymorphismExample;

import java.util.ArrayList;

public class PolymorphismDemo {

    public static void main(String[] args) {

        ArrayList<FlyingMachines> flyingMachines = new ArrayList<FlyingMachines>();
        flyingMachines.add(new FlyingMachines("FlexMachine"));
        flyingMachines.add(new Jet());
        flyingMachines.add(new Jet());
        flyingMachines.add(new Helicopter());
        flyingMachines.add(new Jet());
        flyingMachines.add(new Helicopter());

        new MakeThingsFly().makeThingsFly(flyingMachines);
        System.out.println("---");
        new MakeThingsFly().getMachineInfo(flyingMachines);
    }

}

// a class that has methods
class MakeThingsFly {
    public void makeThingsFly(ArrayList<FlyingMachines> flyingMachines) {
        for(FlyingMachines flyingMachine: flyingMachines) {
            flyingMachine.fly();
        }
    }
    public void getMachineInfo(ArrayList<FlyingMachines> flyingMachines) {
        for(FlyingMachines flyingMachine: flyingMachines) {
            System.out.println(flyingMachine.getMachine());
        }
    }
}

// interface | gives behavior
interface CanFly {
    void fly();
}

// base class so subclasses can be created easier
class FlyingMachines implements CanFly {
    private final String machine;
    public FlyingMachines(String whatKindOfMachine){
    this.machine  = whatKindOfMachine;
    }
    public String getMachine() {
        return machine;
    }
    public void fly(){
        System.out.println(machine + " flies!");
    }
}

// jet class
class Jet extends FlyingMachines {
    public Jet() {
        super("Jet");
    }

    // Example of Overriding!
    public void fly() {
        System.out.println("The Fast Jet flies!");
    }
}

// helicopter class
class Helicopter extends FlyingMachines {
    public Helicopter() {
        super("Helicopter");
    }

    // Example of overriding
    // public void fly() {
    //     System.out.println("Helicopter flies!");
    // }
}