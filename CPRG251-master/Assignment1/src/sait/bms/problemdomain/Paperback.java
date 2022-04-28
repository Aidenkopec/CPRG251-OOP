package sait.bms.problemdomain;

/**
 * Class description for Paperback class
 *
 * @author Aiden Kopec
 * @author Allyssa Preece
 * @author Anusone Soula
 */
public class Paperback extends Book {
    private String authors;
    private int year;
    private char genre;

    /**
     * Creates a PaperBack object with default constructor
     */
    public Paperback() {
    }

    /**
	 * Create a paperback object

     * @param isbn          Paperback isbn
     * @param callNum       Paperback callNum
     * @param available     Paperback number of available books
     * @param total         Paperback number of total books
     * @param title         Paperback book title
     * @param authors       Paperback book authors
     * @param year          Paperback book year
     * @param genre         Paperback book genre
     */
    public Paperback(long isbn, String callNum, int available, int total, String title, String authors, int year,
                     char genre) {
        super(isbn, callNum, available, total, title);
        this.authors = authors;
        this.year = year;
        this.genre = genre;
    }

    /**
     * Returns Paperback author
     *
     * @return     the paperback author
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * Set the Paperback author
     *
     * @param authors     sets the paperback author
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * Returns Paperback book year
     *
     * @return     the paperback year
     */
    public int getYear() {
        return year;
    }

    /**
     * Set Paperback year
     *
     * @param year     sets the paperback year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns Paperback genre
     *
     * @return     the paperback genre
     */
    public char getGenre() {
        return genre;
    }

    /**
     * Set Paperback genre
     *
     * @param genre     the genre to be set
     */
    public void setGenre(char genre) {
        this.genre = genre;
    }

    /**
     * Override the toString method to provide a String list of Paperback parameters
     */
    @Override
    public String toString() {
        return "Paperback [getIsbn()=" + getIsbn() + ", getCallNum()=" + getCallNum() + ", getAvailable()=" +
                getAvailable() + ", getTotal()=" + getTotal() + ", getTitle()=" + getTitle() + ", authors="
                + authors + ", year=" + year + ", genre=" + genre + "]";
    }

    /**
     * Returns the full genre name from the character for genre
     *
     * @param format     Paperback format
     * @return           Full name
     */
    public String fullFormatPaperback(char format) {
        String full = "";
        switch (format) {
            case 'A':
                full = "Adventure";
                break;
            case 'D':
                full = "Drama";
                break;
            case 'E':
                full = "Education";
                break;
            case 'C':
                full = "Classic";
                break;
            case 'F':
                full = "Fantasy";
                break;
            case 'S':
                full = "Science Fiction";
                break;
            default:
        }
        return full;
    }
	
    /**
     * Prints the formatted output as a table for parameters unique to Paperback objects
     *
     * @param b         A Book object
     * @param genre     Paperback genre
     */
  public void displayDifference(Book b, char genre) {
		System.out.printf("%-20s %-20s%n", "Authors:", ((Paperback) b).getAuthors());
		System.out.printf("%-20s %-20d%n", "Year:", ((Paperback) b).getYear());
		System.out.printf("%-20s %-20s%n", "Genre:", ((Paperback) b).fullFormatPaperback(genre));
		System.out.println();
	}
}