/**
 * Created by Andrew Shubin on 9/21/16.
 */

public class Truck extends Vehicle {
    private boolean sideStep;
    private double towCap;

    public Truck(String make, int model, boolean fourWD,
                 double price, double mpg,
                 boolean sideStep, double towCap) {
        super(make, model, fourWD, price, mpg);
        this.sideStep = sideStep;
        this.towCap = towCap;
    }

    public boolean hasSideStep() {
        return sideStep;
    }

    public double getTowCap() {
        return towCap;
    }

    public void setSideStep(boolean sideStep) {
        this.sideStep = sideStep;
    }

    public void setTowCap(double towCap) {
        this.towCap = towCap;
    }

    @Override
    public void printVehicle() {
        super.printVehicle();
        String condition = (sideStep ? "" : "No ");
        System.out.println(condition + "Side Step");
        System.out.println("Tow up to " + towCap + " ton(s)");
    }
}
