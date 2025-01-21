package ocp2;

import java.util.Optional;

class Employee  {
    Optional<Address> address;
    Employee (Optional<Address> address)   {
        this.address = address;
    }
 public  Optional<Address> getAddress()   {   return address;   }
 }
 class Address   {
    String city = "New York";
    public String getCity()  {   return city;   }
    public String toString()    {
        return city;
    }
 }
 
public class OptionalIsPresentTest {

	public static void main(String[] args) {
		 Address address = null;
		 Optional<Address> addrs1 = Optional.ofNullable (address);
		 Employee e1 = new Employee (addrs1);
		 String eAddress = (addrs1.isPresent()) ? addrs1.get().getCity() :"City Not available";
		
	}
	/*
	 	What is the result?
		A. New York
	 	B. City Not available
		C. null
		D. A NoSuchElementException is thrown at run time
		
		// B is correct 
		 สรุปผลลัพธ์:
		เนื่องจาก address เป็น null, Optional.ofNullable(address) จะคืนค่า Optional.empty().
		เมื่อตรวจสอบว่า Optional นี้มีค่าอยู่หรือไม่ (ด้วย isPresent()), จะได้ false และทำให้ข้อความ "City Not available" ถูกเลือกและพิมพ์ออกมา.
		ดังนั้น ผลลัพธ์ที่ได้คือ B. City Not available.
	*/
}
