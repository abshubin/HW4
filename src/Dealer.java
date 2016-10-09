/**
 * Created by Andrew Shubin on 10/8/16.
 */

import org.apache.commons.io.*;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

public class Dealer implements Serializable {

    private String inventoryRawURL;
    private String inventoryRaw;
    private Inventory inv;

    public Dealer(String inventoryRawURL) {

        this.inventoryRawURL = inventoryRawURL;
        if (!loadInventory()) {
            System.out.println("Data could not be loaded from URL:\n"
                    + inventoryRawURL);
        }
    }

    public boolean loadInventory() {

        // Load raw data from file
        InputStream in = null;
        try {
            in = new URL(inventoryRawURL).openStream();
            inventoryRaw = IOUtils.toString(in, "utf-8");
        } catch (Exception e) {
            return false;
        } finally {
            IOUtils.closeQuietly(in);
        }

        // Populate inv from raw data
        String[] invLines = StringUtils.split(inventoryRaw, '\n');
        inv = new Inventory();
        for (String line : invLines) {
            String[] vehicleFields = StringUtils.split(line, ',');
            String make = vehicleFields[0];
            int model = Integer.parseInt(vehicleFields[1]);
            double price = Double.parseDouble(vehicleFields[2]);
            boolean fourWD = false;
            if (vehicleFields.length > 3) {
                fourWD = vehicleFields[3].equals("TRUE");
            }
            Vehicle newVehicle = new Vehicle(make, model, fourWD, price, 0);
            inv.add(newVehicle);
        }

        return true;
    }

    public Inventory getInventory() {
        return inv;
    }

    public void serialize(String fileName) {

        File file = FileUtils.getFile(fileName);
        byte[] data = SerializationUtils.serialize(this);
        try {
            FileUtils.writeByteArrayToFile(file, data);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Dealer deserialize(String fileName) {

        File file = FileUtils.getFile(fileName);
        byte[] serializedDealer = null;
        try {
            serializedDealer = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SerializationUtils.deserialize(serializedDealer);
    }

}
