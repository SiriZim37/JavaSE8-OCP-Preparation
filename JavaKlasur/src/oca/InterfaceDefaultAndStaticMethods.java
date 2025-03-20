package oca;


interface InterfaceX {
    default void defaultMethod() {
        System.out.println("Default method in InterfaceX");
    }

    static void staticMethod() {
        System.out.println("Static method in InterfaceX");
    }
}

class Y implements InterfaceX {
    @Override
    public void defaultMethod() {
        System.out.println("Overridden default method in Y");
    }
}

class Z {
    public void defaultMethod() {
        System.out.println("Overridden default method in Y");
    }
}

public class InterfaceDefaultAndStaticMethods {

	public static void main(String[] args) {
	     InterfaceX obj = new Y();		// InterfaceX obj = new Y(); ได้ โดยให้ obj มีชนิดข้อมูลเป็น InterfaceX แต่ชี้ไปยังวัตถุ (object) ที่เป็นอินสแตนซ์ของ Y นั่นเอง
	     obj.defaultMethod();			// Overridden default method in Y
	     InterfaceX.staticMethod();		// Static method in InterfaceX

//	     InterfaceX obj2 = new Z();	// cf ; 	
	     InterfaceX obj2 = (InterfaceX) new Z();	//  java.lang.ClassCastException
	     obj2.defaultMethod();	
	}

}

