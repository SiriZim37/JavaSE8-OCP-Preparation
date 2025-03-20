package classes;

import java.util.ArrayList;
import java.util.List;

/*
 * Entwickler Tom.
 * 
 * Aufgabe  : Klasse Fortress entwicklen,
 * die Zahlen speichert. Wichtig ist dass die gespeicherte Zahlen 
 * nicht aus Versehen geändert/gelöscht werden.
 */
class Fortress {
	private List<Integer> list; 
	
//	public Fortress(List<Integer> list) {
//		this.list = list;			// Not secure
//	}
	
	public Fortress(List<Integer> list) {
		this.list = new ArrayList<Integer>(list) ; 	// // Kapselung ( Die Kopie liefert zurück. ( nicht Addresse))
	}
	
	public void addToList(int x ) { list.add(x); }
	
//	public List<Integer> getListNotSecure(){	// nicht Kapselung
//		return list;
//	}
	
	public List<Integer> getList(){
		return new ArrayList<Integer>(list);	// Kapselung ( Die Kopie liefert zurück. ( nicht Addresse))
	}
	
	public String toString() {
		return list.toString();
	}
}

/*
 * Entwickler Jerry 
 */
public class Kapselung {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		Fortress f = new Fortress(list);
		
		f.addToList(12);
		f.addToList(13);
		f.addToList(14);
		System.out.println("1. " + f);
		/*
		 * Alles (außer addToList-Methode) versuchen , 
		 * um das Fortress-Objekt zu ändern. 
		 */
		
//		f.getList().getListNotSecure(2);	// 		
//		f.getList().remove(2);	// Kann nicht andern (Wegen der Kapselung)
//		list.remove(2);
		
		System.out.println("list. " + list);
		System.out.println("2. " + f);
		
	}

}
