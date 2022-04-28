package sait.bms.managers;

import java.io.*;
import java.util.*;

import sait.bms.problemdomain.*;

/**
 * This class is the manager for the problem domain. It contains all the utility methods
 *
 * @author Allyssa Preece
 * @author Anusone Soula
 * @author Aiden Kopec
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class Managers {
    private static Scanner in;
    private static final String PATH = "res/books.txt";
    private static final ArrayList<Book> myBooks = new ArrayList<>();

    /**
     * Creates a managers object, to aid in the running of the program
     * @throws IOException     If an input or output exception occurred
     */
    public Managers() throws IOException {
        super();

        in = new Scanner(System.in);
        loadBooks();
        displayMenu();
    }

    /**
     * Prints the formatted menu and allows the user to choose an option
     * @throws IOException     If an input or output exception occurred
     */
    public void displayMenu() throws IOException {
        int option = 0;

        while (option != 5) {
            System.out.println("Welcome in ABC Book Company: How May We Assist You?");
            System.out.printf("%-10d %-10s%n", 1, "Checkout Book");
            System.out.printf("%-10d %-10s%n", 2, "Find Books by Title");
            System.out.printf("%-10d %-10s%n", 3, "Display Books by Type");
            System.out.printf("%-10d %-10s%n", 4, "Produce Random Book List");
            System.out.printf("%-10d %-10s%n", 5, "Save & Exit");
            System.out.print("Enter option: ");
            
            while (!in.hasNextInt()) {
                System.out.print("Invalid input: not a number. Please try again: ");
                in.next(); 
            }
            
            option = in.nextInt();
            
            if (option <= 5 && option > 0) {
            System.out.println();

            switch (option) {
            case 1:
                checkOutBook();
                break;
            case 2:
                findBook();
                break;
            case 3:
                displayType();
                break;
            case 4:
                randomList();
                break;
            case 5:
                saveBooks();
                break; 
            default:
            }
            } else {
            	System.out.println("Invalid input. Please enter a number between 1 and 5.");
            	System.out.println();
            }
        }
        
        in.close();
        System.out.println("Thank you for using ABC Book Company.");
    }

    /**
     * Takes the user input ISBN and searches for it, the method then checks the availability
     * of the book and decrements the availability if it is available
     */
    private void checkOutBook() {
        System.out.print("Enter ISBN of book: ");
        
        while (!in.hasNextLong()) {
            System.out.print("Invalid input: not a proper ISBN. Please try again: ");
            in.next(); 
        }
        
        long searchIsbn = in.nextLong();
        boolean found = false;

        for (Book b: myBooks) {
            if (b.getIsbn() == searchIsbn) {
                if (b.getAvailable() > 0) {
                    b.setAvailable(b.getAvailable() - 1);
                    System.out.println("The book " + b.getTitle() + " has been checked out.");
                    System.out.println("It can be located using a call number: " + b.getCallNum());
                    found = true;
                } else {
                    System.out.println("This book is unavailable");
                    found = false;
                }
            }
        }

        if (!found) {
            System.out.println("This ISBN does not match any books");
        }

        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds a book using user input to do a partial search and display any matches that show up.
     */
    private void findBook() {
        System.out.print("Enter a title to search for: ");
        String findBook = in.next();
        
        boolean found = false;

        for (Book b: myBooks) {
            if (b.getTitle().toLowerCase().contains(findBook.toLowerCase())) {
            	found = true;
                printBook(b);
            }
        }
        
        if (!found) {
        	System.out.println("This search does not match any books");
        }

        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays a formatted list of books and their respective genres.
     * @param b    the book to be displayed
     */
    private void printBook(Book b) {
        b.printFormatOutput(b);

        if (b instanceof ChildrensBook) {
            ((ChildrensBook) b).displayDifference(b, ((ChildrensBook) b).getFormat());
        } else if (b instanceof Cookbook) {
            ((Cookbook) b).displayDifference(b, ((Cookbook) b).getDiet());
        } else if (b instanceof Paperback) {
            ((Paperback) b).displayDifference(b, ((Paperback) b).getGenre());
        } else {
            ((Periodical) b).displayDifference(b, ((Periodical) b).getFrequency());
        }
    }

    /**
     * Displays a list of books based on each book format/diet/genre/frequency.
     *
     * This method will ask the user for which book type they want to narrow their search for.
     * After selecting a book, the application will list several types of genres based on the
     * book chosen. The method will then print out the matching books in a formatted table.
     */
    private void displayType() {
    	int book;
    	
        do {
        	System.out.printf("%-10s %-10s\n", "#", "Type");
            System.out.printf("%-10d %-10s\n", 1, "Children's Books");
            System.out.printf("%-10d %-10s\n", 2, "Cookbooks");
            System.out.printf("%-10d %-10s\n", 3, "Paperbacks");
            System.out.printf("%-10d %-10s\n", 4, "Periodicals");
            System.out.print("Enter type of book: ");

            // Check to see if the input provided isn't an integer.
            while (!in.hasNextInt()) {
                System.out.print("Invalid input: not a number. Please try again: ");
                in.next(); 
            }

            book = in.nextInt();

            /* Check to see if the input provided is outside the range.
             * Since we're checking an integer input and also using that for our while loop, 
             * the entire list gets displayed again unlike where if the input is a string. 
             * Can't find a way to fix.
             */
            if (book < 1 || book > 4) {
                System.out.println("Invalid input: must be between 1 and 4. Please try again.");
            }
        } while (book < 1 || book > 4);
        
        switch (book) {
        case 1:
            System.out.print("Enter a format (P for Picture Book, E for Early Readers, or C for Chapter Book): ");
            break;
        case 2:
            System.out.print("Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-Free, I for International, or N for None): ");
            break;
        case 3:
            System.out.print("Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, for F for Fantasy): ");
            break;
        case 4:
            System.out.print("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bi-Monthly, or Q for Quarterly): ");
            break; 
        default:
            System.out.println("Invalid response.");
        }

        char type = in.next().toUpperCase().charAt(0);

        /* Iterate through each book to find one that matches the specified book type and genre.
         * Since several books use the same character to represent a type, we also check to see 
         * if the book is equal to the type we selected.
         */
        for (Book b: myBooks) {
            if (b instanceof ChildrensBook && book == 1) {
                if (((ChildrensBook) b).getFormat() == type) {
                    b.printFormatOutput(b);
                    ((ChildrensBook) b).displayDifference(b, ((ChildrensBook) b).getFormat());
                }
            } else if (b instanceof Cookbook && book == 2) {
                if (((Cookbook) b).getDiet() == type) {
                    b.printFormatOutput(b);
                    ((Cookbook) b).displayDifference(b, ((Cookbook) b).getDiet());
                }
            } else if (b instanceof Paperback && book == 3) {
                if (((Paperback) b).getGenre() == type) {
                    b.printFormatOutput(b);
                    ((Paperback) b).displayDifference(b, ((Paperback) b).getGenre());
                }
            } else if (b instanceof Periodical && book == 4) {
                if (((Periodical) b).getFrequency() == type) {
                    b.printFormatOutput(b);
                    ((Periodical) b).displayDifference(b, ((Periodical) b).getFrequency());
                }
            }
        }

        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the contents of MyBooks back to the books file in a formatted list
     * @throws IOException     If an input or output exception occurred
     */
    private void saveBooks() throws IOException {
        File bookList = new File(PATH);
        PrintWriter output = new PrintWriter(bookList);

        for (Book b: Managers.myBooks) {
            output.printf("%d;%s;%d;%d;%s", b.getIsbn(), b.getCallNum(), b.getAvailable(), b.getTotal(), b.getTitle());

            if (b instanceof ChildrensBook) {
                output.printf(";%s;%s", ((ChildrensBook) b).getAuthors(), ((ChildrensBook) b).getFormat());
            } else if (b instanceof Cookbook) {
                output.printf(";%s;%s", ((Cookbook) b).getPublisher(), ((Cookbook) b).getDiet());
            } else if (b instanceof Paperback) {
                output.printf(";%s;%d;%s", ((Paperback) b).getAuthors(), ((Paperback) b).getYear(), ((Paperback) b).getGenre());
            } else {
                output.printf(";%s", ((Periodical) b).getFrequency());
            }

            if (Managers.myBooks.indexOf(b) != Managers.myBooks.size() - 1) {
                output.println();
            }
        }
        output.close();
    }

    /**
     * Reads from a file into a single arraylist
     * @throws IOException     If an input or output exception occurred
     */
    public void loadBooks() throws IOException {
        Scanner bookScan = new Scanner(new File(PATH));

        while (bookScan.hasNext()) {
            String line = bookScan.nextLine();
            String[] fields = line.split(";");
            char type = fields[0].charAt(fields[0].length() - 1);

            switch (type) {
            case '0':
            case '1':
                myBooks.add(new ChildrensBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
                    Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
                break;
            case '2':
            case '3':
                myBooks.add(new Cookbook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
                    Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
                break;
            case '4':
            case '5':
            case '6':
            case '7':
                myBooks.add(new Paperback(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
                    Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]),
                    fields[7].charAt(0)));
                break;
            case '8':
            case '9':
                myBooks.add(new Periodical(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
                    Integer.parseInt(fields[3]), fields[4], fields[5].charAt(0)));
                break; 
            default:
            }
        }
        
        bookScan.close();
    }

    /**
     * Produces a random list of books of a length specified by the user
     */
    private void randomList() {
    	int input;
        System.out.print("Enter number of books: ");
        
        while (!in.hasNextInt()) {
            System.out.print("Invalid input: not a number. Please try again: ");
            in.next(); 
        }
        
        input = in.nextInt();

        System.out.println("Random books:");

        int i = 0;
        while (i < input) {
            int min = 0;
            int max = myBooks.size();
            int index = (int)(Math.random() * (max - min) + min);

            Book b = myBooks.get(index);
            printBook(b);

            i++;
        }

        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
