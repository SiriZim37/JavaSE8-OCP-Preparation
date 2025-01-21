package ocp;

public class Concurrency16 {
	/* 
	Which are true? (Choose all that apply.)

	A. 
	Deadlock will not occur if wait()/notify() is used

	B. 
	A thread will resume execution as soon as its sleep duration expires

	C. 
	Synchronization can prevent two objects from being accessed by the same thread

	D. 
	The wait() method is overloaded to accept a duration

	E. 
	The notify() method is overloaded to accept a duration

	F. 
	Both wait() and notify() must be called from a synchronized context

	G. 
	The wait() method does NOT throw a checked exception

	H. 
	The sleep() method does NOT throw a checked exception

	D and F are correct. D is correct because the wait() method is overloaded to accept a wait duration in milliseconds. If the thread has not been notified by the time the wait duration has elapsed, then the thread will move back to runnable even without having been notified. F is correct because wait(), notify(), and notifyAll() must all be called from within a synchronized context. A thread must own the lock on the object it's invoking wait(), notify(), or notifyAll() on.

	A, B, C, E, G, and H are incorrect. A is incorrect because wait()/notify() will not prevent deadlock. B is incorrect because a sleeping thread will return to runnable when it wakes up, but it might not necessarily resume execution right away. To resume executing, the newly awakened thread must still be moved from runnable to running by the scheduler. C is incorrect because synchronization prevents two or more threads from accessing the same object. E is incorrect because notify() is not overloaded to accept a duration. G and H are incorrect because wait() and sleep() both declare a checked exception (InterruptedException).
	*/

	/* 
	คำอธิบาย:
	คำตอบที่ถูกต้องคือ D และ F

	- D: วิธี wait() ถูกโอเวอร์โหลดเพื่อรับระยะเวลาในการรอเป็นมิลลิวินาที หากเธรดไม่ได้รับการแจ้งเตือนเมื่อระยะเวลาในการรอหมดลง เธรดจะกลับไปยังสถานะ runnable โดยไม่จำเป็นต้องได้รับการแจ้งเตือน
	- F
	*/

}
