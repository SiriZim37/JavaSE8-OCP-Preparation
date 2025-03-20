package aufgaben;

public class AufgabeKontrollstrukturenSwitch {
	
	public static void main(String[] args) {
		a1a2();
		a3();
	}
	
	static void a3() {
		System.out.println("\n*** Aufgabe A3");
		
		char ch = '?';
		
		if(ch < 'a' || ch > 'z') { // falls es kein eng. Kleinbuchstabe ist:
			System.out.println(ch + " ist kein englischer Kleinbuchstabe");
		} else { // ansonsten den eng. Kleinbuchstaben analysieren
			switch(ch) {
				case 'a':
				case 'o':
				case 'u':
				case 'e':
				case 'i':
					System.out.println(ch + " ist ein Vokal");
					break;
				default:
					System.out.println(ch + " ist ein Konsonant");
			}
		}
	}
	

	/*
	 * A1, A2
	 */
	static void a1a2() {
		System.out.println("*** Aufgaben A1 und A2");
		
		for(char ch = 'a'; ch<='z'; ch++) {
			switch(ch) {
				case 'a':
				case 'o':
				case 'u':
				case 'e':
				case 'i':
					System.out.println(ch + " ist ein Vokal");
					break;
				default:
					System.out.println(ch + " ist ein Konsonant");
			}
		}
	}

}
