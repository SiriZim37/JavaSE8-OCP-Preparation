package oca;

abstract class Animal {
    public final void makeSound() {
        System.out.println("Animal makes sound");
    }
    public  void makeSound2() {
        System.out.println("Animal makes sound");
    }
    abstract void sleep();
}

class Cat extends Animal {
    @Override
    void sleep() {
        System.out.println("Cat sleeps");
    }
    public void makeSound2() {
        System.out.println("Cat makes sound");
    }

}

public class AbstractClassAndFinalMethods {

	public static void main(String[] args) {
		Animal animal = new Cat();
        animal.makeSound();		// Animal makes sound
        animal.makeSound2();		// Cat makes sound
        animal.sleep();			// Cat sleeps

	}

}
