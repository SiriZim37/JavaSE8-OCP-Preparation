package enums.wdh;


/*
 * 	class ???? extends Element{	// die KLasse , die von Element erbt, dann enhlät alle Element
 * 		public String toString(){
 * 			return "<" + name() + ">";
 * 		}
 * 	}
 */

enum Element{
	ERDE , 
	WASSER{ 	// spezielle Lösung für das Wasser-Objekt
		
		// diese toString gibt es nur für das WASSER-Objekt
		public String toString() { 
			return "<" + name() + ">" ;
		}
	} ,
	FEUER,
	LUFT {
		// diese getValue gibt es nur für das LUFT-Objekt
		@Override
		public int getValue() {  // erbt getValue von Basisklaase ( Element)
			return super.getValue() * 1000 ;
		}
		
		int att = 1000;	// gültig nut in der spezielle Lösung für LUFT
		void m() {}		// gültig nut in der spezielle Lösung für LUFT
	};
	
	/*
	 * Überschreiben der toString für alle Konstanten 
	 * der enum-KLasse , die keine weitere eigene Überschreibung
	 * für die toString haben.
	 */
	@Override
	public String toString() {
		return name().charAt(0) +  super.name().substring(1).toLowerCase() ;
	}
	
	/*
	 * Definition der getValuefür alle Konstanten 
	 * der enum-KLasse , die keine weitere eigene Überschreibung
	 * für die getValue haben.
	 */
	public int getValue() {
		return ordinal();
	}
}

/*
*  - enum-KLasse darf nicht erweitert werden. 
*    Ausnahme : eine spezielle Art einer annonymen Klasse 
*    innerhalb der enum KLasse (s. Bsp. 07)
 */

public class B07_enumUndUeberschreiben {

	public static void main(String[] args) {

		for(Element e : Element.values()) {
			System.out.println(e + " " +  e.getValue());
		}

	}

}
