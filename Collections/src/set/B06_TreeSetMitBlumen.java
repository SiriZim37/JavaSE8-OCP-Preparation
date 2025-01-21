package set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Blume implements Comparable<Blume> {
	int preis ;
	public Blume(int preis) {
		this.preis = preis;			
	}
	
	
	public String toString() {
		return "Blume : " + preis;
	}
	

	public int compareTo(Blume other) {	    
	    return  Integer.compare(this.preis, other.preis); // เปรียบเทียบตาม preis
	}
	  
}
/*
 	- Implementing Comparable: 
 		คลาส Blume ตอนนี้ได้ implement Comparable<Blume> แล้ว
 	- Defining  compareTo: 
 		เมธอด compareTo จะเปรียบเทียบ preis ของออบเจ็กต์ Blume ปัจจุบันกับออบเจ็กต์ Blume อื่น 
 		ซึ่งจำเป็นสำหรับ TreeSet เพื่อจัดเรียงสมาชิกให้ถูกต้อง
 */
public class B06_TreeSetMitBlumen {

	public static void main(String[] args) {
		 System.out.println("\n***TreeSet mit der Standard-Sortiereung");
		  
		  Set<Blume> set = new TreeSet<Blume>();

		  set.add(new Blume(90));
		  set.add(new Blume(120));
		  set.add(new Blume(220));
		  set.add(new Blume(90));
	        
	      System.out.println("1. size: " + set.size());	// ClassCastException
	      /*
		       Blume ลงใน TreeSet แต่ TreeSet ต้องการให้สมาชิกของมันสามารถเปรียบเทียบได้ 
		       เพื่อให้สามารถจัดเรียงได้ เนื่องจากคุณยังไม่ได้ implement อินเตอร์เฟซ Comparable ในคลาส Blume 
		       ดังนั้น TreeSet จะไม่สามารถกำหนดลำดับของสมาชิกได้ และจะเกิด ClassCastException ในระหว่างการทำงาน
	       */
	      
	      System.out.println("1. size: " + set.size());		// 3 
	      
	      System.out.println("2. set: " + set);	 			// [Blume : 90, Blume : 120, Blume : 220]
	      
	      /*
		       ถึงแม้ว่าคุณจะเพิ่มออบเจ็กต์ Blume สามอันที่มีค่า preis เท่ากัน (90) แต่ TreeSet 
		       จะเก็บเฉพาะสมาชิกที่ไม่ซ้ำกัน ดังนั้น ขนาดของเซ็ตจึงเป็น 1 และผลลัพธ์จะแสดงเฉพาะออบเจ็กต์ Blume 
		       หนึ่งอันที่มีค่า preis 90 เท่านั้น
	       */
	      
	      
	      /*
	       * Aufgabe :  
	       * 	public int compareTo(Blume other) {
				    return  0 ;
				}
				
				Set<Blume> set = new TreeSet<Blume>();

				set.add(new Blume(90));
				set.add(new Blume(120));
				set.add(new Blume(220));
				set.add(new Blume(90));
			        
			    System.out.println("1. size: " + set.size()); // immmer 1 !!!!!!! weil return 0 
				
	       */
	      
	      
	      System.out.println("\n***TreeSet mit der absteigenden Sortiereung");
	     
	      Comparator<Blume> cmp = Comparator.reverseOrder();
	      
	      Set<Blume> set2 = new TreeSet<Blume>(cmp);

	      set2.addAll(set);
	      
	      System.out.println("4. size: " + set2.size());		// 3 
	      
		  System.out.println("5. set: " + set2);				// [Blume : 220, Blume : 120, Blume : 90]
	 
		  
		  

	}

}
