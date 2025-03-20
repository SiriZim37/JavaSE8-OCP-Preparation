package classes;


class Rechteck {
	int breite , hoehe;
	
	public String toString() {
		return "Rechteck (" + breite + " X "+ hoehe +  ")";
	}
}

public class B04_toString {

	/*
	 *  Wenn Sie Sie in Ihrer Klasse die Methode
	 *  
	 *  	public String toString()
	 *  definieren , kann die Textdarstellen 
	 *  dieser Klasse bequem erhalten
	 * 
	 */
	public static void main(String[] args) {

		Rechteck r = new Rechteck();
		
		//einfach :
		String text = r.toString();  // bequem arbeiten , schreiben 
		System.out.println(text);	 // Rechteck ( 0 X 0)
		
		// noch einfacher :
		System.out.println(r);
	
		
	

	}

}
