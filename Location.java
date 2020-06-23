
/**
 * The class Location is for the location of a storage facility. It has a name for the location and
 * has methods to manipulate arrays storing information abount the units at the location and the customers.
 *
 * @author Valerie Foster
 * @version 1/9/2018
 */
public class Location {

    // instance variables
    private String name;
    private Unit[][] unitArr;
    private Customer[] custArr;

    /**
     * Constructor for objects of class Location
     * 
     * @param   name    the name to identify the location (PRECONDITION - the name must be of the format two uppercase letters, two numbers, then a name)
     */
    public Location(String name) {
        if (!name.matches("[A-Z]{2}\\d{2}\\w+"))
            throw new IllegalArgumentException("Wrong location name format.");
        this.name = name;
        unitArr = new Unit[12][20];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 20; col++) {
                unitArr[row][col] = new Unit(UnitType.STANDARD, 10, 10, 15, 40);
            }
        }
        for (int col = 0; col < 20; col++) {
            unitArr[10][col] = new Unit(UnitType.HUMIDITY_CONTROLLED, 12, 12, 12, 60);
            unitArr[11][col] = new Unit(UnitType.TEMP_CONTROLLED, 10, 12, 15, 75);
        }
        custArr = new Customer[100];
    }

    /**
     * An accessor - returns the location's identifier
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns a unit at the point of the given indexes
     *
     * @param   row, col    two integer indexes
     * @return              a unit
     */
    public Unit getUnit(int row, int col) {
        return unitArr[row][col];
    }

    /**
     * This method returns a customer at the given index
     *
     * @param   ind     an index
     * @return          a customer
     */
    public Customer getCust(int ind) {
        return custArr[ind];
    }

    /**
     * Returns how many cutomers there are at this location by looping through the array to count how many no-null values there are
     */
    public int getCustCount() {
        int count = 0;
        while (custArr[count] != null) {
            count++;
        }
        return count;
    }

    /**
     * Adds a customer to the customer array by looping through and adding the value to the first null spot it finds
     *
     * @param   newCust     a customer to add
     */
    public void addCust(Customer newCust) {
        int count = 0;
        while (custArr[count] != null) {
            count++;
        }
        custArr[count] = newCust;
    }

    /**
     * Creates an array of units rented to the given customer by looping through the units and finding the total number of units 
     * rented to the given customer, generating an array of that size, then filling it with all the units for that customer
     *
     * @param   cust    a customer of the location
     * @return          an array of rented units
     */
    public Unit[] getUnitForCust(Customer cust) {
        int count = 0;
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[0].length; col++) {
                if (unitArr[row][col].getCust() != null && unitArr[row][col].getCust().equals(cust)) {
                    count++;
                }
            }
        }
        Unit[] unitCust = new Unit[count];
        int idx = 0;
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[0].length; col++) {
                if (unitArr[row][col].getCust() != null && unitArr[row][col].getCust().equals(cust)) {
                    Unit temp = unitArr[row][col];
                    unitCust[idx] = temp;
                    idx++;
                }
            }
        }
        return unitCust;
    }

    /**
     * Creates an array with units that are not rented to anyone by looping through the units and finding the total number of units
     * that aren't rented to anyone, generating an array of that size, then filling it with all the unrented units
     *
     * @return    an array of unrented units
     */
    public Unit[] getEmptyUnits() {
        int count = 0;
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[0].length; col++) {
                if (unitArr[row][col].getCust() == null) {
                    count++;
                }
            }
        }
        Unit[] emptyUnits = new Unit[count];
        int idx = 0;
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[0].length; col++) {
                if (unitArr[row][col].getCust() == null) {
                    Unit temp = unitArr[row][col];
                    emptyUnits[idx] = temp;
                    idx++;
                }
            }
        }
        return emptyUnits;
    }

    /**
     * Creates an array of units of a certain type that aren't rented to anyone by looping through the units and finding the total number of units
     * of the given type that aren't rented to anyone, generating an array of that size, then filling it with all the unrented units of that type
     *
     * @param   type    a type of unit
     * @return          an array of unrented units of the given type
     */
    public Unit[] getTypeEmptyUnits(UnitType type) {
        int count = 0;
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[0].length; col++) {
                if (unitArr[row][col].getType() == type && unitArr[row][col].getCust() == null) {
                    count++;
                }
            }
        }
        Unit[] emptyType = new Unit[count];
        int idx = 0;
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[0].length; col++) {
                if (unitArr[row][col].getType() == type && unitArr[row][col].getCust() == null) {
                    Unit temp = unitArr[row][col];
                    emptyType[idx] = temp;
                    idx++;
                }
            }
        }
        return emptyType;
    }

    /**
     * This method loops through the cutomer array and uses the getUnitForCust method to charge every customer for all of the units they rent
     */
    public void chargeRent() {
        for (int ind = 0; ind < custArr.length; ind++) {
            Unit[] custUnit = getUnitForCust(custArr[ind]);
            for (int idx = 0; idx < custUnit.length; idx ++) {
                double charge = custUnit[idx].getPrice();
                custArr[ind].chargeAcct(charge);
            }
        }
    }

    @Override
    public String toString() {
        String str = "Location:\n";
        str += "Name:      " + name + "\n";
        str += "Customers: " + getCustCount() + "\n";
        return str;
    }
    
}
