package aufgaben.a4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


// 1# Erzeugen Interface KannBehandeltWerden
interface KannBehandeltWerden{	
	void setGesund(boolean gesund);
	boolean isGesund();
}

//2# Erzeugen Klass Mensch , der KannBehandeltWerden implementiert.
class Mensch extends Lebewesen {

	public Mensch(int id) {
		super(id);
	}
}

abstract class Lebewesen implements KannBehandeltWerden {
	private boolean gesund;
	private int id;
	
	public Lebewesen(int id) {
		this.id = id;
	}

	public boolean isGesund() {
		return gesund;
	}

	public void setGesund(boolean gesund) {
		this.gesund = gesund;
	}
	
	public String toString() {
		return getClass().getSimpleName() + 
				" (id=" + id + ") ist " + 
				(gesund ? "gesund" : "krank");
	}
}

//3#  Erzeugen abstract Klass Tier , der KannBehandeltWerden implementiert.
abstract class Tier extends Lebewesen {

	public Tier(int id) {
		super(id);
	}

}

//4# Zebras und Affen sind Tiere
class Zebra extends Tier{
	public Zebra(int id) {
		super(id);
	} 
}
class Affe extends Tier{
	public Affe(int id) {
		super(id);
	}
}

//5# Erzeugen Klass Zoo
class Zoo implements Iterable<Tier>{
	private List<Tier> tiere = new ArrayList<>();

	public void addTier(Tier t) {
		tiere.add(t);
	}
	
	public Collection<Tier> getTiere() {
		return Collections.unmodifiableList(tiere);
	}
    
	@Override
	public Iterator<Tier> iterator() {
		return tiere.iterator();
	}
}

// Generic Klasse Arzt für Tiere und Menschen
class Arzt <P extends KannBehandeltWerden> extends Mensch {
	public Arzt() {
	    super(0);
	}
	
	public void behandeln(P patient) {
		if(!patient.isGesund()) {
			patient.setGesund(true);
		}
	}
}



public class TestGenericsZooArzt {

	public static void main(String[] args) {
	
		Zoo zoo = new Zoo();
		
	    
	    zoo.addTier(new Zebra(1));
	    zoo.addTier(new Zebra(2));
	    zoo.addTier(new Zebra(3));
	    zoo.addTier(new Affe(4));
	    zoo.addTier(new Affe(5));
	    zoo.addTier(new Affe(6));
	    
	    Collection<Tier> tiere = zoo.getTiere();
	    printTiere(tiere);
	    printTiereImZoo(zoo);
	   
	    System.err.println("------------------------------------");
	    
	    Mensch mensch = new Mensch(101);
	    System.out.println(mensch);
	   
	    	
	    System.err.println("------------------------------------");
	    /*
		 * Tierarzt
		 */
	    System.out.println("\n***Tier nach Behandlung ");    
		Arzt<Tier> tierArzt = new Arzt<>();
		for(Tier t : tiere) {
			tierArzt.behandeln(t);
		}
		
		System.out.println();
		printTiere(tiere);
		
	    System.err.println("------------------------------------");
	    
//		tierArzt.behandeln(new Mensch(10)); // cf
		tierArzt.behandeln(new Affe(11)); 
		tierArzt.behandeln(new Zebra(12)); 
		
		/*
		 * Affenarzt
		 */
		Arzt<Affe> affenArzt = new Arzt<>();
		affenArzt.behandeln(new Affe(13));
//		affenArzt.behandeln(new Zebra(14));
//		affenArzt.behandeln(new Mensch(15));
		
		/*
		 * Arzt für Tiere und Menschen
		 */
		Arzt<KannBehandeltWerden> superArzt = new Arzt<>();
		superArzt.behandeln(new Mensch(16));
		superArzt.behandeln(new Affe(17));
		superArzt.behandeln(new Zebra(18));
		superArzt.behandeln(tierArzt);
		superArzt.behandeln(affenArzt);
		
	}

	static void printTiere(Collection<Tier> tiere) {
		int count = 0 ; 
		for (Tier tier : tiere) {
			System.out.println(count++ + "." + tier);
		}
	}
	static void printTiereImZoo(Zoo zoo) {
		 for (Tier tier : zoo) {
	          System.out.println(tier);
	     }
	}
}
