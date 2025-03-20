package basics;

public class SwitchStatement {

	public static void main(String[] args) {
	int monat = 4;
			
			/*
			 * Java 8
			 */
			switch(monat) {
				case 4:
				case 6:
					System.out.println("30 Tage");
			}
	
			/*
			 * Modern geht auch so:
			 */
			switch(monat) {
				case 4, 6:
					System.out.println("30 Tage");
			}

	}

}
