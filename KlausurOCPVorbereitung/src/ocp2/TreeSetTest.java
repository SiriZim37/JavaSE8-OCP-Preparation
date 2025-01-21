package ocp2;

import java.util.Set;
import java.util.TreeSet;

class Vehicle   {
    int vno;
    String name;
    public Vehicle (int vno, String name)   {
        this.vno = vno;
        this.name = name;
    }
    public String toString ()   {
        return vno + ":" + name;
    }
 }

public class TreeSetTest {

	public static void main(String[] args) {
		
		 Set<Vehicle>  vehicles = new TreeSet <> ();
		 vehicles.add(new Vehicle (10123, "Ford"));
		 vehicles.add(new Vehicle (10124, "BMW"));
		 System.out.println(vehicles);

		 /*
			 What is the result?
			 A. 10123 Ford 10124 BMW
			 B. 10124 BMW
			 10123 Ford
			 C. A compilation error occurs.
			 D. A ClassCastException is thrown at run time.
		 */
		 
		 
		 
		 
		 Set<Vehicle2> vehicles2 = new TreeSet<>((v1, v2) -> Integer.compare(v1.vno, v2.vno));
		 vehicles2.add(new Vehicle2 (10123, "Ford"));
		 vehicles2.add(new Vehicle2 (10124, "BMW"));
		 System.out.println(vehicles2);
	}
	
	/*
	  D. A ClassCastException is thrown at run time.: 
	  เป็นคำตอบที่ถูกต้อง เนื่องจากไม่มีการกำหนดวิธีการเปรียบเทียบใน Vehicle และ TreeSet คาดหวังให้มีการเปรียบเทียบออบเจกต์
	 
	 TreeSet ใช้การเปรียบเทียบออบเจกต์เพื่อจัดเรียง แต่ในคลาส Vehicle ไม่มีการกำหนดวิธีการเปรียบเทียบออบเจกต์ของ Vehicle ว่าจะเปรียบเทียบอย่างไร
	  ดังนั้นจะเกิดปัญหาการเปรียบเทียบออบเจกต์ระหว่าง Vehicle ทั้งสองตัว ซึ่งจะทำให้เกิด ClassCastException 
	  เมื่อพยายามเพิ่มออบเจกต์ลงใน TreeSet เนื่องจาก TreeSet คาดหวังว่าออบเจกต์จะสามารถเปรียบเทียบกันได้ 
	  (อาจจะใช้ compareTo หรือ Comparator)
	 */
}

class Vehicle2 implements Comparable<Vehicle2> {
    int vno;
    String name;

    public Vehicle2(int vno, String name) {
        this.vno = vno;
        this.name = name;
    }

    @Override
    public int compareTo(Vehicle2 other) {
        // เปรียบเทียบตามหมายเลข vno (สามารถปรับเปลี่ยนได้ตามต้องการ)
        return Integer.compare(this.vno, other.vno);
    }

    @Override
    public String toString() {
        return vno + ":" + name;
    }
}


