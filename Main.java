
/**
 * The class Main shows examples of the other classes in this project.
 *
 * @author Valerie Foster
 * @version 1/9/2018
 */
public class Main {
    public static void main(String[] args) {
        Customer newCust = new Customer("Valerie Foster", "1234567890", 10.43);
        System.out.println(newCust);
        
        Date myDate = new Date(1, 9, 2018);
        System.out.println(myDate);
        
        Unit newUnit = new Unit(UnitType.STANDARD, 82.5, 49.9, 65.5, 94.2, new Customer("Valerie Foster", "9876543210", 59.63), new Date(5, 5, 2011));
        System.out.println(newUnit);
        
        Location newLoc = new Location("WA19Seattle");
        Customer cust1 = new Customer("Valerie Foster", "9876543210", 659.63);
        Customer cust2 = new Customer("Sally Fields", "9517532580", 552.95);
        Customer cust3 = new Customer("Forest Walker", "1905405641", 816.19);
        Customer cust4 = new Customer("Harry Johnson", "8405493060", 1136.51);
        newLoc.addCust(cust1);
        newLoc.addCust(cust2);
        newLoc.addCust(cust3);
        newLoc.addCust(cust4);
        Date newDate = new Date(1, 9, 2018);
        newLoc.getUnit(3, 2).rentUnit(cust1, newDate);
        newLoc.getUnit(6, 12).rentUnit(cust2, newDate);
        newLoc.getUnit(5, 19).rentUnit(cust3, newDate);
        newLoc.getUnit(0, 9).rentUnit(cust4, newDate);
        newLoc.getUnit(11, 7).rentUnit(cust4, newDate);
        System.out.println(newLoc);
    }
}
