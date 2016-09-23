import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Andrew Shubin on 9/21/16.
 */
public class CarTest {

    private static String make = "Chevy Corvette";
    private static int model = 2001;
    private static boolean drive = false;
    private static double price = 30000;
    private static double mpg = 20;
    private static boolean conv = true;

    @Test
    public void isConvertible() throws Exception {
        // Arrange
        Car c = new Car(make, model, drive, price, mpg, conv);

        // Act
        boolean result = c.isConvertible();

        // Assert
        assertEquals("ERROR in Car.isConvertible()", conv, result);
    }

    @Test
    public void printVehicle() throws Exception {
        // Arrange
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Car c = new Car(make, model, drive, price, mpg, conv);
        String expected = model + " " + make + "\n"
                + (drive ? "4WD" : "2WD") + "\n$"
                + price + "\n" + mpg + "MPG\n"
                + "Is" + (conv ? " " : " not ")
                + "Convertible\n";

        // Act
        c.printVehicle();
        String result = out.toString();

        //Assert
        assertEquals("ERROR in Car.printVehicle()", expected, result);
    }

}