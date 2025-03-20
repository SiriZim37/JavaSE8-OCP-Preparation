package aufgaben.hafen;

import java.util.Arrays;

class Foo{
	static Schiff[] arr = new Schiff[5]; /// Global variable : static gehört nicht zu Foo class
										 // wenn neu Objekt erzeugen , wird array nicht ändern 
										 // arr at position 0 wird ersezt
	
	int positionIndex = 0 ;
	
	void add(Schiff s) {
		HafenSimulation.arr[positionIndex++] = s;
	}
	
	Schiff get(int index) {
		return HafenSimulation.arr[index];
	}

	
}

public class HafenSimulation {

	static Schiff[] arr = new Schiff[5];  // Es ist wie in Foo class und diese Global Variable wird nicht ändern.
	
	public static void main(String[] args) {
		
	
		
		int schiffLimit = 25;

		Hafen h = new Hafen(schiffLimit);
		System.out.println(h);
		

	
		/*------------------- WDH ------------------*/
		
		
		Schiff s = new Schiff("AA"); 
		Foo foo = new Foo();
		foo.add(s);
		System.out.println(foo.get(0));
		
		Foo tmp = new Foo();
		tmp.add(new Schiff("Titanic"));
		System.out.println(foo.get(0));
		
		
		
		/*-------------------END WDH ------------------*/
		
		
		// Das mit new erzeugte Objekt wird nicht verwendet,
        // die for-Schleife überschreibt die Referenz bevor sie gelesen wird.
        // das Objekt wird also verworfen.
       
		
		Schiff schiff = new Schiff("AA"); 
		h.schiffHinzufuegen(schiff);
        System.out.println(h.get(0));
        
		
		System.out.println("\n12 Schiffe ohne Name ankern.---------------\n");
		// 12 Schiffe liegt vor Anger
		for(int i = 0 ; i < 12 ; i++) {
			schiff = new Schiff();
			h.schiffHinzufuegen(schiff);
		}
		System.out.println(h);

		// Die schiffe am Bootssteg
		 h.anzeigeSchiffeAmBootssteg();


		System.out.println("\n2 Schiffe verlassen den Hafen.------------\n");
	
		 h.schiffVerlassen("");
		 h.schiffVerlassen("");		 
		 System.out.println(h);
		
		 // Die schiffe am Bootssteg
		 h.anzeigeSchiffeAmBootssteg();
		 
		
		 
		//////////////SELBSTTEST TEST GROUP SCHIFFE ///////////////////

		 
		System.out.println("\n---- SELBSTTEST ---- \n");
		Schiff[] groupA = new Schiff[7];
		for(int i = 1 ; i <= groupA.length ; i++) {
            groupA[i-1] = new Schiff("SchiffA No."+i );
        }
		
		Schiff[] groupB = new Schiff[13];
		for(int i = 1 ; i <= groupB.length ; i++) {
			groupB[i-1] = new Schiff("SchiffB No."+i);
		}
		
	
		System.out.println(Arrays.toString(groupA));
		System.out.println(Arrays.toString(groupB));
		

		System.out.println("\n" + groupA.length + " Schiffe mit Name ankern------");
		// 12 Schiffe liegt vor Anger
		for(int i = 0 ; i < groupA.length ; i++) {
			h.schiffHinzufuegen(groupA[i]);
		}
		System.out.println(h);
		h.anzeigeSchiffeAmBootssteg();
		
		System.out.println("\n" + groupB.length + " Schiffe mit Name ankern------");
		// 12 Schiffe liegt vor Anger
		for(int i = 0 ; i < groupA.length ; i++) {
			h.schiffHinzufuegen(groupB[i]);
		}
		System.out.println(h);
		h.anzeigeSchiffeAmBootssteg();
		
		
		
		 System.out.println("\nSchiffe verlassen den Hafen.------------\n");
		
//		 h.schiffVerlassen("SchiffA No.1");
//		 h.schiffVerlassen("SchiffB No.7");		 
//		 System.out.println(h);
		
		 // Die schiffe am Bootssteg
//		 h.anzeigeSchiffeAmBootssteg();
		

		 
		
	}
	
	
	

}
