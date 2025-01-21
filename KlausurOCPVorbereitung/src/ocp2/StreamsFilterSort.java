package ocp2;

import java.util.Arrays;
import java.util.List;

public class StreamsFilterSort {

	public static void main(String[] args) {

			 List<String> empDetails = Arrays.asList("100, Robin, HR",
			                                    "200, Mary, AdminServices",
			                                    "101, Peter, HR");
			 empDetails.stream()
					    .filter(s-> s.contains("1"))
					    .sorted()
					    .forEach(System.out::println); //line n1
			
			 /*
			  What is the result?
				 A. 100, Robin, HR
				 	101, Peter, HR
				 B. A compilation error occurs at line n1.
				 C. 100, Robin, HR 101, Peter, HR
				 	200, Mary, AdminServices
				 D. 100, Robin, HR
				 	200, Mary, AdminServices
				 	101, Peter, HR

			  */
			 
			 
			 /*
			 	empDetails: สร้างลิสต์ข้อมูลพนักงาน 3 คนที่ประกอบด้วย ID, ชื่อ, และแผนก.
				empDetails.stream(): แปลงลิสต์เป็นสตรีมเพื่อใช้ Stream API.
				filter(s -> s.contains("1")): กรองข้อมูลเพื่อเลือกเฉพาะที่มีเลข "1" ในสตริง.
				sorted(): เรียงลำดับข้อมูลที่กรองแล้วตามลำดับตัวอักษร.
				forEach(System.out::println): พิมพ์ข้อมูลที่กรองและเรียงลำดับแล้วออกทางหน้าจอ.
				ผลลัพธ์:
				
				Code kopieren
				100, Robin, HR
				101, Peter, HR
				คำตอบที่ถูกต้อง: A.
			  */
			 
	}	
}
