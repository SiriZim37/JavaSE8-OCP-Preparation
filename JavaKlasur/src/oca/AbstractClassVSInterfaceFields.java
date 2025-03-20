package oca;

interface Interface1 {
    int VALUE = 10; // static and final by default
    
    default int testInt() {
    	return 1;
    }
}

abstract class AbstractClass {
    int VALUE = 20; // Instance variable
    int testInt() {
    	return 2;
    }
}

class ConcreteClass extends AbstractClass implements Interface1 {
	public  int testInt() {
	   return 3;
	}
	   
    public void printValue() {
    	
//      System.out.println(VALUE);		// The field VALUE is ambiguous
        
    
        System.out.println(Interface1.VALUE);  // Outputs 10
        System.out.println(super.VALUE);  // Outputs 20
        
        System.out.println(Interface1.super.testInt());	 // 1
        System.out.println(super.testInt());	 // 2
        System.out.println(this.testInt());	 // 3
        System.out.println(testInt());	 // 3
    }
}

public class AbstractClassVSInterfaceFields {

	public static void main(String[] args) {

        ConcreteClass obj = new ConcreteClass();
        obj.printValue();

	}

}
