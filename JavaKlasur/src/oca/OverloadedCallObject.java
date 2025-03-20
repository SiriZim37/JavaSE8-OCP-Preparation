package oca;

class MyAnimal {}
class Horse extends MyAnimal{}
class UseAnimal {
	void callAnimal(MyAnimal n) {
		System.out.println("Animal");
	}
	void callAnimal(Horse n) {
		System.out.println("Horse");
	}
}
public class OverloadedCallObject {

	
	   public static void main(String[] args) {

		   UseAnimal obj = new UseAnimal();
		   MyAnimal a = new MyAnimal();
		   Horse h = new Horse();
		   
		   // Call base on Referenz
		   obj.callAnimal(a);
		   obj.callAnimal(h);
		   
		   MyAnimal animalFromHorse = new Horse();
		   // Call base on Referenz
		   obj.callAnimal(animalFromHorse);    // Animal > because type of animal 
	    }




}
