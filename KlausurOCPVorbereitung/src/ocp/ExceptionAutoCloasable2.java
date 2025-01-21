package ocp;


class Two {
	  static class Good implements AutoCloseable {
	    public void close() throws Exception {
	      System.out.println("Good");
	  } }

	  static class Bad implements AutoCloseable {
	    public void close() throws Exception {
	      System.out.println("Bad");
	      throw new Exception("bad exception");
	  } }

	  public static void main(String[] args) throws Exception {
	    try (Good good = new Good(); Bad bad = new Bad()) {
	      throw new Exception("try exception");
	} } }


/*
	Which are true? (Choose all that apply.)
	
	A.The text "Bad" is printed.
	B.The text "Good" is printed.
	C.The exception "bad exception" is thrown as the top-level exception.
	D.The exception "try exception" is thrown as the top-level exception.
	E.The exception "bad exception" is thrown as a suppressed exception.
	F.The exception "try exception" is thrown as a suppressed exception.
	G.Compilation fails.



	A, B, D, and E are correct. Both resources are automatically closed 
	even if one fails. The exception thrown in the try block is 
	considered the main/top-level exception, and any exceptions 
	thrown during resource management are added to it as suppressed exceptions.
	
	C, F, and G are incorrect based on the above.
 */
 

/*
	***อธิบายการทำงาน:
	1.การเปิดทรัพยากร (Good และ Bad):	
		ในบล็อก try, สร้างอ็อบเจ็กต์ Good และ Bad ซึ่งจะถูกปิดอัตโนมัติเมื่อออกจากบล็อก try ด้วยการใช้ try-with-resources.
	2.ข้อยกเว้นใน try:
		ข้อความ throw new Exception("try exception") จะถูกโยนภายในบล็อก try. ดังนั้นข้อยกเว้นนี้จะกลายเป็น ข้อยกเว้นหลัก (top-level exception).
	3.การปิดทรัพยากร:	
		เมื่อออกจากบล็อก try, เมธอด close ของ Good และ Bad จะถูกเรียก:
			Good จะปิดทรัพยากรและพิมพ์ข้อความ "Good".
			Bad จะปิดทรัพยากรและพิมพ์ข้อความ "Bad". แต่ในขณะเดียวกันก็โยนข้อยกเว้น "bad exception" ด้วย.
	4.การจัดการข้อยกเว้น:
		เมื่อมีข้อยกเว้นในบล็อก try, ข้อยกเว้นที่เกิดขึ้นจากการปิดทรัพยากร (เช่น "bad exception") จะถูกจัดเก็บเป็น suppressed exception 
		(ข้อยกเว้นที่ถูกบันทึกเพิ่มเติม) ในขณะที่ข้อยกเว้นหลัก (คือ "try exception") จะถูกโยนออกมาเป็นข้อยกเว้นหลัก.
	
	คำตอบที่ถูกต้อง:
	A. "The text 'Bad' is printed.": ถูกต้อง, เนื่องจาก Bad จะถูกปิดและพิมพ์ "Bad". แต่มีข้อยกเว้นเกิดขึ้นในระหว่างการปิดทรัพยากร.
	
	B. "The text 'Good' is printed.": ถูกต้อง, เนื่องจาก Good จะถูกปิดและพิมพ์ "Good" ก่อนที่จะเกิดข้อยกเว้นใน Bad.
	
	D. "The exception 'try exception' is thrown as the top-level exception.": ถูกต้อง, 
		ข้อยกเว้น "try exception" ถูกโยนภายในบล็อก try และจะเป็นข้อยกเว้นหลักที่ถูกโยนออกมา.
	
	E. "The exception 'bad exception' is thrown as a suppressed exception.": ถูกต้อง, 
		ข้อยกเว้น "bad exception" ที่เกิดขึ้นในเมธอด close ของ Bad จะถูกบันทึกเป็นข้อยกเว้นที่ถูกบังคับ (suppressed exception) และจะไม่หยุดการทำงานของโปรแกรม.
	
	คำตอบที่ไม่ถูกต้อง:
	C. "The exception 'bad exception' is thrown as the top-level exception.": 
		ไม่ถูกต้อง, ข้อยกเว้น "bad exception" ถูกโยนจากเมธอด close ของ Bad, แต่จะถูกบันทึกเป็น suppressed exception ไม่ใช่ข้อยกเว้นหลัก.
	
	F. "The exception 'try exception' is thrown as a suppressed exception.": ไม่ถูกต้อง, 
		"try exception" เป็นข้อยกเว้นหลักและจะถูกโยนออกมาเป็นข้อยกเว้นหลัก, ไม่ใช่ข้อยกเว้นที่ถูกบังคับ (suppressed exception).
	
	G. "Compilation fails.": ไม่ถูกต้อง, โค้ดนี้คอมไพล์สำเร็จเนื่องจากการใช้งาน AutoCloseable และ try-with-resources ถูกต้อง.
 */
public class ExceptionAutoCloasable2 {

}
