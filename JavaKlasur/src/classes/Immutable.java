package classes;

import java.time.LocalDate;

public class Immutable {

	public static void main(String[] args) {
		
		Integer v = 12;
		v = Integer.parseInt("50");
		v = Integer.valueOf(12);
//		v = v.setValue(15);	// cf : keine setValue
		System.out.println();
		
		String v2 = "java";
		v2.toUpperCase(); // erzeugt ein neues String-Objekt, liefert seine Referenze
		System.out.println(v2); // java
		
		LocalDate v3  = LocalDate.of(2024, 9,11);
		v3.plusMonths(2);	// erzeugt ein neues String-Objekt, liefert seine Referenze
		System.out.println(v3.getMonthValue());	// 9

	}

}
