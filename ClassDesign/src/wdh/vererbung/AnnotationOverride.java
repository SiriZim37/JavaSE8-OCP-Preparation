package wdh.vererbung;

public class AnnotationOverride {

	/*
	 * Die Annotation @Override schalten nur eine weitere
	 * Compiler-Kontrolle ein : 
	 * 
	 * Der Compiler überprüft , ob wirklich eine 
	 * Überschreibung / implementierung ist.
	 * D.h es wird überprüft , ob ein Basistyp die Methoden 
	 * mit derselben Signatur hat
	 */
	public static void main(String[] args) {
		

	}
	/*
	 * gültige Java-Methode
	 */
	private Integer getValue() {
		return 42;
	}
	/*
	 * gültige Java-Methode
	 */
//	@Override
//	public String getText() {  // cf : es ist kein Überschreiben
//		return super.toString();
//	}
	
	/*
	 * gültige Java-Methode.
	 * Der Entwickler wollte überschreiben , hat sich aber vertippt:
	 */
	
	@Override
	public int hashCode() {
		return 22;
	}
	
	/*
	 * gültige Java-Methode.
	 * Der Entwickler wollte toString() , überschreiben ,
	 * hat sich aber vertippt.
	 */
//	@Override
//	public String ToString() { / cf : es ist kein Überschreiben , der Fehler wird ....
//		return "moin";
//	}
	
	

}
