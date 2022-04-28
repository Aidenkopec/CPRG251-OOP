package sait.bms.application;

import java.io.*;

import sait.bms.managers.*;

/**
 * The start of the application.
 * 
 * @author Aiden Kopec
 * @author Allyssa Preece
 * @author Anusone Soula
 */
public class ApplicationDriver {
	public static void main(String[] args) throws IOException {
		// Create a new instance of the managers class
		new Managers();
	}
}
