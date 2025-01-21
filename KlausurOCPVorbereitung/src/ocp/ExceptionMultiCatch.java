package ocp;

/*
public class Party {
static class Rain extends Exception{}
static class Thunderstorm extends Rain{}
public void eat() {
  try {
   bbq();
 } catch(Rain | Thunderstorm e) {
 } }

private void bbq() throws Rain, Thunderstorm { } }

*/
/*
 * Which are true? (Choose all that apply.)
 * 
 * 
	A.Compilation succeeds
	B.Compilation will succeed when line 7 is changed to } catch(Rain e) {
	C.Compilation will succeed when line 7 is changed to } catch(Thunderstorm e) {
	D.Compilation will succeed when line 7 is changed to } catch(Rain e | Thunderstorm e) {
	E.Compilation will succeed when line 7 is changed to } catch(Rain e1 | Thunderstorm e2) {
	F.Compilation will succeed when line 7 is changed to } catch(Exception e) {
	
	
	
	B and F are correct. The multi-catch block may not contain exception types 
	that are in the same hierarchy. Since Rain is a superclass of Thunderstorm, 
	having Thunderstorm is not allowed (and is redundant). 
	Catching the superclass Rain or its superclass Exception has the same effect 
	without the need for the multi-catch.

	A, C, D, and E are incorrect. A and C are incorrect because of the above. 
	D and E are incorrect both because of the subclass/superclass relationship 
	and because of incorrect syntax.	
*/
	
/*
 * ในคำถามนี้มีการใช้ multi-catch ในการจับข้อยกเว้น ซึ่งเป็นฟีเจอร์ที่สามารถจับข้อยกเว้นหลายประเภทได้ในบล็อก catch เดียว 
 * (ใช้เครื่องหมาย | ระหว่างประเภทข้อยกเว้น) แต่มีข้อจำกัดบางประการเกี่ยวกับการจับข้อยกเว้นใน hierarchy ของคลาส 
 * (เช่น การจับคลาสย่อยและคลาสหลักในเวลาเดียวกัน)
 * 
 ***การวิเคราะห์:
 *		- มีการใช้ multi-catch ซึ่งต้องการจับข้อยกเว้นหลายประเภทในบล็อก catch เดียว โดยแยกประเภทด้วยเครื่องหมาย | 
 * 			เช่น catch(Rain | Thunderstorm e).
 * 		- ปัญหาคือ Rain เป็น superclass ของ Thunderstorm (คือ Thunderstorm เป็นคลาสย่อยของ Rain), 
 * 			ดังนั้นการจับทั้งสองชนิดในบล็อก catch เดียวกันจึงทำให้เกิดปัญหา เพราะมันจะจับ Thunderstorm ผ่าน Rain ได้อยู่แล้ว 
 * 			ดังนั้นการจับทั้งสองชนิดนี้เป็นการ ซ้ำซ้อน และ ไม่ถูกต้อง ตามหลักของ multi-catch.
 * 
 ***การเปลี่ยนแปลงที่เป็นไปได้:
	B: การเปลี่ยนบรรทัดที่ 7 เป็น } catch(Rain e) { 
		จะทำให้การคอมไพล์สำเร็จ เพราะ Rain เป็น superclass ของ Thunderstorm การจับ Rain 
		จะจับข้อยกเว้นทั้งหมดที่เป็นประเภท Rain และ Thunderstorm ด้วยอยู่แล้ว ดังนั้นจึงไม่จำเป็นต้องจับ Thunderstorm แยกต่างหาก.

	F: การเปลี่ยนเป็น } catch(Exception e) { 
		ก็จะทำให้การคอมไพล์สำเร็จ เพราะ Exception เป็น superclass ของ Rain ซึ่งหมายความว่า 
		Exception จะจับข้อยกเว้นทั้งหมดที่เป็นประเภท Rain หรือ Thunderstorm ได้เช่นกัน.
 */
		
	
 class Party {
static class Rain extends Exception{}
static class Thunderstorm extends Rain{}
public void eat() {
  try {
   bbq();
// } catch(Rain | Thunderstorm e) {  // cf
  } catch(Rain e) {  
 } }

private void bbq() throws Rain, Thunderstorm { } }
public class ExceptionMultiCatch {

}
