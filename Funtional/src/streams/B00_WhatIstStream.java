package streams;

import java.util.Arrays;
import java.util.List;

public class B00_WhatIstStream {

	public static void main(String[] args) {

		/*
		 * Stream ใน Java คือ ลำดับขององค์ประกอบที่รองรับวิธีการต่างๆ ที่สามารถนำมาต่อกันเพื่อให้ได้ผลลัพธ์ 
		 * Stream ไม่ได้เก็บข้อมูล แต่จะประมวลผลข้อมูลเมื่อถูกเรียกใช้ 
		 * ช่วยให้คุณสามารถจัดการข้อมูลในรูปแบบที่อ่านเข้าใจง่ายและประสิทธิภาพสูงขึ้น
		 * นอกจากนี้ยังสามารถทำงานแบบขนาน (parallel processing) เพื่อเพิ่มประสิทธิภาพในการประมวลผลข้อมูลขนาดใหญ่ได้อีกด้วย
		 * 
		 * filter(): ใช้ในการกรองข้อมูล เช่น ต้องการแค่ข้อมูลที่ไม่ใช่ null
		 * 				
		 * 			stream.filter(name -> name != null);
		 * 
		 * map(): ใช้ในการแปลงข้อมูล เช่น แปลงตัวอักษรทั้งหมดเป็นพิมพ์ใหญ่
		 * 
		 * 			stream.map(String::toUpperCase);
		 * 
		 * forEach(): ใช้ในการวนลูปแต่ละค่าใน stream
		 * 
		 * 			stream.forEach(System.out::println);  // พิมพ์ค่าแต่ละตัว
		 * 
		 * collect(): ใช้ในการเก็บข้อมูลผลลัพธ์จาก stream
		 * 
		 * 			List<String> result = stream.collect(Collectors.toList());
		 * 
		 * sum(): ใช้ในการรวมค่าตัวเลขทั้งหมดใน stream
		 * 
		 * 			int sum = list.stream().mapToInt(x -> x).sum();
		 * 
		 * ทำไมต้องใช้ Stream?
		 * 	-	ทำให้โค้ดอ่านง่ายขึ้น: เราสามารถเขียนโค้ดแบบ declarative แทนการใช้ลูปหลายชั้น เช่น for หรือ while
		 * 	-	ประสิทธิภาพดีขึ้น: ด้วยการทำงานแบบ lazy evaluation (ประมวลผลเฉพาะข้อมูลที่จำเป็น) และการทำงานแบบขนาน (parallel)
		 * 	- 	ลดการใช้โค้ดซ้ำซ้อน: ช่วยลดจำนวนโค้ดที่ต้องเขียนในกรณีที่ต้องกรอง แปลง หรือประมวลผลข้อมูลแบบซ้ำๆ
		 * 
		 * หากต้องการให้ Stream ทำงานแบบขนาน สามารถใช้ parallelStream():
			
			List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");
					 
					  names.parallelStream()
				     .filter(name -> name.startsWith("J"))
				     .map(String::toUpperCase)
				     .forEach(System.out::println);
		 */
		
		/*
		 * Ein Stream (Datenstrom) ist eine Folge von elementen (Objekten) ,  
		 * die zur weiteren Verabeitung (typischerweise zusammenfassend) verwendet wird.
		 * Ein Stream speichert nicht die Daten ไม่ได้เก็บข้อมูล
		 * 
		 */
		
		List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");
		 
		  names.parallelStream()
	     .filter(name -> name.startsWith("J"))
	     .map(String::toUpperCase)
	     .forEach(System.out::println);
		

	}

}
