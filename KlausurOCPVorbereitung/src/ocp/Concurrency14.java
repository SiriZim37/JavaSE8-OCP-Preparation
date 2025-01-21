package ocp;

public class Concurrency14 {
	/* 
	Which are true? (Choose all that apply.)

	A.
	Method invoke of class ForkJoinPool accepts as parameters instances of classes that implement either Runnable or Callable, or instances of classes that are subclasses of ForkJoinTask.

	B.
	An algorithm that will subdivide itself into Fork-Join tasks and does not have to return any value can extend RecursiveTask in order to be processed in parallel.

	C.
	ForkJoinPool IS-A ExecutorService.

	D.
	In the implementation of the compute method of a ForkJoinTask, the fork method should always be called before the join method, or one of the invokeAll methods should be called.

	E.
	It is not possible to use a ForkJoinPool to process an instance of the Callable interface.

	C and D are correct.

	A, B, and E are incorrect. A is incorrect because method invoke of class ForkJoinPool only accepts as parameters instances of ForkJoinTask (that is, instances of subclasses of RecursiveAction or RecursiveTask, which are also subclasses of ForkJoinTask). B is incorrect because if the algorithm that will subdivide itself does not have to return any value, the class that contains it should extend RecursiveAction, not RecursiveTask. E is incorrect because ForkJoinPool IS-A ExecutorService, which makes it possible to use a ForkJoinPool to process an instance of Callable via the submit method.
	*/

	/* คำอธิบาย:
	A. ไม่ถูกต้อง เนื่องจาก method invoke ของ ForkJoinPool ยอมรับพารามิเตอร์เป็นอินสแตนซ์ของ ForkJoinTask เท่านั้น ซึ่งเป็นคลาสที่สืบทอดมาจาก RecursiveAction หรือ RecursiveTask

	B. ไม่ถูกต้อง หากอัลกอริธึมที่จะแบ่งตัวเองเป็น Fork-Join tasks โดยที่ไม่ต้องคืนค่าผลลัพธ์ ควรสืบทอดคลาส RecursiveAction แทน RecursiveTask

	C. ถูกต้อง เพราะ ForkJoinPool คือ ExecutorService ซึ่งทำให้สามารถใช้ ForkJoinPool เพื่อประมวลผล Callable ได้

	D. ถูกต้อง เนื่องจากในเมธอด compute ของ ForkJoinTask ควรเรียก method fork ก่อน join หรือเรียก invokeAll เพื่อแบ่งงานก่อนที่จะเข้าร่วม

	E. ไม่ถูกต้อง เพราะ ForkJoinPool คือ ExecutorService ซึ่งทำให้สามารถใช้ ForkJoinPool เพื่อประมวลผลอินสแตนซ์ของ Callable ได้ผ่านเมธอด submit
	*/ 

}
