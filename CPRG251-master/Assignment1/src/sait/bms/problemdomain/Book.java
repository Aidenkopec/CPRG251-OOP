package sait.bms.problemdomain;

/**
 * Class description for creating Book objects
 * 
 * @author Aiden Kopec
 * @author Allyssa Preece
 * @author Anusone Soula
 */
public class Book {
	private long isbn;
	private String callNum;
	private int available;
	private int total;
	private String title;

	/**
	 * Creates a Book object with default values
	 */
	public Book() {
		super();
	}

	/**
	 * Creates a Book object by providing ISBN, call number, available, total,
	 * and title
	 * 
	 * @param isbn          Book ISBN
	 * @param callNum       Book call number
	 * @param available     Number of that Book available
	 * @param total         Total number of that Book
	 * @param title         Book title
	 */
	public Book(long isbn, String callNum, int available, int total, String title) {
		super();
		this.isbn = isbn;
		this.callNum = callNum;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	/**
	 * Returns the book ISBN
	 * 
	 * @return     the book isbn
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * Sets the book ISBN
	 * 
	 * @param isbn     Book isbn
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * Returns the book call number
	 * 
	 * @return     the book call number
	 */
	public String getCallNum() {
		return callNum;
	}

	/**
	 * Sets the book call number
	 * 
	 * @param callNum     Book call number
	 */
	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}

	/**
	 * Returns the number of this book that are available
	 * 
	 * @return     if the book is available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * Sets the number of available of the book
	 * 
	 * @param available     number of Book available
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * Returns the total number of the book
	 * 
	 * @return     the total number of the book
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Sets the total number of the book
	 * 
	 * @param total     Book total number
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Returns the book title
	 * 
	 * @return     the book title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the book title
	 * 
	 * @param title     Book title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Overridden toString to provide a String list of the Book parameters
	 */
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", callNum=" + callNum + ", available=" + available + ", total=" + total
				+ ", title=" + title + "]";
	}

	/**
	 * Prints the formatted output in a table
	 * 
	 * @param b     Book object
	 */
	public void printFormatOutput(Book b) {
		System.out.printf("%-20s %-20d%n", "ISBN:", b.getIsbn());
		System.out.printf("%-20s %-20s%n", "Call Number:", b.getCallNum());
		System.out.printf("%-20s %-20d%n", "Available:", b.getAvailable());
		System.out.printf("%-20s %-20d%n", "Total:", b.getTotal());
		System.out.printf("%-20s %-20s%n", "Title:", b.getTitle());
	}
}
