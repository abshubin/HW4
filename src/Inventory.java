/**
 * Created by shubinite on 9/21/16.
 */

import java.util.*;
import java.text.*;

public class Inventory {
    private List<Vehicle> inv;

    public Inventory() {
        inv = new ArrayList<Vehicle>();
    }

    public void add(Vehicle v) {
        inv.add(v);
    }

    public void remove(Vehicle v) {
        inv.remove(v);
    }

    public Vehicle findCheapestVehicle() {
        Vehicle cheapest = inv.get(0);
        for (Vehicle v : inv) {
            if ( v.getPrice() < cheapest.getPrice() ) {
                cheapest = v;
            }
        }
        return cheapest;
    }

    public Vehicle findMostExpensiveVehicle() {
        Vehicle mostExp = new Vehicle(null, 0, false, 0, 0);
        for (Vehicle v : inv) {
            if ( v.getPrice() > mostExp.getPrice() ) {
                mostExp = v;
            }
        }
        return mostExp;
    }

    public void printAveragePriceOfAllVehicles() {
        double sum = 0;
        int n = 0;
        for (Vehicle v : inv) {
            sum += v.getPrice();
            n++;
        }
        String ave = new DecimalFormat("#.##").format(sum / (double) n);
        System.out.print( "$" + ave );
    }
}
