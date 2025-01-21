package ocp;

public class StreamTerminalIntermediate {

	/*
	 * Which of the following statements are true about java.util.Stream? (Choose all that apply.)
	 * 
	 * A.  A stream does not store data elements
	 * 
	 * B.  A stream does store data elements
	 * 
	 * C.  Intermediate stream operations return a stream
	 * 
	 * D.  Intermediate stream operations are lazy; that is, an operation may not operate on all elements 
	 *     of the source if the stream is short-circuited or elements from the source are filtered 
	 *     before arriving at the operation in the pipeline
	 * 
	 * E.  You can use a stream only once
	 * 
	 * F.  Terminal operations produce another stream
	 * 
	 * G.  Terminal operations are the end of the stream pipeline
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * A, C, D, E, and G are correct statements.
	 * B and F are incorrect; see statements A and G.
	 * 
	 * คำอธิบาย:
	 * - A: สตรีมไม่เก็บข้อมูลเอง แต่จะเป็นแค่เครื่องมือที่ไหลผ่านข้อมูล
	 * - B: ข้อนี้ไม่ถูกต้อง เพราะสตรีมไม่เก็บข้อมูล
	 * - C: การทำงานของสตรีมที่เป็นการประมวลผลกลาง (intermediate operations) จะคืนค่ากลับเป็นสตรีม
	 * - D: การทำงานของสตรีมที่เป็นการประมวลผลกลางนั้นเป็นการทำงานแบบ "lazy" หมายความว่า การทำงานอาจจะไม่ทำกับข้อมูลทั้งหมด ถ้ามีการใช้ short-circuiting หรือกรองข้อมูลบางส่วนก่อนที่มาถึงการทำงานนั้น
	 * - E: สตรีมสามารถใช้งานได้แค่ครั้งเดียว เนื่องจากมันจะถูกปิดหลังจากการทำงานแบบ terminal
	 * - F: ข้อนี้ไม่ถูกต้อง เนื่องจากการทำงานแบบ terminal จะไม่คืนสตรีมใหม่
	 * - G: การทำงานแบบ terminal จะเป็นจุดสิ้นสุดของ pipeline
	 */

}
