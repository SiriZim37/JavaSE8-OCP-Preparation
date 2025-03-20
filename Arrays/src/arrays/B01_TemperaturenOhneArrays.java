package arrays;

class TermparaturenFuerTag{
	
	/*
	 * 	Aufgabe ist : 24 Temperaturmessungen zu speichen , 
	 * um danach untershiedliche Analysen mit den Werten durchzuführen.
	 * 
	 * Diese Lösung ist sehr schlecht.
	 */
	int t1;
	int t2;
	int t3;
	int t4;
	//...
	int t24;
	
	int mittelwert() {
		int sum = t1+t2+t3+t4/*....*/+t24;
		return sum/24;
	}
	
	//	weitere Methoden...
}

public class B01_TemperaturenOhneArrays {

	public static void main(String[] args) {
		

	}

}
