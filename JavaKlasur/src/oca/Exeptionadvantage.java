package oca;


public class Exeptionadvantage {

	public static void main(String[] args) {
		
	/*
	 Which three are advantages of the Java exception mechanism?
	a) Provides a set of standard exceptions that covers all possible errors
	****** b) Allows the creation of new exceptions that are customized to the particular program being created
	c) Improves the program structure because exceptions must be handled in the method in which they occurre
	d) Improves the program structure because the programmer can choose where to handle exceptions
	e) Improves the program structure because the error handling code is separated from the normal program function





	/*
 	ข้อดีของ Java Exception Mechanism:

	(b) ช่วยให้สร้างข้อยกเว้นใหม่ที่ปรับแต่งได้ให้เหมาะสมกับโปรแกรมที่กำลังพัฒนา
	
	นักพัฒนาสามารถสร้างข้อยกเว้นเฉพาะตัว (Custom Exception) เพื่อจัดการกับสถานการณ์เฉพาะที่ไม่สามารถใช้ข้อยกเว้นมาตรฐานได้ เช่น การสร้างคลาสที่ขยายจาก Exception หรือ RuntimeException
	(d) ปรับปรุงโครงสร้างโปรแกรม เพราะนักพัฒนาสามารถเลือกได้ว่าจะจัดการข้อยกเว้นที่ใด
	
	ใน Java คุณสามารถตัดสินใจได้ว่าจะจัดการข้อยกเว้น (Exception Handling) ในเมธอดที่ทำให้เกิดข้อยกเว้น หรือส่งต่อข้อยกเว้นไปยังเมธอดอื่นเพื่อจัดการในระดับที่เหมาะสม
	(e) ปรับปรุงโครงสร้างโปรแกรมเพราะโค้ดที่จัดการข้อผิดพลาดถูกแยกออกจากฟังก์ชันปกติของโปรแกรม
	
	โค้ดปกติและโค้ดสำหรับจัดการข้อผิดพลาดจะถูกแยกออกอย่างชัดเจนด้วยการใช้ try-catch หรือ throw ทำให้โปรแกรมอ่านง่ายและดูแลรักษาได้ดีขึ้น

	answer : b d e 
	 
	 */	
		
		
	/*
	 * Exception Key Advantage
	 * 
	 *	1. Centralized Error Handling:

			Using exceptions allows you to handle errors and other exceptional situations in a central place
		 	in your program, rather than scattering error-checking code throughout the application.
		 	This improves maintainability and readability.
	 */
		try {
		    int result = 10 / 0; // Will cause an ArithmeticException
		} catch (ArithmeticException e) {
		    System.out.println("Cannot divide by zero!");
		}
	/*
	 *2. Separation of Error-Handling Code:
	
			Exceptions help you separate the regular code logic from the error-handling logic, 
			improving the clarity of the code.
		
	 */
		
	/*
	 *	3. Predefined Exceptions:

			Java provides a rich hierarchy of predefined exceptions such as NullPointerException, 
			ArrayIndexOutOfBoundsException, and IOException. This saves developers time and effort
			since they don't need to implement their own error handling for common issues
	 */
		String[] array = new String[2];
		System.out.println(array[3]); // Will cause ArrayIndexOutOfBoundsException

	 /*
	  * 4. Custom Exceptions:

		Java allows developers to define their own exceptions, making it possible 
		to handle application-specific errors in a more meaningful way.
	  */
		
		 try {
	            checkAge(15); // Will cause InvalidAgeException
	        } catch (InvalidAgeException e) {
	            System.out.println(e.getMessage());
	        }
		 
		 
		/*
		 *  5. Checked and Unchecked Exceptions:

				- Checked Exceptions: Must be either caught or declared in the method signature using throws. 
					These exceptions typically represent conditions that a program should 
					anticipate and recover from (e.g., IOException, SQLException).
				- Unchecked Exceptions: These do not need to be explicitly handled (e.g., NullPointerException, 
					ArithmeticException). They represent programming errors that usually should not be caught
					but instead fixed in the code.
				- For the OCA 8 exam, knowing the difference between checked and unchecked exceptions is crucial, 
					as questions often focus on handling these exceptions correctly
		 */
	}
	
	  static void checkAge(int age) throws InvalidAgeException {
	        if (age < 18) {
	            throw new InvalidAgeException("Age is less than 18!");
	        }
	    }

}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
