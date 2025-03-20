package vererbung;

class MassageApp { /* extends Object  (explizit)*/
	
}

class Skype extends MassageApp{
	
}

class Telegram extends MassageApp{
	
}

//class MyApp1 extends Skype extends Telegram {} // cf
//class MyApp2 extends MassageApp , Telegram {} // cf
//class MyApp2 extends Skype extends Telegram {} // cf

public class B02_Begriffe {
	
	/*
	 * 
	 *  Eine Java-Klasse darf in Java nur eine andere Klasse erweitern!
	 *  Eine Java-Klasse darf in Java nur eine andere Klasse erweitern!
	 *  Eine Java-Klasse darf in Java nur eine andere Klasse erweitern!
	 *  
	 *  
	 *	MessageApp ist Basisklasse für Skype und Telegram
	 *	(Basisklasse wird seltener als Parent- bzw. Vater-Klasse bezeichnet)
	 * 
	 * Skype ist abgeleitete Klasse (von MessageApp abgeleitete Klasse)
	 * Telegram ist abgeleitete Klasse (von MessageApp abgeleitete Klasse)
	 * 
	 * Skype und Telegram sind Geschwisterklassen
	 * 
	 * Skype erbt von MessageApp
	 * Telegram erbt von MessageApp
	 * 
	 * MessageApp vererbt an Skype und Telegram (die Realisierungen)
	 * 
	 * Mit extends entsteht eine IS-A-Beziehung:
	 * 		Skype IS-A MessageApp
	 * 		Telegram IS-A MessageApp
	 * 
	 * ----
	 * Object ist die Basisklasse für MessageApp.
	 * MessageApp erbt von Object.
	 * 
	 * 		MessageApp IS-A Object.
	 * 
	 * 		Skype IS-A MessageApp IS-A Object
	 * 		Telegram IS-A MessageApp IS-A Object
	 */
	public static void main(String[] args) {

		
		
		Skype s1 = new Skype();
		int hash1 = s1.hashCode(); 	// Methode, geerbt aus MessageApp (die von Object erbt)
		String str1 = s1.toString();// Methode, geerbt aus MessageApp (die von Object erbt)
		boolean res1 = s1.equals(s1);// Methode, geerbt aus MessageApp (die von Object erbt)
	}

}
