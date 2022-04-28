package sait.bms.problemdomain;

/**
 * Class description for Cookbook Class
 * 
 * @author Aiden Kopec
 * @author Allyssa Preece
 * @author Anusone Soula
 */
public class Cookbook extends Book {
	private String publisher;
	private char diet;

	/**
	 * Creates a Cookbook object with default values
	 */
	public Cookbook() {
		super();
	}

	/**
	 * Creates a Cookbook object provided isbn, call number, available, total,
	 * title, and type from Book class and the publisher and diet from this class
	 * 
	 * @param isbn          Book isbn
	 * @param callNum       Book call number
	 * @param available     Book number of available books
	 * @param total         Book number of total books
	 * @param title         Book title
	 * @param publisher     Cookbook publisher
	 * @param diet          Cookbook diet
	 */
	public Cookbook(long isbn, String callNum, int available, int total, String title, String publisher, char diet) {
		super(isbn, callNum, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}
	
	/**
	 * Returns the Cookbook publisher
	 * @return     the cookbook publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * Sets the Cookbook publisher
	 * @param publisher     Cookbook publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * Returns the Cookbook diet
	 * @return     the cookbook diet
	 */
	public char getDiet() {
		return diet;
	}
	
	/**
	 * Sets the Cookbook diet
	 * @param diet     Cookbook diet
	 */
	public void setDiet(char diet) {
		this.diet = diet;
	}
	
	/**
	 * Override the toString method to provide a String list of Cookbook parameters
	 */
	@Override
	public String toString() {
		return "Cookbook [getIsbn()=" + getIsbn() + ", getCallNum()=" + getCallNum() + ", getAvailable()="
				+ getAvailable() + ", getTotal()=" + getTotal() + ", getTitle()=" + getTitle() + "publisher="
				+ publisher + ", diet=" + diet + "]";
	}
	
	/**
	 * Returns the full diet name from the character for diet
	 * @param format     Cookbook format
	 * @return           Full name
	 */
	public String fullFormatCook(char format) {
		String full = "";
		
		switch (format) {
		case 'D':
			full = "Diabetic";
			break;
		case 'V':
			full = "Vegetarian";
			break;
		case 'G':
			full = "Gluten-free";
			break;
		case 'I':
			full = "International";
			break;
		case 'N':
			full = "None";
			break;
		default:
		}
		
		return full;
	}
	
	/**
	 * Prints the formatted output as a table for parameters unique to Cookbook objects
	 * @param b        A Book object
	 * @param diet     Cookbook diet
	 */
	public void displayDifference(Book b, char diet) {
		System.out.printf("%-20s %-20s%n", "Publisher:", ((Cookbook) b).getPublisher());
		System.out.printf("%-20s %-20s%n", "Diet:", ((Cookbook) b).fullFormatCook(diet));
		System.out.println();
	}
}
