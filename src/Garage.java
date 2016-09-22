/**
 * Created by Andrew Shubin on 9/21/16.
 */
public class Garage {
    public static void main(String[] args) {
        Garage g = new Garage();
    }

    public Garage() {
        Inventory inv = new Inventory();

        Vehicle v1 = new Truck("Ford", 1995, false, 1200, 13, false, 0.5);
        Vehicle v2 = new Car("Toyota", 1999, true, 200, 28, false);
        Vehicle v3 = new Truck("Ram", 2000, true, 5800, 10, true, 10);

        inv.add(v1);
        inv.add(v2);
        inv.add(v3);

        System.out.println("Cheapest vehicle is:");
        inv.findCheapestVehicle().printVehicle();

        System.out.println("\nMost expensive is:");
        inv.findMostExpensiveVehicle().printVehicle();

        System.out.print("\nAverage cost of vehicles in inventory is: ");
        inv.printAveragePriceOfAllVehicles();
        System.out.println();

    }
}
