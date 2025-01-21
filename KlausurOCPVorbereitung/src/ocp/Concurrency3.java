package ocp;

import java.util.concurrent.atomic.AtomicInteger;

public class Concurrency3 {

	/*
	public class Calculator {
	  private AtomicInteger i = new AtomicInteger();
	  public void add(int value) {
	    int oldValue = i.get();                                     // line 4
	    int newValue = oldValue + value;
	    System.out.println(i.compareAndSet(oldValue, newValue));    // line 6
	  }
	  public int getValue() {
	    return i.get();
	  }
	}
	Which are true? (Choose all that apply.)

	A. Class Calculator is thread-safe
	
	B. The instruction on line 6 will always print true
		
	C. The instruction on line 6 would always print true if a Lock were used before line 4 and after line 6, locking and unlocking, respectively
		
	D. Class Calculator would be thread-safe if method addAndGet were used in place of the compareAndSet method on line 6	
	
	E. Class Calculator could only be thread-safe if method add were synchronized

	
	
	
	A and C are correct.
	
	B, D, and E are incorrect. B is incorrect because if Thread A executes the instruction on line 4 and right after Thread B executes the instruction on line 6, the value contained by Thread A would be outdated and the compareAndSet method would return false. D and E are incorrect because class Calculator is thread-safe.	 


	คำอธิบาย:
	- ข้อ A และ C ถูกต้อง:
	  A: คลาส Calculator เป็น thread-safe เพราะใช้ AtomicInteger ซึ่งออกแบบมาให้รองรับการทำงานแบบหลายเธรด (thread-safe) โดยไม่ต้องใช้การซิงโครไนซ์เพิ่มเติม
	  C: การใช้ Lock ก่อนบรรทัดที่ 4 และหลังบรรทัดที่ 6 จะช่วยให้มั่นใจว่า compareAndSet จะคืนค่า true เสมอ เพราะจะไม่มี thread อื่นมาเปลี่ยนค่าในช่วงที่ล็อคไว้
	
	- ข้อ B, D และ E ไม่ถูกต้อง:
	  B: การพิมพ์ค่า true จาก compareAndSet ไม่สามารถเกิดขึ้นเสมอได้ เนื่องจากถ้ามี thread อื่นเปลี่ยนค่า `i` ระหว่างการคำนวณค่าใหม่ จะทำให้ compareAndSet คืนค่า false
	  D: ใช้ addAndGet แทน compareAndSet ไม่ได้ทำให้ thread-safe เพิ่มขึ้น เพราะ AtomicInteger รองรับ thread-safe อยู่แล้ว
	  E: การทำให้เมธอด add เป็น synchronized ไม่จำเป็น เพราะ AtomicInteger จัดการ thread-safe ให้เรียบร้อยแล้ว
	 */
	

	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.add(1);
		System.out.println(c.getValue());
	}
}

class Calculator {
	  private AtomicInteger i = new AtomicInteger();
	  public void add(int value) {
	    int oldValue = i.get();                                     // line 4
	    int newValue = oldValue + value;
	    System.out.println(i.compareAndSet(oldValue, newValue));    // line 6
	  }
	  public int getValue() {
	    return i.get();
	  }
	}

