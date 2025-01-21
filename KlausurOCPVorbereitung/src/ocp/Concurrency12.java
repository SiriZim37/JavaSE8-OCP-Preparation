package ocp;

public class Concurrency12 {
	/* 
	Question: 
	What is the most likely result?

	A. 
	1 2 [1, 2, 3, 4] 3 4

	B. 
	1 2 [1, 2, 3, 4] 3 4 42

	C. 
	1 2 [1, 2, 3, 4, 42] 3 4

	D. 
	1 2 [1, 2, 3, 4, 42] 3 4 42

	E. 
	Compilation fails

	F. 
	An exception is thrown at runtime

	Explanation:
	C is correct. 
	CopyOnWriteArrayList is a thread-safe collection that makes a copy of the collection whenever the collection gets modified. In this case, the main thread gets a copy of the collection, and when the second thread updates the collection, a new collection is created and the main thread's copy is not impacted.

	A, B, D, E, and F are incorrect based on the above.
	*/

	/*
	คำอธิบาย:
	คำตอบ C ถูกต้อง
	CopyOnWriteArrayList เป็นคอลเล็กชันที่รองรับการทำงานแบบเธรด-เซฟ (thread-safe) ซึ่งจะสร้างสำเนาของคอลเล็กชันทุกครั้งที่มีการแก้ไข ในกรณีนี้เธรดหลักจะได้รับสำเนาของคอลเล็กชัน และเมื่อเธรดที่สองทำการอัปเดตคอลเล็กชัน จะมีการสร้างคอลเล็กชันใหม่ขึ้นมา และสำเนาของเธรดหลักจะไม่ได้รับผลกระทบ

	A, B, D, E, และ F ไม่ถูกต้องตามคำอธิบายข้างต้น
	*/

}
