package klausur;

interface MyInterface {
    class InnerClass {  // Inner class ภายใน interface
        void display() {
            System.out.println("Hello from InnerClass!");
        }
    }
}

interface OuterInterface {
    interface InnerInterface {  // Inner interface ภายใน Interface
        void display();
    }
    
}

    
public class TestInterface3 {

}
