/**
 * Created by Andrew Shubin on 9/21/16.
 * Garage.java is merely a test runner,
 * and not part of the assignment.
 */
public class Garage {
    public static void main(String[] args) {
        Garage g = new Garage();
    }

    public Garage() {
        String invURL = "https://raw.githubusercontent.com/"
                + "kyungsooim/TestData/master/data/"
                + "SeptemberInventory.txt";
        Dealer dealer = new Dealer(invURL);

        Inventory inv = dealer.getInventory();

        System.out.println("Cheapest vehicle is:");
        inv.findCheapestVehicle().printVehicle();

        System.out.println("\nMost expensive is:");
        inv.findMostExpensiveVehicle().printVehicle();

        System.out.print("\nAverage cost of vehicles in inventory is: ");
        inv.printAveragePriceOfAllVehicles();
        System.out.println();

    }
}
