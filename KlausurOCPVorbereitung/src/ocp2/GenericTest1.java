package ocp2;

public class GenericTest1<T> {

	
	    private T t;
	    
	    public T get() {
	        return t;
	    }
	    
	    public void set(T t) {
	        this.t = t;
	    }
	    
	    public static void main(String[] args) {
	    	GenericTest1<String> type = new GenericTest1<>();
	    	GenericTest1 type1 = new GenericTest1();  // line n1
	        type.set("Java");
	        type1.set(100);  // line n2

	        System.out.print(type.get() + " " + type1.get());
	    }
	
		/*
		 *  What is the result?
			 A. Java 100
			 B. java.lang.string@<hashcode>java.lang.Integer@<hashcode>
			 C. A compilation error occurs. To rectify it, replace line n1 with: Test<Integer> type1 = new Test<>();
			 D. A compilation error occurs. To rectify it, replace line n2 with: type1.set (Integer(100))
		 */
	    /*
	    1. การสร้างอ็อบเจ็กต์ `type`:
	    
	        - อ็อบเจ็กต์ `type` ถูกสร้างโดยใช้ `Test<String>`, ซึ่งทำให้ `T` เป็น `String` ในคลาส `Test` นี้.
	        - ดังนั้นค่าที่เก็บใน `t` จะต้องเป็นชนิด `String`. ในกรณีนี้ ค่าที่ถูกตั้งใน `type` คือ `"Java"`, ซึ่งเป็น `String`.

	    2. การสร้างอ็อบเจ็กต์ `type1`:

	        - อ็อบเจ็กต์ `type1` ถูกสร้างโดยใช้ `Test` โดยไม่ระบุชนิดข้อมูล (raw type).
	        - ดังนั้น `type1` สามารถเก็บค่าใดๆ ได้ ไม่ว่าจะเป็น `Integer`, `String`, หรือชนิดอื่นๆ ซึ่งจะไม่ผ่านการตรวจสอบชนิดข้อมูลในระหว่างการคอมไพล์.

	    3. การตั้งค่าและดึงค่าของ `type`:

	        - การใช้ `type.set("Java")` จะเก็บค่า `"Java"` ซึ่งเป็น `String` ใน `type`.
	        - เมื่อเรียก `System.out.print(type.get())`, โปรแกรมจะแสดงผล `"Java"`.

	    4. การตั้งค่าและดึงค่าของ `type1`:

	        - การใช้ `type1.set(100)` จะเก็บค่าตัวเลข `100` ซึ่งเป็น `Integer` ใน `type1`.
	        - เมื่อเรียก `System.out.print(type1.get())`, โปรแกรมจะแสดงผล `100`.
	*/

}
