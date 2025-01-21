package ocp;

interface Modern {
	  default String speak() { return "modern! "; }    // line a
	  static String doStuff(String gerund) {           // line b
	    return gerund + " in your sleep";
	  }
	}
	 class InterfaceWitgDefault implements Modern {
	  public static void main(String[] args) {
	    new InterfaceWitgDefault().go();
	  }
	  void go() {
//	    System.out.print(InterfaceWitgDefault.speak());              // line c
	    System.out.print(speak());                    				 // line d 
	    System.out.print(Modern.doStuff("walking"));   				 // line e
//	    System.out.print(doStuff("talking"));          				 // line f   
	  }
	  
	  
}
/*
 * 	Which line(s) cause compilation to fail? (Choose all that apply.)
 *  บรรทัดใดบ้างที่ทำให้การคอมไพล์ล้มเหลว? (เลือกคำตอบทั้งหมดที่ถูกต้อง)
 * 
 * A. line a
 * B. line b
 * C. line c
 * D. line d
 * E. line e
 * F. line f
 * 
 * คำตอบที่ถูกต้อง:
 * C. บรรทัด c:
 *    - default method `speak()` ไม่สามารถเรียกใช้โดยตรงผ่านชื่ออินเทอร์เฟซ (Modern.speak()) ได้
 * F. บรรทัด f:
 *    - static method `doStuff()` ต้องเรียกใช้ผ่านชื่ออินเทอร์เฟซ (Modern.doStuff()) เท่านั้น
 * 
 * คำอธิบาย:
 * 1. บรรทัด a และ b: ถูกต้องตามกฎการประกาศ default และ static methods ในอินเทอร์เฟซ
 * 2. บรรทัด d: ถูกต้อง เพราะเรียกใช้ default method ผ่าน instance ของคลาสที่ implement อินเทอร์เฟซ
 * 3. บรรทัด e: ถูกต้อง เพราะ static method ถูกเรียกใช้ผ่านชื่ออินเทอร์เฟซ
 * 4. บรรทัด c และ f: ผิดพลาดเนื่องจากการใช้ syntax ที่ไม่ถูกต้อง
 */
			

