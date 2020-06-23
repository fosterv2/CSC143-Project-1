
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LocationTest tests the location class.
 *
 * @author  Valerie Foster
 * @version 1/9/2018
 */
public class LocationTest {
    
    Location newLoc;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        newLoc = new Location("WA19Seattle");
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
    }
    
    @Test
    public void testConstructor() {
        assertEquals("WA19Seattle", newLoc.getName());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testPrecondition() {
        Location badLoc = new Location("W19Seattle");
    }
    
    @Test
    public void testGetCustCount() {
        assertEquals(4, newLoc.getCustCount());
    }
    
    @Test
    public void testGetEmptyUnits() {
        assertEquals(235, newLoc.getEmptyUnits().length);
        assertNull(newLoc.getEmptyUnits()[0].getCust());
    }
    
    @Test
    public void testGetTypeEmptyUnits() {
        assertEquals(19, newLoc.getTypeEmptyUnits(UnitType.TEMP_CONTROLLED).length);
        assertNull(newLoc.getEmptyUnits()[0].getCust());
    }
    
    @Test
    public void testChargeRent() {
        newLoc.chargeRent();
        assertEquals(619.63, newLoc.getCust(0).getAcctBal(), 0.001);
    }
    
}
