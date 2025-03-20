package functonal;

class Tier {
	private String name;
	private int alter;
	private boolean gesund;
	
	public Tier(String name, int alter, boolean gesund) {
		this.name = name;
		this.alter = alter;
		this.gesund = gesund;
	}
	
	public String toString() {
		return name + " (" + alter + ") ist " + (gesund ? "gesund" : "krank");
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return alter;
	}

	public boolean isGesund() {
		return gesund;
	}

} // end of Tier

interface TierTester {
	boolean test(Tier t);
}

class TierTesterAll implements TierTester {
	public boolean test(Tier t) {
		return true;
	}
}

class TierTesterNone implements TierTester {
	public boolean test(Tier t) {
		return false;
	}
}

class TierTesterGesund implements TierTester {
	public boolean test(Tier t) {
		return t.isGesund();
	}
}

class TierTesterKrank implements TierTester {
	public boolean test(Tier t) {
		return !t.isGesund();
	}
}

class TierTesterAlterGroesser3 implements TierTester {
	public boolean test(Tier t) {
		return t.getAlter() > 3;
	}
}

class TierTesterAlterGroesser3UndGesund implements TierTester {
	public boolean test(Tier t) {
		return t.getAlter() > 3 && t.isGesund();
	}
}

public class B01_OhneLambdas {

	/*
	 * Aufgabe: eine universelle Methode entwickeln,
	 * die Tiere aus einem Array auswählt und ausgibt 
	 */
	public static void main(String[] args) {
		Tier[] arr = {
			new Tier("Jerry", 5, true),	
			new Tier("Tom", 3, false),	
			new Tier("Rex", 4, true),	
			new Tier("Lessie", 2, true),	
			new Tier("Benjamin", 9, false),	
		};
		
		System.out.println("*** Alle Tiere: ");
		TierTester tt1 = new TierTesterAll();
		printSelected(arr, tt1);
		
		System.out.println("\n*** keine Tiere: ");
		TierTester tt2 = new TierTesterNone();
		printSelected(arr, tt2);
		
		System.out.println("\n*** Gesunde Tiere: ");
		printSelected(arr, new TierTesterGesund());
		
		System.out.println("\n*** Kranke Tiere: ");
		printSelected(arr, new TierTesterKrank());
		
		System.out.println("\n*** Tiere, die älter als 3 Jahre sind: ");
		printSelected(arr, new TierTesterAlterGroesser3());
		
		System.out.println("\n*** Tiere, die älter als 3 Jahre sind "
				+ "und dabei gesund sind: ");
		printSelected(arr, new TierTesterAlterGroesser3UndGesund());
	}

	static void printSelected(Tier[] arr, TierTester tester) {
		for (int i = 0, nr = 1; i < arr.length; i++) {
			Tier t = arr[i];
			boolean result = tester.test(t);
			if(result) {
				System.out.println(nr++ + ". " + t);
			}
		}
	}
}

