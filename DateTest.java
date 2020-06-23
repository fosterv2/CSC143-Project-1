
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DateTest tests the date class.
 *
 * @author  Valerie Foster
 * @version 1/9/2018
 */
public class DateTest {

    Date newDate;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        newDate = new Date(1, 9, 2018);
    }

    @Test
    public void testConstructor() {
        assertEquals(9, newDate.getDay());
        assertEquals(1, newDate.getMonth());
        assertEquals(2018, newDate.getYear());
    }
}

