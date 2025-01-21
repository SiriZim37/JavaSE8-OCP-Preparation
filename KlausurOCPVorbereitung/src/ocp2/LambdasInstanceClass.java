package ocp2;


interface Rideable  { Car getCar (String name);   }
class Car {     
		private String name;     
		public Car (String name)    {         
  } 
}

public class LambdasInstanceClass {

	public static void main(String[] args) {
			Rideable rider = Car :: new;
		 	Car vehicle = rider.getCar("MyCar");
	}

		 /*
			 Which code fragment creates an instance of Car?
			 A. Car auto = Car ("MyCar"):: new;
			 B. Car auto = Car :: new;
			 	Car vehicle = auto :: getCar("MyCar");
			 C. Rideable rider = Car :: new;
			 	Car vehicle = rider.getCar("MyCar");
			 D. Car vehicle = Rideable : : new : : getCar("MyCar");
		
		  */
	
	/*
	A. Car auto = Car ("MyCar"): : new;
		ตัวเลือกนี้ไม่ถูกต้องเนื่องจากไม่สามารถสร้างอินสแตนซ์ของคลาส Car โดยตรงแบบนี้ใน Java ซึ่ง syntax แบบนี้ไม่ได้รับการยอมรับ
	
	B. Car auto = Car : : new; Car vehicle = auto : : getCar("MyCar");	
		ตัวเลือกนี้ไม่ถูกต้องเช่นกัน เพราะว่า Car :: new เป็น method reference ที่ใช้ในการสร้างอินสแตนซ์ของ Car โดยตรง แต่คำสั่งนี้ไม่สามารถทำงานได้อย่างที่คาดหวัง เพราะการใช้งาน getCar("MyCar") ควรจะเกิดจากการเรียกผ่านออบเจกต์ของ Rideable
	
	C. Rideable rider = Car : : new; Car vehicle = rider.getCar("MyCar");	
		ตัวเลือกนี้ถูกต้อง:
		Car :: new คือ method reference ที่ใช้สร้างอินสแตนซ์ของคลาส Car จากคลาส Rideable ซึ่งอ้างอิงถึงเมธอด getCar ใน Rideable.
		ในกรณีนี้ rider.getCar("MyCar") จะเรียก getCar ของ Rideable ซึ่งสร้างและคืนค่าของออบเจกต์ Car ตามชื่อที่ส่งให้
	
	D. Car vehicle = Rideable : : new : : getCar("MyCar")
		ตัวเลือกนี้ไม่ถูกต้อง เนื่องจากไม่สามารถเรียกใช้ new และ getCar("MyCar") ในลักษณะนี้ได้ใน Java
	
	คำตอบที่ถูกต้อง: C
	 */
}
