package ocpexam;

public class EncapsulationTest {

	/*
	 * 
	Given the definition of the Vehicle class:

	Which action encapsulates the Vehicle class?

	A. Make the Vehicle class private.

	B. Make the name variable public.

	C. Make the getName() and setName() method public.

	D. Make the name variable private.

	E. Make the getName() and setName() method private.




		
		Key Concept of Encapsulation:
		Encapsulation refers to restricting direct access to the internal state of an object. This is usually done by:
		
		. Making the fields (variables) private.
		. Providing getter and setter methods to access and modify the fields.
		
		Encapsulation คือการซ่อนข้อมูลภายในของคลาส (เช่น ตัวแปร) และให้การเข้าถึงข้อมูลนั้นผ่าน methods (เช่น getter และ setter) เพื่อควบคุมการเข้าถึงและการปรับแก้ข้อมูล
		Principle of Encapsulation: ตัวแปรภายในจะต้อง private เพื่อป้องกันการเข้าถึงจากภายนอก และให้ public methods เป็นตัวกลางในการเข้าถึงหรือแก้ไขตัวแปรนั้น


	A. ทำให้คลาส Vehicle เป็น private:
	ไม่ถูกต้อง: เราไม่สามารถทำให้คลาส Vehicle เป็น private ในระดับคลาสที่เป็น top-level ได้ 
	เพราะมันจะทำให้ไม่สามารถเข้าถึงคลาสนั้นได้เลย
	
	B. ทำให้ตัวแปร name เป็น public:
	ไม่ถูกต้อง: การทำให้ตัวแปร name เป็น public ไม่ใช่การห่อหุ้มข้อมูล เพราะมันเปิดเผยข้อมูลภายในคลาส
	ให้สามารถเข้าถึงได้โดยตรงจากภายนอก ซึ่งขัดกับหลักการของ Encapsulation ที่จะต้องป้องกันการเข้าถึงข้อมูลภายใน
	
	C. ทำให้เมธอด getName() และ setName() เป็น public:
	ไม่ถูกต้อง: การทำให้เมธอด getName() และ setName() เป็น public เป็น การเข้าถึงข้อมูลผ่านเมธอด 
	ซึ่งถือว่าเป็นแนวทางที่ถูกต้อง แต่ การห่อหุ้มข้อมูลที่ถูกต้อง คือการทำให้ตัวแปร name เป็น private และใช้เมธอดเหล่านี้ในการเข้าถึง
	
	D. ทำให้ตัวแปร name เป็น private:
	ถูกต้อง: การทำให้ตัวแปร name เป็น private จะช่วย ห่อหุ้มข้อมูล และไม่ให้ภายนอกเข้าถึงข้อมูลได้โดยตรง
	 แต่ต้องใช้เมธอด getter/setter ที่เป็น public เพื่อให้สามารถเข้าถึงข้อมูลนี้ได้ตามต้องการ
	
	E. ทำให้เมธอด getName() และ setName() เป็น private:
	ไม่ถูกต้อง: การทำให้เมธอด getName() และ setName() เป็น private จะทำให้ ไม่สามารถเข้าถึงตัวแปรจากภายนอก 
	ได้เลย ซึ่งจะทำให้ไม่สามารถใช้งานคลาสนี้ได้

		ตัวอย่างการห่อหุ้มข้อมูล (Encapsulation):
		
		class Vehicle {
		    private String name;  // ตัวแปร name เป็น private
		
		    // getter method
		    public String getName() {
		        return name;
		    }
		
		    // setter method
		    public void setName(String name) {
		        this.name = name;
		    }
		}

	
	*/
	
}

