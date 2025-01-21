package ocp;

public class InnerClassInLocalMethode {
	
	int z = 2;
	
	  public static void main(String[] args) {
	    int y = 4;
	    new InnerClassInLocalMethode().doStuff(7);
	  }
	  void doStuff(int arg) {
	    int x = 8;        
	    class Inner {                         // line a
	      void m1() {                         // line b
	        System.out.print(z++ + " ");      // line c
//	        System.out.print(++y);            // line d 
//	        System.out.println(" " + ++x);    // line e
	      } 
	    }
	    new Inner().m1();                     // line f
	  }
}

/*
 * The following code demonstrates an outer class with a method containing a local inner class.
 * The local inner class accesses variables from its enclosing scope, leading to compilation issues.
 * 
 * 
 * What is the result? (Choose all that apply.)
 * 
 * A. 2 4 8
 * B. 2 4 9
 * C. Compilation fails due to an error at line a
 * D. Compilation fails due to an error at line b
 * E. Compilation fails due to an error at line c
 * F. Compilation fails due to an error at line d
 * G. Compilation fails due to an error at line e
 * H. Compilation fails due to an error at line f
 * 
 * 
 * 
 * คำตอบที่ถูกต้อง:
 * F. Compilation fails due to an error at line d:
 *    - ตัวแปรโลคัล y ไม่เป็น effectively final ดังนั้นไม่สามารถเข้าถึงหรือเปลี่ยนแปลงในคลาสภายในได้
 * G. Compilation fails due to an error at line e:
 *    - ตัวแปรโลคัล x ถูกจับโดยคลาสภายใน ทำให้มันเป็น effectively final และการเปลี่ยนแปลงค่า x จะทำให้เกิดข้อผิดพลาด
 *  //line d: ใช้ y ซึ่งเป็นตัวแปร local ใน main
 *  //line e: ใช้ x ซึ่งเป็นตัวแปร local ใน doStuff	  
 * 
 * คำอธิบาย:
 * 1. ตัวแปรโลคัลที่เข้าถึงภายในคลาสภายในแบบโลคัลจะต้องเป็น effectively final
 * 2. ตัวแปรอินสแตนซ์ (เช่น z) สามารถเข้าถึงและเปลี่ยนแปลงได้โดยไม่มีข้อจำกัด
 * 3. ตัวแปรที่ประกาศภายในเมธอด (เช่น y และ x) จะไม่สามารถเปลี่ยนแปลงได้หากถูกใช้ในคลาสภายใน
 * 
 * ตัวเลือกที่ไม่ถูกต้อง:
 * A, B: ผลลัพธ์เหล่านี้ไม่สามารถเกิดขึ้นได้เนื่องจากข้อผิดพลาดในการคอมไพล์
 * C, D, E, H: ไม่มีข้อผิดพลาดที่บรรทัดเหล่านี้
 */

