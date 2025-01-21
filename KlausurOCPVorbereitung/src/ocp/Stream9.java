package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Stream9 {
	
	public static void main(String[] args) {
		IntStream is = IntStream.of(2, 3, 4, 5, 6, 7, 8, 9);
		IntPredicate isPrime = n -> {
		   if (n == 2) return true;
		   if (n == 1 || n % 2 == 0) return false;
		   for (int i = 3; i * i <= n; i += 2) {
		      if (n % i == 0) return false;
		   }
		   return true;
		}; 
//		System.out.println(    F1     );
	
	}
	
	/*
	 * 
	 * A.
	 * is.mapToInt(i -> i).anyMatch(isPrime)
	 * 
	 * B.
	 * is.anyMatch(isPrime)
	 * 
	 * C.
	 * is.filter(isPrime)
	 * 
	 * D.
	 * is.filter(isPrime).findFirst()
	 * 
	 * E.
	 * is.allMatch(isPrime)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * B is correct. anyMatch() takes a Predicate and returns true if any of the items in the stream pass the predicate test. Several numbers in the list are prime, and the test is to determine if any numbers are prime, so the result is true.
	 * 
	 * A, C, D, and E are incorrect. In A we can't mapToInt() on an IntStream (it's already int!). In C filter() takes a Predicate, but returns a stream. In D filtering and then findFirst() will return an optional integer. In E allMatch() checks to see if all items in the stream match the predicate, and many of the numbers in the stream are not prime, so this returns false.
	 */

	/*
	คำอธิบาย:
	ตัวเลือก B คือคำตอบที่ถูกต้อง เพราะเมธอด anyMatch() ใช้ตรวจสอบว่าในสตรีมมีค่าที่ตรงตามเงื่อนไขที่กำหนดใน Predicate หรือไม่ โดยจะคืนค่า true
	 ถ้ามีอย่างน้อยหนึ่งตัวที่ตรงตามเงื่อนไข (ในกรณีนี้คือ ตัวเลขที่เป็นจำนวนเฉพาะ) ดังนั้น ผลลัพธ์คือ true เนื่องจากในสตรีมมีจำนวนเฉพาะหลายตัว

	คำตอบ A, C, D, และ E ไม่ถูกต้อง:
	- A ใช้ mapToInt() แต่ IntStream เป็นชนิดที่เป็น int อยู่แล้ว ดังนั้นไม่สามารถใช้ได้
	- C ใช้ filter() ซึ่งจะคืนค่าเป็น stream แต่ไม่ได้ทำการตรวจสอบเงื่อนไขให้ผลลัพธ์เป็น true หรือ false
	- D ใช้ filter() แล้วตามด้วย findFirst() ซึ่งจะคืนค่าเป็น Optional ซึ่งไม่สามารถตรวจสอบได้ว่าเป็น true หรือ false โดยตรง
	- E ใช้ allMatch() ซึ่งตรวจสอบว่า ทุกตัวในสตรีมตรงกับเงื่อนไขหรือไม่ แต่ในกรณีนี้หลายๆ ตัวในสตรีมไม่เป็นจำนวนเฉพาะ ทำให้ผลลัพธ์เป็น false
	*/ 

}
