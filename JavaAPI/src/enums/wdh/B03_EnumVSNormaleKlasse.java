package enums.wdh;


import java.util.Arrays;
import java.util.Collections;

enum Color{
	RED , YELLOW , GREEN		// die 3 statische Konstanten
								// RED , YELLOW , GREEN sind Referenzen
}

class Farbe	implements Comparable<Farbe>{
	public static final Farbe  ROT = new Farbe("ROT" , 0);
	public static final Farbe  GELB = new Farbe("GELB" , 1 );
	public static final Farbe  GRUEN = new Farbe("GRUEN" , 2 );
	
	public static Farbe[] values() {
		return new Farbe[]{ ROT , GELB  , GRUEN} ;
	}
		
	private String name;
	private int ordinal;
	
	private Farbe(String name , int ordinal ) {  
		this.name = name; 
		this.ordinal = ordinal;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}

	public final int ordinal() {
		return ordinal;
	}
	
	public int compareTo(Farbe o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	
}
public class B03_EnumVSNormaleKlasse {

	public static void main(String[] args) {

		/*
		 * keine neuen Objekte sind möglich
		 */
		
		//new Color();
		//new Farbe();
		
		/*
		 *  Die Konstanten der enum-Klasse sind
		 *  statische Konstanten
		 */
		
		Color c1 = Color.RED;
		Farbe f1 = Farbe.ROT;
		
		/*
		 * API. statische Methode values()
		 */
		System.out.println("*** All Colors : ");	
		
	   Color[] allColors = Color.values();
	   System.out.println(Arrays.toString(allColors));	
	   for(Color c : allColors) {
		   System.out.println(c);
	   }
	   
	   System.out.println("\n*** Alle Farben :");
	   Farbe[] alleFarben = Farbe.values();
	   for(Farbe f : alleFarben) {
		   System.out.println(f);
	   }
	   
	   /*
	    * API. toString()
	    */
	   System.out.println("\n*** toString");
	   System.out.println(Color.YELLOW); // YELLOW
	   System.out.println(Farbe.GELB); // GELB
	   
	   /*
	    * API.
	    * 		String name()
	    */
	   System.out.println("\n*** name()");
	   String cn1 = Color.GREEN.name();
	   System.out.println(cn1); 
	   
	   String fn1 = Farbe.GELB.getName();
	   System.out.println(fn1); 
	   
	   /*
	    * API.
	    * 		int ordinal()
	    */
	   System.out.println("\n*** allColor ordinals");
	   for(Color c : Color.values()) {
		   System.out.println(c + " : " + c.ordinal());
	   }
	   
	   System.out.println("\n*** allFarbe ordinals");
	   for(Farbe f : Farbe.values()) {
		   System.out.println(f + " : " + f.ordinal());
	   }
	
	   /*
	    * Jede enum-Klass implementiert Comparable
	    */
	   System.out.println("\n*** Comparable");
	   Comparable<Color> v1 = Color.GREEN;	// Comparable <- IS-A <- Color
	   Comparable<Farbe> v2 = Farbe.GRUEN;	// Comparable <- IS-A <- Farbe
	   
	   System.out.println("\n***absteigend sortiert");
	   Color[]	colors = Color.values();
	   Arrays.sort(colors , Collections.reverseOrder());
	   System.out.println("colors : " + Arrays.toString(colors));

	   Farbe[]	farben = Farbe.values();
	   Arrays.sort(farben , Collections.reverseOrder());
	   System.out.println("farben : " + Arrays.toString(farben));
	   
	   
	   /*
	    * enum Klassen werden mon switch-Anweisung
	    * (und in Java 21 mit switch-Expression)
	    */
	}

}
