package sait.bms.problemdomain;

/**
 * Class description for Periodical Class
 *
 * @author Aiden Kopec
 * @author Allyssa Preece
 * @author Anusone Soula
 */
public class Periodical extends Book {
    private char frequency;

    /**
     * Default constructor for periodical
     */
    public Periodical() {
        super();
    }

    /**
	 * Create a periodical object
	 * 
     * @param isbn          Periodical isbn
     * @param callNum       Periodical callNum
     * @param available     Periodical number of a available books
     * @param total         Periodical number of total books
     * @param title         Periodical title of book
     * @param frequency     Periodical frequency
     */
    public Periodical(long isbn, String callNum, int available, int total, String title, char frequency) {
        super(isbn, callNum, available, total, title);
        this.frequency = frequency;
    }

    /**
     * Return Periodical frequency
     *
     * @return     the periodical frequency
     */
    public char getFrequency() {
        return frequency;
    }

    /**
     * Set Periodical frequency
     *
     * @param frequency     the frequency to be set
     */
    public void setFrequency(char frequency) {
        this.frequency = frequency;
    }

    /**
     * Override the toString method to provide a String list of Periodical parameters
     */
    @Override
    public String toString() {
        return "Periodical [getIsbn()=" + getIsbn() + ", getCallNum()=" + getCallNum()
                + ", getAvailable()=" + getAvailable() + ", getTotal()=" + getTotal() + ", getTitle()=" + getTitle()
                + ", frequency=" + frequency + "]";
    }

    /**
     * Returns the full frequency name from the character list for format
     *
     * @param format     Periodical format
     * @return           the full name of char letter
     */
    public String fullFormatPeriodical(char format) {
        String full = "";
        switch (format) {
            case 'D':
                full = "Daily";
                break;
            case 'W':
                full = "Weekly";
                break;
            case 'M':
                full = "Monthly";
                break;
            case 'B':
                full = "Bi-Monthly";
                break;
            case 'Q':
                full = "Quarterly";
                break;
            default:
        }
        return full;
    }

    /**
     * Prints the formatted output as a table for parameters unique to Periodical objects
     *
     * @param b             Periodical object
     * @param frequency     Periodical frequency
     */
    public void displayDifference(Book b, char frequency) {
		  System.out.printf("%-20s %-20s%n", "Frequency:", ((Periodical) b).fullFormatPeriodical(frequency));
		  System.out.println();
    }
}