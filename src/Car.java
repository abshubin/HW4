/**
 * Created by Andrew Shubin on 9/21/16.
 */

public class Car extends Vehicle {
    private boolean convertible;

    public Car(String make, int model, boolean fourWD,
               double price, double mpg,
               boolean convertible) {
        super(make, model, fourWD, price, mpg);
        this.convertible = convertible;
    }

    public boolean isConvertible() {
        return convertible;
    }

    @Override
    public void printVehicle() {
        super.printVehicle();
        String condition = (convertible ? " " : " not ");
        System.out.println("Is" + condition + "Convertible");
    }
}
