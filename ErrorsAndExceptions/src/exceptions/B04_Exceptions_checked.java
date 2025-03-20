package exceptions;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

public class B04_Exceptions_checked {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
//		String s = (String) o ; 
		//  java.lang.ClassCastException: class java.lang.Object cannot be cast to class java.lang.String  => RuntimeException , muss nicht behandelt werden
		
		int[] intArr = { 1 , 2 , 3, 4 , 5};
		for(int i = 0 ; i <= intArr.length ; i++){ 
//			System.out.println(intArr[i]); 	// ArrayIndexOutOfBoundsException => RuntimeException , muss nicht behandelt werden
		}
		String s = "Hello Welt!";
//		System.out.println(s.charAt(20));  
		// StringIndexOutOfBoundsException: Index 20 out of bounds for length 11 => RuntimeException , muss nicht behandelt werden
		
//		String d = "7. Juli 2024";
		String d = "07.07.2024";
		DateFormat df = DateFormat.getDateInstance();
		try {
			Date date = df.parse(d);
			// ParseException ist keine RuntimeException und daher eine checked Exception => sie muss daher behandelt oder propagirt werden (handel or declare)
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Wir beenden das Program in 5 Sekunden");
		Thread.sleep(5000); // Unhandled exception type InterruptedException  , dann -> throws InterruptedException 
		// sleep kann eine InterruptedException werfen. Diese ist Subklasse von Exception , also checkes und muss behandelte oder deklariert werden
		System.out.println("Servus");

	}

}
