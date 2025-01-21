package func.aufgaben.bifuntion;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

class Auto {
	private String hersteller;
	private int baujahr;

	public Auto(String hersteller  , int baujahr) {
		this.hersteller = hersteller;
		this.baujahr = baujahr;
	}

	/*
	 * sinnlose Metode. Nur für die Lernaufgabe ok : 
	 */
	// A6
	Besitzer createBesitzer(Integer id) {
		return new Besitzer( this , id);
	}
	

}
 
class Besitzer {
	 private int id;
	 private Auto auto;
	  
	 public Besitzer( Auto auto , int id) {
		    this.auto = auto;
	        this.id = id;
	     
	}
	 
	static Besitzer createInstance(Auto a, Integer id) {
		return new Besitzer(a, id);
	}

	public Besitzer instanzCreateBesitzer(Auto auto, int id) {
       return new Besitzer(auto, id);
    }

}

class BesitzerBuilder {
	
	public Besitzer build(Auto auto, Integer id) {
        return new Besitzer(auto, id);
    }
}

public class TestBiFunction {
   
	public static void main(String[] args) {
		
	
		Auto auto = new Auto("Mercedes", 2019);

		/*	  BiFunction<Auto, Integer, Besitzer>
		 *    argumente :  Auto , Integer 
		 *    return : Besitzer
		 */
		// #A1 	: anonyme Klasse.
		
		BiFunction<Auto, Integer, Besitzer> f1 = new BiFunction<Auto, Integer, Besitzer>() {  
			public Besitzer apply(Auto a, Integer id) {
				return new Besitzer( a , id);
			}
		};
		Besitzer b1 = f1.apply(auto, 1) ;
		System.out.println(	"b1 : " + b1 );
		
		
		// #A2  : Lambda-Funktion.
		
		BiFunction<Auto, Integer, Besitzer> f2 = (Auto a , Integer id) -> {
			return new Besitzer( a ,id );
		};
		Besitzer b2 = f2.apply(auto, 2)  ;
		System.out.println(	"b2 : " + b2);


		// #A3 : Methodenreferenz
		// Referenz auf eine statische Methode
		/*
		 * 	public Besitzer apply(Auto auto, Integer id) {
		 * 		return Klasse.statischeMethode(id);
		 * 	}
		 * 
		 */
		BiFunction<Auto, Integer, Besitzer> f3 = Besitzer::createInstance; // return Besitzer : parameter Auto ,Integer
		Besitzer b3 = f3.apply(auto, 3)  ;
		System.out.println(	"b3 : " + b3 );
		
		
		// #A4	: Methodenreferenz 
		// Referenz auf einen Konstruktor
		/*
		 * 	public Besitzer apply(Auto auto, Integer id) {
		 * 		return new Besitzer( auto , id);
		 * 	}
		 * 
		 */
		BiFunction<Auto, Integer, Besitzer> f4 =  Besitzer::new; // return Besitzer : parameter Auto ,Integer
		Besitzer b4 = f4.apply(auto, 4)  ;
		System.out.println(	"b4 : " + b4 );
		
		
		
		// #A5 : Methodenreferenz 
		// Referenz auf eine Instanzmethode eines vorhandenen Objektes
		/*
		 * 	public Besitzer apply(Auto auto, Integer id) {
		 * 		return obj.instazMethode(a,id);
		 * 	}
		 * 
		 */
		
		BesitzerBuilder obj = new BesitzerBuilder();
		BiFunction<Auto, Integer, Besitzer> f5 = obj::build;
		
		Besitzer b5 = f5.apply(new Auto("Audi", 2021), 5);
		System.out.println(	"b5 : " + b5 );
		
		
		// #A6 : Methodenreferenz 
		// Referenz auf eine Instanzmethode einesunbestimmten Objektes von einem bekannten Typ	
		/*
		 * 	public Besitzer apply(Auto auto, Integer id) {
		 * 		return a.instazMethode(id);
		 * 	}
		 * 
		 */
		 
		BiFunction<Auto, Integer, Besitzer> f6 = Auto::createBesitzer;
		Besitzer b6 = f6.apply(auto, 6)  ;
		System.out.println(	"b6 : " + b6 );
		
		
	}

}
