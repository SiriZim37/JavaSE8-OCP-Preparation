package exeptions;



class MeineResA implements AutoCloseable{
	public void close() {
		System.out.println("close A");
	}
}


public class B12_try_with_resources_weitere_Regeln {

	/*
	 * Automatischen Aufrufe der close-Methode gibt es beim
	 * Beendet von dem try-Block
	 * Wenn der catch-Block aktiviert wird , wird er DANACH aktiviert
	 * Wenn es den finally
	 * 
	 * โค้ดนี้แสดงตัวอย่างการทำงานของ try-with-resources
     * ที่จะปิดทรัพยากรอัตโนมัติด้วยการเรียกใช้เมธอด close()
     * เมื่อสิ้นสุดการทำงานของ try-block
     * ในกรณีที่มี catch-block หรือ finally-block
     * การปิดทรัพยากรจะเกิดขึ้นก่อนที่จะเข้าสู่ catch หรือ finally
	 */
	public static void main(String[] args) {
		
		// !! Bei der OCP Prüfung 
		// !! Bei der OCP Prüfung 
		// !! Bei der OCP Prüfung 
		// !! Bei der OCP Prüfung 
		// !! Bei der OCP Prüfung 
		// !! Bei der OCP Prüfung 
		// !! Bei der OCP Prüfung 
		
		System.out.println("*** Bsp. 1");
		/*
		 * Ausgaben :
		 * 
		 * 			1. try 
		 * 			close A
		 */
		try(MeineResA mA = new MeineResA()){
			System.out.println("1. try");
		} // r.closse() wird automatisch aufgerufen.
		
		
		
		System.out.println("\n*** Bsp. 2");
		/*
		 * Ausgaben :
		 * 
		 * 			close A
		 * 			2. catch
		 */
		try(MeineResA mA = new MeineResA()){
			throw new ArithmeticException();
		}catch(Exception e) {
			System.out.println("2. catch");
		}
			
		
		System.out.println("\n*** Bsp. 3");
		/*
		 * Ausgaben :
		 * 
		 * 			close A
		 * 			3. catch
		 * 			3. finally
		 */
		try(MeineResA mA = new MeineResA()){
			throw new ArithmeticException();
		}catch(Exception e) {
			System.out.println("3. catch");
		}finally {
			System.out.println("3. finally");
		}
		

	}

}
