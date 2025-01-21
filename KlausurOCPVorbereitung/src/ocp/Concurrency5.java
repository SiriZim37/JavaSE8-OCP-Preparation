package ocp;

public class Concurrency5 {
	/* 
	When using ExecutorService instances from the Executors class, which are true? (Choose all that apply.)

	A. When constructing a fixed thread pool, you specify how many threads will be used to execute tasks

	B. When constructing a cached thread pool, you specify how many threads will be used to execute tasks

	C. Cached thread pools can reuse threads that have become free

	D. When using fixed thread pools, tasks that cannot be executed immediately are placed in a task pool for later execution

	E. The Java API does NOT provide a way to determine the number of hardware processors that are available at runtime

	A and C are correct statements.

	B is incorrect; cached thread pools grow dynamically, which can be dangerous. D is incorrect; such tasks are queued, not pooled. 
	E is incorrect; java.lang.Runtime has an availableProcessors() method.
	*/

	/*
	คำอธิบาย (Thai):
	- A: ถูกต้อง เพราะ fixed thread pool จะกำหนดจำนวน thread ที่ใช้เมื่อสร้าง 
	- B: ไม่ถูกต้อง เพราะ cached thread pool ไม่กำหนดจำนวน thread ล่วงหน้า แต่จะเพิ่ม thread ตามต้องการ
	- C: ถูกต้อง เพราะ cached thread pool จะนำ thread ที่ว่างกลับมาใช้ใหม่
	- D: ไม่ถูกต้อง เพราะ fixed thread pool จะจัดเก็บ task ที่ยังรอการดำเนินการไว้ในคิว ไม่ใช่ใน pool
	- E: ไม่ถูกต้อง เพราะ Java มีวิธีตรวจสอบจำนวนโปรเซสเซอร์ที่ใช้ได้ผ่าน `java.lang.Runtime.availableProcessors()`
	*/

}
