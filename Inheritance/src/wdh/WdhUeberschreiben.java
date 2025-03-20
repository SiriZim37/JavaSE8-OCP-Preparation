package wdh;

class Auto{
	void fahren() {}
	protected int bremsen(int x) { return 0;}
	
}

class VW extends Auto{
	private int fahren(int x) { return 3 ;} // Überladen: Kein Problem
	
//	int bremsen(int param) { return 0;} // cf : Sichtbarkeit verschärft
	
	@Override
	protected int bremsen(int param) { return 0; } // Überschreiben mit gleicher oder weniger restriktiver Sichtbarkeit
} 

class Opel extends Auto { 
	
	public void fahren() {}  //  Sichtbarkeit nicht verschärfen

//	int bremsen( int name) { return 7 ; }; // cf :  Sichtbarkeit verschärft
//	public byte bremsen( int name) { return 7 ; }; // cf :  Rückgabetyp  geändert.
	
}




public class WdhUeberschreiben {

	public static void main(String[] args) {
		
		/*
		 * - Regeln beim Überschreiben : ( wird kein Exeception)
		 * 
		 * 		1. Sichtbarkeit nicht verschärfen  //  Do not increase visibility Public > protected > default >private
		 * 		2. Rückgabetyp nicht ändern. (Kovarianz ist ok)
		 * 		3. Zusätzliche checked Exceptions nicht deklarieren.
		 * 		
		 */
		
		
		/*
		 * Sichtbarkeiten :
		 * 		
		 * 		public 
		 * 		protected
		 * 		'pakage private' oder 'default'
		 * 		private
		 */

	}

}
