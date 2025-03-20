package enums.wdh;

enum OS{
	LINUX , MAX , WINDOWS
}

class MyOS{
	
}

public class B04_enumMitSwitch {
	
	static final OS caseKonstanten = OS.WINDOWS;

	public static void main(String[] args) {


		OS v1 = OS.LINUX;
		
		switch (v1) {
			case LINUX : 
				System.out.println("Linum ist toll");
				break;
				// case OS.MAC : // cf : nur einfacher relaubt
		
		}
		
		/*
		 * mit 'normalen 'Klassen
		 * funktioniert die switch gar nicht :
		 */
		
		MyOS v2 = new MyOS() ;
//		switch (v2) {	 // cf : Typ MyOS ist 'normale 'Klasse
//		
//		}

	}

}
