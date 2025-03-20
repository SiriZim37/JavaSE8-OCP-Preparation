package aufgaben.lambdas.v2.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class CPU {
	private String hersteller;
	private int anzahlKerne;
	
	CPU(String hersteller, int anzahlKerne) {
		this.hersteller = hersteller;
		this.anzahlKerne = anzahlKerne;
	}
	
	public String getHersteller() {
		return hersteller;
	}
	
	public String toString() {
		return hersteller + " [" + anzahlKerne + " Kern(e)]";
	}
}


public class AufgabeLambdasA4 {

	/*
		Die Klasse `CPU` definiert Instanz-Attribute `int anzahlKerne` und `String hersteller`. 
		Erzeugen Sie eine ArrayList mit 3-4 Elementen von Typ `CPU`. 

		Geben Sie alle Hersteller-Namen der Elemente der Liste aus, 
		verwenden Sie dafür die Methode `forEach` der Klasse `ArrayList` 
		und eine Lambda-Funktion, die das Interface 
		`java.util.function.Consumer` realisiert.  
	 */
	public static void main(String[] args) {
		List<CPU> list = new ArrayList<>();
		
		CPU c1 = new CPU("AMD", 4);
		list.add(c1);
		list.add(new CPU("Qualcomm", 32));
		list.add(new CPU("Intel", 12));
		list.add(new CPU("AMD", 8));
		list.add(new CPU("Apple", 4));

		System.out.println("*** Hersteller mit forEach-Schleife:");
		for(CPU c : list) {
			System.out.println(c.getHersteller());
		}

		System.out.println("\n*** Hersteller mit forEach-Methode:");
		Consumer<CPU> consumer = cpu -> System.out.println(cpu.getHersteller());
		list.forEach(consumer);
		
		//	class Blabla implements Consumer<CPU> {
		//		public void accept(CPU cpu) {
		//			System.out.println(cpu.getHersteller());
		//		}
		//	}
		
	} // end of main

}
