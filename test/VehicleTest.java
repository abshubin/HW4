import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Andrew Shubin on 9/21/16.
 */
public class VehicleTest {

    private static String make = "Ford Ranger";
    private static int model = 1998;
    private static boolean drive = true;
    private static double price = 5000;
    private static double mpg = 13;

    @Test
    public void getMake() throws Exception {
        // Arrange
        Vehicle v = new Vehicle(make, model, drive, price, mpg);

        // Act
        String result = v.getMake();

        // Assert
        assertEquals("ERROR in Vehicle.getMake()", make, result);

    }

    @Test
    public void getModel() throws Exception {
        // Arrange
        Vehicle v = new Vehicle(make, model, drive, price, mpg);

        // Act
        int result = v.getModel();

        // Assert
        assertEquals("ERROR in Vehicle.getModel()", model, result);
    }

    @Test
    public void is4WD() throws Exception {
        // Arrange
        Vehicle v = new Vehicle(make, model, drive, price, mpg);

        // Act
        boolean result = v.is4WD();

        // Assert
        assertEquals("ERROR in Vehicle.is4WD()", drive, result);
    }

    @Test
    public void getPrice() throws Exception {
        // Arrange
        Vehicle v = new Vehicle(make, model, drive, price, mpg);

        // Act
        double result = v.getPrice();

        // Assert
        assertEquals("ERROR in Vehicle.getPrice()", price, result, 0);
    }

    @Test
    public void getMPG() throws Exception {
        // Arrange
        Vehicle v = new Vehicle(make, model, drive, price, mpg);

        // Act
        double result = v.getMPG();

        // Assert
        assertEquals("ERROR in Vehicle.getMPG()", mpg, result, 0);
    }

    @Test
    public void setPrice() throws Exception {
        // Arrange
        Vehicle v = new Vehicle(make, model, drive, price, mpg);
        double newPrice = price * 2;

        // Act
        v.setPrice(newPrice);

        // Assert
        assertEquals("ERROR in Vehicle.setPrice()", newPrice, v.getPrice(), 0);
    }

    @Test
    public void setMPG() throws Exception {
        // Arrange
        Vehicle v = new Vehicle(make, model, drive, price, mpg);
        double newMPG = mpg * 2;

        // Act
        v.setPrice(newMPG);

        // Assert
        assertEquals("ERROR in Vehicle.setMPG()", newMPG, v.getMPG(), 0);
    }

    @Test
    public void printVehicle() throws Exception {
        // Arrange
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Vehicle v = new Vehicle(make, model, drive, price, mpg);
        String expected = model + " " + make + "\n"
                + (drive ? "4WD" : "2WD") + "\n$"
                + price + "\n" + mpg + "MPG";

        // Act
        v.printVehicle();
        String result = out.toString();

        // Assert
        assertEquals("ERROR in Vehicle.printVehicle()", expected, result);
    }

}