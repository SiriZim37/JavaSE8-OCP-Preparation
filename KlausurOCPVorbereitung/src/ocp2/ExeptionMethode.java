package ocp2;

class FuelNotAvailException extends Exception {   }
class VehicleDD   {
	protected void ride() throws Exception  {    //line n1
       System.out.println("Happy Journey!");
   }
}
class SolarVehicle extends VehicleDD   {
   public void ride () throws Exception   {        //line n2
       super.ride();
   }
}
public class ExeptionMethode {
	
	public static void main(String[] args) throws FuelNotAvailException, Exception  {
		VehicleDD v = new SolarVehicle ();
		    v.ride();
	}
	
	/*
	class FuelNotAvailException extends Exception {   }
	class Vehicle   {
	   void ride() throws FuelNotAvailException  {    //line n1
	       System.out.println("Happy Journey!");
	   }
	}
	class SolarVehicle extends Vehicle   {
	   public void ride () throws Exception   {        //line n2
	       super ride ();
	   }
	}

	public static void main(String[] args) throws FuelNotAvailException, Exception  {
		 Vehicle v = new SolarVehicle ();
		    v.ride();
	}
	
	 Which modification enables the code fragment to print Happy Journey!?
	 A. Replace line n1 with public void ride() throws FuelNotAvailException   {
	 B. Replace line n1 with protected void ride() throws Exception   {
	 C. Replace line n2 with void ride() throws Exception   {
	 D. Replace line n2 with private void ride() throws FuelNotAvailException   {
 
 
	
	 คำตอบที่ถูกต้อง:
	 	B. Replace line n1 with protected void ride() throws Exception
		ข้อนี้ถูกต้อง! การเปลี่ยน n1 ให้เป็น protected void ride() throws Exception ในคลาส Vehicle จะทำให้ SolarVehicle 
		สามารถโอเวอร์ไรด์เมธอดนี้ได้ตามที่ต้องการโดยการโยน FuelNotAvailException เนื่องจากการใช้ protected ทำให้คลาสย่อยสามารถเข้าถึงได้
	
	
	--------------------------------------------------
	C. Replace line n2 with void ride() throws Exception
		ข้อนี้ไม่ถูกต้อง เพราะการใช้ throws Exception ในคลาสย่อยจะขัดแย้งกับข้อกำหนดที่ว่าเมธอดในคลาสย่อยต้องโยนข้อยกเว้นที่แคบกว่า (หรือเท่ากับ) คลาสพาเรนต์
	D. Replace line n2 with private void ride() throws FuelNotAvailException
		ข้อนี้ไม่ถูกต้อง เพราะการใช้ private ในการโอเวอร์ไรด์เมธอดจะทำให้เมธอดใน SolarVehicle ไม่สามารถเข้าถึงได้จาก Vehicle หรือที่อื่น ๆ ซึ่งทำให้ไม่สามารถใช้เมธอดนี้ได้
	A. Replace line n1 with public void ride() throws FuelNotAvailException
		ข้อนี้ไม่ถูกต้องเพราะการเปลี่ยน n1 โดยให้ ride() ใน Vehicle เป็น public เป็นการแก้ไขที่ไม่จำเป็นเนื่องจากเมธอดในคลาสพาเรนต์แล้วเป็น void และไม่มีปัญหากับการเข้าถึง

	 */
}
