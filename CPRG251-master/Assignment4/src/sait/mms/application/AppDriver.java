package sait.mms.application;

import sait.mms.managers.MovieManagementSystem;

import java.sql.SQLException;

/**
 * This class is responsible for running the application
 * @author Allyssa Preece
 * @author Anusone Soula
 * @author Aiden Kopec
 *
 * @version April 13, 2022
 */
public class AppDriver {
    public static void main(String[] args) throws SQLException {
        //creates a new movieManagementSystem object
        MovieManagementSystem mms = new MovieManagementSystem();
        mms.displayMenu();
    }
}
