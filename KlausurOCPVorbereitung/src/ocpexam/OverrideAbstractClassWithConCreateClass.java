package ocpexam;

abstract class Animal {
    abstract void sound(); // Abstract method to be implemented by subclasses

    // Overloaded method with a different parameter type
    abstract void sound(int times);
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }

    @Override
    void sound(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Bark");
        }
    }

    // Overloaded method with a String parameter
    void sound(String type) {
        System.out.println(type + " barks");
    }

    // Overloaded method with both String and int parameters
    void sound(String type, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(type + " barks");
        }
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }

    @Override
    void sound(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Meow");
        }
    }

    // Overloaded method with a String parameter
    void sound(String type) {
        System.out.println(type + " meows");
    }
}


public class OverrideAbstractClassWithConCreateClass {

	  public static void main(String[] args) {
	        Animal dog = new Dog();
	        dog.sound(); // Bark
	        dog.sound(3); // Bark, Bark, Bark
	        ((Dog) dog).sound("bulldog"); // bulldog barks
	        ((Dog) dog).sound("bulldog", 2); // bulldog barks bulldog barks

	        Animal cat = new Cat();
	        cat.sound(); // Meow
	        cat.sound(2); // Meow Meow
	        ((Cat) cat).sound("persian"); // persian meows
	   }
}
