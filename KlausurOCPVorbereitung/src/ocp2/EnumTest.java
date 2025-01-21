package ocp2;




public class EnumTest {
	/*
	enum USCurrency   {
		   PENNY (1),
		   NICKLE(5),
		   DIME (10),
		   QUARTER(25);
		   private int value;
		   public USCurrency(int value)   {
		       this.value = value;
		   }
		   public int getValue()    {return value;}
		}
	
	   public static void main (String[] args)   {
	       USCurrency usCoin = new USCurrency.DIME;
	       System.out.println(usCoin.getValue()):
	   }
	 */
	/*
	 * Which two modifications enable the given code to compile? (Choose two.)
		A. Nest the USCurrency enumeration declaration within the Coin class.
		B. Make the USCurrency enumeration constructor private.
		C. Remove the new keyword from the instantion of usCoin.
		D. Make the getter method of value as a static method.
		E. Add the final keyword in the declaration of value.
	
	 */
	   
	   /*
	    B. Make the USCurrency enumeration constructor private.
		ใน enum การใช้คอนสตรัคเตอร์เพื่อกำหนดค่าให้กับค่าของ enum เป็นสิ่งที่ถูกต้อง และใน Java enum ทุกตัวจะมีคอนสตรัคเตอร์ที่เป็น private โดยอัตโนมัติ
		คอนสตรัคเตอร์ของ enum จะถูกใช้ภายในตัว enum เท่านั้น และไม่สามารถสร้างอ็อบเจกต์ของ enum ได้โดยตรงจากภายนอก (การใช้ new จะไม่สามารถทำได้) ดังนั้นในกรณีนี้ ไม่จำเป็นต้องเปลี่ยนแปลงคอนสตรัคเตอร์ให้เป็น private เพราะมันถูกทำไว้อยู่แล้ว
		แต่คำตอบ B เป็นการบอกว่า การสร้าง enum จากภายนอกไม่สามารถทำได้โดยไม่เปลี่ยนคอนสตรัคเตอร์เป็น private ซึ่งเป็นข้อกำหนดพื้นฐานของ enum อยู่แล้ว
		
		C. Remove the new keyword from the instantiation of usCoin.
		ในกรณีของ enum การสร้างอ็อบเจกต์ไม่จำเป็นต้องใช้ new โดยตรงเหมือนกับการสร้างอ็อบเจกต์ของคลาสปกติ
		การใช้งาน enum จะต้องเรียกใช้ค่าของ enum โดยตรง เช่น USCurrency.DIME แทนที่จะใช้ new USCurrency.DIME
		ดังนั้น การลบ new ออกจะทำให้โค้ดสามารถคอมไพล์ได้ ซึ่งคำตอบ C จึงถูกต้อง
		สรุป:
		คำตอบ B และ C ถูกต้อง:
		B: การสร้างคอนสตรัคเตอร์ของ enum ให้เป็น private เป็นการตั้งค่าโดยอัตโนมัติใน enum อยู่แล้ว ซึ่งไม่จำเป็นต้องเปลี่ยนแปลงเพิ่มเติม
		C: การใช้ enum จะต้องเรียกค่าของ enum โดยตรง ไม่ต้องใช้ new
	    */
	
	
	enum USCurrency   {
		   PENNY (1),
		   NICKLE(5),
		   DIME (10),
		   QUARTER(25);
		   private int value;
		   private USCurrency(int value)   {
		       this.value = value;
		   }
		   public int getValue()    {return value;}
		}
	
	   public static void main (String[] args)   {
	       USCurrency usCoin = USCurrency.DIME;
	       System.out.println(usCoin.getValue());
	   }
}
