package enums;

public class B01_AufzaehlungKlassich {
	
	private enum Test { EINS , ZEWI , DREI }
	
	public static void main(String[] args) {

		String jahrzeit = "Sommer";
		int jahreszeitAlsKlasse =  JahreszeitAlsKlasse.SOMMER;
		if(jahreszeitAlsKlasse == JahreszeitAlsKlasse.SOMMER) {
			System.out.println("Es ist Sommer");
		}
		JahreszeitAlsEnum herbst =  JahreszeitAlsEnum.HERBST;
		if(herbst == JahreszeitAlsEnum.SOMMER) {
			System.out.println("Es ist Sommer");
		}else {
			System.out.println("Es ist kein Sommer!");
		}
		
//		enum Test { EINS , ZEWI , DREI } // enums dürfen nicht in einem Methode definiert werden! 
		Season season = Season.FALL;
		System.out.println(season);
		Season fall = Season.FALL;
		System.out.println("season==fall " + ( season==fall ));
		System.out.println("season.equals(fall) " + ( season.equals(fall) ));
	}

}

class JahreszeitAlsKlasse{
	
	public static int FRUEHLING = 0 ; 
	public static int SOMMER = 1 ; 
	public static int HERBST = 2 ; 
	public static int WINTER = 3 ; 
}

// seit Java 5 gibt es die enums als Aufzzäleungstypen
enum JahreszeitAlsEnum{
	FRUEHLING , SOMMER , HERBST , WINTER
}