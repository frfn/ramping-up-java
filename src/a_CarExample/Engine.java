package a_CarExample;

// Created for Composition example
public class Engine {

    private double liter;
    private double horsepower;

    public Engine(double engineLiter, double horsePower) {
        this.liter = engineLiter;
        this.horsepower = horsePower;
    }

    public double getHorsepower() {
        return  horsepower;
    }
    public double getLiter() {
        return liter;
    }

    public void setHorsepower(double newHorsepower) {
        horsepower = newHorsepower;
    }
    public void setLiter(double newLiter) {
        liter = newLiter;
    }

    // class' go to | how to print object!
    public String toString() {
        return liter + " Liter, " + horsepower + " Horsepower";
    }

}
