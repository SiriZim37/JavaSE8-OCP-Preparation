package arrays;

public class Wdh_Arr2 {

	public static void main(String[] args) {
	
		int[] a1 = new int[2];
		a1[0]= 42;
		a1[1] = -7;
		
		
		int[] a2 = { 42 , -7 };
		int[] a3 = new int[]{ 42 , -7 };
		
	
	}

}
/*

		Erklärung des Codes
		1. int[] a1 = new int[2];
		Stack:
		Eine Referenzvariable a1 wird auf dem Stack erstellt.
		Heap:
		Ein Array mit der Länge 2 wird auf dem Heap erstellt. Der Standardwert für die Elemente eines int-Arrays ist 0.
		Die Adresse dieses Arrays wird der Referenzvariable a1 auf dem Stack zugewiesen.
		2. a1[0] = 42;
		Der Wert 42 wird dem ersten Element des Arrays a1 zugewiesen.
		3. a1[1] = -7;
		Der Wert -7 wird dem zweiten Element des Arrays a1 zugewiesen.
		4. int[] a2 = {42, -7};
		Stack:
		Eine Referenzvariable a2 wird auf dem Stack erstellt.
		Heap:
		Ein Array mit den Werten 42 und -7 wird auf dem Heap erstellt.
		Die Adresse dieses Arrays wird der Referenzvariable a2 auf dem Stack zugewiesen.
		Diese Kurzschreibweise ist nur bei der Deklaration erlaubt.
		
		5. int[] a3 = new int[]{42, -7};
		Stack:
		Eine Referenzvariable a3 wird auf dem Stack erstellt.
		Heap:
		Ein Array mit den Werten 42 und -7 wird auf dem Heap erstellt.
		Die Adresse dieses Arrays wird der Referenzvariable a3 auf dem Stack zugewiesen.
		Visualisierung
		Stack
		a1 → Referenz auf das Array im Heap
		a2 → Referenz auf das Array im Heap
		a3 → Referenz auf das Array im Heap
		Heap
		a1 zeigt auf das Array [42, -7]
		a2 zeigt auf das Array [42, -7]
		a3 zeigt auf das Array [42, -7]
		Alle drei Arrays sind inhaltlich gleich, aber sie sind unterschiedliche Objekte im Speicher.
		
		Fazit
		Die Variablen a1, a2 und a3 selbst liegen auf dem Stack.
		Die eigentlichen Arrays, auf die diese Variablen verweisen, liegen im Heap.
		a1, a2 und a3 enthalten jeweils Referenzen (Adressen) zu den Arrays im Heap.
		So wird sichergestellt, dass der Speicher effizient genutzt wird und Arrays eine flexible Größe haben können, ohne die begrenzten Ressourcen des Stacks zu belasten.

*/