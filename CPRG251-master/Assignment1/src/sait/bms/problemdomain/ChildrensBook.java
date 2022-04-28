package sait.bms.problemdomain;

/**
 * Class description for ChildrensBook, which is a Book
 * 
 * @author Aiden Kopec
 * @author Allyssa Preece
 * @author Anusone Soula
 */
public class ChildrensBook extends Book {
	private String authors;
	private char format;

	/**
	 * Creates a ChildrensBook object with default values
	 */
	public ChildrensBook() {
		super();
	}

	/**
	 * Creates a ChildrensBook object provided isbn, call number, available, total,
	 * title, and type from Book class and authors, format from this class
	 * 
	 * @param isbn          Book isbn
	 * @param callNum       Book call number
	 * @param available     Book number of available books
	 * @param total         Book number of total books
	 * @param title         Book title
	 * @param authors       Children's book authors
	 * @param format        Children's book format
	 */
	public ChildrensBook(long isbn, String callNum, int available, int total, String title, String authors, char format) {
		super(isbn, callNum, available, total, title);
		this.authors = authors;
		this.format = format;
	}

	/**
	 * Returns the book authors
	 * 
	 * @return the book authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * Sets the book authors
	 * 
	 * @param authors     Children's book authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * Returns the format of the children's book
	 * 
	 * @return     the format of the book
	 */
	public char getFormat() {
		return format;
	}

	/**
	 * Sets the format of the children's book
	 * 
	 * @param format     Children's book format
	 */
	public void setFormat(char format) {
		this.format = format;
	}
	
	/**
	 * Override the toString method to provide String list of Children's Book
	 * parameters
	 */
	@Override
	public String toString() {
		return "ChildrensBook [getIsbn()=" + getIsbn() + ", getCallNum()=" + getCallNum() + ", getAvailable()="
				+ getAvailable() + ", getTotal()=" + getTotal() + ", getTitle()=" + getTitle() + "authors=" + authors
				+ ", format=" + format + "]";
	}

	/**
	 * Returns the full name of the format from the character that is input from the
	 * user
	 * 
	 * @param format     Children's Book format
	 * @return           Full name
	 */
	public String fullFormatChildrens(char format) {
		String full = "";
		
		switch (format) {
		case 'P':
			full = "Picture Book";
			break;
		case 'E':
			full = "Early Readers";
			break;
		case 'C':
			full = "Chapter Book";
			break;
		default:
		}
		
		return full;
	}

	/**
	 * Prints the formatted parameters in a table that are unique to Childrens Book
	 * type
	 * 
	 * @param b          A Book object
	 * @param format     Children's Book format
	 */
	public void displayDifference(Book b, char format) {
		System.out.printf("%-20s %-20s%n", "Authors:", ((ChildrensBook) b).getAuthors());
		System.out.printf("%-20s %-20s%n", "Format:", ((ChildrensBook) b).fullFormatChildrens(format));
		System.out.println();
	}
}
