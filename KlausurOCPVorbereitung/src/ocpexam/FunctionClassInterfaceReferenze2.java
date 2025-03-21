package ocpexam;


interface Rideable {Car getCar (String name); }

class Car {	
	
	private String name;
	
	public Car (String name) {
		this.name = name;
	}
}

public class FunctionClassInterfaceReferenze2 {

	public static void main(String[] args) {
		
		Rideable rider = Car :: new;
		Car vehicle = rider.getCar("MyCar");
		
		//A
		//Car auto = Car("MyCar"):: new;
		
		//B
		/*Car auto = Car :: new;
		Car vehicle = auto :: getCar("MyCar");*/
		
		//C
		/*Rideable rider = Car :: new;
		Car vehicle = rider.getCar("MyCar");*/
		
		//D
		/*Car vehicle = Rideable :: new :: getCar("MyCar");*/

		
	}
	
	/*
	 * 
	Question No : 17

	Given:
	interface Rideable {Car getCar (String name); }
	class Car {
		private String name;
		public Car (String name) {
			this.name = name;
		}
	}

	Which code fragment creates an instance of Car?
	A. Car auto = Car (“MyCar”): : new;
	B. Car auto = Car : : new;
	Car vehicle = auto : : getCar(“MyCar”);
	C. Rideable rider = Car : : new;
	Car vehicle = rider.getCar(“MyCar”);
	D. Car vehicle = Rideable : : new : : getCar(“MyCar”);

	Answer: C
	 */
}
