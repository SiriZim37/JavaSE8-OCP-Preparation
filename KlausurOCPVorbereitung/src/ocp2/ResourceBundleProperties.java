package ocp2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResourceBundleProperties {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties ();
		FileInputStream fis = new FileInputStream("src/ocp2/Message.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("welcome1"));
		System.out.println(prop.getProperty("welcome2", "Test")); //line n1
		System.out.println(prop.getProperty("welcome3"));
		
		/*
		     What is the result?
			 A. Good day!   Test
			     followed by an Exception stack trace
			 B. Good day!
			     followed by an Exception stack trace
			 C. Good day!
			  Test
			  null
			 D. A compilation error occurs at line n1
		 */
		
		
		/*
		 * ผลลัพธ์ที่ได้:
			บรรทัดแรก: prop.getProperty("welcome1") จะคืนค่า "Good day!".
			บรรทัดที่สอง: prop.getProperty("welcome2", "Test") จะคืนค่า "Test" เพราะไม่มีคีย์ welcome2 ในไฟล์.
			บรรทัดที่สาม: prop.getProperty("welcome3") จะคืนค่า null เนื่องจากไม่มีคีย์ welcome3 ในไฟล์.
		 */
	}
}
