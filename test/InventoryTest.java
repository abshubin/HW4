import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import static org.junit.Assert.*;

/**
 * Created by Andrew Shubin on 9/21/16.
 */
public class InventoryTest {

    private static String make = "Ford Ranger";
    private static int model = 1998;
    private static boolean drive = true;
    private static double price = 5000;
    private static double mpg = 13;

    @Test
    public void add() throws Exception {
        // Arrange
        Inventory inv = new Inventory();
        Vehicle v = new Vehicle(make, model, drive, price, mpg);

        // Act
        inv.add(v);

        // Assert
        assertEquals("ERROR in Inventory.add()", v, inv.findCheapestVehicle());
    }

    @Test
    public void remove() throws Exception {
        // Arrange
        Inventory inv = new Inventory();
        Vehicle v1 = new Vehicle(make, model, drive, price, mpg);
        Vehicle v2 = new Vehicle(make, model, drive, price + 100, mpg);
        inv.add(v1);
        inv.add(v2);

        // Act
        inv.remove(v2);

        // Assert
        assertEquals("ERROR in Inventory.remove()", v1, inv.findMostExpensiveVehicle());
    }

    @Test
    public void findCheapestVehicle() throws Exception {
        // Arrange
        Inventory inv = new Inventory();
        Vehicle cheap = new Vehicle(make, model, drive, price, mpg);
        Vehicle pricey = new Vehicle(make, model, drive, price * 3, mpg);
        inv.add(cheap);
        inv.add(pricey);

        // Act
        Vehicle result = inv.findCheapestVehicle();

        // Assert
        assertEquals("ERROR in Inventory.findCheapestVehicle()", cheap, result);
    }

    @Test
    public void findMostExpensiveVehicle() throws Exception {
        // Arrange
        Inventory inv = new Inventory();
        Vehicle cheap = new Vehicle(make, model, drive, price, mpg);
        Vehicle pricey = new Vehicle(make, model, drive, price * 3, mpg);
        inv.add(cheap);
        inv.add(pricey);

        // Act
        Vehicle result = inv.findMostExpensiveVehicle();

        // Assert
        assertEquals("ERROR in Inventory.findMostExpensiveVehicle()", pricey, result);
    }

    @Test
    public void printAveragePriceOfAllVehicles() throws Exception {
        // Arrange
        Inventory inv = new Inventory();
        Vehicle v1 = new Vehicle(make, model, drive, price, mpg);
        Vehicle v2 = new Vehicle(make, model, drive, price * 3,  mpg);
        inv.add(v1);
        inv.add(v2);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String expected = "$" + new DecimalFormat("#.##").format(price * 2);

        // Act
        inv.printAveragePriceOfAllVehicles();

        // Assert
        assertEquals("ERROR in Inventory.printAveragePriceOfAllVehicles()", expected, out.toString());
    }

}