package wdh.classdesignpattern;

public class SingeletonClass {

	/*
	 * Singleton Pattern เป็นแนวทางการออกแบบที่กำหนดว่า คลาสหนึ่ง ๆ สามารถมีอ็อบเจ็กต์ได้เพียงแค่หนึ่งเดียวในโปรแกรมทั้งหมด 
	 * และให้การเข้าถึงอ็อบเจ็กต์เดียวนี้จากจุดใดก็ได้ทั่วทั้งแอปพลิเคชัน
	 * 
	 * Singleton class is a design pattern that ensures a class 
	 * has only one instance and provides a global point of access to that instance. 
	 * 
	 * 1. A Singleton can only have one object's state.
	 * 2. A class implementing the Singleton pattern must have its constructor marked as private.
	 * 3. The public-facing API of a Singleton can have more than one method.
	 * 4. The Singleton pattern is considered a creation design pattern.
	 * 5. A properly designed Singleton must be thread-safe, 
	 * 	  and the enum-based Singleton is a good choice for this.
	 * 
	 * 1. Singleton สามารถมีแค่สถานะของอ็อบเจ็กต์เดียวเท่านั้น
	 * 2. คลาสที่ใช้ Singleton ต้องมีคอนสตรัคเตอร์ที่ถูกตั้งเป็น private
	 * 3. API ที่เผยแพร่สู่สาธารณะของ Singleton สามารถมีหลายเมธอดได้
	 * 4. Singleton เป็นดีไซน์แพทเทิร์นประเภทการสร้าง (creation design pattern)
	 * 5. Singleton ที่ออกแบบมาอย่างถูกต้องจะต้องปลอดภัยต่อการใช้งานในหลายเธรด และการใช้ Singleton แบบ enum เป็นทางเลือกที่ดีสำหรับความปลอดภัยนี้
	 */

	

}
/*
 * 1, Eager Initialization (Thread-Safe)
 * getInstance() provides access to the single instance.!! 
 */
class SingletonA {
    // Eagerly initialized instance
    private static final SingletonA instance = new SingletonA();

    // Private constructor to prevent instantiation
    private SingletonA() {}

    // Public method to provide access to the instance
    public static SingletonA getInstance() {
        return instance;
    }
}
/*
 * 2. Lazy Initialization (Not Thread-Safe)
 * The instance is created only when getInstance() is called for the first time. !!!!!!!
 */
class SingletonB {
    private static SingletonB instance;

    private SingletonB() {}

    public static SingletonB getInstance() {
        if (instance == null) {
            instance = new SingletonB();  // Lazy initialization
        }
        return instance;
    }
}
/*
 * 3. Thread-Safe Singleton (Using synchronized)
 * */
 class SingletonC {
    private static SingletonC instance;

    private SingletonC() {}

    public static synchronized SingletonC getInstance() {
        if (instance == null) {
            instance = new SingletonC();  // Lazy initialization
        }
        return instance;
    }
}
/*
 .  4Enum-Based Singleton
 */
 enum Singleton {
	    INSTANCE;

	    public void someMethod() {
	        System.out.println("Singleton method called");
	    }
	}

