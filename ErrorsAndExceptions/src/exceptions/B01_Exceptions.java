package exceptions;

import java.util.Scanner;

public class B01_Exceptions {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte geben zwei Zahlen ein : ");
		int quotient = 0 ; 
		try {
			
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			quotient = a/b ; 
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("a/b = " + quotient);
		System.out.println("Servus");
		scanner.close();


	}

}
