package assertions;

import java.util.Collection;

/*
 * 	Tag 1
 */
/*
class Person{
	private String name;
	private int geburtsjahr;
	
	public Person(String name, int geburtsjahr) {
		super();
		if(name == null  || name.isEmpty()) {
			throw new IllegalArgumentException("name darf nicht null sein");
		}
		
		if(geburtsjahr < 0) {
			throw new IllegalArgumentException("geburtsjahr darf nicht negative sein.");
		}
		this.name = name;
		this.geburtsjahr = geburtsjahr;
	}
	
	
	public void setGeburtsJahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}
	
	@Override
	public String toString() {
		assert name != null; 	// Invariante name !=null
		assert geburtsjahr >= 0 ;    //Invariante geburtstag > 0 
		return String.format("Person : %s, Geboren in %d" , name , geburtsjahr);
	}
}
*/


/*
 * Tag 300.
 * 
 * Klasse Person muss aus irgenddeinem Grund angepasst werden.
 * 
 */

class Person{
	private String name;
	private int geburtsjahr;
	
	public Person(String name, int geburtsjahr) {
		super();
		if(name == null  || name.isEmpty()) {
			throw new IllegalArgumentException("name darf nicht null sein");
		}
		
		if(geburtsjahr < 0) {
			throw new IllegalArgumentException("geburtsjahr darf nicht negative sein.");
		}
		this.name = name;
		this.geburtsjahr = geburtsjahr;
	}
	
	/*
	 * neue Methode mit dem Bug
	 */
//	public void setGeburtsJahr(int geburtsjahr) {
//		// hier sollte if-Abfrage stehen :
////		if(geburtsjahr < 0) {
////			throw new IllegalArgumentException("geburtsjahr darf nicht negative sein.");
////		}
//		
//		this.geburtsjahr = geburtsjahr;
//	}
	 /*
     * Neue Methode ohne den Bug
     */
    public void setGeburtsJahr(int geburtsjahr) {
        // Hier wird die if-Abfrage aktiviert:
        if (geburtsjahr < 0) {
            throw new IllegalArgumentException("geburtsjahr darf nicht negativ sein.");
        }
        this.geburtsjahr = geburtsjahr;
    }

	@Override
	public String toString() {
		assert name != null; 	// Invariante name !=null
		assert geburtsjahr >= 0 ;    //Invariante geburtstag > 0 
		return String.format("Person : %s, Geboren in %d" , name , geburtsjahr);
	}
}

public class B01_Assertions {
	/*
	 *  Eine komplizierte Anwendung wird entwickelt.
	 *  
	 *  Entwickler Tom soll die Klasse Person entwickeln.
	 *  Person darf keine null-Name haben.
	 *  Person darf keine negatived Geburtsjahre haben
	 *  
	 *  Tom entscheidet sich die Aussertions-Technik  bei der 
	 *  Entwicklung zu werwenden.
	 *  
	 *  Tom muss dafür : 
	 *  	- Assertions immer aktivieren!
	 *  	- Davon ausgehen, dass andere Entwickler die
	 *  	  Assertions
	 */
	
	/*
	 * assert ใน Java ใช้เพื่อตรวจสอบความถูกต้องของเงื่อนไขในโค้ด 
	 * ซึ่งช่วยให้ผู้พัฒนาสามารถตรวจจับข้อผิดพลาดได้ง่ายขึ้นระหว่างการพัฒนา
	 * assert จะตรวจสอบว่าค่าเงื่อนไขที่กำหนดเป็นจริงหรือไม่ (true) 
	 * หากเงื่อนไขนั้นเป็น false โปรแกรมจะทำให้เกิดข้อผิดพลาดและหยุดการทำงาน 
	 * ซึ่งช่วยให้ผู้พัฒนาเห็นข้อผิดพลาดที่อาจเกิดขึ้นในโค้ดได้เร็วขึ้น
	 * คำสั่งนี้มักใช้ในขั้นตอนการพัฒนา แต่ในเวอร์ชันของโปรแกรมที่ถูกปล่อยออกมา 
	 * (production) คำสั่ง assert อาจถูกปิดการใช้งาน
	 */
	public static void main(String[] args) {
		
		int x = 10;
		assert x > 5 : "x ควรมากกว่า 5";
		
		Person p = new Person("Tom", 2003);
		
		p.setGeburtsJahr(-1);
		
		System.out.println(p); // soll  immer korrekt
		
		
	}
	
	/* Run Configuration : 
	 * Argumente : 
	 * 	VM : -ea  und dann Run
	 */

}
