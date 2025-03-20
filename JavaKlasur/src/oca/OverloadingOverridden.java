package oca;



/*
 * การ Overload (Method Overloading)
 * 	1.	เมธอดที่ Overload สามารถมีประเภทการคืนค่า (return type) ที่แตกต่างกัน แต่ต้องมีพารามิเตอร์ที่แตกต่างกันด้วย
 * 	2. การ Overload จะถูกแก้ไขในระยะเวลาในการคอมไพล์ (compile time)
 */
class Calculator {
    // เมธอดที่เพิ่มเลขจำนวนเต็มสองตัว
    int add(int a, int b) {
        return a + b;
    }
    
//    double add(int a, int b) {	// cf 
//        return a + b;
//    }

    // เมธอด Overload ที่เพิ่มเลขจำนวนเต็มสามตัว
    int add(int a, int b, int c) {
        return a + b + c;
    }
//    double add(int a, int b, int c) {
//        return a + b + c;
//    }

    // เมธอด Overload ที่เพิ่มเลขทศนิยมสองตัว
    double add(double a, double b) {
        return a + b;
    }
}


/*
 * การ Override (Method Overriding)
 * จุดสำคัญ:
 * 	1.	เมธอดในคลาสย่อยต้องมีลักษณะเดียวกัน (ชื่อ, ประเภทการคืนค่า, และพารามิเตอร์) กับเมธอดในคลาสหลัก
 * 	2. 	เมื่อเรียกใช้เมธอดที่ถูก Override บนอ็อบเจ็กต์ของคลาสย่อย จะเรียกใช้เวอร์ชันของเมธอดที่อยู่ในคลาสย่อย
 * 	3.	การ Override เป็นวิธีหนึ่งในการบรรลุ Polymorphism (พหุนาม) ใน Java
 */
interface Lebenwesen{
	void sound();
}

class Tier {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Tier implements Lebenwesen{
    @Override
	public void sound() {
        System.out.println("Dog barks");
    }
}

public class OverloadingOverridden {


	
	
	public static void main(String[] args) {
		 Calculator calc = new Calculator();
		
	     System.out.println("Sum of 2 integers: " + calc.add(5, 10));             // เรียกใช้เมธอดแรก
	     System.out.println("Sum of 3 integers: " + calc.add(5, 10, 15));        // เรียกใช้เมธอดที่สอง
	     System.out.println("Sum of 2 doubles: " + calc.add(5.5, 10.5));        // เรียกใช้เมธอดที่สาม
	     
	     System.out.println("***1.");
	     Dog m1 = new Dog();
	     m1.sound();  // เรียกใช้เมธอดที่ถูก Override ในคลาส Dog
	     
	     System.out.println("\n***2.");
	     
	     Tier m2 = new Dog();
	     m2.sound();  // เรียกใช้เมธอดที่ถูก Override ในคลาส Dog

	     System.out.println("\n***3.");
	     
	     Tier m3 = new Tier();
	     m3.sound();  // เรียกใช้เมธอดที่ถูก Override ในคลาส Tier
	     
	     System.out.println("\n***4.");
	     
	     Lebenwesen m4 = new Dog();
	     m1.sound();  // เรียกใช้เมธอดที่ถูก Override ในคลาส Dog
	     
//	     Lebenwesen m5 = new Tier(); 
	     
	     System.out.println("\n***5.");
	     
	     Tier m5 =  (Tier)m1; 
	     // m5 จะใช้เมธอด sound() ของคลาส Dog แทน เนื่องจาก Java ใช้หลักการ polymorphism ซึ่งเลือกเมธอดตามออบเจ็กต์จริง (runtime object)  
	     m5.sound();  
	     
//	     Dog m6 = m2;		// compiler fehler
	     Dog m6 = (Dog)m2;		
	     
	     Tier m7 = m2;		
	     m7.sound();  
	     
	     Dog m8 = (Dog)m3;	// exception
	}

}
