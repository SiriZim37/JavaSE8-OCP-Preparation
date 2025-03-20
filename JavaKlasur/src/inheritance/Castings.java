package inheritance;

import java.util.ArrayList;

class MyList extends ArrayList<String> implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

public class Castings {

	public static void main(String[] args) {

		
		/*
		 * Casting kompiliert nicht bei Geschwisterklassen
		 * 
		 * Casting zw. Klasse und Interface geht.
		 * (Es gibt nichtprüfungsrelevante Ausnahmen)
		 *  
		 */
		
		Integer v1 = null ; 
		Double v2 = null ; 
		
//		v1 = (Integer)v2 ; 	// Geschwisterklasse wird nicht kompilieren
//		v2 = (Double)v1;	// Geschwisterklasse wird nicht kompilieren
		
		Runnable v3 = null;		// Interface! 
		ArrayList<String> v4 = new MyList();
		
		v3 = (Runnable)v4;	// Casting zw. Klasse und Interface
		
		/*
		 * Casting für Compiler : betrachte die Referenz
		 * an der Cast-Stelle als eine von Referenz vom
		 * anderen Typ
		 * 
		 * Casting übersetzt : 
		 * wenn das Objekt nicht vom versprochenen Typ ist , 
		 * wird die ClassCastException generiert
		 */
		
		v4 = new ArrayList<>();
		v3 = (Runnable)v4;	// ClassCastExeption
		
//		v4.run();	// cf : ArrayList hat keine run()
		((Runnable)v4).run();
		
		String s = null;
		Object o = s;    // Upcasting : String เป็น subclass ของ Object
		// String s1 = (Object)s;    // ไม่ถูกต้อง : เพราะพยายามแคสต์ Object ไปเป็น String โดยตรง ซึ่งต้องใช้การแคสต์แบบเฉพาะเจาะจง
		String s1 = (String) o;    // Downcasting : ถูกต้อง เนื่องจากทำการแคสต์จาก Object ไปยัง String
	}

}
