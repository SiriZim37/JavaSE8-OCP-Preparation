package ocp;

public class ExceptionAssert {

/*
	 * Which are true?
	A.	In an assert statement, the expression after the : (colon) can be any Java expression.
	B.	If a switch block has no default, adding an assert default is considered appropriate.
	C.	In an assert statement, if the expression after the : (colon) does not have a value, 
		the assert's error message will be empty.
	D.	It is appropriate to handle assertion failures using a catch clause.
	
	
	
	B is correct. Adding an assert statement to a switch statement that previously 
	had no default case is considered an excellent use of the assert mechanism.
		
	A, C, and D are incorrect. A is incorrect because only Java expressions that 
	return a value can be used. For instance, a method that returns void is illegal. 
	C is incorrect because the expression after the colon must have a value. 
	D is incorrect because assertions throw errors (not exceptions), 
	and assertion errors do cause program termination and should not be handled.
	
	
 */
	
	
/*
 คำถาม: คำตอบใดถูกต้อง?
	
	A. ในคำสั่ง assert, คำแสดงออกหลังเครื่องหมาย : (colon) สามารถเป็นคำแสดงออกใด ๆ ที่เป็น Java expression ได้
	
	B. หากบล็อก switch ไม่มี default การเพิ่ม assert default ถือเป็นสิ่งที่เหมาะสม
	
	C. ในคำสั่ง assert, หากคำแสดงออกหลังเครื่องหมาย : (colon) ไม่มีค่า ข้อความแสดงข้อผิดพลาดจะว่างเปล่า
	
	D. การจัดการข้อผิดพลาดจาก assertion โดยใช้ catch clause นั้นเหมาะสม
	
	คำอธิบาย:
	
	A. คำตอบนี้ไม่ถูกต้อง เพราะหลังเครื่องหมาย : ในคำสั่ง assert จะต้องเป็น Java expression ที่มีค่า เท่านั้น
	เช่น ตัวแปรหรือค่าคงที่ที่มีผลลัพธ์ ซึ่งหากเป็นเมธอดที่คืนค่า void จะไม่สามารถใช้ได้
	
	B. คำตอบนี้ถูกต้อง เพราะถ้าบล็อก switch ไม่มี default การเพิ่ม assert default 
	จะช่วยให้การใช้งาน assert เหมาะสมและเป็นการตรวจสอบเงื่อนไขในกรณีที่ไม่เคยคาดคิดมาก่อน ถือว่าเป็นการใช้งาน assert ที่ดี
	
	C. คำตอบนี้ไม่ถูกต้อง เพราะคำแสดงออกหลังเครื่องหมาย : ต้องมีค่าที่จะนำมาแสดงเป็นข้อความข้อผิดพลาด ถ้าไม่มีค่า ข้อความแสดงข้อผิดพลาดจะไม่ว่างเปล่า
	
	D. คำตอบนี้ไม่ถูกต้อง เพราะ assert นั้นจะโยน AssertionError ซึ่งไม่ใช่ Exception 
	ดังนั้นจึงไม่ควรจัดการข้อผิดพลาดจาก assert โดยใช้ catch เนื่องจากการเกิด AssertionError จะทำให้โปรแกรมหยุดทำงานทันที
 */
}
