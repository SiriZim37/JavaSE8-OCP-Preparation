package ocp;

	/*
	class Test {
		public static int y;
		public static int foo(int x) {
		  System.out.print("foo ");
		  return y = x;
		  }
		public static void bar(int z) {
		  System.out.print("bar ");
		  y = z;
		 }
		public static void main(String [] args ) {
		   int t = 2;
		   assert t < 4 : bar(7);	
		   assert t > 1 : foo(8);
		   System.out.println("done ");
		 }
	}
	*/

	/*
	  What is the result?
	
	A.bar
	B.done
	C.foo done
	D.bar foo done
	E.Compilation fails
	F.An exception is thrown at runtime
	
	
	
	E is correct. The bar() method returns void. It is a perfectly acceptable method, 
	but because it returns void it cannot be used in an assert statement. Thus, line 13 will not compile.
	A, B, C, D, and F are incorrect based on the program logic above.
	 */
		
	/*
	 เนื่องจากเมธอด bar คืนค่าประเภท void (ไม่มีค่า) ซึ่งไม่สามารถใช้ใน assert ได้ในรูปแบบ assert condition : 
	 expression; ได้ เพราะ expression จะต้องมีค่า (non-void expression) ดังนั้น โค้ดนี้จะคอมไพล์ไม่ผ่าน ที่บรรทัด 13 และจะไม่ทำงานต่อไป
	
	 คำตอบที่ถูกต้องคือ:
	
	 E. Compilation fails: โค้ดนี้จะคอมไพล์ไม่ผ่าน เพราะใช้ bar(7) ใน assert ซึ่งเป็นเมธอดที่ไม่มีการคืนค่า
	 */
public class ExceptionAssert2 {

}
