package ocpexam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ResourceBundleTest3 {

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream (getCurrentPath() + "/resource/Message.properties"); // Error
		prop.load(fis);
		System.out.println(prop.getProperty("welcome1"));
		System.out.println(prop.getProperty("welcome2", "Test"));//line n1
		System.out.println(prop.getProperty("welcome3"));
		
		/** Answered : D is incorrect, Correct is C **/
		/* Print :
		 * Good day!
		 * Test
		 * null
		 */
	}
	
	// Not in Question : Addition for get question's properties file path.
	private static String getCurrentPath()
	{
		return System.getProperty("user.dir"); // // Correct way to get the working directory
	}
	
}

/*
Question No : 14

Given the content of /resourses/Message.properties:

welcome1="Good day!"

and given the code fragment:

Properties prop = new Properties ();
FileInputStream fis = new FileInputStream ("/resources/Message.properties");
prop.load(fis);
System.out.println(prop.getProperty("welcome1"));
System.out.println(prop.getProperty("welcome2", "Test"));//line n1
System.out.println(prop.getProperty("welcome3"));

What is the result?

A. Good day!
Test
followed by an Exception stack trace
B. Good day!
followed by an Exception stack trace
C. Good day!
	Test
	null
D. A compilation error occurs at line n1.

Answer: D เฉลยผิด ข้อที่ถูก คือ C

*/
