package ocpexam;

public class ExceptionTest1 {

	/*
	 
	 Given: **** FOUND IN OCP 

		class FuelNotAvailException extends Exception { }
		
		class Vehicle {
		
		void ride() throws FuelNotAvailException {//line n1
		
		System.out.println(''Happy Journey!'');
		
		}
		
		}
		
		class SolarVehicle extends Vehicle {
		
		public void ride () throws FuelNotAvailException {//line n2
		
		super ride ();
		
		}
		
		}
		
		and the code fragment:
		
		public static void main (String[] args) throws Exception {
		
		Vehicle v = new SolarVehicle ();
		
		v.ride();
		
		}
		
		Which modification enables the code fragment to print Happy Journey!?
		
		Options
		A	Replace line n1 with public void ride() throws FuelNotAvailException {
		B	Replace line n1 with protected void ride() throws Exception {
		C	Replace line n2 with void ride() throws Exception {
		D	Replace line n2 with private void ride() throws FuelNotAvailException {
		
		Answer
		C

	 */
}
