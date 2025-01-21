package exeptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *  Exception :
 *  		1. RuntimeException
 *  		2. IOException
 *  		3. SQLException
 *  		4. InterruptedException
 */
public class B03_01Exceptions {

	  public static void main(String[] args) {
		  
	        // Checked Exception (must be caught or declared)
	        try {
	            throwCheckedException();
	        } catch (Exception e) {
	            System.out.println("Caught checked Exception: " + e);
	        }
	        
	        try {
	            throwIOException();
	        } catch (IOException e) {
	            System.out.println("Caught IOException: " + e);
	        }
	        
	        try {
	            throwFileNotFoundException();
	        } catch (FileNotFoundException e) {
	            System.out.println("Caught FileNotFoundException: " + e);
	        }
	        
	        try {
	        	throwSQLException();
	        } catch (SQLException e) {
	            System.out.println("Caught SQLException: " + e);
	        }
	        
	        try {
	        	throwInterruptedException();
	        } catch (InterruptedException e) {
	            System.out.println("Caught InterruptedException: " + e);
	        }

	  }

	  // 1. Checked Exception (IOException)
	  public static void throwCheckedException() throws Exception {
	      throw new Exception("This is a checked exception");
	  }
	  
	  public static void throwIOException() throws IOException {
	        // Attempting to open a file that may not exist
	        File file = new File("non_existing_file.txt");
	        FileInputStream fis = new FileInputStream(file); // This will throw IOException if file is not found
	        fis.close();
	  }
	  
	  public static void throwFileNotFoundException() throws FileNotFoundException {
	        // Attempting to open a file that doesn't exist
	        File file = new File("non_existing_file.txt");
	        FileInputStream fis = new FileInputStream(file); // This will throw FileNotFoundException
	  }
	  
	  public static void throwSQLException() throws SQLException {
		  try {
	          Connection conn = DriverManager.getConnection("jdbc:invalidurl", "user", "password");
	      } catch (SQLException e) {
	          System.out.println("Caught SQLException: " + e.getMessage());
	      }
	  }
	  
	  
	  public static void throwInterruptedException() throws InterruptedException {
		  Thread thread = new Thread(() -> {
	            try {
	                Thread.sleep(2000);  // This might throw InterruptedException
	            } catch (InterruptedException e) {
	                System.out.println("Caught InterruptedException: " + e.getMessage());
	            }
	        });

	        thread.start();
	        thread.interrupt();  // Interrupt the thread
	  }
	

}