package aufgaben;

public class AufgabeOperatorenSpritverbrauch {
	
	public static void main(String[] args) {
		v1();
		v2();
		v3();
		v4();
		v5();
	}
	
	static void v5() {
		System.out.println("*** V5");
		
		int getankt = 31;
		int gefahren = 780;	
		
		double verbrauch = 100.0 * getankt / gefahren;
		
		// formatieren mit System.out.format
		System.out.format("Verbrauch: %.2f Liter pro 100 Km", verbrauch);
	}
	
	static void v4() {
		System.out.println("*** V4");
		
		int getankt = 31;
		int gefahren = 780;	
		
		double verbrauch = 100.0 * getankt / gefahren;
		
		// formatieren mit String.format
		String verbrauchAlsText = String.format("%.2f", verbrauch);
		
		System.out.println("Verbrauch: " + verbrauchAlsText + " Liter pro 100 Km");
	}
	
	static void v3() {
		System.out.println("*** V3");
		
		int getankt = 31;
		int gefahren = 780;	
		
		double verbrauch = 100.0 * getankt / gefahren;
		
		System.out.println("Verbrauch: " + verbrauch + " Liter pro 100 Km");
	}

	static void v2() {
		System.out.println("*** V2");
		
		int getankt = 31;
		double gefahren = 780;	
		
		double verbrauch = getankt / gefahren * 100;
		
		System.out.println("Verbrauch: " + verbrauch + " Liter pro 100 Km");
	}
	
	static void v1() {
		System.out.println("*** V1");
		
		int getankt = 31;
		int gefahren = 780;	
		
		double verbrauch = (double)getankt / gefahren * 100;
		
		System.out.println("Verbrauch: " + verbrauch + " Liter pro 100 Km");
	}

}
