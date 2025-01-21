package wdh.funtional;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;
/*
 
 Syntax ของ Method Reference:
 
		1. Reference to a Static Method
			การอ้างถึงเมธอดแบบสแตติก (Static Method Reference) ใช้ในกรณีที่เราต้องการอ้างถึงเมธอดที่เป็น static โดยตรงผ่านชื่อคลาส
				
				ClassName::staticMethodName
		
		2. Reference to an Instance Method of a Particular Object
			การอ้างถึงเมธอดของออบเจกต์เฉพาะ
				
				instance::instanceMethodName
		
		3. Reference to an Instance Method of an Arbitrary Object of a Particular Type
			การอ้างถึงเมธอดของออบเจกต์ใดๆ ในคลาสที่กำหนด
					
				ClassName::instanceMethodName
		
		4. Reference to a Constructor 
			การอ้างถึงคอนสตรักเตอร์ (Constructor Reference) ใช้เพื่อสร้างออบเจกต์ใหม่
		
				ClassName::new

 */


class StaticMethodReferenceExample {

    // Static Method
    public static int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction = StaticMethodReferenceExample::square;
        System.out.println(squareFunction.apply(5)); // Output: 25
    }
}


class InstanceMethodReferenceExample {

    public void printMessage(String message) {
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        InstanceMethodReferenceExample instance = new InstanceMethodReferenceExample();
        Consumer<String> printer = instance::printMessage;
        printer.accept("Hello, Method Reference!"); // Output: Message: Hello, Method Reference!
    }
}


class ArbitraryInstanceMethodReferenceExample {

    public static void main(String[] args) {
        Function<String, Integer> stringLength = String::length;    // Return Integer
        System.out.println(stringLength.apply("Hello")); // Output: 5
    }
}



class ConstructorReferenceExample {

    public ConstructorReferenceExample() {
        System.out.println("Constructor invoked!");
    }

    public static void main(String[] args) {
        Supplier<ConstructorReferenceExample> instanceCreator = ConstructorReferenceExample::new;
        instanceCreator.get(); // Output: Constructor invoked!
    }
}

public class LambdasMethodReferens {


}
