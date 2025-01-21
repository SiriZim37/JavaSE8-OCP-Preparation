package ocp2;

public class ExceptionDup {

	static void doStuff() throws ArithmeticException, NumberFormatException, Exception   {
		      if (Math.random() >-1 )throw new Exception ("Try again");
}
	public static void main(String[] args) {			 
		/*
		try {
			      doStuff ( );
		} catch (ArithmeticException | NumberFormatException | Exception e )  {
			     System.out.println (e.getMessage()); }
			 catch (Exception e)    {
			     System.out.println (e.getMessage()); }
		}
		*/

	}
	
	/*
	 *  Which modification enables the code to print Try again?
		 A. Comment the lines 28, 29 and 30.
		 B. Replace line 26 with:
		 } catch (Exception | ArithmeticException | NumberFormatException e) {
		 C. Replace line 26 with:
		 } catch (ArithmeticException | NumberFormatException e) {
		 D. Replace line 27 with:
		 throw e
		 
		 โค้ดนี้ ไม่สามารถคอมไพล์ได้ เพราะโครงสร้าง catch มีข้อขัดแย้งในการจัดการข้อยกเว้น:

		catch (ArithmeticException | NumberFormatException | Exception e) (ที่บรรทัด 26)
		Exception เป็น superclass ของ ArithmeticException และ NumberFormatException
		Java ไม่อนุญาตให้ใช้ตัวเลือก | ใน catch ที่มีความสัมพันธ์แบบ superclass-subclass เพราะจะทำให้เกิดความซ้ำซ้อน (Duplicate catch block)
	 */
}
