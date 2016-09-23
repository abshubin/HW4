import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Andrew Shubin on 9/21/16.
 */
public class TruckTest {

    private static String make = "Ford Ranger";
    private static int model = 1998;
    private static boolean drive = true;
    private static double price = 5000;
    private static double mpg = 13;
    private static boolean step = false;
    private static double tow = 1;

    @Test
    public void hasSideStep() throws Exception {
        // Arrange
        Truck t = new Truck(make, model, drive, price, mpg, step, tow);

        // Act
        boolean result = t.hasSideStep();

        // Assert
        assertEquals("ERROR in Truck.hasSideStep()", step, result);
    }

    @Test
    public void getTowCap() throws Exception {
        // Arrange
        Truck t = new Truck(make, model, drive, price, mpg, step, tow);

        // Act
        double result = t.getTowCap();

        // Assert
        assertEquals("ERROR in Truck.getTowCap()", tow, result, 0);
    }

    @Test
    public void setSideStep() throws Exception {
        // Arrange
        Truck t = new Truck(make, model, drive, price, mpg, step, tow);

        // Act
        t.setSideStep(!step);

        // Assert
        assertEquals("ERROR in Truck.setSideStep()", !step, t.hasSideStep());
    }

    @Test
    public void setTowCap() throws Exception {
        // Arrange
        Truck t = new Truck(make, model, drive, price, mpg, step, tow);

        // Act
        t.setTowCap(tow * 2);

        // Assert
        assertEquals("ERROR in Truck.setTowCap()", tow * 2, t.getTowCap(), 0);
    }

    @Test
    public void printVehicle() throws Exception {
        // Arrange
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Truck t = new Truck(make, model, drive, price, mpg, step, tow);
        String expected = model + " " + make + "\n"
                + (drive ? "4WD" : "2WD") + "\n$"
                + price + "\n" + mpg + "MPG\n"
                + (step ? "" : "No ") + "Side Step\n"
                + "Tow up to " + tow + " ton(s)\n";

        // Act
        t.printVehicle();

        // Assert
        assertEquals("ERROR in Truck.printVehicle()", expected, out.toString());
    }

}