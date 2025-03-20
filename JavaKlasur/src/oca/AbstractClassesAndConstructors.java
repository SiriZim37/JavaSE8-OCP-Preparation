package oca;


abstract class A {
     A() {
        System.out.println("A's constructor");
    }
    
     abstract void display();
}

class B extends A {
	
    B() {
        System.out.println("B's constructor");
    }
    
    @Override
    void display() {
        System.out.println("Display in B");
    }
}

public class AbstractClassesAndConstructors {
    public static void main(String[] args) {
        B obj = new B();
        obj.display();
    
    
    // Aufgabe : A's constructor  B's constructor Display in B
    
   }
}


