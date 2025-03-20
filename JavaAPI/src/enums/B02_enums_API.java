package enums;

import static enums.Season.*;

import java.util.Arrays;


public class B02_enums_API {

	public static void main(String[] args) {
		Season summer = Season.SUMMER;
		String s = summer.name();
		System.out.println("s = " + s);
		System.out.println(s.toLowerCase());
		
		Season[] seasons = {SUMMER, SPRING, WINTER, FALL};
	        
	        // Printing each season in the array
	        for (Season season : seasons) {
	            System.out.println(season);
	        }
	        
	        Arrays.sort(seasons);
	        System.out.println("****************");
	        for (Season season : seasons) {
	            System.out.println(season);
	        }
//	         Season winter = new Season("WINTER"); // enums könen nicht über den Konstruktor erzeugt werden, da dieser nicht sichtbar ist
	        Season winter = Season.WINTER; 
	        seasons = Season.values(); // values ist eine statische Methode eines Enums , das eine Array mit den Konstanten liefert.
	        System.out.println("****************");
	        for (Season season : seasons) {
	            System.out.println(season + " " + season.ordinal());
	        }
	        int compaare = winter.compareTo(summer);
	        System.out.println("compaare = " + compaare); // 2

	        int ordinal = summer.ordinal();
	        System.out.println("ordinal summer = " + ordinal); // 1
	        
	        ordinal = winter.ordinal();
	        System.out.println("ordinal winter= " + ordinal); // 3
	}

}
