package methoden;

public class B04_Parameter {

	public static void main(String[] args) {
		addAndPrint(2, 3); 	 // 2 + 3
		addAndPrint(17, -5); // 17 + -5
		
		int x = 5;
		byte y = 6;
		addAndPrint(x, y);
	}

	/*
	 * - Die Methode hat in der Parameterliste zwei Parameter: a und b
	 * - Beim Aufruf der Methode muss man beide Parameter initialisieren:
	 * 		Der Aufruf dieser Methode braucht zwei Argumente
	 * 		(sie müssen beim Aufruf übergeben werden) 
	 */
	static void addAndPrint(int a, int b) {
		// int a = 17;
		// int b = 33;
		
		System.out.println(a + " + " + b + " = " + (a+b));
	}
}
