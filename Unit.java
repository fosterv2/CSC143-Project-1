
/**
 * The class Unit keeps track of the data related to a specific storage unit, such as the type of unit it is,
 * it's dimentions, the price to rent it, and whether it is rented to a customer.
 *
 * @author Valerie Foster
 * @version 1/9/2018
 */
public class Unit {
    
    // instance variables
    private UnitType type;
    private double width;
    private double length;
    private double height;
    private double price;
    private Customer cust;
    private Date date;

    /**
     * The full constructor for objects of class Unit
     * 
     * @param   type        the unit's type
     * @param   width       the unit's width (PRECONDITION - the width cannot be negative.)
     * @param   length      the unit's length (PRECONDITION - the length cannot be negative.)
     * @param   height      the unit's height (PRECONDITION - the height cannot be negative.)
     * @param   price       the price that the unit is rented at (PRECONDITION - the price cannot be negative.)
     * @param   cust        the customer the unit is rented to
     * @param   date        the date the unit was rented to a customer
     */
    public Unit(UnitType type, double width, double length, double height, double price, Customer cust, Date date) {
        if (width < 0.0){
            throw new IllegalArgumentException("The width cannot be less than zero.");
        }
        if (length < 0.0){
            throw new IllegalArgumentException("The length cannot be less than zero.");
        }
        if (height < 0.0){
            throw new IllegalArgumentException("The height cannot be less than zero.");
        }
        if (price < 0.0){
            throw new IllegalArgumentException("The price cannot be less than zero.");
        }
        this.type = type;
        this.width = width;
        this.length = length;
        this.height = height;
        this.price = price;
        this.cust = cust;
        this.date = date;
    }

    /**
     * The second constructor for objects of class Unit
     */
    public Unit(UnitType type, double width, double length, double height, double price) {
        this(type, width, length, height, price, null, null);
    }
    
    /**
     * An accessor - returns the unit's type
     */
    public UnitType getType() {
        return type;
    }
    
    /**
     * An accessor - returns the unit's width
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * An accessor - returns the unit's length
     */
    public double getLength() {
        return length;
    }
    
    /**
     * An accessor - returns the unit's height
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * An accessor - returns the unit's price
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * An accessor - returns the Customer associated to the unit if there is one
     */
    public Customer getCust() {
        return cust;
    }
    
    /**
     * An accessor - returns the date the unit was rented if it is rented to a customer
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * This method rents a unit to a customer on a date with a renting price
     *
     * @param   cust    a customer the unit is rented to
     * @param   date    the date the unit is rented on
     */
    public void rentUnit(Customer cust, Date date) {
        this.cust = cust;
        this.date = date;
    }
    
    /**
     * This method releases a unit so that it is unrented by making no customer or date attached
     */
    public void releaseUnit() {
        this.cust = null;
        this.date = null;
    }
    
    @Override
    public String toString() {
        String str = "Unit\n";
        str += "Dimensions: " + width + " X " + length + " X " + height + "\n";
        str += "Price:      " + price + "\n";
        str += "Rented:     ";
        if (getCust() == null) {
            str += "No\n";
        } else {
            str += "Yes\n";
        }
        return str;
    }
    
}
