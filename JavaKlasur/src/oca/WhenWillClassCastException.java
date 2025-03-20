package oca;

class AnimalS { }
class DogS extends AnimalS {
    void bark() { System.out.println("Woof!"); }
}
class KatS extends AnimalS {
    void meow() { System.out.println("Meow!"); }
}

public class WhenWillClassCastException {

	public static void main(String[] args) {
		
		   
		   DogS myDog = new DogS();
		   if (myDog instanceof AnimalS) {
		       System.out.println("myDog is an instance of Animal.");	// myDog is an instance of Animal.
		   } else {
		       System.out.println("myDog is NOT an instance of Animal.");
		   }
		   
		   
		   
		   AnimalS myAnimal = new DogS();	    // สร้างออบเจกต์ของคลาส Dog และเก็บไว้ในตัวแปรที่ประกาศเป็นชนิด Animal 
		   										// Dog เป็นคลาสลูก (subclass) ของ Animal ดังนั้นเราจึงสามารถทำเช่นนี้ได้
		   
		 //  DogS mDog = (DogS) new AnimalS();	// พยายามสร้างออบเจกต์ของคลาส Animal แล้วทำการแปลง (cast) เป็น Dog 
		   										 // Animal ไม่ใช่ Dog  ::: ClassCastException .Downcasting 
	
	

	        // เช็คว่า myAnimal เป็น Dog จริงหรือไม่
	        if (myAnimal instanceof AnimalS) {
	            DogS myDogs = (DogS) myAnimal; // cast ได้อย่างปลอดภัย
	            myDogs.bark();
	        } else {
	            System.out.println("myAnimal ไม่ใช่ Dog");
	        }

	        // เช็คว่า myAnimal เป็น Cat หรือไม่ (จะไม่ผ่านเงื่อนไข)
	        if (myAnimal instanceof KatS) {
	        	KatS myCats = (KatS) myAnimal;
	            myCats.meow();
	        } else {
	            System.out.println("myAnimal ไม่ใช่ Cat");
	        }
	}
	/*
	 
	// ตัวอย่างเกี่ยวกับการใช้ Cast และ instanceof ใน Java

	--------------------
	1. การ Cast (การแปลงชนิด)
	--------------------
	การ cast คือการแปลงชนิดข้อมูลของออบเจกต์ (object) ให้เป็นชนิดที่ต้องการใช้งาน 
	ใช้เมื่อเราต้องการเรียกใช้เมธอดหรือคุณสมบัติที่ไม่ได้ประกาศในตัวแปรตอนสร้างออบเจกต์

	Animal myAnimal = new Dog(); // ประกาศตัวแปรเป็น Animal แต่แท้จริงเป็น Dog
	Dog myDog = (Dog) myAnimal; // cast myAnimal เป็น Dog เพื่อเรียกใช้เมธอดเฉพาะของ Dog

	--------------------
	เมื่อไหร่ที่ต้องใช้ Cast?
	--------------------
	- เมื่อเรามีตัวแปรอ้างอิง (reference) ชนิดแม่ (เช่น Animal) 
	  แต่ต้องการเรียกใช้ฟีเจอร์เฉพาะของชนิดลูก (เช่น Dog)
	- เพื่อเข้าถึงเมธอดที่ไม่มีในคลาสแม่ แต่มีในคลาสลูก

	// ตัวอย่าง
	Animal myAnimal2 = new Dog(); // Animal ไม่มีเมธอด fetch()
	((Dog) myAnimal2).fetch(); // ต้อง cast เป็น Dog ก่อนถึงจะเรียก fetch() ได้

	--------------------
	การระวังการใช้ Cast
	--------------------
	การ cast อาจทำให้เกิด ClassCastException ได้ 
	หากชนิดข้อมูลที่แท้จริงของออบเจกต์ไม่ตรงกับชนิดที่พยายาม cast

	Animal myAnimal3 = new Cat();
	Dog myDog2 = (Dog) myAnimal3; // จะเกิด ClassCastException เพราะ myAnimal3 ไม่ได้เป็น Dog

	--------------------
	2. คำสั่ง instanceof
	--------------------
	คำสั่ง instanceof ใช้เพื่อตรวจสอบว่าออบเจกต์นั้นเป็นอินสแตนซ์ของคลาสหรืออินเทอร์เฟซที่ระบุหรือไม่ 
	ช่วยให้เราเช็คได้ว่าออบเจกต์สามารถ cast เป็นชนิดที่ต้องการได้โดยไม่เกิด ClassCastException

	Animal myAnimal4 = new Dog();

	if (myAnimal4 instanceof Dog) { // เช็คว่า myAnimal4 เป็น Dog หรือไม่
	    Dog myDog3 = (Dog) myAnimal4; // cast ได้อย่างปลอดภัย
	    myDog3.bark(); // เรียกเมธอด bark() ของ Dog
	} else {
	    System.out.println("myAnimal4 ไม่ใช่ Dog");
	}

	--------------------
	เมื่อไหร่ที่ควรใช้ instanceof?
	--------------------
	- ใช้เมื่อไม่แน่ใจว่าออบเจกต์ที่ต้องการ cast เป็นชนิดที่ต้องการจริงหรือไม่
	- ใช้เพื่อป้องกัน ClassCastException โดยเช็คก่อน cast

	--------------------
	ตัวอย่างเพิ่มเติม: การใช้ instanceof ร่วมกับการ cast
	--------------------

	class Animal { }
	class Dog extends Animal {
	    void bark() { System.out.println("Woof!"); }
	}
	class Cat extends Animal {
	    void meow() { System.out.println("Meow!"); }
	}

	public class Main {
	    public static void main(String[] args) {
	        Animal myAnimal = new Dog();

	        // เช็คว่า myAnimal เป็น Dog จริงหรือไม่
	        if (myAnimal instanceof Dog) {
	            Dog myDog = (Dog) myAnimal; // cast ได้อย่างปลอดภัย
	            myDog.bark();
	        } else {
	            System.out.println("myAnimal ไม่ใช่ Dog");
	        }

	        // เช็คว่า myAnimal เป็น Cat หรือไม่ (จะไม่ผ่านเงื่อนไข)
	        if (myAnimal instanceof Cat) {
	            Cat myCat = (Cat) myAnimal;
	            myCat.meow();
	        } else {
	            System.out.println("myAnimal ไม่ใช่ Cat");
	        }
	    }
	}

	--------------------
	สรุป
	--------------------
	- Cast: ใช้เมื่อเราต้องการแปลงชนิดของออบเจกต์เพื่อเรียกฟีเจอร์เฉพาะของชนิดลูก
	- instanceof: ใช้เพื่อเช็คว่าการ cast นั้นปลอดภัยหรือไม่ ช่วยป้องกัน ClassCastException

	--------------------------
	ClassCastException
	--------------------------
	ClassCastException เกิดขึ้นเมื่อพยายามแปลง (cast) อินสแตนซ์ของคลาสหนึ่งไปยังอีกคลาสหนึ่งที่ไม่มีความสัมพันธ์กัน
	เช่น เมื่อพยายามแปลงอินสแตนซ์ไปเป็นชนิดที่ไม่สามารถใช้แทนกันได้โดยตรง 

	--------------------------
	1. Abstract Class (คลาสนามธรรม)
	--------------------------
	`abstract class` เป็นคลาสที่ไม่สามารถสร้างอินสแตนซ์ได้โดยตรง 
	สามารถมีเมธอดปกติและเมธอดนามธรรมได้ โดยคลาสลูกที่สืบทอดต้องนิยามเมธอดนามธรรมที่กำหนดในคลาสแม่

	abstract class Animal {
	    abstract void makeSound();
	    
	    void sleep() {
	        System.out.println("Sleeping...");
	    }
	}

	class Dog extends Animal {
	    @Override
	    void makeSound() {
	        System.out.println("Bark!");
	    }
	}

	--------------------------
	2. Interface (อินเทอร์เฟซ)
	--------------------------
	`interface` คือสัญญาที่กำหนดว่าออบเจกต์ที่ implement อินเทอร์เฟซนั้นต้องมีเมธอดใดบ้าง
	สามารถมี `default methods` และ `static methods` ได้ตั้งแต่ Java 8 แต่ทั่วไปจะเป็นนามธรรม (`abstract`)

	interface Walkable {
	    void walk();
	}

	class Cat implements Walkable {
	    @Override
	    public void walk() {
	        System.out.println("Cat is walking");
	    }
	}

	--------------------------
	3. Instance (อินสแตนซ์)
	--------------------------
	อินสแตนซ์คือวัตถุที่สร้างจากคลาส 
	เมื่อสร้างอินสแตนซ์ของคลาส จะสามารถเรียกเมธอดหรือเข้าถึงข้อมูลของคลาสนั้นได้

	Cat myCat = new Cat();
	myCat.walk();

	--------------------------
	4. ClassCastException (ข้อผิดพลาดการแปลงชนิดคลาส)
	--------------------------
	`ClassCastException` เกิดขึ้นเมื่อพยายามแปลงอินสแตนซ์ของคลาสหนึ่งไปอีกคลาสที่ไม่มีความสัมพันธ์กัน 
	เช่น พยายามแปลงออบเจกต์ที่ไม่ได้สืบทอดหรือไม่ได้ `implement` อินเทอร์เฟซนั้น

	ตัวอย่างที่ทำให้เกิด `ClassCastException`

	1. การแปลงระหว่างคลาสที่ไม่ได้เกี่ยวข้องกัน
	Dog dog = new Dog();
	Cat cat = (Cat) dog; // จะเกิด ClassCastException เพราะ Dog ไม่ได้สืบทอดจาก Cat

	2. การแปลงอินสแตนซ์โดยไม่ได้ตรวจสอบประเภท
	Walkable walker2 = (Walkable) new String("Hello"); // จะเกิด ClassCastException เพราะ String ไม่ได้ implement Walkable

	--------------------------
	สรุป
	--------------------------
	- `abstract class` และ `interface` ช่วยกำหนดสัญญาหรือพฤติกรรมที่คลาสต้องทำตาม
	- `ClassCastException` เกิดเมื่อพยายามแปลงออบเจกต์เป็นชนิดที่ไม่สามารถใช้แทนกันได้
	- ใช้ instanceof เพื่อตรวจสอบก่อนแปลงเพื่อหลีกเลี่ยงข้อผิดพลาด
	*/
}
