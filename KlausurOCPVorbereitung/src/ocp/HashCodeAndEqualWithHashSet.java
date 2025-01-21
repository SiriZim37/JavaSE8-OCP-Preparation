package ocp;

import java.util.HashSet;
import java.util.Set;

class Nearly {
	  String value;
	  Nearly(String v) { value = v; }
	  public int hashCode() { return 1; }
	  public boolean equals(Nearly n) {
	    if(value.charAt(0) == n.value.charAt(0)) return true;
	    return false;
	  }
	  public static void main(String[] sss) {
	    Nearly n1 = new Nearly("aaa");
	    Nearly n2 = new Nearly("aaa");
	    String s = "-";
	    if(n1.equals(n2)) s += "1";
	    if(n1 == n2) s += "2";
	    Set<Nearly> set = new HashSet<Nearly>();
	    set.add(n1);
	    set.add(n2);
	    System.out.println(s + " " + set.size());
	  }
	}

public class HashCodeAndEqualWithHashSet {

	/*
	 * What is the result?
	 * 
	 * A.	-1 1
	 * B.	-1 2
	 * C.	-12 1
	 * D.	-12 2
	 * E.	Compilation fails
	 * F.	An exception is thrown at runtime

	
		B is correct. The equals() method shown in the code doesn't properly override Object.equals(),
		which takes an object. Therefore, when the code adds instances to the set, 
		the default equals method from class Object is used.
	
		A, C, D, E, and F are incorrect based on the preceding statement.
	 */
	
	/*
	  n1.equals(n2): ถึงแม้ว่า equals จะเปรียบเทียบค่า value 
	  และคืนค่า true เพราะค่า value ของทั้งสองเริ่มต้นด้วยตัวอักษรเดียวกัน ('a'), 
	  แต่เนื่องจาก equals ไม่ได้ override เมธอด Object.equals() อย่างถูกต้องใน HashSet, 
	  ทำให้ HashSet ไม่สามารถตรวจสอบความเท่ากันได้.

	  n1 == n2: คำสั่งนี้คืนค่า false เพราะ n1 และ n2 เป็นออบเจ็กต์คนละตัวในหน่วยความจำ 
	  (ไม่ใช่การอ้างอิงเดียวกัน).

	  set.add(n1) และ set.add(n2): HashSet ใช้ hashCode และ equals เพื่อตรวจสอบความเท่ากันของออบเจ็กต์. 
	  ในกรณีนี้, hashCode คืนค่าเหมือนกัน (1), แต่เนื่องจาก equals ไม่ได้ override อย่างถูกต้อง, 
	  HashSet จึงใช้ Object.equals() ซึ่งตรวจสอบการอ้างอิง (==). 
	  ผลลัพธ์คือ HashSet เพิ่มทั้ง n1 และ n2 เพราะคิดว่าออบเจ็กต์ทั้งสองไม่เท่ากัน.
	*/

}
