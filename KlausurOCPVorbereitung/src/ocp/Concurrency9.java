package ocp;

public class Concurrency9 {
	/* 
	Given:
	List<Integer> ppms = Arrays.asList(405, 405, 406, 406, 406, 406, 405, 406, 407);
	double avg = ppms.parallelStream()
	                 .distinct()
	                 .mapToInt(i -> i)
	                 .average().getAsDouble();
	System.out.println(avg);
	Which are true? (Choose all that apply.)

	A.
	The stream pipeline uses a stateful operation

	B.
	The stream pipeline uses no stateful operations

	C.
	The output is 406.0

	D.
	The output is 405.777777

	E.
	The stream pipeline is parallel

	F.
	The stream pipeline contains a terminal operation

	G.
	The stream pipeline contains a reduction operation

	A, C, E, F, and G are true. distinct() is a stateful operation. The output is 406.0 because the three distinct values are 407, 405, and 406. parallelStream() creates a parallel stream pipeline. average() is both a terminal operation and a reduction operation.

	B and D are incorrect.
	*/

	/*
	คำอธิบาย:
	ในโค้ดนี้, stream pipeline ใช้การทำงานแบบ parallel ซึ่งทำให้สามารถประมวลผลข้อมูลหลายๆ ค่าในเวลาเดียวกันได้ (parallelStream) ซึ่งเป็นการทำงานในลักษณะ parallel stream.
	- `distinct()` เป็น stateful operation เนื่องจากต้องจำค่าที่ได้แล้วใน pipeline และกรองออกซ้ำ.
	- `average()` เป็น terminal operation ซึ่งคำนวณค่าเฉลี่ยของข้อมูลที่ผ่าน pipeline.
	- ผลลัพธ์คือ 406.0 เนื่องจากมีค่า distinct 3 ค่า คือ 407, 405, และ 406 ที่ได้จาก `distinct()` ก่อนคำนวณค่าเฉลี่ย.
	- `average()` ยังทำการลดข้อมูลจากหลายๆ ค่าให้เหลือแค่ค่าเฉลี่ย ซึ่งเป็น reduction operation.
	ดังนั้น A, C, E, F, และ G เป็นจริง.
	*/


}
