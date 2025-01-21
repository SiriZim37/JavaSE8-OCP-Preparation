package ocp;

public class HashCodeAndEqual {

	public static void main(String[] args) {
		/*
		 x = 0;
		 if (x1.hashCode() != x2.hashCode() )  x = x + 1;  		// หมายความว่า x1 และ x2 มี hashCode ต่างกัน
		 if (x3.equals(x4) == false ) x = x + 10;				//หมายความว่า x3 และ x4 ไม่เท่ากัน
		 if (x5.equals(x6) == true ) x = x + 100;				//หมายความว่า x5 และ x6 เท่ากัน
		 if (x7.hashCode() == x8.hashCode() )  x = x + 1000;	//หมายความว่า x7 และ x8 มี hashCode เท่ากัน
		 System.out.println("x = " + x);
		 

		A.x2.equals(x1) == true
		B.x3.hashCode() != x4.hashCode()
		C.x5.hashCode() == x6.hashCode()
		D.x8.equals(x7) == true


		คำตอบ C: x5.hashCode() == x6.hashCode()
		เหตุผล: เมื่อ x5.equals(x6) == true สัญญา (contract) ของ equals() และ hashCode()
		ใน Java กำหนดไว้ว่าถ้า equals() คืนค่า true ค่า hashCode() ของออบเจ็กต์ทั้งสองต้องเท่ากันเสมอ
		 
		คำตอบอื่นไม่ถูกต้องเพราะไม่ได้รับประกันตามสัญญาของ equals() และ hashCode().
		
		*/
	
	}
}
