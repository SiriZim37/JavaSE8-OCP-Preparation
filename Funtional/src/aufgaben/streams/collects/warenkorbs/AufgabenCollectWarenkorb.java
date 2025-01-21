package aufgaben.streams.collects.warenkorbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;


class Produkt {
	private String name;
	private int preis;
	
	public Produkt(String name, int preis) {
		super();
		this.name = name;
		this.preis = preis;
	}

	public String getName() {
		return name;
	}

	public int getPreis() {
		return preis;
	}
	 
	public String toString() {
	        return name + " (" + preis/100 + ")";
	}	 
	
}

class Bestellung {
	private String produktName;
	private int anzahl; // gewünschte Anzahl der Produkt-Objekte
	
	public Bestellung(String produktName, int anzahl) {
		super();
		this.produktName = produktName;
		this.anzahl = anzahl;
	}

	public String getProduktName() {
		return produktName;
	}

	public int getAnzahl() {
		return anzahl;
	}
	
}



public class AufgabenCollectWarenkorb {

	static Map<String, Integer> produktPreis = new HashMap<>();
	
	static {
		produktPreis.put("Brot", 129);
		produktPreis.put("Wurst", 199);
		produktPreis.put("Milch", 119);
	}

	
	public static void main(String[] args) {
		
		a1();
		a2();
		
	
	}
	
	private static void a1() {
		List<Produkt> warenkorb = new ArrayList<>();
		warenkorb.add(new Produkt("Brot", 129));
		warenkorb.add(new Produkt("Wurst", 230));
		warenkorb.add(new Produkt("Milch", 99));
		warenkorb.add(new Produkt("Milch", 99));
		
		// A1
		// Alternativ 1
		
		int gesamtpreis = warenkorb.stream().mapToInt(Produkt::getPreis).sum();
		
	    System.out.println("1. Gesamtpreis: " + gesamtpreis );
	    
		// Alternativ 2
		gesamtpreis = warenkorb.stream().map(produkt -> produkt.getPreis()).reduce(0 ,  (p1,p2) -> p1+p2);
		System.out.println("2. Gesamtpreis: " + gesamtpreis );
	
	    
	}

	private static void a2() {
		//A2
		List<Bestellung> bestellungen = new ArrayList<>();
		bestellungen.add(new Bestellung("Brot", 3));
		bestellungen.add(new Bestellung("Wurst", 1));
		bestellungen.add(new Bestellung("Milch", 2));
		
		 List<Produkt> warenkorb = buildWarenkorb(bestellungen);
		 System.out.println("Bestellung : ");
		 warenkorb.forEach(System.out::println);
		
	}

	public static List<Produkt> buildWarenkorb(List<Bestellung> bestellungen) {
		  
		Supplier<List<Produkt>> supp = ArrayList::new;
		
		BiConsumer<List<Produkt>, Bestellung> acc = (listProdukte, bestellung) -> {
			String produktName = bestellung.getProduktName();
			System.out.println(" product name : " + produktName);
			int preis = produktPreis.get(produktName);
			for(int i = 0; i < bestellung.getAnzahl(); i++) {
				listProdukte.add(new Produkt(produktName, preis));
			}
		};
		// Alternativ 1 
		BiConsumer<List<Produkt>, List<Produkt>> comb = (list1, list2) -> list1.addAll(list2);
		comb = List::addAll;
		// Alternativ 2
		return bestellungen.stream().collect(supp, acc, comb );

	}
}