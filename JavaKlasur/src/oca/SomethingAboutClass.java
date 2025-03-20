package oca;

public class SomethingAboutClass {
/*
 * In the context of a Java SE 8 certification test (such as OCA/OCP Java SE 8 Programmer exams),
 *  questions about Java classes typically cover several important aspects. 
 *  Here are some key points that might be tested regarding Java classes:
		
		1.	Class Declaration:
		
			- A class in Java is declared using the class keyword.
			- A class can be public or package-private (default), but cannot be both.
			- A class name should follow Java's naming conventions, starting with an uppercase letter.
		
			public class MyClass { }
		
		2. 	Class Members:
		
			- Classes can have fields (variables), methods, constructors, and inner classes.
			- Fields can be static (class-level) or instance-level.
			- Methods can also be static or instance-level, and have access modifiers like 
		  	  public, protected, private, and package-private.
		
		3. 	Constructors:
		
			- Constructors are special methods used to initialize objects.
			- If no constructor is provided, Java provides a default no-argument constructor.
			- A constructor cannot return a value, and it must have the same name as the class.
		
			public class MyClass {
			    MyClass() {  // Constructor
			        System.out.println("Constructor called");
			    }
			}
		
		4.	Inheritance:
		
			- A class can extend only one other class (single inheritance), but it can implement multiple interfaces.
			- final classes cannot be subclassed.
			- abstract classes can have abstract methods that must be implemented by subclasses.
	
			public class SubClass extends SuperClass { }
			
		5.	Modifiers:
		
			- public, private, protected, and default access control visibility for fields, methods, and classes.
			- final prevents modification, either for variables (making them constants) or for classes/methods.
			- abstract classes and methods force subclass implementation of abstract methods.
		
		6.	Static Members:
		
			- Static methods and fields belong to the class itself rather than to any instance.
			- Static blocks are used to initialize static data members.
		
			public class MyClass {
			    static int count = 0;
			    static {
			        count = 5;
			    }
			}
		
		7.	Inner Classes:
		
			- Java allows the definition of inner (nested) classes.
			- These can be static nested classes or inner (non-static) classes.
			- They have special rules regarding access to outer class members.
		
		8.	Polymorphism:
		
			- Method overriding and overloading are common topics.
			- Overridden methods must have the same signature and return type (or a covariant return type).
			- Static methods cannot be overridden, but they can be hidden.
	
		9.	Object Class Methods:
		
			- Classes implicitly inherit from java.lang.Object, and you should understand
			  the methods like toString(), equals(), and hashCode().
		
		
 */
	
	interface testHaha{
		
		public static void main(String...s) { System.out.println("test");}
	}
	
	public static void main(String[] args) {
		
		/*
		 * 	- 	fields in a class cannot have duplicate names
		 *  - 	not every class in Java must declare a main() method. The main()
		 *  -	Heap & Stack Memory 
		 *  		> Heap memory stores objects and instance variables.(Primitive data types)
		 * 			> Stack memory stores local variables (primitives) and references to objects. (Object references)
		 *  		> Garbage Collection manages heap memory, reclaiming unused objects.
		 *  
		 *  
		 */
		testHaha.main("");
		
	}

}
