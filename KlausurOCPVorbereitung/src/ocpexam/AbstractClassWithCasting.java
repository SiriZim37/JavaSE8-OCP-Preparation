package ocpexam;


abstract class A {
    abstract void show();
}

class B extends A {
    @Override
    void show() {
        System.out.println("Class B");
    }
}

class C extends A {
    @Override
    void show() {
        System.out.println("Class C");
    }
}


public class AbstractClassWithCasting {

    public static void main(String[] args) {
        A a = new B();    // Line 1
        C c = new C();    // Line 2
        A bb = (C) a;     // Line 3

        a.show();
        c.show();
        bb.show();

    }
    /*
	Options:
	a) Compilation Error at Line 3
	b) Class B, Class C, Class C
	c) Class B, Class C, Class B
	d) Class C, Class C, Class C
	
	Answer Explanation:
	Line 1 (A a = new B();): This is valid. a is a reference of type A that points to an object of class B. Java allows polymorphism, where a superclass reference can point to a subclass object.
	
	Line 2 (C c = new C();): This is valid. c is a reference of type C that points to an object of class C.
	
	Line 3 (A bb = (C) a;): This line causes a ClassCastException at runtime. a is an instance of B,
	 but you're trying to cast it to C. Since B and C are not in the same class hierarchy 
	 (they both extend A but are not related to each other directly), this cast is invalid. 
	 This will cause a ClassCastException when the program runs.
	
	Option a): Correct. The cast A bb = (C) a; will cause a Compilation Error because the type of a (which is B) cannot be cast to type C.
	Output of a.show(), c.show(), and bb.show():
	
	a.show() will print "Class B" because a refers to an object of type B.
	c.show() will print "Class C" because c refers to an object of type C.
	bb.show() will throw a ClassCastException, as the cast in Line 3 is invalid.
	Correct Answer:
	a) Compilation Error at Line 3
     */
}