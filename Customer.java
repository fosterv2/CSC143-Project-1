
/**
 * The class Customer creates a customer with a name, phone number and an account,
 * and it manages that account balance.
 *
 * @author Valerie Foster
 * @version 1/9/2018
 */
public class Customer {
    
    // instance variables
    private String name;
    private String phone;
    private double acctBal;

    /**
     * Constructor for objects of class Customer
     * 
     * @param   name    the customer's first and last name (PRECONDITION - the name cannot be empty)
     * @param   phone   the customer's phone number (PRECONDITION - The phone number must be a String of 10 digits with no dashes or parentheses between.
     * @param   acctBal the customer's account balance (PRECONDITION - The acount balance cannot be negative.)
     */
    public Customer(String name, String phone, double acctBal) {
        if (name == "") {
            throw new IllegalArgumentException("The name connot be empty.");
        }
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("The phone number must be 10 digits with no characters.");
        }
        if (acctBal < 0.0) {
            throw new IllegalArgumentException("The account balance cannot be less than zero.");
        }
        this.name = name;
        this.phone = phone;
        this.acctBal = acctBal;
    }

    /**
     * An accessor - returns the customer's name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * An accessor - returns the customer's phone number.
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * An accessor - returns the customer's account balance.
     */
    public double getAcctBal() {
        return acctBal;
    }
    
    /**
     * A mutator method - changes the cutomer's name to the given name (PRECONDITION - the name cannot be empty)
     */
    public void setName(String name) {
        if (name == "") {
            throw new IllegalArgumentException("The name connot be empty.");
        }
        this.name = name;
    }
    
    /**
     * A mutator method - changes the cutomer's phone number to the given number (PRECONDITION - The phone number must be a String of 10 digits with no dashes or parentheses between.)
     */
    public void setPhone(String phone) {
        if(!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("The phone number must be 10 digits with no characters.");
        }
        this.phone = phone;
    }
    
    /**
     * Subtracts the given amount to the customer's balance (PRECONDITION - the charge amount must be positive)
     *
     * @param   charge  the amount to be charged to the account
     * @return          the updated account balance
     */
    public double chargeAcct(double charge) {
        if (charge < 0.0) {
            throw new IllegalArgumentException("Charge amounts must be non-negative");
        }
        acctBal -= charge;
        return acctBal;
    }
    
    /**
     * Adds the given amount from the customer's balance (PRECONDITION - the credit amount must be positive)
     *
     * @param   credit  the amount to be credited to the account
     * @return          the updated account balance
     */
    public double creditAcct(double credit) {
        if (credit < 0.0) {
            throw new IllegalArgumentException("Credit amounts must be non-negative");
        }
        acctBal += credit;
        return acctBal;
    }
    
    @Override
    public String toString() {
        String str = "Customer:\n";
        str += "Name:    " + name + "\n";
        str += "Phone:   " + phone + "\n";
        str += "Balance: $" + acctBal + "\n";
        return str;
    }
    
}
