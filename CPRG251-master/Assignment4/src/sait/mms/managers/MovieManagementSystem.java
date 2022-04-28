package sait.mms.managers;

import sait.mms.contracts.DatabaseDriver;
import sait.mms.drivers.MariaDbDriver;
import java.sql.*;
import java.util.*;

/**
 * MovieManagementSystem class is responsible for the management and interactions with the MariaDb Database
 * @author Allyssa Preece
 * @author Anusone Soula
 * @author Aiden Kopec
 *
 * @version April 13, 2022
 */
public class MovieManagementSystem {
    private final DatabaseDriver db;
    private final Scanner input = new Scanner(System.in);

    /**
     * Constructor to create a new MovieManagementSystem object and opens a connection to the database
     * @throws SQLException if the database cannot be accessed
     */
    public MovieManagementSystem() throws SQLException {
        this.db = new MariaDbDriver();
        this.db.connect();
    }

    /**
     * Displays the menu, reads in the users input, and redirects to the appropriate method
     * @throws SQLException if the database cannot be accessed
     */
    public void displayMenu() throws SQLException {
        int option = 0;

        while (option != 5) {
            System.out.println("Jim's Movie Manager");
            System.out.printf("%-10d %-10s%n", 1, "Add New Movie");
            System.out.printf("%-10d %-10s%n", 2, "Print movies released in year");
            System.out.printf("%-10d %-10s%n", 3, "Print random list of movies");
            System.out.printf("%-10d %-10s%n", 4, "Delete a movie");
            System.out.printf("%-10d %-10s%n", 5, "Exit");
            try {
                System.out.print("Enter option: ");
                option = input.nextInt();

                if (option <= 5 && option > 0) {
                    System.out.println();
                    switch (option) {
                        case 1:
                            addMovie();
                            break;
                        case 2:
                            printMoviesInYear();
                            break;
                        case 3:
                            printRandomMovies();
                            break;
                        case 4:
                            deleteMovie();
                            break;
                        case 5:
                            System.out.println("Goodbye!");
                            db.disconnect();
                            System.exit(0);
                            break;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.\n");
                }
            }catch (InputMismatchException e){
                System.out.println("Error, please input a number between 1 and 5.\n");
                input.nextLine();
                displayMenu();
            }
        }
    }

    /**
     * Deletes a movie from the database given the id number of the movie
     * @throws SQLException if the database cannot be accessed
     */
    private void deleteMovie() throws SQLException {
        System.out.print("Enter the movie ID that you want to delete: ");
        int deleteId = input.nextInt();

        String sqlStatement = "delete from movies where id = '" + deleteId + "'";

        int deleted = db.update(sqlStatement);
        if (deleted > 0) {
            System.out.println("Movie " + deleteId + " is deleted.\n");
        }
        else{
            System.out.println("Error, the movie was not deleted\n");
        }
    }

    /**
     * Prints a list of random movies and calculates the total run time of the list produced
     * @throws SQLException if the database cannot be accessed
     */
    private void printRandomMovies() throws SQLException {
        int totalDuration = 0;
        System.out.print("Enter number of movies: ");
        int numberOfMovies = input.nextInt();

        String sqlStatement = "Select * from movies order by rand() fetch first " + numberOfMovies + " rows only";
        ResultSet result = db.get(sqlStatement);

        System.out.println("\nMovie List");
        System.out.printf("%-10s %-10s %-10s\n", "Duration", "Year", "Title");
        while (result.next()) {
            totalDuration += result.getInt("Duration");
            System.out.printf("%-10d %-10d %-10s\n",
                    result.getInt("Duration"),
                    result.getInt("Year"),
                    result.getString("Title"));
        }
        System.out.println("Total Duration: " + totalDuration + " minutes\n");

    }

    /**
     * Prints a list of all the movies produced in a specified year and calculates the total runtime for the movies
     * @throws SQLException if the database cannot be accessed
     */
    private void printMoviesInYear() throws SQLException {
        int totalDuration = 0;
        System.out.print("Enter in year: ");
        int inputYear = input.nextInt();

        String sqlStatement = "Select * from movies where year = " + inputYear;

        ResultSet result = db.get(sqlStatement);

        System.out.println("\nMovie List");
        System.out.printf("%-10s %-10s %-10s\n", "Duration", "Year", "Title");

        while (result.next()) {
            totalDuration += result.getInt("Duration");
            System.out.printf("%-10d %-10d %-10s\n",
                    result.getInt("Duration"),
                    result.getInt("Year"),
                    result.getString("Title"));
        }
        System.out.println("Total Duration: " + totalDuration + " minutes\n");
    }

    /**
     * Adds a movie to the database given the users input of title, duration, and year
     * @throws SQLException if the database cannot be accessed
     */
    private void addMovie() throws SQLException {
        System.out.print("Enter movie title: ");
        input.nextLine();
        String inputTitle = input.nextLine();
        System.out.print("Enter duration: ");
        int inputDuration = input.nextInt();
        System.out.print("Enter year: ");
        int inputYear = input.nextInt();
        try {
            String sqlStatement = "Insert into movies (duration, title, year) values (" + inputDuration + ",'" + inputTitle + "'," + inputYear + ")";
            int rows = db.update(sqlStatement);
            if (rows > 0) {
                System.out.println("\nAdded movie to database.\n");
            } else {
                System.out.println("\nAn error occurred, please try again");
            }
        } catch (SQLDataException exception) {
            System.out.println("Error, this is invalid input, please try again.");
        }
    }
}