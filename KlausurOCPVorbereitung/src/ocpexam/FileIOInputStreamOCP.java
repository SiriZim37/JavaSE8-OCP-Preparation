package ocpexam;

import java.util.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOInputStreamOCP {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		int i;
		char c;
		
		try ( FileInputStream fis = new FileInputStream("courses.txt");
//			  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/wealth/certificate/dumps_1z0_809/question117/courses.txt");
			  InputStreamReader isr = new InputStreamReader(fis); ) {
			while(isr.ready())	// line n1
			{
				isr.skip(2);
				i = isr.read();
				c = (char) i;
				System.out.print(c);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
}

/*
 * Given that course.txt is accessible and contains:

	Course :: Java

and given the code fragment:

	int i;
	char c;
	
	try ( FileInputStream fis = new FileInputStream("courses.txt");
		  InputStreamReader isr = new InputStreamReader(fis); ) {
		while(isr.ready())	// line n1
		{
			isr.skip(2);
			i = isr.read();
			c = (char) i;
			System.out.print(c);
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}

What is the result?
A. ur :: va
B. ueJa
C. The program prints nothing.
D. A compilation error occurs at line n1. 


[Answer]
B

[Explanation]
... to be continue ...

[console]
ueJa

*/
