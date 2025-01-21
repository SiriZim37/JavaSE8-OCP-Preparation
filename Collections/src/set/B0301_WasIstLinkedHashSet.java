package set;

import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class B0301_WasIstLinkedHashSet {

	/*
	 * LinkedHashSet ในภาษา Java คือโครงสร้างข้อมูลชนิดหนึ่งที่เป็นการผสมผสานระหว่าง HashSet 
	 * และลิงก์ลิสต์ (Linked List) โดยมันทำหน้าที่เก็บข้อมูลในรูปแบบของเซต (Set) ที่ 
	 * "ไม่เก็บข้อมูลซ้ำ does not allow duplicate entries" 
	 * และยังคงรักษาลำดับของข้อมูลตามลำดับที่ถูกเพิ่มเข้ามา (maintaining the order of elements as they are added)
	 * 
	 * คุณสมบัติหลักของ LinkedHashSet:
	 * 		1. ไม่เก็บข้อมูลซ้ำ No Duplicate Entries: : เหมือนกับ HashSet โดยแต่ละออบเจ็กต์ที่ถูกเพิ่มเข้ามาจะไม่ซ้ำกัน
	 *  	2. รักษาลำดับการเพิ่มข้อมูล Order Preservation: : ต่างจาก HashSet ตรงที่ LinkedHashSet
	 *  		 "จะรักษาลำดับของข้อมูลตามลำดับที่ถูกเพิ่มเข้ามา" ซึ่งทำให้เราสามารถดึงข้อมูลในลำดับเดิมได้
	 *  	3. ประสิทธิภาพ Efficiency: LinkedHashSet ทำงานได้รวดเร็วในเรื่องของการเพิ่ม การลบ 
	 *  		และการค้นหาข้อมูลใกล้เคียงกับ HashSet แต่จะมีประสิทธิภาพต่ำกว่าเล็กน้อยเนื่องจากต้องรักษาลำดับของข้อมูล
	 *  
	 *  ความแตกต่างจาก HashSet:
	 *  	- LinkedHashSet Order Preservation: : 
	 *  		จะรักษาลำดับการเพิ่มข้อมูล ส่วน HashSet จะไม่รักษาลำดับของข้อมูล.
	 *  	- Performance ทั้งสองมีข้อดีในเรื่องของการค้นหาข้อมูลที่รวดเร็ว 
	 *  		แต่ LinkedHashSet จะช้ากว่าเล็กน้อย เนื่องจากต้องจัดการลำดับของข้อมูล
	 *  
	 *  LinkedHashSet เหมาะกับสถานการณ์ที่เราต้องการเก็บข้อมูลที่ไม่ซ้ำกันและต้องการรักษาลำดับการเพิ่มข้อมูล
	 */
	public static void main(String[] args) {

			LinkedHashSet<String> set = new LinkedHashSet<>();
			set.add("Birne");
	        set.add("Apple");
	        set.add("Banana");
	        set.add("Cherry");
	        set.add("Apple"); // Not added, because it is a duplicate

	        System.out.println(set); // Output: [Apple, Banana, Cherry]
	}
	

}
