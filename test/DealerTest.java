/**
 * Created by Andrew Shubin on 10/8/16.
 */

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class DealerTest {

    @Test
    public void loadInventoryTest() throws Exception {

        // Arrange
        String invURL = "https://raw.githubusercontent.com/"
                + "kyungsooim/TestData/master/data/"
                + "SeptemberInventory.txt";
        Dealer dealer = null;

        // Act
        dealer = new Dealer(invURL);

        // Assert
        assertNotNull(dealer.getInventory());
    }

    @Test
    public void serializeDeserializeTest() throws Exception {

        // Arrange
        String fileName = "dealer.ser";
        String invURL = "https://raw.githubusercontent.com/"
                + "kyungsooim/TestData/master/data/"
                + "SeptemberInventory.txt";
        Dealer dealer = new Dealer(invURL);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String make = "Ford Mustang";
        int model = 1999;
        boolean drive = false;
        double price = 8000;
        double mpg = 0;
        // This is dependant upon data in invURL staying
        // what it was when I wrote this code (Oct 8, 2016)
        String expected = model + " " + make + "\n"
                + (drive ? "4WD" : "2WD") + "\n$"
                + price + "\n" + mpg + "MPG\n";

        // Act
        dealer.serialize(fileName);
        Dealer loadedDealer = Dealer.deserialize(fileName);
        loadedDealer.getInventory().findCheapestVehicle().printVehicle();
        String result = out.toString();

        // Assert
        assertEquals(expected, result);
    }

}