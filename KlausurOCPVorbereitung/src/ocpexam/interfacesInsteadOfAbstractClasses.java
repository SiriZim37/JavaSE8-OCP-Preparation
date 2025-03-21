package ocpexam;

public class interfacesInsteadOfAbstractClasses {

	/*
	 Question 72

	Which two reasons should you use interfaces instead of abstract classes?
	A. You expect that classes that implement your interfaces have many common methods or
	   fields, or require access modifiers other than public.
	B. You expect that unrelated classes would implement your interfaces.
	C. You want to share code among several closely related classes.
	D. You want to declare non-static on non-final fields.
	E. You want to take advantage of multiple inheritance of type.
	
	Answer: B,E
	
	Reference: https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
	
	A. is wrong. You expect that classes that extend your abstract class have many common methods or fields, 
		or require access modifiers other than public (such as protected and private). 
		
	B. is correct. You expect that unrelated classes would implement your interface. 
		For example, the interfaces Comparable and Cloneable are implemented by many unrelated classes.
		
	C. is wrong. Abstract classes can share code among several closely related classes.
	
	D. is wrong. Use Abstract classeas if you want to declare non-static or non-final fields. 
		This enables you to define methods that can access and modify the state of the object to which they belong.
		
	E. is correct. The Java programming language supports multiple inheritance of type, 
		which is the ability of a class to implement more than one interface. 
		Read more 
		https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html
		https://docs.oracle.com/javase/tutorial/java/IandI/interfaceAsType.html
	 */
}
