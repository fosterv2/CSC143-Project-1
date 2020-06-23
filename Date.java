
/**
 * The class Date is a simple class that stores infromation about a date with month, day, and year.
 *
 * @author Valerie Foster
 * @version 1/9/2018
 */
public class Date {

    // instance variables
    private int month;
    private int day;
    private int year;

    /**
     * Constructor for objects of class Date
     * 
     * @param   month   the date's month (PRECONDITION - the month must be in 1 to 12)
     * @param   day     the date's day (PRECONDITION - the day must be in 1 to 31)
     * @param   year    the dates's year (PRECONDITION - the year must be positive)
     */
    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("The month should be between 1 and 12");
        if (day <= 0 || day > 31)
            throw new IllegalArgumentException("The day should be between 1 and 31");
        if (year <= 0)
            throw new IllegalArgumentException("The year should be greater than 0");
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * An accessor - returns the date's month.
     */
    public int getMonth() {
        return this.month;
    }
    
    /**
     * An accessor - returns the date's day.
     */
    public int getDay() {
        return this.day;
    }
    
    /**
     * An accessor - returns the date's year.
     */
    public int getYear() {
        return this.year;
    }
    
    @Override
    public String toString() {
        return "Date:\n" + this.month + "/" + this.day + "/" + this.year + "\n";
    }
}
