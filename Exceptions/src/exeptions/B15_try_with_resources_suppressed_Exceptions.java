package exeptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;



class MyResouceA implements AutoCloseable{
	
	public void close() throws Exception {
		throw new RuntimeException("exc A");
	}
}

class MyResouceB implements AutoCloseable{
	
	public void close() throws Exception {
		throw new RuntimeException("exc B");
	}
}

public class B15_try_with_resources_suppressed_Exceptions {

	public static void main(String[] args) {

		System.out.println("***Bsp. 1 ");
		/*
		 * Ausgaben : 
		 * 					exc aus try	     
		 * 	(umgekehrt)		exc B
		 * 					exc A
		 */
		try (MyResouceA rA = new MyResouceA();
				MyResouceB rB = new MyResouceB();){
			
			throw new RuntimeException("exc aus try"); // wir an den cathc übergeben
			
		}catch (Exception e) {
			System.out.println(e.getMessage());  // exc aus try
			
			Throwable[] arrSuppressed =   e.getSuppressed();
			for(Throwable supp : arrSuppressed) {
				System.out.print(supp.getMessage() + " ");	// exc B exc A 
			}
		}
		
		System.out.println("\n\n*** Bsp. 2  ");
		/*
		 * Ausgaben : 
		 * 			exc A
		 */
		try (MyResouceA rA = new MyResouceA(); ){
			
		}catch (Exception e) {
			System.out.println(e.getMessage());  // exc A 
		}
		
		System.out.println("\n\n*** Bsp. 3  ");
		/*
		 * Ausgaben : (umgekehrt)
		 * 			exc B
		 */
		try (MyResouceA rA = new MyResouceA(); 
				MyResouceB rB = new MyResouceB(); ){
			
		}catch (Exception e) {
			System.out.println(e.getMessage());  // exc B
		}
		
		
		System.out.println("\n\n*** Bsp. 4  ");
		/*
		 * Ausgaben : (umgekehrt)
		 * 			exc A
		 * 			exc B
		 */	
		try ( MyResouceB rB = new MyResouceB(); 
				MyResouceA rA = new MyResouceA(); ){
			
		}catch (Exception e) {
			System.out.println(e.getMessage());  // exc A
			Throwable[] arrSuppressed = e.getSuppressed();
			for(Throwable supp : arrSuppressed) {
				System.out.print(supp.getMessage() + " ");	// exc B 
			}
		}
		
	}
	/*
	 * 
	 * Aufgaben 
	 * 		- garantiert die Ressourcen schließen
	 * 		- keine Exceptions verlieren
	 * 
	 * Ab Java 7
	 * 
	 * Wenn es eine oder mehrere Exceptions gibt , werden sie
	 * alle erhalten bleiben : eine wird die Hauptexception sein 
	 * die anderen die suppressed Exceptions
	 * 
	 * เมื่อเกิดข้อยกเว้น (Exception) หนึ่งหรือหลายตัวขึ้น 
	 * ระบบจะเก็บทุกข้อยกเว้นที่เกิดขึ้นไว้ โดยข้อยกเว้นหลัก 
	 * จะถูกบันทึกเป็น "Hauptexception" ส่วนข้อยกเว้นอื่นๆ 
	 * จะถูกบันทึกเป็น suppressed Exceptions
	 * 
	 * copy (ตั้งแต่ Java 7): ใช้ try-with-resources เพื่อปิด BufferedReader และ BufferedWriter อัตโนมัติ 
	 * โดยเมื่อใดก็ตามที่เกิดข้อยกเว้น ระบบจะเก็บทุกข้อยกเว้นไว้โดยไม่สูญเสียข้อมูลที่สำคัญ
	 */
	
	static void copy(String inputFile ,String outputFile) throws IOException {
		

		try(BufferedReader  in = new BufferedReader(new FileReader(inputFile));
				BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));) {

			 String  line;
			while( ( line = in.readLine()) != null  ) {
				out.write(line);
				out.newLine();
			}
		}
				
	}
	
	
	
	/*
	 * Vor Java 7
	 * 
	 * Aufgaben 
	 * 		- garantiert die Ressourcen schließen
	 * 		- keine Exceptions verlieren
	 * 
	 * copyOld (ก่อน Java 7): ใช้วิธีการปิดทรัพยากรใน finally แทน ซึ่งต้องเพิ่มโค้ดเพื่อจัดการข้อยกเว้นที่อาจเกิดขึ้นระหว่างการปิดทรัพยากร
	 */
	static void copyOld(String inputFile ,String outputFile) {
		
		BufferedReader in = null;
		BufferedWriter out = null;
		
		UncheckedIOException exc = null;
		try {
			 in = new BufferedReader(new FileReader(inputFile));
			 out = new BufferedWriter(new FileWriter(outputFile));
			 
			 
			 String  line;
			while( ( line = in.readLine()) != null  ) {
				out.write(line);
				out.newLine();
			}
				
		} catch (IOException e) {
			exc = new UncheckedIOException(e);
			
		}finally {
			try {
				if( in != null ) {
					in.close();
				}
			} catch (IOException e) {
				if( exc == null ) {
					exc = new UncheckedIOException(e);
				}else {
					exc.addSuppressed(e);
				}
			}
			
			try {
				if( out != null ) {
					out.close();
				}
			} catch (IOException e) {
				
			}
		}
		
		
		
	}

}
