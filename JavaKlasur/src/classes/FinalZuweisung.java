package classes;


public class FinalZuweisung {
	int x = 5 ;
	public static void main(String[] args) {
		final FinalZuweisung f1 = new FinalZuweisung(); // Da f1 als final deklariert ist, 
														// kann die Referenz von f1 nicht geändert werden.
//		f1.x = 10;	//ok								// Aber die Eigenschaften des Objekts selbst (wie x) können geändert werden.
//		x = 3; // cf : 
		FinalZuweisung f2  = new FinalZuweisung();
		FinalZuweisung f3 = FizzStwich(f1, f2);
		System.out.println((f1==f3) + " " + (f1.x == f3.x ));
		
		System.out.println(f1.x + " " + f3.x ); 
		

	}
	

	static FinalZuweisung FizzStwich(FinalZuweisung x , FinalZuweisung y ) {
		final FinalZuweisung  z = x; // final , kann nur einmal zuweisen.
		z.x = 6;	// Obwohl z final ist, darfst du die Eigenschaften des Objekts, auf das z zeigt, ändern.
		return z;
	}
}
