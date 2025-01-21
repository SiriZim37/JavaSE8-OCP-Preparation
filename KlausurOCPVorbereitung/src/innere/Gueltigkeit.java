package innere;


class A {}
public class Gueltigkeit {

	static int x = 12;

	public static void main(String[] args) {
		
		System.out.println(x); // 12
		String x = "mo";
		
		System.out.println(x); // mo 
		System.out.println(Gueltigkeit.x);

		
		A v1; // innere Klasse A
		innere.AllesUeberthis v11; // Toplevel-Klasse A
		
		class A {}
		
		A v2; // lokale Klasse A
		Gueltigkeit.A v22; // innere Klasse
		innere.AllesUeberthis v222; // Toplevel-Klasse A
		
	} // end of main

	class A {}
}

