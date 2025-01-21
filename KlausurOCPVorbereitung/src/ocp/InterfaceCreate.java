package ocp;

/*
 * Which are valid definitions for the Omelette interface so the code fragment will display 
 * “Crack 3 eggs for an omelette”? (Choose all that apply.)
 * 
 * 
 class Egg {
	 
	  public void makeAnOmelette() {
	     Omelette o = 
	        (n) -> System.out.println("Crack " + n + " eggs for an omelette");
	     o.crack(3);
	  }
	
	}
		A.	interface Omelette {
		      public void crack(Integer numEggs);
		      public default void breakEggs(int numEggs) { 
		          System.out.println("Crack " + numEggs + " eggs for an omelette");
		      }
		   }
		
		B.	interface Omelette {
		      public static void crack(Integer numEggs) {
		         System.out.println("Crack " + numEggs + " eggs for an omelette")
		      }
		   }
		
		C.	public interface Omelette {
		      public void crack(int numEggs);
		   }
		
		D.	interface Omelette {
		      public default void crack(Integer numEggs);
		   }
		
		E.	interface Omelette {
		      public void crack(Integer numEggs);
		   }
		   
		   
		   

		Answer :
		   
		A, C, and E are correct. Omelette needs to be a functional interface with one abstract method, and A, C, and E all provide one.
		
		B and D are incorrect. Neither B nor D provides an abstract method.
		
		ตัวเลือกที่ถูกต้อง:
		A: ถูกต้อง เพราะมีเมธอด crack(Integer numEggs) ที่เป็น abstract method และสามารถใช้กับ Lambda Expression ได้ 
			นอกจากนี้ยังมีเมธอด breakEggs(int numEggs) ที่เป็น default method และจะไม่ถูกเรียกใช้ในโค้ดนี้
		C: ถูกต้อง เพราะมีเมธอด crack(int numEggs) ที่เป็น abstract method และตรงกับพารามิเตอร์ใน Lambda Expression
		E: ถูกต้อง เพราะมีเมธอด crack(Integer numEggs) ที่เป็น abstract method และตรงกับพารามิเตอร์ใน Lambda Expression
		ตัวเลือกที่ผิด:
		B: ผิด เพราะใช้ static method ซึ่งไม่สามารถใช้กับ Lambda Expression ได้
		D: ผิด เพราะใช้ default method โดยไม่มีการกำหนดคำสั่งภายในเมธอด (ทำให้ไม่สามารถใช้งานได้)


	 */
		
public class InterfaceCreate {

}
