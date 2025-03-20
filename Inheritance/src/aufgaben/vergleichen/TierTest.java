package aufgaben.vergleichen;

import java.util.Arrays;

/*
 * •Jedes Tier hat Namen und Alter. Erzeugen Sie ein Array mit 3-4 Tieren. 
 * Sortieren Sie das Array mit Arrays.sort. 
 * 
 * Ein Vorschlag: 
 * Die Tiere beim Sortieren sollten nach Namen sortiert werden. 
 * Falls es Tiere mit dem gleichen Namen gibt, 
 * sollten solche Tiere nach dem Alter sortiert werden.
 */

class Tier implements Comparable<Tier> {
	private String name ;
	private int alter;
	public Tier( String name , int alter) {
		this.name = name ;
		this.alter = alter;
	}
	
	public Tier() {
		// TODO Auto-generated constructor stub
	}
    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }
    
	@Override
	public String toString() {
		return name + " (" +  alter + ")" ;
	}

	@Override
	public int compareTo(Tier t2) {
		// 1 #
//		Tier t1 = this;
//		int result = 0 ;
//		result = t1.name.compareTo(t2.name); 
//		if(result == 0 ) {
//			 if (t1.alter > t2.alter) {
//				 result = 1;
//			 } else if (t1.alter < t2.alter) {
//				 result =  -1; 
//		     } else {
//		    	 result =  0;
//		     }
//		}
//		return result;
		
		// 2 #
		int nameVergleich = this.name.compareTo(t2.getName());
        if (nameVergleich != 0) {
            return nameVergleich;
        }
        return Integer.compare(this.alter, t2.getAlter());
	}
	
}

public class TierTest {
	

	
	public static void main(String[] args) {
	double d = new Double(1_000.0);

	
		Tier[] arr = {  new Tier("Katze", 2) , 
						new Tier("Hund", 5),
						new Tier("Meerschweinchen", 1), 
						new Tier("Hamster", 1),
						new Tier("Papagei", 4)};
		
		System.out.println("Vorher: " + Arrays.toString(arr));

	    Arrays.sort(arr);

	    System.out.println("Nachher: " + Arrays.toString(arr));

	}

}
