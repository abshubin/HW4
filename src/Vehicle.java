/**
 * Created by Andrew Shubin on 9/21/16.
 */
public class Vehicle {
    private String make;
    private int model;
    private boolean fourWD;
    private double price;
    private double mpg;

    public Vehicle(String make, int model, boolean fourWD,
                   double price, double mpg) {
        this.make = make;
        this.model = model;
        this.fourWD = fourWD;
        this.price = price;
        this.mpg = mpg;
    }

    public String getMake() {
        return make;
    }

    public int getModel() {
        return model;
    }

    public boolean is4WD() {
        return fourWD;
    }

    public double getPrice() {
        return price;
    }

    public double getMPG() {
        return mpg;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMPG(double mpg) {
        this.mpg = mpg;
    }

    public void printVehicle() {
        System.out.println(model + " " + make);
        System.out.println(fourWD ? "4WD" : "2WD");
        System.out.println("$" + price);
        System.out.println(mpg + "MPG");
    }
}
