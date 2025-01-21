package ocp2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Buch implements Comparator<Buch>  {
    String name;
    double price;

    public Buch() {}

    public Buch(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int compare(Buch b1, Buch b2) {
        return b1.name.compareTo(b2.name); // เปรียบเทียบชื่อของหนังสือ
    }

    public String toString() {
        return name + ":" + price;
    }
}


public class CollectionSortComparatorTest {

	public static void main(String[] args) {
		List<Buch> books = Arrays.asList(new Buch("Beginning with Java", 2), new Buch("A Guide to Java Tour", 3));
		Collections.sort(books, new Buch());
		System.out.print(books);
	}
	/*
	  	What is the result?
		 A. [A Guide to Java Tour:3.0, Beginning with Java:2.0]
		 B. [Beginning with Java:2, A Guide to Java Tour:3]
		 C. A compilation error occurs because the Book class does not override the abstract method compareTo().
		 D. An Exception is thrown at run time.
	 */
	
	/*
	 * การอธิบาย:
		compare() method:
		ในคลาส Book, คุณ implement เมธอด compare() จาก Comparator ซึ่งเปรียบเทียบชื่อของหนังสือโดยใช้ compareTo() 
		ซึ่งจะเรียงลำดับตัวอักษรจาก A ถึง Z ตามชื่อของหนังสือ (name).
		การใช้ Collections.sort():
		คุณใช้ Collections.sort(books, new Book()); เพื่อเรียงลำดับ books โดยใช้ Comparator ที่คุณได้ implement ในคลาส Book.
		ผลลัพธ์จากการจัดเรียง:
		หลังจากการจัดเรียงชื่อหนังสือ, รายการ books จะเรียงตามชื่อจาก A ถึง Z ซึ่ง "A Guide to Java Tour" จะอยู่ก่อน "Beginning with Java" เพราะ "A" มาก่อน "B".
		คำตอบ:
		คำตอบที่ถูกต้องคือ A: [A Guide to Java Tour:3.0, Beginning with Java:2.0]
		
		เหตุผล:
		
		ตัวเลือก A คือผลลัพธ์ที่ถูกต้อง เพราะรายการ books ถูกจัดเรียงตามชื่อของหนังสือ โดย "A Guide to Java Tour" (ราคาคือ 3.0) จะมาอยู่ก่อน "Beginning with Java" (ราคาคือ 2.0) เนื่องจาก "A" มาก่อน "B" ในการจัดเรียงตามลำดับตัวอักษร.
	 */
}
