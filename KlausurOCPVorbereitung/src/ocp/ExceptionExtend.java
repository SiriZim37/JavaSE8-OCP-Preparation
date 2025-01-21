package ocp;

public class ExceptionExtend {

	/*
		class MyException extends Exception { }    // line A

		class MyTestClass {
		  public static void main(String[] args) {
		    try {
		      new MyTestClass().go();
		    } catch (MyException me) {               // line B
		      System.out.println("threw ME");
		    }
		  }
		  void go() throws MyException {            // line C
		    int x = 7/0;                            // line D
		  }
		}
		What is the result?
		A.threw ME
		B.An uncaught exception is thrown
		C.Compilation fails due only to an error on line D
		D.Compilation fails due only to an error on line A
		E.Compilation fails due to multiple error(s) on line(s) A, B, and/or C



		B is correct. The custom exception code is all valid, but it doesn't catch a runtime exception like the ArithmeticException that the code will throw.

		A, C, D, and E are incorrect based on the above.
		*/
	
	/*
	 * A. threw ME: ไม่ถูกต้อง เพราะข้อผิดพลาดที่เกิดขึ้นคือ ArithmeticException 
	 * 		ซึ่งไม่เกี่ยวข้องกับ MyException ที่จับได้ใน catch ของ MyException
	 * 
	 * B. An uncaught exception is thrown: ถูกต้อง เพราะ ArithmeticException 
	 * 		เป็น RuntimeException ซึ่งไม่ได้รับการจับใน catch และทำให้เกิดข้อผิดพลาดที่ไม่ได้จับ
	 */
	
	public static void main(String[] args) {	


		  /* Test1 */
			try {
				 int x = 7/0;      
			} catch (Exception e) {
				System.out.println("Exception");
			}  
		 /* Test2 */	
			try {
				new ExceptionExtend().go();
			} catch (RuntimeException e) {
				 System.out.println("RuntimeException AritmaticException");
		    } catch (Exception e) {               	// line B
		      System.out.println("threw ME");
		    }
			
			//---------------------------//
			
			/* B An uncaught exception is thrown 
			 * threw ME: ไม่ถูกต้อง เพราะข้อผิดพลาดที่เกิดขึ้นคือ ArithmeticException 
		     * 	ซึ่งไม่เกี่ยวข้องกับ MyException ที่จับได้ใน catch ของ MyException 
		    */
			  try {
			      new ExceptionExtend().go();
			    } catch (MyException me) {               // line B
			      System.out.println("threw ME");
			    }
	}
	void go() throws MyException {            		// line C
		    int x = 7/0;                            // line D
	}
}
class MyException extends Exception { } 			// line A
