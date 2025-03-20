package variablen;

public class BezeichnerOderIdentifer {
	/*
	 *  - Bezeichner dürfen keine Schlüsselwörter sein
	 *  
	 *  - Bezeichner dürfen bestehen aus (consist of)
	 *  	# Buchstaben
	 *  	# Ziffern (aber nicht vorne) z.B. int x2 , x1 ; 
	 *  	# Unterstrich
	 *  	# Währungsysmbole
	 */
	public static void main(String[] args) {
		
	// int class 3 ;  << cf: Schlüßelwort als Bezeichner >> complile Error!! 
		int x;
		int aBcD;
		int öäüß;   // <<< Nicht-englishe Buchstaben für die Praxis nicht empfohlen.
		int greekWord;   // <<< Nicht gegen Java-Reglen aber nicht empfohlen.
		
	//	int 1x;     // cf: Ziffer vorne (es kann Nicht kompilieren) 
				    //- Syntax error on token "1", delete this token Duplicate local variable x
		int x1;
		
		int _ = 3;  // Komilliert in Java 8 , für die Praxis Nicht empfohlen. 
		int __;     // Kompilliert in jeder-Version , für die Praxis Nicht empfohlen.
					/* Für Java 8 '_' should not be used as an identifier, 
			           since it is a reserved keyword from source level 1.8 on
			         */
		int $;      //für die Praxis Nicht empfohlen. 
		int €;	 	//für die Praxis Nicht empfohlen. 
//		int §;	    // cf: 
		
//		int a.b; // cf: Sonderzeichen im Namen
//		int a*b; // cf: Sonderzeichen im Namen
//		int a%b; // cf: Sonderzeichen im Namen
//		int a#b; // cf: Sonderzeichen im Namen
		
		
		
		
	}
}
