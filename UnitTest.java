
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UnitTest tests the Unit class.
 *
 * @author  Valerie Foster
 * @version 1/9/2018
 */
public class UnitTest {

    Unit newUnit;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        newUnit = new Unit(UnitType.STANDARD, 82.5, 49.9, 65.5, 94.2, new Customer("Valerie Foster", "9876543210", 59.63), new Date(5, 5, 2011));
    }

    @Test
    public void testConstructor() {
        assertEquals(UnitType.STANDARD, newUnit.getType());
        assertEquals(82.5, newUnit.getWidth(), 0.001);
        assertEquals(49.9, newUnit.getLength(), 0.001);
        assertEquals(65.5, newUnit.getHeight(), 0.001);
        assertEquals(94.2, newUnit.getPrice(), 0.001);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testPrecondition() {
        Unit badUnit = new Unit(UnitType.STANDARD, -5, 8, 4, 32);
    }
    
    @Test
    public void testRentUnit() {
        Unit unit1 = new Unit(UnitType.STANDARD, 82.5, 49.9, 65.5, 94.2);
        Customer cust1 = new Customer("Valerie Foster", "9876543210", 59.63);
        Date date1 = new Date(5, 5, 2011);
        unit1.rentUnit(cust1, date1);
        assertEquals(cust1, unit1.getCust());
        assertEquals(date1, unit1.getDate());
    }
    
    @Test
    public void testReleaseUnit() {
        newUnit.releaseUnit();
        assertNull(newUnit.getCust());
        assertNull(newUnit.getDate());
    }
    
}

